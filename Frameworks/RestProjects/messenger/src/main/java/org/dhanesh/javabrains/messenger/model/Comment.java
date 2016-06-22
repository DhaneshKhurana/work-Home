package org.dhanesh.javabrains.messenger.model;

import java.util.Calendar;

public class Comment {
	
	private int id;
	private String content;
	private Calendar created;
	private String author;
	
	public Comment() {
		super();
	}

	public Comment(int id, String content, Calendar created, String author) {
		super();
		this.id = id;
		this.content = content;
		this.created = created;
		this.author = author;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Calendar getCreated() {
		return created;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
