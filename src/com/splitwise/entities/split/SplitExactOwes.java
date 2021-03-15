package com.splitwise.entities.split;

public class SplitExactOwes extends Split
{
	public SplitExactOwes(double amount)
	{
		super(amount);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void split(double split)
	{
		this.owes=split;
	}

	@Override
	public void split() 
	{
	}
}
