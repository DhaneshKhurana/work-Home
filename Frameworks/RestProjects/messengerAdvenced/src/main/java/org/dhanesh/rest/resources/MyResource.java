package org.dhanesh.rest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("test")
@Produces(MediaType.TEXT_PLAIN)
public class MyResource {

	
	@GET
	public String test(){
		return "Hey I am test method";
	}
}
