package com.beans;

public class UserBean {
private int uid;
private String name,email,gender,occupation;
private String address,contact,location;

public UserBean() {}

public UserBean(String name, String email, String gender, String occupation, String address,String location,
		String contact) {
	super();
	this.name = name;
	this.email = email;
	this.gender = gender;
	this.occupation = occupation;
	
	this.address = address;
	this.location = location;
	this.contact = contact;
}

public UserBean(int uid, String name, String email, String gender, String occupation,
		String address,String location, String contact) {
	super();
	this.uid = uid;
	this.name = name;
	this.email = email;
	this.gender = gender;
	this.occupation = occupation;
	this.address = address;
	this.location = location;
	this.contact = contact;
}

public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getOccupation() {
	return occupation;
}
public void setOccupation(String occupation) {
	this.occupation = occupation;
}

public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}

}
