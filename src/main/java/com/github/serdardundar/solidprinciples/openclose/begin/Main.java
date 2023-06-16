package com.github.serdardundar.solidprinciples.openclose.begin;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        MobileCustomer mobileCustomer = new MobileCustomer();
        mobileCustomer.setCustomerId(1L);
        mobileCustomer.setAddress("Taksim Square");
        mobileCustomer.setPhoneNumber(555444332211L);
        mobileCustomer.setBaseRate(20);

        CallHistory.addSession(mobileCustomer.getCustomerId(), LocalDateTime.now(), 2000);
        List<CallHistory.Call> calls = CallHistory.getCurrentCalls(mobileCustomer.getCustomerId());
        System.out.println("mobile customer call history size " + calls.size());
        System.out.println("mobile customer bill " + mobileCustomer.calculateBill());


        ISPCustomer ispCustomer = new ISPCustomer();
        ispCustomer.setCustomerId(2L);
        ispCustomer.setAddress("Etiler");
        ispCustomer.setBaseRate(1000);
        ispCustomer.setFreeUsage(200L);
        ispCustomer.setPhoneNumber(666555443322L);

        InternetSessionHistory.addSession(ispCustomer.getCustomerId(), LocalDateTime.now(), 200);
        InternetSessionHistory.addSession(ispCustomer.getCustomerId(), LocalDateTime.now(), 300);
        List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory.getCurrentSessions(2L);
        System.out.println("isp customer call history size " + sessions.size());
        System.out.println("isp customer bill " + ispCustomer.calculateBill());
    }
}
