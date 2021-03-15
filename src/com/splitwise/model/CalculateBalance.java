package com.splitwise.model;
import com.splitwise.entities.expense.Expense;

public class CalculateBalance 
{
	BalanceSheet balanceSheet=BalanceSheet.getInstance();
	public double getBalance(int id)
	{
		float total_owes=0,total_getBack=0;
		if(balanceSheet.balanceSheet.get(id) == null)
		{
			System.out.println("You are all clear with the dues");
		}
		else
		for(Expense expense:balanceSheet.balanceSheet.get(id))
		{
			total_owes+=expense.getOwes();
			total_getBack+=expense.getGetsBack();
		}
		return total_getBack-total_owes;
	}

}
