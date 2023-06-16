package com.github.serdardundar.solidprinciples.openclose.model;

import java.time.LocalDateTime;

public abstract class CustomerHistory {

    private LocalDateTime begin;
    private Long customerId;

    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
