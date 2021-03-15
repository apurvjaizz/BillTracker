package com.splitwise.model;
import java.util.ArrayList;
import java.util.List;
import com.splitwise.entities.expense.Expense;

public class AddToBalanceSheet
{
		BalanceSheet balanceSheet=BalanceSheet.getInstance();
		public void addExpense(Expense e)
		{
			e.setId(++balanceSheet.expense_id);
			int id=e.getUserWith().getUserId();
			ArrayList<Expense> expList=new ArrayList<Expense>();
			if(BalanceSheet.balanceSheet.containsKey(id))
			{
				expList.addAll(balanceSheet.balanceSheet.get(id));
				expList.add(e);
				balanceSheet.balanceSheet.put(id, expList);
			}
			else
			{
				expList.add(e);
				BalanceSheet.balanceSheet.put(id,expList);
			}
		}
}
