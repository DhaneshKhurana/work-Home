package org.dhanesh.javabrains.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.dhanesh.javabrains.messenger.model.ErrorMessage;

@Provider
public class ExceptionHandler implements ExceptionMapper<Throwable>{

	@Override
	public Response toResponse(Throwable ex) {
		System.out.println("~~~~~~~~~~~~~~~~Inside Exception Handler~~~~~~~~~~~~~~~~~~~~~");
		ErrorMessage msg = new ErrorMessage(500, ex.getMessage(), "http://www.google.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(msg).build();
	}
	

}
