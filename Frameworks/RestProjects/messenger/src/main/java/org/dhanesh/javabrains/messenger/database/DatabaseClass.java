package org.dhanesh.javabrains.messenger.database;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.dhanesh.javabrains.messenger.model.Comment;
import org.dhanesh.javabrains.messenger.model.Message;
import org.dhanesh.javabrains.messenger.model.Profile;

public class DatabaseClass {
	
	private static Map<Integer, Message> messageMap = new HashMap<>();
	private static Map<String, Profile> profileMap = new HashMap<>();
	
	static{
		Message m1 = new Message(1, "hi", "dhanesh");
		Message m2 = new Message(2, "hello", "dhanesh");
		Message m3 = new Message(3, "how", "kaushik");
		Message m4 = new Message(4, "what", "kaushik");
		
		Profile p1 = new Profile(1, "dhanno", "dhanesh", "khurana");
		Profile p2 = new Profile(2, "kasuh", "Kaushik", "kothagal");
		
		Comment c1 = new Comment(1, "Comment1", Calendar.getInstance(), "dhanesh");
		Comment c2 = new Comment(2, "Comment1", Calendar.getInstance(), "dhanesh");
		Comment c3 = new Comment(3, "Comment1", Calendar.getInstance(), "dhanesh");
		Comment c4 = new Comment(1, "Comment1", Calendar.getInstance(), "kaushik");
		Comment c5 = new Comment(2, "Comment1", Calendar.getInstance(), "kaushik");
		Comment c6 = new Comment(3, "Comment1", Calendar.getInstance(), "kaushik");
		
		m1.getCommentsMap().put(1, c1);
		m1.getCommentsMap().put(2, c2);
		m2.getCommentsMap().put(1, c3);
		m3.getCommentsMap().put(1, c4);
		m3.getCommentsMap().put(2, c5);
		m4.getCommentsMap().put(1, c6);
		
		messageMap.put(1, m1);
		messageMap.put(2, m2);
		messageMap.put(3, m3);
		messageMap.put(4, m4);
		
		profileMap.put("dhanno", p1);
		profileMap.put("kaush", p2);
	}
	
	public static Map<Integer, Message> getMessageMap(){
		return messageMap;
	}


	public static Map<String, Profile> getProfileMap() {
		return profileMap;
	}
	
}
