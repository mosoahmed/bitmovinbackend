package com.bitmovin.encoding.schedular.service;

import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class SchedulerService {

    private ScheduledExecutorService executorService;
    private VmApi virtualMachineApi;
    private ContainerApi containerApi;
    private RabbitMqEncodingFinished rabbitMqEncodingFinished;
    private RabbitMqEncodingTaskCreated rabbitMqEncodingTaskCreated;

    public SchedulerService() {
        executorService = Executors.newSingleThreadScheduledExecutor();
        virtualMachineApi = new VirtualMachineImpl();
        containerApi = new ContainerApiImpl();
        rabbitMqEncodingFinished = new RabbitMqEncodingFinishedImpl();
        rabbitMqEncodingTaskCreated = new RabbitMqEncodingTaskCreatedImpl();
        setUpEncodingTasks();
        this.executorService.scheduleAtFixedRate(startEncodingTask(), 0, 1, TimeUnit.SECONDS);
        this.executorService.scheduleAtFixedRate(releaseFinishedTasks(), 5, 1, TimeUnit.SECONDS);

    }

    private Runnable startEncodingTask() {
        return () -> {
            createEncodingTask();
        };
    }

    public void createEncodingTask() {
        while (EncodingTasks.runningTasks.size() < 10) {
            Encoding encodingTask = EncodingTasks.encodings.poll();
            encodingTask.setVirtualMachineIp(virtualMachineApi.startVMAndReturnIp());
            encodingTask.setContainerId(containerApi.startContainer());
            startTask(encodingTask);
            EncodingTasks.runningTasks.add(encodingTask);
        }
    }

    private static void startTask(Encoding encodingTask) {
        //TODO
        // post encoding service to VM here
    }

    private Runnable releaseFinishedTasks() {
        return () -> {
            if (EncodingTasks.runningTasks.size() > 0) {
                Encoding task = EncodingTasks.runningTasks.poll(); //get random task to finish
                rabbitMqEncodingFinished.encodingFinished(task.getEncodingId());
            }
        };
    }

    private void setUpEncodingTasks() {
        int number = 1;
        while (number < 40) {
            String encodingId = UUID.randomUUID().toString();
            String serializedTask = "here is Task";
            String userId = UUID.randomUUID().toString();
            int priority = new Random().nextInt(30);
            String provider = "AWS";
            rabbitMqEncodingTaskCreated.receiveTask(encodingId, serializedTask, userId, priority, provider);
            number++;
        }
    }

}
