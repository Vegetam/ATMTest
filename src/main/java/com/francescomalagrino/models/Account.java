package com.francescomalagrino.models;


public class Account {
	
	private int account_number;
	private int pin;
	private double balance;
	private double overdraft;
	
	public Account(int account_number, int pin, double balance, double overdraft) {
		super();
		this.account_number = account_number;
		this.pin = pin;
		this.balance = balance;
		this.overdraft = overdraft;
	}

	public int getAccount_number() {
		return account_number;
	}

	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

	public String showAccount() {
		return "Account [account_number=" + account_number + ", balance=" + balance + ", overdraft="
				+ overdraft + "]";
	}
	
	public String showBalance() {
		return "Balance = " + balance + ", Overdraft = " + overdraft;
	}

	@Override
	public String toString() {
		return "Account [account_number=" + account_number + ", pin=" + pin + ", balance=" + balance + ", overdraft="
				+ overdraft + "]";
	}
	
	
	
	
}
