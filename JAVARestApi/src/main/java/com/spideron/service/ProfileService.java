package com.spideron.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.spideron.database.DatabaseOps;
import com.spideron.model.Profile;

public class ProfileService {
	private static Map<String, Profile> profileMap = DatabaseOps.getProfiles();
	
	public ProfileService() {
		profileMap.put("Ronodeep", new Profile("Ronodeep", "Ronodeep", "Ronodeep", "Bhattacharya"));
		profileMap.put("Sagnik", new Profile("Sagnik", "Sagnik", "Sagnik", "Bhattacharyya"));
	}
	
	public List<Profile> getallProfiles(){
		return new ArrayList<Profile>(profileMap.values());
	}
	
	public Profile getProfile(String profileName){
		return profileMap.get(profileName);
	}
}
