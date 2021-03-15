package com.splitwise.model;

import java.util.ArrayList;
import java.util.Scanner;

import com.splitwise.entities.User;
import com.splitwise.model.person.AddToPerson;

public class MenuHandler
{
	Scanner sc=new Scanner(System.in);
	public void menuHandler(char option)
	{
		UserManager userManager=UserManager.UserManager();
		GroupManager groupManager=GroupManager.GroupManager();
		/*
		    System.out.println("\tMenu\n1. Add transaction to a Person:");
			System.out.println("2. Add transaction to a Group (coming soon)");
			System.out.println("3. Show balance");
			System.out.println("4. Settle Dues ");
			System.out.println("5. Exit Menu");
		 */
		char subOption='\0';
		int id=0,userId,groupId;
		switch (option) 
		{
		case '1':
			System.out.println("Select the option\n1. New Contact");
			System.out.println("2. Existing Contact");
			System.out.println("3. Exit");
			subOption=sc.nextLine().charAt(0);
			userId=0;
			
			if(subOption=='1')
			{
				System.out.println("Enter the name: ");
				String name=sc.nextLine();
				if(UserManager.userMap.containsKey(name))
				{
					System.out.println("Contact already exists! Try Again!");
					menuHandler(option);
					
					return;
				}
				else
				{
					userManager.createUser(name);
					userId=UserManager.userMap.get(name).getUserId();
				}
			}
			else if(subOption=='2')
			{
				System.out.println("Select the User ID:");
				userManager.displayAllUser();
				userId=Integer.parseInt(sc.next());
				if(!UserManager.userHash.containsKey(userId))
				{
					System.out.println("User ID does not exist! Try Again!");
					menuHandler(option);
					
					return;
				}
			}
			else if(subOption=='3')
				break;
			else
			{
				System.out.println("Invalid Choice! Try again!");
				menuHandler(option);
				
				return;
			}
			//System.out.println("User ID="+userId);
			AddToPerson add=new AddToPerson();
			add.doTransaction(userId);
			
			break;
	
		case '2':System.out.println("Select the option\n1. New Group");
				System.out.println("2. Existing Group");
				System.out.println("3. Exit");
				subOption=sc.nextLine().charAt(0);
				groupId=0;
				if(subOption=='1')
				{
					System.out.println("Enter the name for the group: ");
					String name=sc.nextLine();
					if(GroupManager.groupNameMap.containsKey(name))
					{
						System.out.println("Group Name already exists! Try Again!");
						menuHandler(option);
						return;
					}
					else
					{
						groupManager.createGroup(name);
						groupId=GroupManager.groupNameMap.get(name).getGroupId();
						System.out.println("Group Created! Please add members to the group");
					}
					//Adding user to the group
					ArrayList<User> groupUser=new ArrayList<User>();
					char subOption2;
					do
					{
						System.out.println("Select the option\n1. New Contact");
						System.out.println("2. Existing Contact");
						System.out.println("3. Exit");
						subOption2=sc.nextLine().charAt(0);
						userId=0;
						
						if(subOption2=='1')
						{
							System.out.println("Enter the name: ");
							name=sc.nextLine();
							if(UserManager.userMap.containsKey(name))
							{
								System.out.println("Contact already exists! Try Again!");
								menuHandler(option);
								
								return;
							}
							else
							{
								userManager.createUser(name);
								userId=UserManager.userMap.get(name).getUserId();
							}
						}
						else if(subOption2=='2')
						{
							System.out.println("Select the User ID:");
							userManager.displayAllUser();
							userId=Integer.parseInt(sc.nextLine().charAt(0)+"");
							if(!UserManager.userHash.containsKey(userId))
							{
								System.out.println("User ID does not exist! Try Again!");
								menuHandler(option);
								
								return;
							}
						}
						else if(subOption2=='3')
							break;
						else
						{
							System.out.println("Invalid Choice! Try again!");
							menuHandler(option);
							
							return;
						}
						groupUser.add(UserManager.userHash.get(userId));
					}while(subOption2!='3');
					GroupManager.groupIDMap.get(groupId).setUser(groupUser);
					
				}
				else if(subOption=='2')
				{
					System.out.println("Select the Group ID:");
					groupManager.displayAllGroups();
					String input=""+sc.nextLine().charAt(0);
					groupId=Integer.parseInt(input);
					if(!GroupManager.groupIDMap.containsKey(groupId))
					{
						System.out.println("Group ID does not exist! Try Again!");
						menuHandler(option);
						return;
					}
				}
				else if(subOption=='3')
					break;
				else
				{
					System.out.println("Invalid Choice! Try again!");
					menuHandler(option);
					return;
				}
				
				AddToGroup addToGroup=new AddToGroup();
				addToGroup.doTransaction(groupId);
				break;
			
		case '3':System.out.println("Select User ID to proceed:");
				userManager.displayAllUser();
				id=sc.nextInt();
				if(UserManager.userHash.containsKey(id))
				{
					ViewBalanceSheet view=new ViewBalanceSheet();
					view.viewBalanceSheet(id);
				}
				else
				{
					System.out.println("Invalid User ID!");
				}
				break;
			
		case '4':System.out.println("Select User ID to proceed:");
				userManager.displayAllUser();
				id=sc.nextInt();
				if(UserManager.userHash.containsKey(id))
				{
					CalculateBalance cb=new CalculateBalance();
					double balance=cb.getBalance(id);
					if(balance>0)
					{
						System.out.println("You get back Rs."+balance+" from "+UserManager.userHash.get(id).getName());
					}
					else if(balance<0)
					{
						System.out.println("You owe Rs."+Math.abs(balance)+" to "+UserManager.userHash.get(id).getName());
					}
				}
				else
				{
					System.out.println("Invalid User ID!");
				}
				break;

		case '5': System.out.println("Select User ID to proceed:");
				userManager.displayAllUser();
				id=Integer.parseInt(sc.nextLine());
				if(UserManager.userHash.containsKey(id))
				{
					CalculateBalance cb=new CalculateBalance();
					DueManager due=new ClearAllDues(id);
					double balance=cb.getBalance(id);
					if(balance>0)
					{
						System.out.println("You get back Rs."+balance+" from "+UserManager.userHash.get(id).getName());
						System.out.println("Do you want to settle all the dues? (Y/N)");
						char ch=sc.nextLine().charAt(0);
						if(ch=='y'||ch=='Y')
						{
							due.clearDues();
						}
					}
					else if(balance<0)
					{
						System.out.println("You owe Rs."+Math.abs(balance)+" to "+UserManager.userHash.get(id).getName());
						System.out.println("Do you want to settle all the dues? (Y/N)");
						char ch=sc.nextLine().charAt(0);
						if(ch=='y'||ch=='Y')
						{
							due.clearDues();
						}
					}
					else
					{
						System.out.println("All dues are settled!");
					}
				}
				else
				{
					System.out.println("Invalid User ID!");
				}
				break;
		
		case '6': System.out.println("Exiting");break;

		default:System.out.println("Invalid Option!");
		}
		

	}

}
