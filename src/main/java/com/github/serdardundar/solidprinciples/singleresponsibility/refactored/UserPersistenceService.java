package com.github.serdardundar.solidprinciples.singleresponsibility.refactored;

import com.github.serdardundar.solidprinciples.singleresponsibility.model.Store;
import com.github.serdardundar.solidprinciples.singleresponsibility.model.User;

public class UserPersistenceService {

    private final Store store = new Store();

    public void saveUser(User user) {
        store.store(user);
    }
}
