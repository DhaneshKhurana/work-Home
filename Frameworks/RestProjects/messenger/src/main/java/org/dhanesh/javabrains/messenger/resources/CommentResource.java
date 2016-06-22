package org.dhanesh.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dhanesh.javabrains.messenger.beans.QueryBeans;
import org.dhanesh.javabrains.messenger.service.CommentService;
import org.dhanesh.javabrains.messenger.model.Comment;


@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CommentResource {

	private CommentService commentService = new CommentService();	
	
	@GET
	public List<Comment> getComments(@BeanParam QueryBeans bean){
		System.out.println(bean.getYear() + " :: "  + bean.getStart() + " :: " + bean.getOffset() 
							+" messageId " + bean.getMessageId());
		return commentService.getAllComments(bean.getMessageId());
	}
	
	@POST
	public Comment addComment(@BeanParam QueryBeans bean, Comment msg){
		return commentService.addComment(bean.getMessageId(), msg);
	}
	
	@GET
	@Path("/{commentId}")
	public Comment getCommentForId(@BeanParam QueryBeans bean){
		return commentService.getComment(bean.getMessageId(), bean.getCommentId());
	}
	
	
	@PUT
	@Path("/{commentId}")
	public Comment updateCommentForId(@BeanParam QueryBeans bean, Comment msg){
		msg.setId(bean.getCommentId());
		return commentService.updateComment(bean.getMessageId(), bean.getCommentId(), msg);
	}
	
	@DELETE
	@Path("/{commentId}")
	public Comment deleteCommentForId(@BeanParam QueryBeans bean){
		return commentService.removeComment(bean.getMessageId(), bean.getCommentId());
	}
	
	
	
}
