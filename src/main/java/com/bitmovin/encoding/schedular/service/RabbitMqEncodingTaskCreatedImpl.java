package com.bitmovin.encoding.schedular.service;

public class RabbitMqEncodingTaskCreatedImpl implements RabbitMqEncodingTaskCreated {

    @Override
    public void receiveTask(String encodingId, String serializedTask, String userId, int priority, String provider) {
        Encoding encoding = new Encoding();
        encoding.setEncodingId(encodingId);
        encoding.setPriority(priority);
        encoding.setProviderId(provider);
        encoding.setUserId(userId);
        encoding.setSerializedTask(serializedTask);
        EncodingTasks.encodings.add(encoding);
        System.out.println("RabbitMqEncodingTaskCreatedImpl:receiveTask:" + encodingId);
    }
}
