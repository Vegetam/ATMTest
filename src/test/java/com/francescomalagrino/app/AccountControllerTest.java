package com.francescomalagrino.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;




import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


import com.francescomalagrino.controllers.AccountController;
import com.francescomalagrino.controllers.RestApiController;
import com.francescomalagrino.models.Account;
import com.francescomalagrino.services.AccountService;
import com.francescomalagrino.services.SafeService;
import com.sun.tools.javac.util.Assert;



@SpringBootTest
class AccountControllerTest {
	
	private MockMvc mockMvc;
	  
    @InjectMocks AccountController accountController;
    
    @InjectMocks SafeService safeService;
    
    @Mock
    private Account account;
    
    @Mock
    private RestApiController restApi;
    
	     
	 	
	 	 @Test
	 	  void addAccountTest(){
	 		Account account1= new Account(123456789,1234,800,200);
			 AccountService classAccountService = mock(AccountService.class);
			 int accountNum = account1.getAccount_number();
				int pin = account1.getPin();
				double balance = account1.getBalance();
				double overdraft = account1.getOverdraft();

	 	   Assert.checkNonNull(accountNum);
	 	  Assert.checkNonNull(pin);
	 	  Assert.checkNonNull(balance);
	 	  Assert.checkNonNull(overdraft);
	 	//  Assert.check("true", classAccountService.createAccount(accountNum, pin, balance, overdraft));
	 	   



	 	  }
	 	 
	 	 @Test
	 	  void NotExistingAccount(){
	 		 AccountService classAccountService = mock(AccountService.class);

	 	        int accountNumber = 12345;
	 	        int pin = 12345679;

	 	      
	 			assertEquals(false ,classAccountService.ExistingAccount(accountNumber));

	 	  }
	 	 
	 	 
	 	 @Test
	 	  void ExistingAccount(){
	 			Account account1= new Account(123456789,1234,800,200);
	 			 AccountService classAccountService = mock(AccountService.class);
	 			 int accountNum = account1.getAccount_number();
	 				int pin = account1.getPin();
	 				double balance = account1.getBalance();
	 				double overdraft = account1.getOverdraft();
	 		
	 			 classAccountService.createAccount(accountNum, pin, balance, overdraft);
	 			  //verify(classAccountService, times(1));
	 			 Mockito.when(classAccountService.ExistingAccount(accountNum)).thenReturn(true);
	 		    assertEquals(true, classAccountService.ExistingAccount(accountNum));

	 	  }
	 	 
	 	 
	 	 @Test
	 	  void PinforAccountTest(){
	 		Account account1= new Account(123456789,1234,800,200);
	 		 AccountService classAccountService = mock(AccountService.class);
	 		 int accountNum = account1.getAccount_number();
	 			int pin = account1.getPin();
	 			double balance = account1.getBalance();
	 			double overdraft = account1.getOverdraft();
	 	
	 		 classAccountService.createAccount(accountNum, pin, balance, overdraft);
	 		  //verify(classAccountService, times(1));
	 		 Mockito.when(classAccountService.PinforAccount(pin)).thenReturn(true);
	 	    assertEquals(true, classAccountService.PinforAccount(pin));
	 	      



	 	  }
	 	 
	 	 @Test
	 	  void checkFundsTest(){
	 		Account account1= new Account(123456789,1234,800,200);
	 		 AccountService classAccountService = mock(AccountService.class);
	 		 int accountNum = account1.getAccount_number();
	 			int pin = account1.getPin();
	 			double balance = account1.getBalance();
	 			double overdraft = account1.getOverdraft();
	 			int finalBalance = (int) account1.getBalance();
	 		 classAccountService.createAccount(accountNum, pin, balance, overdraft);
	 		  //verify(classAccountService, times(1));
	 		 Mockito.when(classAccountService.IsThereAccountFunds(finalBalance)).thenReturn(true);
	 	    assertEquals(true, classAccountService.IsThereAccountFunds(finalBalance));


	 	  }
	 	 
	 	 
	 	 @Test
	 	void calulateNotes50() {
	 		int fifty = 50;
		 	assertEquals("You are now recieving [fiftys= " +1 + "]", safeService.calulateNotes(fifty));

	 	 }
	 	 
		 @Test
		 	void calulateNotes20() {
		 		int twenty = 20;
			 	assertEquals("You are now recieving [fiftys= 0, twentys= 1]", safeService.calulateNotes(twenty));
		 	 }
		 
		 
		 @Test
		 	void calulateNotes10() {
		 		int tens = 10;
			 	assertEquals("You are now recieving [fiftys= 0, twentys= 0, tens=1]", safeService.calulateNotes(tens));
		 	 }
		 
		 

		 @Test
		 	void calulateNotes5() {
		 		int fives = 5;
			 	assertEquals("You are now recieving [fiftys= 0, twentys= 0, tens=0, fives=1]", safeService.calulateNotes(fives));
		 	 }
	 	 


	 }


