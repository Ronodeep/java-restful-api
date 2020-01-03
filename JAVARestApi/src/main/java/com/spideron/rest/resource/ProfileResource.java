package com.spideron.rest.resource;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.spideron.model.Profile;
import com.spideron.service.ProfileService;

@Path("/profiles")
public class ProfileResource {
	
	ProfileService profileService=new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Profile> getAllProfiles() {
		
		return profileService.getallProfiles();
	}
}
