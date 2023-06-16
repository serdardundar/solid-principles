package com.github.serdardundar.solidprinciples.openclose.rafactored;

import com.github.serdardundar.solidprinciples.openclose.model.Customer;
import com.github.serdardundar.solidprinciples.openclose.model.CustomerHistory;

import java.util.List;

public class ISPCustomer extends Customer {

    private long freeUsage;

    public long getFreeUsage() {
        return freeUsage;
    }

    public void setFreeUsage(long freeUsage) {
        this.freeUsage = freeUsage;
    }

    @SuppressWarnings("unchecked")
    @Override
    public double calculateBill(List<? extends CustomerHistory> sessions) {
        long totalData = ((List<InternetSessionHistory>)sessions).stream().mapToLong(InternetSessionHistory::getDataUsed).sum();
        long chargeableData = totalData - freeUsage;
        return (double) chargeableData * getBaseRate() / 100;
    }
}
