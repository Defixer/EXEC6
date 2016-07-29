package com.hibernate.exercise6.model;

public class Contact{
	private int id;
	private String contactDetails;
	private String contactType;
	
	public Contact(){}
	
	public Contact(String contactDetails, String contactType){
		this.contactDetails = contactDetails;
		this.contactType = contactType;
	}
	
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	
	public void setContactDetails(String contactDetails){
		this.contactDetails = contactDetails;
	}
	public String getContactDetails(){
		return contactDetails;
	}
	
	public void setContactType(String contactType){
		this.contactType = contactType;
	}
	public String getContactType(){
		return contactType;
	}
	
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(!this.getClass().equals(obj.getClass())){
			return false;
		}
		
		Contact obj2 = (Contact)obj;
		if((this.id == obj2.getId()) && (this.contactDetails.equals(obj2.getContactDetails()))){
			return true;
		}
		return false;
	}
	
	public int hashCode(){
		int tmp = 0;
		tmp = (id + contactDetails).hashCode();
		return tmp;
	}
}
