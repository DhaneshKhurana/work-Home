package org.dhanesh.javabrains.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dhanesh.javabrains.messenger.database.DatabaseClass;
import org.dhanesh.javabrains.messenger.model.Profile;

public class ProfileServices {

	private Map<String, Profile> profileMap = DatabaseClass.getProfileMap();
	
	public List<Profile> getAllProfiles(){
		return new ArrayList<>(profileMap.values());
	}
	
	public Profile getProfile(String name){
		if(profileMap.containsKey(name)){
			return profileMap.get(name);
		}else{
			return new Profile();
		}
	}
	
	public Profile addProfile(Profile msg){
		if(!profileMap.containsKey(msg.getProfileName())){
			int id = profileMap.size()+1;
			msg.setId(id);
			profileMap.put(msg.getProfileName(), msg);
			return msg;
		}else{
			return new Profile(-1, "Server", "Prfile already exists", "Server");	
		}
		
	}
	
	public Profile updateProfile(String id, Profile msg){
		if(profileMap.containsKey(id)){
			profileMap.put(id, msg);
			return msg;
		}else{
			return new Profile(404,"Server", "Sorry required source not found", "Server");
		}
	}
	
	public Profile removeProfile(String id){
		if(profileMap.containsKey(id)){
			Profile msg= profileMap.get(id);
			profileMap.remove(id);
			return msg;
		}else{
			return new Profile(404, "Server", "Sorry required source not found to delete", "Server");
		}
	}
}
