package com.github.serdardundar.solidprinciples.depinvers.end;

import com.github.serdardundar.solidprinciples.depinvers.formatter.JSONFormatter;
import com.github.serdardundar.solidprinciples.depinvers.formatter.TextFormatter;
import com.github.serdardundar.solidprinciples.depinvers.model.Message;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {

    public static void main(String[] args) throws IOException {

        Message msg = new Message("This is a message again");
        MessagePrinter printer = new MessagePrinter();
        try (PrintWriter writer = new PrintWriter(System.out)) {
            printer.writeMessage(msg, new JSONFormatter(), writer);
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("test_msg.txt"))) {
            printer.writeMessage(msg, new TextFormatter(), writer);
        }
    }

}
