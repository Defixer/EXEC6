package com.hibernate.exercise6.model;

public abstract class Id{
	private int uniqueID;
		
	public abstract void setId(int uniqueID);
	public abstract int getId();
}
