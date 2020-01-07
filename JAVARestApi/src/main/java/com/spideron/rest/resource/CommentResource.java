package com.spideron.rest.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.spideron.model.Comment;
import com.spideron.service.CommentService;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class CommentResource {
	
	CommentService commentServ=new CommentService();
	
	@GET
	public List<Comment> getAllCommentsforMessage(@PathParam("messageID")long messageId) {
		
		return commentServ.getAllCommentsForMesssageId(messageId);
		
	}
	
	/**
	 * Here we can access all the path param like message id and comment id 
	 * @return
	 */
	@GET
	@Path("/{commentId}")
	public Comment getCommentforMessage(@PathParam("messageID")long messageId,@PathParam("commentId")long commentId) {
		return commentServ.getCommentForID(messageId, commentId);
	}
}
