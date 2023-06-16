package com.github.serdardundar.solidprinciples.openclose.begin;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class InternetSessionHistory {

    private static final Map<Long, List<InternetSession>> SESSIONS = new HashMap<>();

    public InternetSessionHistory() {
    }

    public static synchronized List<InternetSession> getCurrentSessions(Long customerId) {
        if (!SESSIONS.containsKey(customerId)) {
            return Collections.emptyList();
        }
        return SESSIONS.get(customerId);
    }

    public static synchronized void addSession(Long customerId, LocalDateTime begin, long dataUsed) {
        List<InternetSession> sessions;
        if (!SESSIONS.containsKey(customerId)) {
            sessions = new LinkedList<>();
            SESSIONS.put(customerId, sessions);
        } else {
            sessions = SESSIONS.get(customerId);
        }
        sessions.add(new InternetSession(customerId, begin, dataUsed));
    }

    public static class InternetSession {

        private LocalDateTime begin;
        private Long customerId;
        private Long dataUsed;

        public InternetSession(Long customerId, LocalDateTime begin, long dataUsed) {
            this.begin = begin;
            this.dataUsed = dataUsed;
            this.customerId = customerId;
        }

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

        public Long getDataUsed() {
            return dataUsed;
        }

        public void setDataUsed(Long dataUsed) {
            this.dataUsed = dataUsed;
        }
    }
}
