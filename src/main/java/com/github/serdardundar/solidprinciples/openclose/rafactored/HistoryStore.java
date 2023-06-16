package com.github.serdardundar.solidprinciples.openclose.rafactored;

import com.github.serdardundar.solidprinciples.openclose.model.CustomerHistory;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HistoryStore {

    private final Map<Long, List<CustomerHistory>> SESSIONS = new HashMap<>();

    public synchronized List<CustomerHistory> getCurrentSessions(Long customerId) {
        if (!SESSIONS.containsKey(customerId)) {
            return Collections.emptyList();
        }
        return SESSIONS.get(customerId);
    }

    public synchronized void addSession(CustomerHistory customerHistory) {
        List<CustomerHistory> sessions;
        if (!SESSIONS.containsKey(customerHistory.getCustomerId())) {
            sessions = new LinkedList<>();
            SESSIONS.put(customerHistory.getCustomerId(), sessions);
        } else {
            sessions = SESSIONS.get(customerHistory.getCustomerId());
        }
        sessions.add(customerHistory);
    }
}
