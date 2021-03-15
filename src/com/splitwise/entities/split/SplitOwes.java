package com.splitwise.entities.split;

public class SplitOwes extends Split
{
	public SplitOwes(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}
	public void split()
	{
		this.owes=amount;
	}
}
