package com.splitwise.entities;

import java.util.ArrayList;

public class Group 
{
	ArrayList<User> user;
	int groupId;
	String groupName;
	public Group()
	{
		super();
		user=new ArrayList<User>();
	}
	public Group(String groupName)
	{
		super();
		this.groupName=groupName;
		user=new ArrayList<User>();
	}
	
	public Group(ArrayList<User> user, int groupId) {
		super();
		this.user = user;
		this.groupId = groupId;
	}
	public ArrayList<User> getUser() {
		return user;
	}
	public void setUser(ArrayList<User> user) {
		this.user = user;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	

}
