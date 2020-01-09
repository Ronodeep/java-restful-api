package com.spideron.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.spideron.database.DatabaseOps;
import com.spideron.model.Comment;
import com.spideron.model.ErrorMessage;
import com.spideron.model.Message;

public class CommentService {

	private Map<Long, Message> messageMap = DatabaseOps.getMessages();
	private static Map<Long,Comment>commentMap=new HashMap<>();
	
	public CommentService() {
		int commentID=1;
		for(Message message:messageMap.values()) {
			
			List<Comment>commentListForMessage=new ArrayList<>();
			Comment comment1 = new Comment(commentID, "Hi Ronodeep!! how are you?", "Sagnik", new Date());
			Comment comment2 = new Comment(commentID+1, "Hi Ronodeep!! Good Morning. How are you?", "Rohan", new Date());
			
			commentListForMessage.add(comment1);
			commentListForMessage.add(comment2);
			
			commentMap.put(comment1.getCommentId(), comment1);
			commentMap.put(comment2.getCommentId(), comment2);
			
			message.setCommentsList(commentListForMessage);
			commentID+=2;
		}
	}
	
	public List<Comment>getAllCommentsForMesssageId(long messageId){
		
		System.out.println("Message Id"+messageId);
		
		return messageMap.get(messageId).getCommentsList();
	}
	
	public Comment getCommentForID(long messageId,long commentId) {
		Comment specificComment = null;
		
		ErrorMessage errorMessage = new ErrorMessage("Not Found", "https://google.co.in", 404);
		Response response= Response.status(Status.NOT_FOUND).entity(errorMessage).build();
		
		Message message = messageMap.get(messageId);
		if(message==null) {
			//Steps 1:
			//throw new WebApplicationException(Status.NOT_FOUND); // This will send only the status to the response, Proper way to do it as use the Response
			//Steps 2:
			/*
			
			
			throw new WebApplicationException(response); // using response object
			*/
			
			/*
			 * Steps 3:
			 * Much More Cleaner way to do exception handling is using jersey specific exception class
			 */
			throw new NotFoundException(response);
			
		}
		List<Comment> commentsList = messageMap.get(messageId).getCommentsList();
		if(commentsList!=null && commentsList.size()>0) {
			for (Comment comment : commentsList) {
				if (comment.getCommentId() == commentId) {
					specificComment = comment;
				}else {
					throw new NotFoundException(response);
				}
			}
		}
		
		return specificComment;
	}

	public Comment addCommentForID(long messageId, Comment comment) {
		comment.setCommentId(commentMap.size()+1);
		comment.setCreatedon(new Date());
		commentMap.put(comment.getCommentId(), comment);
		
		Message message = messageMap.get(messageId);
		List<Comment> commentsList = message.getCommentsList();
		commentsList.add(comment);
		message.setCommentsList(commentsList);
		//System.out.println(message.getCommentsList());
		return comment;
	}
	
	public Comment updateCommentForID(long messageId, Comment updatedcomment) {
		
		if(updatedcomment.getCommentId()>0 && commentMap.containsKey(updatedcomment.getCommentId())) {
			commentMap.put(updatedcomment.getCommentId(), updatedcomment);
			Message message = messageMap.get(messageId);
			List<Comment> commentsList = message.getCommentsList();
			for (Comment comment : commentsList) {
				if(comment.getCommentId()==updatedcomment.getCommentId()) {
					commentsList.remove(comment);
					commentsList.add(updatedcomment);
				}
			}
			message.setCommentsList(commentsList);
		}
		return updatedcomment;
	}
}
