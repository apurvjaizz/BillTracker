package com.splitwise.entities.split;


public class SplitEqualGetsBack extends Split
{

	public SplitEqualGetsBack(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}

	public void split()
	{
		this.getsBack=amount/2;
	}
	

}
