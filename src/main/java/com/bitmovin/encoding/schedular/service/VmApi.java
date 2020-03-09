package com.bitmovin.encoding.schedular.service;

public interface VmApi {

    String startVMAndReturnIp();
    void deleteVM(String ip);

}
