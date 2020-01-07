package com.spideron.rest.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.spideron.model.Message;
import com.spideron.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService mesServ=new MessageService();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Message> getAllMessages(@QueryParam("year")int year,@QueryParam("start")int start,@QueryParam("size")int size) {
		System.out.println("Year="+year);
		System.out.println("Start="+start);
		System.out.println("Size="+size);
		if(year>0 && start>=0 && size>0) {
			System.out.println("Case 1");
			return mesServ.getMessagesOnPagination(year, start, size);
		}
		else if(year<=0 && start>=0 && size>0) {
			System.out.println("Case 2");
			return mesServ.getMessagesOnPagination(year, start, size);
		}
		else if(year>0) {
			System.out.println("Case 3");
			return mesServ.getMessagesForYear(year);
		}
		else {
			System.out.println("Case 4");
			return mesServ.getAllMessages();
		}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message message) {
		
		return mesServ.addMessage(message);
	}
	
	@GET
	@Path("/{messageID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessageForID(@PathParam("messageID") long messageId) {
		
		return mesServ.getMessage(messageId);
	}
	
	@PUT
	@Path("/{messageID}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageID")long messageId, Message message) {
		message.setId(messageId);
		
		return mesServ.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageID}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageID") long messageId) {
		
		mesServ.removeMessage(messageId);
	}
	
	/**
	 * Sub Resource for Comments
	 * @return
	 */
	@Path("/{messageID}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
}
