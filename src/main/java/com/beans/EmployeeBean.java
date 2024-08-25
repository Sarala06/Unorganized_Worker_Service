package com.beans;

public class EmployeeBean {
private int id;
private String name,email,password,address,contact,location;

public EmployeeBean() {
	super();
	// TODO Auto-generated constructor stub
}

public EmployeeBean(String name, String email, String password, String address, String contact, String location) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
	this.address = address;
	this.contact = contact;
	this.location = location;
}

public EmployeeBean(int id, String name, String email, String password, String address, String contact, String location) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.address = address;
	this.contact = contact;
	this.location = location;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getContact() {
	return contact;
}
public void setContact(String contact) {
	this.contact = contact;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}

}
