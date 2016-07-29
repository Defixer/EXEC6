package com.hibernate.exercise6.model;

public class Name{
	private String firstName,
									lastName,
									middleName,
									suffix,
									title;
	
	public Name() {}
	
	public Name(String title, String firstName, String middleName, String lastName, String suffix){
		this.title = title;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.suffix = suffix;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return title;
	} 
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getFirstName(){
		return firstName;
	}
	
	public void setMiddleName(String middleName){
		this.middleName = middleName;
	}
	public String getMiddleName(){
		return middleName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public String getLastName(){
		return lastName;
	}
	
	public void setSuffix(String suffix){
		this.suffix = suffix;
	}
	public String getSuffix(){
		return suffix;
	}
}
