package com.splitwise.model;

import com.splitwise.entities.expense.Expense;

public class ViewBalanceSheet
{
	BalanceSheet balanceSheet=BalanceSheet.getInstance();
	public void viewBalanceSheet(int userId)
	{
		System.out.println("ExpnseID Transaction Details");
		if(balanceSheet.balanceSheet.get(userId) == null)
		{
			System.out.println("You are all clear with the transactions");
		}
		else
		for(Expense expense:balanceSheet.balanceSheet.get(userId))
		{
			System.out.print(expense.getId()+"\t");
			System.out.println(expense.getPaidBy().getName()+" paid "+expense.getAmount()+" you get back Rs."+expense.getGetsBack()+", you owe Rs."+expense.getOwes());
		}
		System.out.println();
	}

}
