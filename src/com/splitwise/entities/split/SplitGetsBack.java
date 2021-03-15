package com.splitwise.entities.split;

public class SplitGetsBack extends Split
{
	public SplitGetsBack(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}
	public void split()
	{
		this.getsBack=amount;
	}

}
