package com.spideron.service;

import java.util.ArrayList;
import java.util.List;

import com.spideron.model.Message;

public class MessageService {
	
	public List<Message> getAllMessages(){
		Message mes1= new Message(1L, "Hello Ronodeep", "Ronodeep");
		Message mes2= new Message(2L, "Hello Rohan", "Rohan");
		Message mes3= new Message(3L, "Hello Sagnik", "Sagnik");
		
		List<Message> messageList=new ArrayList<Message>();
		messageList.add(mes1);
		messageList.add(mes2);
		messageList.add(mes3);
		
		return messageList;
	}
}
