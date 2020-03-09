package com.bitmovin.encoding.schedular.service;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class ContainerApiImpl implements ContainerApi {

    @Override
    public String startContainer() {
        String containerId = "containerId:" + new Random().nextInt(90);
        System.out.println("Generated Countainer Id: " + containerId);
        return containerId;
    }

}
