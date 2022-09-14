package com.francescomalagrino.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.francescomalagrino.models.Account;

@Service
public class AccountService {

	private Account signedInAccount = null;
	private Account account1= new Account(123456789,1234,800,200);
	private Account account2= new Account(987654321,4321,1230,150);
	private List<Account> accounts;

	
	public AccountService(List<Account> accounts) {
		this.accounts = accounts;
		accounts.add(account1);
		accounts.add(account2);
		
	}
	

	public void createAccount(int accNum, int pin, double balance, double overdraft) {
		Account newAccount = new Account(accNum, pin, balance,overdraft);
		accounts.add(newAccount);
	}


	public boolean ExistingAccount(int ans) {
		accounts.add(account1);
		accounts.add(account2);
		for (Account account : accounts) {
			if(ans == account.getAccount_number()) {
				signedInAccount = account;
				return true;
			}
		}
		return false;
	}


	public boolean PinforAccount(int ans) {
		
		if(ans == signedInAccount.getPin()) {
			return true;
		}
		else {
			signedInAccount = null;
			return false;
		}
	}


	public boolean IsThereAccountFunds(int ans) {
		double amount = signedInAccount.getBalance() + signedInAccount.getOverdraft();
		if(ans <= amount) {
			return true;
		}
		else {
			return false;
		} 
	}


	public void Withdrawal(int withdraw) {
		if(withdraw <= signedInAccount.getBalance()) {
			double ans = signedInAccount.getBalance() - withdraw;
			signedInAccount.setBalance(ans);
		}
		else {
			double ans = withdraw - signedInAccount.getBalance();
			signedInAccount.setBalance(0);
			double ans2 = signedInAccount.getOverdraft() - ans;
			signedInAccount.setOverdraft(ans2);
		}
		
	}


	public String viewAccount() {
		return signedInAccount.showAccount();
	}


	public void signOutOfAccount() {
		signedInAccount = null;
	}
	
	public String showBalance() {
		return signedInAccount.showBalance();
	}

	public String ApiSignIn(int accountNumber, int pin) {
		for(Account account : accounts) {
			if(account.getAccount_number() == accountNumber && account.getPin() == pin) {
				return "signed in as : " + accountNumber;
			}
		}
		return "invalid account number or pin";
	}


	public String ApiShowBalance(int accountNumber, int pin) {
		for (Account account : accounts) {
			if(account.getAccount_number() == accountNumber) {
				if(account.getPin() == pin) {
					return account.showBalance();
				}
			}
		}
		return "invalid account number or pin";
	}
	
	public boolean ApiIsThereAccountFunds(int accountNumber, int pin ,int ans) {
		for (Account account : accounts) {
			if(account.getAccount_number() == accountNumber) {
				if(account.getPin() == pin) {
					double amount = account.getBalance() + account.getOverdraft();
					if(ans <= amount) {
						return true;
					}
				}
			}
		}
		return false;
	}


	public void ApiWithdraw(int accountNumber, int pin, int withdraw) {
		for (Account account : accounts) {
			if(account.getAccount_number() == accountNumber) {
				if(account.getPin() == pin) {
					if(withdraw <= account.getBalance()) {
						double ans = account.getBalance() - withdraw;
						account.setBalance(ans);
					}
					else {
						double ans = withdraw - account.getBalance();
						account.setBalance(0);
						double ans2 = account.getOverdraft() - ans;
						account.setOverdraft(ans2);
					}
				}
			}
		}
	}

}
