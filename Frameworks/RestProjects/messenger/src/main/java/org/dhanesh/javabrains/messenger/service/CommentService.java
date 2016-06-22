package org.dhanesh.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.dhanesh.javabrains.messenger.database.DatabaseClass;
import org.dhanesh.javabrains.messenger.model.Comment;
import org.dhanesh.javabrains.messenger.model.ErrorMessage;
import org.dhanesh.javabrains.messenger.model.Message;

public class CommentService {
	
	private Map<Integer, Message> messgaeMap = DatabaseClass.getMessageMap();
	
	public List<Comment> getAllComments(int id){
		return new ArrayList<>(messgaeMap.get(id).getCommentsMap().values());
	}
	
	public List<Comment> getCommentsPage(int id, int start, int offet){
		List<Comment> Comments = new ArrayList<>(messgaeMap.get(id).getCommentsMap().values());
		if( (start + offet) > Comments.size()){
			return Comments.subList(start, Comments.size());
		}else{
			return Comments.subList(start, start+offet);
		}
		
	}
	
	
	public Comment getComment(int messageid, int id){
		ErrorMessage msg = new ErrorMessage(404, "message not gound", "happy");
		Response response = Response.status(Status.NOT_FOUND).entity(msg).build();
		if(messgaeMap.containsKey(messageid)){
			throw new WebApplicationException(response);
		}
		if(messgaeMap.get(messageid).getCommentsMap().containsKey(id)){
			return messgaeMap.get(messageid).getCommentsMap().get(id);
		}else{
			return new Comment();
		}
	}
	
	public Comment addComment(int id, Comment msg){
		int commentId = messgaeMap.get(id).getCommentsMap().size()+1;
		msg.setId(commentId);
		messgaeMap.get(id).getCommentsMap().put(commentId, msg);
		return msg;
	}
	
	public Comment updateComment(int messageId, int id, Comment msg){
		if(messgaeMap.get(messageId).getCommentsMap().containsKey(id)){
			messgaeMap.get(messageId).getCommentsMap().put(id, msg);
			return msg;
		}else{
			return new Comment();
		}
	}
	
	public Comment removeComment(int messageId, int id){
		if(messgaeMap.get(messageId).getCommentsMap().containsKey(id)){
			Comment msg= messgaeMap.get(messageId).getCommentsMap().get(id);
			messgaeMap.get(messageId).getCommentsMap().remove(id);
			return msg;
		}else{
			return new Comment();
		}
	}
}
