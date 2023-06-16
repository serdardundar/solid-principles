package com.github.serdardundar.solidprinciples.openclose.begin;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CallHistory {

    private static final Map<Long, List<Call>> CALLS = new HashMap<>();

    private CallHistory() {
    }

    public static synchronized List<Call> getCurrentCalls(Long customerId) {
        if (!CALLS.containsKey(customerId)) {
            return Collections.emptyList();
        }
        return CALLS.get(customerId);
    }

    public static synchronized void addSession(Long customerId, LocalDateTime begin, long duration) {
        List<Call> calls;
        if (!CALLS.containsKey(customerId)) {
            calls = new LinkedList<>();
            CALLS.put(customerId, calls);
        } else {
            calls = CALLS.get(customerId);
        }
        calls.add(new Call(customerId, begin, duration));
    }

    public static class Call {
        private LocalDateTime begin;
        private long duration;
        private Long customerId;

        public Call(Long customerId, LocalDateTime begin, long duration) {
            this.begin = begin;
            this.duration = duration;
            this.customerId = customerId;
        }

        public LocalDateTime getBegin() {
            return begin;
        }

        public void setBegin(LocalDateTime begin) {
            this.begin = begin;
        }

        public long getDuration() {
            return duration;
        }

        public void setDuration(long duration) {
            this.duration = duration;
        }

        public Long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(Long customerId) {
            this.customerId = customerId;
        }
    }
}
