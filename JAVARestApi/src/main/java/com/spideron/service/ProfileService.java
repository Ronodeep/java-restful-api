package com.spideron.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.spideron.database.DatabaseOps;
import com.spideron.model.Profile;

public class ProfileService {
	private static Map<Long, Profile> profileMap = DatabaseOps.getProfiles();
	
	public ProfileService() {
		profileMap.put(1L, new Profile(1L, "Ronodeep", "Ronodeep", "Bhattacharya"));
		profileMap.put(2L, new Profile(2L, "Sagnik", "Sagnik", "Bhattacharyya"));
	}
	
	public List<Profile> getallProfiles(){
		return new ArrayList<Profile>(profileMap.values());
	}
}
