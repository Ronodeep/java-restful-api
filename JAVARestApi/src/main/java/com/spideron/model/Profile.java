package com.spideron.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Profile {
	private String profileId;
	private String profileName;
	private String firstName;
	private String lastName;
	
	public Profile() {
		super();
	}

	public Profile(String profileId, String profileName, String firstName, String lastName) {
		super();
		this.profileId = profileId;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getProfileId() {
		return profileId;
	}

	public void setProfileId(String profileId) {
		this.profileId = profileId;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
