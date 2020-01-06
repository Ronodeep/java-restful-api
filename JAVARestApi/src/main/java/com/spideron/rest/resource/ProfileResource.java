package com.spideron.rest.resource;

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

import com.spideron.model.Profile;
import com.spideron.service.ProfileService;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.APPLICATION_XML)
public class ProfileResource {

	ProfileService profileService = new ProfileService();

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Profile> getAllProfiles() {
		return profileService.getallProfiles();
	}

	@GET
	@Path("/{profilename}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profilename") String profileName) {

		return profileService.getProfile(profileName);
	}

	@POST
	public Profile addNewProfile(Profile profile) {
		return profileService.addNewProfile(profile);
	}

	@PUT
	@Path("/{profilename}")
	public Profile updateProfile(@PathParam("profilename") String profileName, Profile profile) {
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);
	}

	@DELETE
	@Path("/{profilename}")
	public void updateProfile(@PathParam("profilename") String profileName) {
		profileService.deleteProfile(profileName);
	}
}
