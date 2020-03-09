package com.bitmovin.encoding.schedular.service;

public interface RabbitMqEncodingTaskCreated {

    void receiveTask(String encodingId, String serializedTask, String userId, int priority, String provider);

}
