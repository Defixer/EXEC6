package com.hibernate.exercise6.model;

import java.util.Set;
import java.util.Comparator;

public class Employee extends Id{
	private int uniqueId;
	private Name nameInfo;
	private Address addressInfo;
	private OtherInfo otherInfo;
	private Set contact;
	private Set role;
	
	public Employee() {}
	
	public Employee(Name nameInfo, Address addressInfo, OtherInfo otherInfo){
		this.nameInfo = nameInfo;
		this.addressInfo = addressInfo;
		this.otherInfo = otherInfo;
	}
	
	public void setId(int uniqueId){
		this.uniqueId = uniqueId;
	}
	public int getId(){
		return uniqueId;
	}
	
	public void setName(Name nameInfo){
		this.nameInfo = nameInfo;
	}
	public Name getName(){
		return nameInfo;
	}
	
	public void setAddress(Address addressInfo){
		this.addressInfo = addressInfo;
	}
	public Address getAddress(){
		return addressInfo;
	}
	
	public void setOtherInfo(OtherInfo otherInfo){
		this.otherInfo = otherInfo;
	}
	public OtherInfo getOtherInfo(){
		return otherInfo;
	}
	
	public void setContacts(Set contact){
		this.contact = contact;
	}
	public Set getContacts(){
		return contact;
	}
	
	public void setRole(Set role){
		this.role = role;
	}
	public Set getRole(){
		return role;
	}
	
	public static Comparator<Employee> employeeGwaComparator = new Comparator<Employee>(){
		public int compare(Employee emp1, Employee emp2){
			String emp1Gwa = String.valueOf(emp1.otherInfo.getGwa());
			String emp2Gwa = String.valueOf(emp2.otherInfo.getGwa());
			
			return emp1Gwa.compareTo(emp2Gwa);
		}		
	};
}
