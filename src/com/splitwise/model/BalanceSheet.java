package com.splitwise.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.splitwise.entities.expense.Expense;

public class BalanceSheet
{
		public static HashMap<Integer,ArrayList<Expense>> balanceSheet;
		static int expense_id;
		private static BalanceSheet single_instance=null; 
		BalanceSheet() 
	    { 
			balanceSheet=new HashMap<Integer,ArrayList<Expense>>();
			expense_id=0;
	    }
	    public static BalanceSheet getInstance()
	    { 
	    	if (single_instance == null) 
	        { 
	            single_instance = new BalanceSheet(); 
	        } 
	        return single_instance; 
	    } 
		
	
}
