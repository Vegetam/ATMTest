package com.francescomalagrino.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.francescomalagrino.models.Account;
import com.francescomalagrino.models.Safe;
import com.francescomalagrino.services.AccountService;
import com.francescomalagrino.services.SafeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "RestApiController", description = "API Of the ATM")
@RestController
public class RestApiController {
	
	private AccountService accountService; 
	private SafeService safeService;
	
	public RestApiController(AccountService accountService, SafeService safeService) {
		this.accountService = accountService;
		this.safeService = safeService;
	}
	
	
	
	@ApiOperation(value = "Welcome", response = Account.class, tags = "welcome")
	@GetMapping(value = "/")
	public String welcome() {
		return "welcome to atm";
	}
	
	
	@ApiOperation(value = "Safe", response = Safe.class, tags = "safe")
	@RequestMapping(path = "/atm/safe", method = RequestMethod.GET)
	public String showsafe() {
		return safeService.ApiDisplaySafe();
	}
	
	@ApiOperation(value = "GetPin", response = Account.class, tags = "Pin")
	@RequestMapping(path = "/atm/{accountNumber}/{pin}", method = RequestMethod.GET)
	public String signin(@PathVariable int accountNumber, @PathVariable int pin) {
		return accountService.ApiSignIn(accountNumber,pin);
	}
	
	@ApiOperation(value = "GetBalance", response = Account.class, tags = "Balance")
	@RequestMapping(path = "/atm/{accountNumber}/{pin}/balance", method = RequestMethod.GET)
	public String accountDetails(@PathVariable int accountNumber, @PathVariable int pin) {
		return accountService.ApiShowBalance(accountNumber, pin);
	}
	
	
	@ApiOperation(value = "withdraw", response = Account.class, tags = "Withdraw")
	@RequestMapping(path = "/atm/{accountNumber}/{pin}/withdraw/{withdraw}", method = RequestMethod.GET)
	public String withdraw(@PathVariable int accountNumber, @PathVariable int pin, @PathVariable int withdraw) {
		
		if(accountService.ApiIsThereAccountFunds(accountNumber,pin,withdraw) == true) {
			if(safeService.IsThereSufficiantFundsInSafe(withdraw)) {
				accountService.ApiWithdraw(accountNumber,pin,withdraw);
				String ans= safeService.calulateNotes(withdraw);
				return ans + " Totaling: " + withdraw;
			}
			else {
				return "There is no sufficiant funds in safe";
			}
		}
		else {
			return "no avaliable funds in account"; 
		}
	}
	
}
