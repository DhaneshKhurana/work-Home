package org.dhanesh.javabrains.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.dhanesh.javabrains.messenger.beans.QueryBeans;
import org.dhanesh.javabrains.messenger.model.Message;
import org.dhanesh.javabrains.messenger.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = {MediaType.APPLICATION_JSON, MediaType.TEXT_XML})
public class MessageResource {

	private MessageService messageService = new MessageService();
	
	
	@GET
	public List<Message> getXMLMessages(@BeanParam QueryBeans bean){
		System.out.println("XML method called");
		//System.out.println(year + " :: "  + start + " :: " + offset);
		System.out.println(bean.getYear() + " :: "  + bean.getStart() + " :: " + bean.getOffset());
		if(bean.getYear()>0){
			System.out.println(messageService.getMessagesForYear(bean.getYear()));
			return messageService.getMessagesForYear(bean.getYear());
		}
		if(bean.getOffset()>0){
			return messageService.getMessagesPage(bean.getStart(), bean.getOffset());
		}
			
		return messageService.getAllMessages();
	}
	
/*	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getJSONMessages(@BeanParam QueryBeans bean){
		System.out.println("JSON method called");
		//System.out.println(year + " :: "  + start + " :: " + offset);
		System.out.println(bean.getYear() + " :: "  + bean.getStart() + " :: " + bean.getOffset());
		if(bean.getYear()>0){
			System.out.println(messageService.getMessagesForYear(bean.getYear()));
			return messageService.getMessagesForYear(bean.getYear());
		}
		if(bean.getOffset()>0){
			return messageService.getMessagesPage(bean.getStart(), bean.getOffset());
		}
			
		return messageService.getAllMessages();
	}*/
	
	@POST
	public Response addMessage(Message msg , @Context UriInfo uriInfo){
		Message message =  messageService.addMessage(msg);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(message.getId())).build();
		
		//return Response.status(Status.CREATED).entity(message).header("msg", "blah-blah").header("loc", uri).build();
		return Response.created(uri).entity(message).header("msg", "blah-blah").build();
	}
	
	@GET
	@Path("/{id}")
	public Message getMessageForId(@PathParam("id")int id, @Context UriInfo uriinfo){
		Message msg = messageService.getMessage(id);
		msg.addLink(getMessageURI(uriinfo, msg), "self");
		msg.addLink(getProfileURI(uriinfo, msg), "self");
		msg.addLink(getCommentURI(uriinfo, msg), "self");
		return msg;
	}

	private URI getMessageURI(UriInfo uriinfo, Message msg) {
		URI uri = uriinfo.getBaseUriBuilder()
					.path(MessageResource.class)
					.path(String.valueOf(msg.getId()))
					.build();
		return uri;
	}
	
	private URI getProfileURI(UriInfo uriinfo, Message msg) {
		URI uri = uriinfo.getBaseUriBuilder()
					.path(ProfileResource.class)
					.path(msg.getAuthor())
					.build();
		return uri;
	}
	
	private URI getCommentURI(UriInfo uriinfo, Message msg) {
		URI uri = uriinfo.getBaseUriBuilder()
					.path(MessageResource.class)
					.path(MessageResource.class, "getComments")
					.resolveTemplate("messageId", msg.getId())
					.build();
		return uri;
	}
	
	
	@PUT
	@Path("/{id}")
	public Message updateMessageForId(@PathParam("id")int id, Message msg){
		msg.setId(id);
		return messageService.updateMesage(id, msg);
	}
	
	@DELETE
	@Path("/{id}")
	public Message deleteMessageForId(@PathParam("id")int id){
		return messageService.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getComments(){
		return new CommentResource();
	}
	
	
	
}
