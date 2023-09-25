package com.github.serdardundar.solidprinciples.depinvers.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.github.serdardundar.solidprinciples.depinvers.exception.FormatException;
import com.github.serdardundar.solidprinciples.depinvers.model.Message;

//Formats message to JSON format
public class JSONFormatter implements Formatter {

    public String format(Message message) throws FormatException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        try {
            return mapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new FormatException(e);
        }
    }
}
