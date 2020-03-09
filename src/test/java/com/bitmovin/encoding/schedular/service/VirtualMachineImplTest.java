package com.bitmovin.encoding.schedular.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VirtualMachineImplTest {

    VmApi vmApi = new VirtualMachineImpl();
    List<String> ipAddressesTest = new ArrayList<>();
    @Test
    void startVMAndReturnIp() {
        String ipAddress = vmApi.startVMAndReturnIp();
        ipAddressesTest.add(ipAddress);
        assertEquals(ipAddressesTest.size(), VirtualMachineImpl.getIpAddresses().size());
        assertArrayEquals(ipAddressesTest.toArray(), VirtualMachineImpl.getIpAddresses().toArray());
    }

    @Test
    void deleteVM() {
        String ipAddress = vmApi.startVMAndReturnIp();
        ipAddressesTest.add(ipAddress);
        vmApi.deleteVM(ipAddress);
        ipAddressesTest.remove(ipAddress);
        assertEquals(ipAddressesTest.size(), VirtualMachineImpl.getIpAddresses().size());
        assertArrayEquals(ipAddressesTest.toArray(), VirtualMachineImpl.getIpAddresses().toArray());

    }

    @Test
    void generateRandomIpAddress() {
    }
}