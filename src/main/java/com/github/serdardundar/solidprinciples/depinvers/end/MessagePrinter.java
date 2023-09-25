package com.github.serdardundar.solidprinciples.depinvers.end;

import com.github.serdardundar.solidprinciples.depinvers.formatter.Formatter;
import com.github.serdardundar.solidprinciples.depinvers.model.Message;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MessagePrinter {

	//Writes message to a file
	public void writeMessage(Message msg, Formatter formatter, PrintWriter writer) throws IOException {
		writer.println(formatter.format(msg)); //formats and writes message
		writer.flush();
	}
}
