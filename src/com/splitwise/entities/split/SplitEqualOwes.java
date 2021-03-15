package com.splitwise.entities.split;


public class SplitEqualOwes extends Split
{

	public SplitEqualOwes(double amount) {
		super(amount);
		// TODO Auto-generated constructor stub
	}

	public void split()
	{
		this.owes=amount/2;
	}
	

}
