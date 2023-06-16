package com.github.serdardundar.solidprinciples.openclose.begin;

import java.util.List;

public class ISPCustomer {

    private Long customerId;
    private String address;
    private Long phoneNumber;
    private int baseRate;
    private Long freeUsage;

    private static final InternetSessionHistory internetSessionHistory = new InternetSessionHistory();

    public double calculateBill() {
        List<InternetSessionHistory.InternetSession> sessions = internetSessionHistory.getCurrentSessions(customerId);
        long totalData = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();
        long chargeableData = totalData - freeUsage;
        return (double) chargeableData * baseRate / 100;
    }

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

    public Long getFreeUsage() {
        return freeUsage;
    }

    public void setFreeUsage(Long freeUsage) {
        this.freeUsage = freeUsage;
    }
}
