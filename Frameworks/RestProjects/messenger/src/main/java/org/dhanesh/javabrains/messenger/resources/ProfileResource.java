package org.dhanesh.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.dhanesh.javabrains.messenger.model.Profile;
import org.dhanesh.javabrains.messenger.service.ProfileServices;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileServices profileService = new ProfileServices();
	
	
	@GET
	public List<Profile> getProfiles(){
		return profileService.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile msg){
		return profileService.addProfile(msg);
	}
	
	@GET
	@Path("/{id}")
	public Profile getProfileForId(@PathParam("id")String id){
		return profileService.getProfile(id);
	}
	
	
	@PUT
	@Path("/{id}")
	public Profile updateProfileForId(@PathParam("id")String id, Profile msg){
		return profileService.updateProfile(id, msg);
	}
	
	@DELETE
	@Path("/{id}")
	public Profile deleteProfileForId(@PathParam("id")String id){
		return profileService.removeProfile(id);
	}
	
}
