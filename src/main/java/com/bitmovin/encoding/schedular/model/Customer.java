package com.bitmovin.encoding.schedular.model;

public class Customer implements Comparable<Customer> {

    private int id;
    private int priority;

    public Customer(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Customer customer) {
        if (this.getPriority() > customer.getPriority()) {
            return 1;
        } else if (this.getPriority() < customer.getPriority()) {
            return -1;
        } else {
            return 0;
        }
    }
}
