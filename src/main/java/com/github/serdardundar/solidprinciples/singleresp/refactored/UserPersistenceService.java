package com.github.serdardundar.solidprinciples.singleresp.refactored;

import com.github.serdardundar.solidprinciples.singleresp.model.Store;
import com.github.serdardundar.solidprinciples.singleresp.model.User;

public class UserPersistenceService {

    private final Store store = new Store();

    public void saveUser(User user) {
        store.store(user);
    }
}
