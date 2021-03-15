package com.splitwise.model;

public abstract class DueManager
{
	BalanceSheet balanceSheet=BalanceSheet.getInstance();
	int id;
	DueManager(int id)
	{
		this.id=id;
	}
	public void clearDues() {
		// TODO Auto-generated method stub
	}
}
