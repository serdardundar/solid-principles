package com.github.serdardundar.solidprinciples.singleresponsibility.begin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.serdardundar.solidprinciples.singleresponsibility.model.Store;
import com.github.serdardundar.solidprinciples.singleresponsibility.model.User;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserController {

    private final Store store = new Store();

    //Create a new user
    public String createUser(String userJson) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(userJson, User.class);

        if (!isValidUser(user)) {
            return "ERROR";
        }

        store.store(user);

        return "SUCCESS";
    }

    private boolean isValidUser(User user) {
        if (!isPresent(user.getName())) {
            return false;
        }
        user.setName(user.getName().trim());

        if (!isValidAlphaNumeric(user.getName())) {
            return false;
        }
        if (user.getEmail() == null || user.getEmail().trim().length() == 0) {
            return false;
        }
        user.setEmail(user.getEmail().trim());
        return isValidEmail(user.getEmail());
    }

    private boolean isPresent(String value) {
        return value != null && value.trim().length() > 0;
    }

    private boolean isValidAlphaNumeric(String value) {
        Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
        Matcher matcher = pattern.matcher(value);
        return !matcher.find();
    }

    //Just for demo not perfect implementation
    private boolean isValidEmail(String value) {
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(value);
        return matcher.find();
    }

}