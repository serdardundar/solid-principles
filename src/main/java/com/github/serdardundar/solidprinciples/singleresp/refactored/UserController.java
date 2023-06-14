package com.github.serdardundar.solidprinciples.singleresp.refactored;

import com.github.serdardundar.solidprinciples.singleresp.model.User;

import java.io.IOException;

public class UserController {

    private final UserPersistenceService persistenceService = new UserPersistenceService();
    private final UserMapper userMapper = new UserMapper();
    private final UserValidator validator = new UserValidator();

    //Create a new user
    public String createUser(String userJson) throws IOException {
        User user = userMapper.mapToUser(userJson);
        boolean valid = validator.validateUser(user);

        if (!valid) {
            return "ERROR";
        }

        persistenceService.saveUser(user);
        return "SUCCESS";
    }

}