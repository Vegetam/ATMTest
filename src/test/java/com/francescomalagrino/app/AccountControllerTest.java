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
import com.sun.tools.javac.util.Assert;



@SpringBootTest
class AccountControllerTest {
	
	private MockMvc mockMvc;
	  
    @InjectMocks AccountController accountController;

    
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
	 	 


	 }


