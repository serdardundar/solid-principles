package com.github.serdardundar.solidprinciples.depinvers.formatter;

import com.github.serdardundar.solidprinciples.depinvers.formatter.Formatter;
import com.github.serdardundar.solidprinciples.depinvers.model.Message;

//Formats Message to plain text
public class TextFormatter implements Formatter {

	public String format(Message message){
		return message.getTimestamp().toString() + ":" + message.getMsg();
	}
}
