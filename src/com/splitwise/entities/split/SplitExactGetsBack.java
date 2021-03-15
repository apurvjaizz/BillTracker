package com.splitwise.entities.split;

public class SplitExactGetsBack extends Split
{
	public SplitExactGetsBack(double amount)
	{
		super(amount);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void split(double split)
	{
		this.getsBack=split;
	}

	@Override
	public void split() 
	{
	}
}
