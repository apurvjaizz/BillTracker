package com.splitwise.entities.split;

public abstract class Split
{
	double amount;
	double owes;
	double getsBack;
	public abstract void split();
	Split(double amount)
	{
		this.amount=amount;
	}
    public double getOwes() {
		return owes;
	}

	public void setOwes(double owes) {
		this.owes = owes;
	}

	public double getGetsBack() {
		return getsBack;
	}

	public void setGetsBack(double getsBack) {
		this.getsBack = getsBack;
	}

	public double getAmount()
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }
	public void split(double parseFloat) {
		// TODO Auto-generated method stub
		
	}
}
