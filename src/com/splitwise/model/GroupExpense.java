package com.splitwise.model;

import java.util.ArrayList;

import com.splitwise.entities.User;
import com.splitwise.entities.expense.Expense;

public class GroupExpense extends Expense 
{
	ArrayList<User> groupUser;
}
