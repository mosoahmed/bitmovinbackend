package com.bitmovin.encoding.schedular.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerApiImplTest {

    ContainerApi containerApi = new ContainerApiImpl();

    @Test
    void startContainer() {
      String containerId = containerApi.startContainer();
      assertNotNull(containerId);
    }

}