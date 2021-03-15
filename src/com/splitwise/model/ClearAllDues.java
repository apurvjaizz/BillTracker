package com.splitwise.model;

public class ClearAllDues extends DueManager 
{

	ClearAllDues(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void clearDues()
	{
		balanceSheet.balanceSheet.remove(id);
		System.out.println("All dues are settled! ");
	}

}
