package com.github.serdardundar.solidprinciples.singleresponsibility.begin;

import java.io.IOException;


public class Main {

    private static final String VALID_USER_JSON = "{\"name\": \"Serdar\", \"email\": \"serdar@email.com\", \"address\":\"Hanoi Towers\"}";

    private static final String INVALID_USER_JSON = "{\"name\": \"Dundar\", \"email\": \"dundar@email\", \"address\":\"Empire State Building\"}";

    public static void main(String[] args) throws IOException {
        UserController controller = new UserController();
        
        //Check with valid JSON
        String response = controller.createUser(VALID_USER_JSON);
        if (!response.equalsIgnoreCase("SUCCESS")) {
            System.err.println("Failed");
        }
        System.out.println("Valid JSON received response: " + response);
        
        //Check with invalid JSON
        response = controller.createUser(INVALID_USER_JSON);
        if (!response.equalsIgnoreCase("ERROR")) {
            System.err.println("Failed");
        }
        System.out.println("Invalid JSON received response: " + response);
    }

}
