package com.splitwise.entities;

public class Account extends User
{
	String id,password;
	boolean login(String id,String password)
	{
		return true;
	}
	void resetPassword()
	{
		
	}

}
