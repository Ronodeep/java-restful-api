package com.spideron.database;

import java.util.HashMap;
import java.util.Map;

import com.spideron.model.Message;
import com.spideron.model.Profile;

public class DatabaseOps {
	private static Map<Long, Message>messageMap=new HashMap<>();
	private static Map<String, Profile>profileMap=new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		
		return messageMap;
	}
	public static Map<String, Profile> getProfiles() {
		
		return profileMap;
	}
}
