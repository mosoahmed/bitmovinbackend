package com.bitmovin.encoding.schedular.service;

public class RabbitMqEncodingFinishedImpl implements RabbitMqEncodingFinished {
    @Override
    public void encodingFinished(String encodingId) {
        synchronized (EncodingTasks.runningTasks) {
            EncodingTasks.runningTasks.remove(encodingId);
            System.out.println("RabbitMqEncodingFinishedImpl:encodingFinished:" + encodingId);
        }
    }
}
