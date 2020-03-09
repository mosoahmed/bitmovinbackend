package com.bitmovin.encoding.schedular.service;

public interface RabbitMqEncodingFinished {

    void encodingFinished(String encodingId);

}
