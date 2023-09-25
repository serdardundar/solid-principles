package com.github.serdardundar.solidprinciples.depinvers.begin;

import com.github.serdardundar.solidprinciples.depinvers.model.Message;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		Message msg = new Message("This is a message");
		MessagePrinter printer = new MessagePrinter();
		printer.writeMessage(msg, "test_msg.txt");
	}

}
