package com.github.serdardundar.solidprinciples.depinvers.begin;

import com.github.serdardundar.solidprinciples.depinvers.formatter.Formatter;
import com.github.serdardundar.solidprinciples.depinvers.formatter.JSONFormatter;
import com.github.serdardundar.solidprinciples.depinvers.model.Message;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MessagePrinter {

	//Writes message to a file
	public void writeMessage(Message msg, String fileName) throws IOException {
		Formatter formatter = new JSONFormatter();//creates formatter
		try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))) { //creates print writer
			writer.println(formatter.format(msg)); //formats and writes message
			writer.flush();
		}
	}
}
