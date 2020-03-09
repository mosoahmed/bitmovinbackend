package com.bitmovin.encoding.schedular.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class VirtualMachineImpl implements VmApi {

    private static List<String> ipAddresses = new ArrayList<>();

    @Override
    public String startVMAndReturnIp() {
        String ipAddress = generateRandomIpAddress();
        ipAddresses.add(ipAddress);
        System.out.println("Generated Virtual Machine with IP:" + ipAddress);
        return ipAddress;
    }

    @Override
    public void deleteVM(String ip) {
        ipAddresses.remove(ip);
        System.out.println("Delete Virtual Machine with IP:" + ip);
    }

    public String generateRandomIpAddress() {
        Random r = new Random();
        return r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
    }

    public static List<String> getIpAddresses() {
        return ipAddresses;
    }

    public static void setIpAddresses(List<String> ipAddresses) {
        VirtualMachineImpl.ipAddresses = ipAddresses;
    }
}
