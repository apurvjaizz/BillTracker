package com.splitwise.model;

import java.util.Scanner;

import com.splitwise.entities.expense.Expense;
import com.splitwise.entities.split.Split;
import com.splitwise.entities.split.SplitEqualGetsBack;
import com.splitwise.entities.split.SplitEqualOwes;
import com.splitwise.entities.split.SplitExactGetsBack;
import com.splitwise.entities.split.SplitExactOwes;
import com.splitwise.entities.split.SplitGetsBack;
import com.splitwise.entities.split.SplitOwes;
import com.splitwise.model.person.AddToPerson;

public class AddToGroup
{
	Scanner sc=new Scanner(System.in);
	UserManager userManager=UserManager.UserManager();
	GroupManager groupManager=GroupManager.GroupManager();
	public void doTransaction(int groupId) 
	{
		Expense expense=new GroupExpense();
		double amount=AddToPerson.convertStringToFloat();		
		expense.setAmount(amount);
		System.out.println("Select User ID who Paid :");
		groupManager.displayGroup(groupId);
		System.out.println("0 "+UserManager.userHash.get(0).getName());
		String id=sc.nextLine().charAt(0)+"";
		expense.setPaidBy(UserManager.userHash.get(id));
		groupSplitMenu(groupId,expense);
	}
	private void groupSplitMenu(int groupId, Expense expense) 
	{
		int paidUserId=expense.getPaidBy().getUserId();
		double amount=expense.getAmount();
		System.out.println("Select the split option");
		System.out.println("1 Split Rs."+amount+" equally");
		System.out.println("Or any other key to exit");
		char splitOption=sc.nextLine().charAt(0);
		System.out.println("Buy premium for group split :P");
		
	}

}
