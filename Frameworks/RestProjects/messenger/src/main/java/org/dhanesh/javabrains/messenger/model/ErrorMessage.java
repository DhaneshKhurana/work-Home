package org.dhanesh.javabrains.messenger.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	
	private int id;
	private String message;
	private String documentationLink;
	
	public ErrorMessage(){
		
	}
	
	public ErrorMessage(int id, String message, String documentationLink) {
		this.id = id;
		this.message = message;
		this.documentationLink = documentationLink;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDocumentationLink() {
		return documentationLink;
	}

	public void setDocumentationLink(String documentationLink) {
		this.documentationLink = documentationLink;
	}
	
	
	
}
