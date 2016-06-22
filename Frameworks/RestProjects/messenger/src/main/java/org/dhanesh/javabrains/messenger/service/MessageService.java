package org.dhanesh.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.dhanesh.javabrains.messenger.database.DatabaseClass;
import org.dhanesh.javabrains.messenger.model.Message;

public class MessageService {
	
	private Map<Integer, Message> messgaeMap = DatabaseClass.getMessageMap();
	
	public List<Message> getAllMessages(){
		return new ArrayList<>(messgaeMap.values());
	}
	
	public List<Message> getMessagesForYear(int year){
		List<Message> messages = new ArrayList<>();
		for(Message msg : messgaeMap.values()){
			Calendar date = Calendar.getInstance();
			date.setTime(msg.getDateCreated());
			if(date.get(Calendar.YEAR)==year){
				messages.add(msg);
			}
		}
		return messages;
	}
	
	public List<Message> getMessagesPage(int start, int offet){
		List<Message> messages = new ArrayList<>(messgaeMap.values());
		if( (start + offet) > messages.size()){
			return messages.subList(start, messages.size());
		}else{
			return messages.subList(start, start+offet);
		}
		
	}
	
	
	
	public Message getMessage(int id){
		if(messgaeMap.containsKey(id)){
			return messgaeMap.get(id);
		}else{
			throw new RuntimeException();
		}
	}
	
	public Message addMessage(Message msg){
		int id = messgaeMap.size()+1;
		msg.setId(id);
		messgaeMap.put(id, msg);
		return msg;
	}
	
	public Message updateMesage(int id, Message msg){
		if(messgaeMap.containsKey(id)){
			messgaeMap.put(id, msg);
			return msg;
		}else{
			return new Message(404, "Sorry required source not found", "Server");
		}
	}
	
	public Message removeMessage(int id){
		if(messgaeMap.containsKey(id)){
			Message msg= messgaeMap.get(id);
			messgaeMap.remove(id);
			return msg;
		}else{
			return new Message(404, "Sorry required source not found to delete", "Server");
		}
	}
	
}
