package org.dhanesh.javabrains.messenger.demos;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

@Path("/params")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.TEXT_PLAIN)
public class ParamDemo {

	@GET
	@Path("test")
	public String testOne(@MatrixParam("matrix") String matrix,
						@HeaderParam("Content-Type") String content,
						@CookieParam("cook") String cook){
		
		System.out.println(matrix + " :: " + content + " :: " + cook);
		
		return (matrix + " :: " + content + " :: " + cook);
	}
	
	@GET
	@Path("context")
	public String contextTest(@Context UriInfo urlinfo, @Context HttpHeaders headers){
		System.out.println("base uri :: " + urlinfo.getBaseUri() + " :: " + headers.getLength() + " :: " + headers.getCookies() + " last :: " + urlinfo.getPathParameters());
		String text = urlinfo.getPath(true);
		return text;
	}
}
