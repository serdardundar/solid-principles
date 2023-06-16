package com.github.serdardundar.solidprinciples.openclose.rafactored;

import com.github.serdardundar.solidprinciples.openclose.model.CustomerHistory;

import java.time.LocalDateTime;

public class CallHistory extends CustomerHistory {

    private long duration;

    public CallHistory(Long customerId, LocalDateTime begin, long duration) {
        setBegin(begin);
        setCustomerId(customerId);
        setDuration(duration);
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
