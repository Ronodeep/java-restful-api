package com.spideron.rest.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.spideron.model.Message;
import com.spideron.service.MessageService;

@Path("/messages")
public class MessageResource {
	MessageService mesServ=new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages() {
		
		return mesServ.getAllMessages();
	}
}
