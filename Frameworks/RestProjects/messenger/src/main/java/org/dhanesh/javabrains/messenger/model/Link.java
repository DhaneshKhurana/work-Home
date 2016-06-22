package org.dhanesh.javabrains.messenger.model;

import java.net.URI;

public class Link {
	
	private URI link;
	private String rel;
	
	public Link() {
		super();
	}
	
	public Link(URI link, String rel) {
		super();
		this.link = link;
		this.rel = rel;
	}



	public URI getLink() {
		return link;
	}

	public void setLink(URI link) {
		this.link = link;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}
	
	

}
