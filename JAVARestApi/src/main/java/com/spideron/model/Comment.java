package com.spideron.model;

import java.util.Date;

public class Comment {
	
	private long commentId;
	private String message;
	private String authorName;
	private Date createdon;
	
	
	public Comment() {
		super();
	}
	
	public Comment(long commentId, String message, String authorName, Date createdon) {
		super();
		this.commentId = commentId;
		this.message = message;
		this.authorName = authorName;
		this.createdon = createdon;
	}
	
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Date getCreatedon() {
		return createdon;
	}
	public void setCreatedon(Date createdon) {
		this.createdon = createdon;
	}
	
	
}
