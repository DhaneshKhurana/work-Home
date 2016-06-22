package org.dhanesh.javabrains.messenger.beans;

import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class QueryBeans {
	private @QueryParam("year") int year; 
	private @QueryParam("start") int start;
	private @QueryParam("offset") int offset;
	
	private @PathParam("messageId") int messageId;
	private @PathParam("commentId") int commentId;
	
	
	public int getMessageId() {
		return messageId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getCommentId() {
		return commentId;
	}
	
	
}
