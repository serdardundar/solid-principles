package com.github.serdardundar.solidprinciples.openclose.model;

import java.util.List;

public abstract class Customer {

    private Long customerId;
    private String address;
    private Long phoneNumber;
    private int baseRate;

    public abstract double calculateBill(List<? extends CustomerHistory> customerHistoryList); //extension

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getBaseRate() {
        return baseRate;
    }

    public void setBaseRate(int baseRate) {
        this.baseRate = baseRate;
    }
}
