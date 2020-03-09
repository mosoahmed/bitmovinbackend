package com.bitmovin.encoding.schedular.service;

import java.util.PriorityQueue;

public class EncodingTasks {
    public static PriorityQueue<Encoding> encodings = new PriorityQueue<>();
    public static PriorityQueue<Encoding> runningTasks = new PriorityQueue<Encoding>();


}
