package com.github.serdardundar.solidprinciples.openclose.rafactored;

import com.github.serdardundar.solidprinciples.openclose.model.CustomerHistory;

import java.time.LocalDateTime;

public class InternetSessionHistory extends CustomerHistory {

    private Long dataUsed;

    public InternetSessionHistory(Long customerId, LocalDateTime begin, Long dataUsed) {
        setDataUsed(dataUsed);
        setBegin(begin);
        setCustomerId(customerId);
    }

    public Long getDataUsed() {
        return dataUsed;
    }

    public void setDataUsed(Long dataUsed) {
        this.dataUsed = dataUsed;
    }
}
