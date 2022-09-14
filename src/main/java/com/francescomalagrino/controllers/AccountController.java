package com.francescomalagrino.controllers;

import com.francescomalagrino.services.AccountService;

public class AccountController {

	private AccountService accountService;
	
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	public void addAccount(int accNum, int pin, double balance, double overdraft) {
		accountService.createAccount(accNum, pin, balance,overdraft);
	}

	public boolean isThereAccount(int ans) {
		return accountService.ExistingAccount(ans);
	}

	public boolean isPinCorrect(int ans) {
		return accountService.PinforAccount(ans);
	}

	public boolean checkFunds(int ans) {
		return accountService.IsThereAccountFunds(ans);
	}

	public void takeAwayWithdrawal(int ans) {
		accountService.Withdrawal(ans);
	}

	public String getAccount() {
		return accountService.viewAccount();
	}

	public void signOut() {
		accountService.signOutOfAccount();
	}

	public String getBalance() {
		return accountService.showBalance();
	}

}
