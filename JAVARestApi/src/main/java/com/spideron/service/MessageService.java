package com.spideron.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.spideron.database.DatabaseOps;
import com.spideron.exception.DataNotFoundException;
import com.spideron.model.Message;

public class MessageService {

	private Map<Long, Message> messageMap = DatabaseOps.getMessages();

	public MessageService() {
		

	}

	public List<Message> getAllMessages() {

		return new ArrayList<>(messageMap.values());
	}

	public Message getMessage(long messageid) {
		Message message = messageMap.get(messageid);
		if(message==null) {
			throw new DataNotFoundException("Message with ID "+messageid+ " not found");
		}
		return message;
	}
	
	public List<Message> getMessagesForYear(int year) {
		Calendar calendar=Calendar.getInstance();
		
		List<Message> messsageList = new ArrayList<Message>();
		for (Message message : messageMap.values()) {
			calendar.setTime(message.getCreated());
			if(year==calendar.get(Calendar.YEAR)) {
				messsageList.add(message);
			}
		}
		return messsageList;
	}
	
	public List<Message> getMessagesOnPagination(int year,int start, int size) {
		Calendar calendar=Calendar.getInstance();
		
		List<Message> messsageList = new ArrayList<Message>();
		if(year<=0) {
			messsageList = new ArrayList<Message>(messageMap.values());
		}
		else {
			for (Message message : messageMap.values()) {
				calendar.setTime(message.getCreated());
				if(year==calendar.get(Calendar.YEAR)) {
					messsageList.add(message);
				}
			}
		}
		return messsageList.subList(start, start+size);
	}
	
	public Message addMessage(Message message) {

		message.setId(messageMap.size() + 1);
		message.setCreated(new Date());
		messageMap.put(message.getId(), message);

		return message;

	}

	public Message updateMessage(Message message) {

		if (message.getId() > 0 && message.getId()<=messageMap.size()) {
			messageMap.put(message.getId(), message);
		} else {
			return null;
		}
		return message;
	}

	public Message removeMessage(long mesId) {

		return messageMap.remove(mesId);
	}
}
