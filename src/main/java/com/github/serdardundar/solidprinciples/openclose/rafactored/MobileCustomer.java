package com.github.serdardundar.solidprinciples.openclose.rafactored;

import com.github.serdardundar.solidprinciples.openclose.model.Customer;
import com.github.serdardundar.solidprinciples.openclose.model.CustomerHistory;

import java.util.List;

public class MobileCustomer extends Customer {

    @SuppressWarnings("unchecked")
    @Override
    public double calculateBill(List<? extends CustomerHistory> customerHistories) {
        long totalDuration = ((List<CallHistory>) customerHistories).stream().mapToLong(CallHistory::getDuration).sum();
        return (double) totalDuration * getBaseRate() / 100;
    }
}
