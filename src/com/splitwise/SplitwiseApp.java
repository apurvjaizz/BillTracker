package com.splitwise;
import java.util.Scanner;

import com.splitwise.model.*;
public class SplitwiseApp 
{
	public static void main(String[] args)
	{
		//initializations
		UserManager userManager=UserManager.UserManager();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Please create account to begin\nEnter your name");
		String name=sc.nextLine();
		userManager.createUser(name);
		char option='1';
		do
		{
			option='1';
			System.out.println("\t Menu\n\t------\n1. Add transaction to a Person");
			System.out.println("2. Add transaction to a Group (coming soon)");
			System.out.println("3. Show Transactions");
			System.out.println("4. Show Dues");
			System.out.println("5. Settle Dues");
			System.out.println("6. Exit Menu");
			option=sc.nextLine().charAt(0);
			MenuHandler mh=new MenuHandler();
			if(option!='6')
			{
				mh.menuHandler(option);
			}			
			System.out.println();
		}while(option!='6');
		System.out.println("Thank you");
	}

}
