package com.splitwise.model;

import java.util.HashMap;

import com.splitwise.entities.Group;
import com.splitwise.entities.User;

public class GroupManager 
{
		UserManager userManager=UserManager.UserManager();
		public static HashMap<Integer,Group>groupIDMap;
		public static HashMap<String,Group>groupNameMap;
		int groupId;
		
		private static GroupManager single_instance=null; 
		GroupManager() 
	    { 
			groupIDMap=new HashMap<Integer,Group>();
			groupNameMap=new HashMap<String,Group>();
	        groupId=1;
	    }
	    public static GroupManager GroupManager()
	    { 
	    	if (single_instance == null) 
	        { 
	            single_instance = new GroupManager(); 
	        } 
	        return single_instance; 
	    } 
	    public void createGroup(String name)
		{
	    	Group group=new Group(name);
	    	group.setGroupId(groupId);
			group.setGroupName(name);
			groupIDMap.put(groupId++,group);
			groupNameMap.put(group.getGroupName(),group);
		}
		public void createUser(String name)
		{
			User user=new User(name);
			user.setUserId(UserManager.userCount);
			user.setName(name);
			UserManager.userHash.put(UserManager.userCount++,user);
			UserManager.userMap.put(user.getName(),user);
		}
		public void displayAllGroups()
		{
			System.out.println("ID\tGroup Name");
			for(int i=1;i<=groupId;i++)
			{
				if(groupIDMap.get(i) != null)
				{
					System.out.println(i+"  "+groupIDMap.get(i).getGroupName());
				}
			}
		}
		public void displayGroup(int groupId)
		{
			System.out.println("ID\tUser Name");
			for(User user:groupIDMap.get(groupId).getUser())
			{
				if(user != null)
				{
					System.out.println(user.getUserId()+"\t"+user.getName());				
				}
			}
			
		}
		
}
