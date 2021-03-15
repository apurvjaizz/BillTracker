package com.splitwise.entities.expense;

import com.splitwise.entities.User;
import com.splitwise.entities.split.Split;

public class Expense
{
    User paidBy;
    User userWith;
    Split splits;
	String title,description,note;
	double getsBack;
	double owes;
	double amount;
	int id;

	public double getGetsBack() {
		return getsBack;
	}
	public void setGetsBack(double getsBack) {
		this.getsBack = getsBack;
	}
	public double getOwes() {
		return owes;
	}
	public void setOwes(double owes) {
		this.owes = owes;
	}
	public Expense()
	{
		
	}
	public Expense(double amount, User paidBy, User userWith, Split splits)
	{
        this.amount = amount;
        this.paidBy = paidBy;
        this.splits = splits;
        this.userWith=userWith;
        this.getsBack=0;
        this.owes=0;

    }
	public User getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(User paidBy) {
		this.paidBy = paidBy;
	}
	public User getUserWith() {
		return userWith;
	}
	public void setUserWith(User userWith) {
		this.userWith = userWith;
	}
	public Split getSplits() {
		return splits;
	}
	public void setSplits(Split splits) 
	{
		this.splits = splits;
		this.getsBack=splits.getGetsBack();
		this.owes=splits.getOwes();
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}

