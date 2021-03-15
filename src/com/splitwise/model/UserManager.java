package com.splitwise.model;
import java.util.HashMap;
import com.splitwise.entities.User;

public class UserManager 
{
	public static HashMap<Integer,User>userHash;
	public static HashMap<String,User>userMap;
	public static int userCount;
	
	private static UserManager single_instance=null; 
    UserManager() 
    { 
        userHash=new HashMap<Integer,User>();
        userMap=new HashMap<String,User>();
        userCount=0;
    }
    public static UserManager UserManager()
    { 
    	if (single_instance == null) 
        { 
            single_instance = new UserManager(); 
        } 
        return single_instance; 
    } 
	
	public void createUser(String name)
	{
		User user=new User(name);
		user.setUserId(userCount);
		user.setName(name);
		userHash.put(userCount++,user);
		userMap.put(user.getName(),user);
	}
	public void displayAllUser()
	{
		System.out.println("ID\tUser Name");
		for(int i=1;i<=userCount;i++)
		{
			if(userHash.get(i) != null)
			{
				User u=userHash.get(i);
				System.out.println(i+"\t"+u.getName());				
			}
		}
	}

}
