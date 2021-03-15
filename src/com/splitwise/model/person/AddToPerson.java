package com.splitwise.model.person;
import java.util.Scanner;
import com.splitwise.entities.expense.Expense;
import com.splitwise.entities.split.*;
import com.splitwise.model.AddToBalanceSheet;
import com.splitwise.model.UserManager;
import com.splitwise.entities.User;

public class AddToPerson
{
	Scanner sc=new Scanner(System.in);
	UserManager userManager=UserManager.UserManager();
	public void doTransaction(int userId)
	{
		Expense expense=new Expense();
		double amount=convertStringToFloat();		
		expense.setAmount(amount);
		splitMenu(userId,expense);
	}
	private void splitMenu(int userId, Expense expense) 
	{
		AddToBalanceSheet addExpense=new AddToBalanceSheet();

		User user=UserManager.userHash.get(userId);
		User currUser=UserManager.userHash.get(0);
		double amount=expense.getAmount();
		System.out.println("Select paid by:");
		System.out.println("1 "+currUser.getName());
		System.out.println("2 "+user.getName());
		char paidBy=sc.nextLine().charAt(0);
		if(paidBy=='1')
			expense.setPaidBy(currUser);
		else
			expense.setPaidBy(user);
		System.out.println("Select the split option");
		System.out.println("1 "+expense.getPaidBy().getName()+" gets back  Rs."+amount);
		System.out.println("2 Split Rs."+amount+" equally");
		System.out.println("3 Split amount manually");
		System.out.println("Or any other key to exit");
		char splitOption=sc.nextLine().charAt(0);

		if(splitOption=='1')
		{
			if(!expense.getPaidBy().getName().equalsIgnoreCase(UserManager.userHash.get(0).getName()))
			{
				Split split=new SplitOwes(amount);
				split.split();
				expense.setUserWith(user);
				expense.setSplits(split);
				addExpense.addExpense(expense);
				System.out.println("Split successful!");
			}
			else
			{
				Split split=new SplitGetsBack(amount);
				split.split();
				expense.setUserWith(user);
				expense.setSplits(split);
				addExpense.addExpense(expense);
				System.out.println("Split successful!");
			}
		}
		else if(splitOption=='2')
		{
			if(!expense.getPaidBy().getName().equalsIgnoreCase(UserManager.userHash.get(0).getName()))
			{
				Split split=new SplitEqualOwes(amount);
				split.split();
				expense.setUserWith(user);
				expense.setSplits(split);
				addExpense.addExpense(expense);
				System.out.println("Split successful!");
			}
			else
			{
				Split split=new SplitEqualGetsBack(amount);
				split.split();
				expense.setUserWith(user);
				expense.setSplits(split);
				addExpense.addExpense(expense);
				System.out.println("Split successful!");
			}
		}
		else if(splitOption=='3')
		{
			if(!expense.getPaidBy().getName().equalsIgnoreCase(UserManager.userHash.get(0).getName()))
			{
				Split split=new SplitExactOwes(amount);
				double amt=convertStringToFloat();
				split.split(amt);
				expense.setUserWith(user);
				expense.setSplits(split);
				addExpense.addExpense(expense);
				System.out.println("Split successful!");		
			}
			else
			{
				Split split=new SplitExactGetsBack(amount);
				double amt=convertStringToFloat();
				split.split(amt);
				expense.setUserWith(user);
				expense.setSplits(split);
				addExpense.addExpense(expense);
				System.out.println("Split successful!");		
			}
		}
		else
		{
			System.out.println("Exiting split menu");
		}
		
	}
	public static double convertStringToFloat() 
    { 
		Scanner sc=new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter expense Amount: ");
			String amt=sc.nextLine();
			try
	        { 
	           double amount=Float.parseFloat(amt);
	           return amount;
	        } 
	        catch (Exception e)
	        {
	        	System.out.println("Invalid amount!");
				continue;
	        }
		}
    }

}
