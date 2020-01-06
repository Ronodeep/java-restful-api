package com.spideron.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.spideron.database.DatabaseOps;
import com.spideron.model.Profile;

public class ProfileService {
	private static Map<String, Profile> profileMap = DatabaseOps.getProfiles();
	
	public ProfileService() {
		profileMap.put("Ronodeep", new Profile(1L, "Ronodeep", "Ronodeep", "Bhattacharya"));
		profileMap.put("Sagnik", new Profile(2L, "Sagnik", "Sagnik", "Bhattacharyya"));
	}
	
	public List<Profile> getallProfiles(){
		return new ArrayList<Profile>(profileMap.values());
	}
	
	public Profile getProfile(String profileName){
		return profileMap.get(profileName);
	}
	
	public List<Profile> getProfilesOnPagination(int start, int size) {
		
		List<Profile> profileList = new ArrayList<Profile>();
		profileList = new ArrayList<Profile>(profileMap.values());
		
		return profileList.subList(start, start+size);
	}
	
	public Profile addNewProfile(Profile profile){
		profile.setProfileId(profileMap.size()+1);
		return profileMap.put(profile.getProfileName(), profile);
	}
	
	public Profile updateProfile(Profile profile){
		Profile returnProfile=null; 
		if(!profile.getProfileName().isEmpty()) {
			returnProfile= profileMap.put(profile.getProfileName(), profile);
		}
		
		return returnProfile;
	}
	
	public Profile deleteProfile(String profileName){
		
		return profileMap.remove(profileName);
	}
	
}
