package com.github.serdardundar.solidprinciples.depinvers.formatter;

import com.github.serdardundar.solidprinciples.depinvers.model.Message;
import com.github.serdardundar.solidprinciples.depinvers.exception.FormatException;

//Common interface for classes formatting Message object
public interface Formatter {
	
	String format(Message message) throws FormatException;
	
}
