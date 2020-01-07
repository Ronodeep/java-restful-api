package com.spideron.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.spideron.database.DatabaseOps;
import com.spideron.model.Comment;
import com.spideron.model.Message;

public class CommentService {

	private Map<Long, Message> messageMap = DatabaseOps.getMessages();
	
	public CommentService() {
		int commentID=1;
		for(Message message:messageMap.values()) {
			
			List<Comment>commentList=new ArrayList<>();
			commentList.add(new Comment(commentID, "Hi Ronodeep!! how are you?", "Sagnik", new Date()));
			commentList.add(new Comment(commentID+1, "Hi Ronodeep!! Good Morning. how are you?", "Rohan", new Date()));
			message.setCommentsList(commentList);
			commentID+=2;
		}
	}
	
	public List<Comment>getAllCommentsForMesssageId(long messageId){
		
		System.out.println("Message Id"+messageId);
		
		return messageMap.get(messageId).getCommentsList();
	}
	
	public Comment getCommentForID(long messageId,long commentId) {
		Comment specificComment = null;
		
		List<Comment> commentsList = messageMap.get(messageId).getCommentsList();
		
		for (Comment comment : commentsList) {
			if (comment.getCommentId() == commentId) {
				specificComment = comment;
			}
		}
		return specificComment;
	}
}
