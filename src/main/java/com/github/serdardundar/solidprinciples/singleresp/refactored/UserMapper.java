package com.github.serdardundar.solidprinciples.singleresp.refactored;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.serdardundar.solidprinciples.singleresp.model.User;

import java.io.IOException;

public class UserMapper {

    private final ObjectMapper mapper = new ObjectMapper();

    public User mapToUser(String userJson) throws IOException {
        return mapper.readValue(userJson, User.class);
    }
}
