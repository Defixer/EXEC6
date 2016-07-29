package com.hibernate.exercise6.model;

import java.util.Set;

public class Role{
	private int id;
	private String roleName;
	private Set employees;
	
	public Role() {}
	
	public Role(String roleName){
		this.roleName = roleName;
	}
	
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
	
	public void setRoleName(String roleName){
		this.roleName = roleName;
	}
	public String getRoleName(){
		return roleName;
	}
	
	public boolean equals(Object obj){
		if(obj == null){
			return false;
		}
		if(!this.getClass().equals(obj.getClass())){
			return false;
		}
		
		Role obj2 = (Role)obj;
		if((this.id == obj2.getId()) && (this.roleName.equals(obj2.getRoleName()))){
			return true;
		}
		return false;
	}
	
	public int hashCode(){
		int tmp = 0;
		tmp = (id + roleName).hashCode();
		return tmp;
	}
	
	public void setEmployee(Set employees){
		this.employees = employees;
	}
	
	public Set getEmployee(){
		return employees;
	}
}
