package com.github.serdardundar.solidprinciples.openclose.rafactored;

import com.github.serdardundar.solidprinciples.openclose.model.CustomerHistory;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        HistoryStore historyStore = new HistoryStore();

        MobileCustomer mobileCustomer = new MobileCustomer();
        mobileCustomer.setCustomerId(1L);
        mobileCustomer.setAddress("Taksim Square");
        mobileCustomer.setPhoneNumber(555444332211L);
        mobileCustomer.setBaseRate(20);

        CallHistory callHistory = new CallHistory(mobileCustomer.getCustomerId(), LocalDateTime.now(), 2000);
        historyStore.addSession(callHistory);

        List<CustomerHistory> calls = historyStore.getCurrentSessions(mobileCustomer.getCustomerId());
        System.out.println("mobile customer call history size " + calls.size());
        System.out.println("mobile customer bill " + mobileCustomer.calculateBill(calls));

        ISPCustomer ispCustomer = new ISPCustomer();
        ispCustomer.setCustomerId(2L);
        ispCustomer.setAddress("Etiler");
        ispCustomer.setBaseRate(1000);
        ispCustomer.setFreeUsage(200L);
        ispCustomer.setPhoneNumber(666555443322L);

        InternetSessionHistory history = new InternetSessionHistory(ispCustomer.getCustomerId(), LocalDateTime.now(), 200L);
        historyStore.addSession(history);
        historyStore.addSession(new InternetSessionHistory(ispCustomer.getCustomerId(), LocalDateTime.now(), 300L));

        List<CustomerHistory> sessions = historyStore.getCurrentSessions(history.getCustomerId());
        System.out.println("isp customer call history size " + sessions.size());
        System.out.println("isp customer bill " + ispCustomer.calculateBill(sessions));
    }
}
