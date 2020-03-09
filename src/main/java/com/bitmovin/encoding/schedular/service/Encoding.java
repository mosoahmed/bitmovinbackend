package com.bitmovin.encoding.schedular.service;

import com.bitmovin.encoding.schedular.model.Customer;
import org.springframework.stereotype.Service;


public class Encoding implements Comparable<Encoding> {

    private String encodingId;
    private String providerId;
    private String userId;
    private int Priority;
    private String containerId;
    private String virtualMachineIp;
    private String status;
    private String serializedTask;

    public String getSerializedTask() {
        return serializedTask;
    }

    public void setSerializedTask(String serializedTask) {
        this.serializedTask = serializedTask;
    }

    public String getEncodingId() {
        return encodingId;
    }

    public void setEncodingId(String encodingId) {
        this.encodingId = encodingId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPriority() {
        return Priority;
    }

    public void setPriority(int priority) {
        Priority = priority;
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public String getVirtualMachineIp() {
        return virtualMachineIp;
    }

    public void setVirtualMachineIp(String virtualMachineIp) {
        this.virtualMachineIp = virtualMachineIp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Encoding{" +
                "encodingId='" + encodingId + '\'' +
                ", providerId='" + providerId + '\'' +
                ", userId='" + userId + '\'' +
                ", Priority=" + Priority +
                ", containerId='" + containerId + '\'' +
                ", virtualMachineIp='" + virtualMachineIp + '\'' +
                ", status='" + status + '\'' +
                ", serializedTask='" + serializedTask + '\'' +
                '}';
    }

    @Override
    public int compareTo(Encoding encoding) {
        if (this.getPriority() > encoding.getPriority()) {
            return 1;
        } else if (this.getPriority() < encoding.getPriority()) {
            return -1;
        } else {
            return 0;
        }
    }

}
