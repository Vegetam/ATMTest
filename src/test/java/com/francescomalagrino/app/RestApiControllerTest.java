package com.francescomalagrino.app;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import com.francescomalagrino.controllers.RestApiController;
import com.francescomalagrino.models.Account;
import com.francescomalagrino.services.AccountService;
import com.francescomalagrino.services.SafeService;



@SpringBootTest
class RestApiControllerTest {
	  private MockMvc mockMvc;
	  
	    @InjectMocks
	  private RestApiController restApi;
	    

	    @InjectMocks
	    
	    private SafeService safe1;
	  
	    
	    @Mock
	    
	    private AccountService accountService;
	    
	    @Mock
	    
	    private Account account;
	  
	    @Mock
	    
	    private SafeService safe;
	  
	  @BeforeEach
	    public void setup() {
	        mockMvc = MockMvcBuilders.standaloneSetup(restApi)
	                .build();
	    }

	  @Test
	  public void getPin() throws Exception {
	     
	        int accountNumber = account.getAccount_number();
	        int pin = account.getPin();
		  String account =  restApi.signin(accountNumber, pin);

	      
	      Mockito.when(restApi.signin(accountNumber, pin)).thenReturn(account);
	      
	      mockMvc.perform(MockMvcRequestBuilders
	              .get("/atm/" + accountNumber + "/" + pin)
	              .contentType(MediaType.APPLICATION_JSON))
	              .andExpect(status().isOk());
	  }
	  
	  

	  @Test
	  public void getBalance() throws Exception {
	     
	        int accountNumber = account.getAccount_number();
	        int pin = account.getPin();
		  String account =  restApi.signin(accountNumber, pin);

	      
	      Mockito.when(restApi.signin(accountNumber, pin)).thenReturn(account);
	      
	      mockMvc.perform(MockMvcRequestBuilders
	              .get("/atm/" + accountNumber + "/" + pin + "/balance")
	              .contentType(MediaType.APPLICATION_JSON))
	              .andExpect(status().isOk());
	  }
	  
	  
	  @Test
	  public void getAnyWithdraw() throws Exception {
	     
	        int accountNumber = account.getAccount_number();
	        int pin = account.getPin();
	        int widthdraw = 5;
		  String account =  restApi.signin(accountNumber, pin);
		  
	      
	      Mockito.when(restApi.signin(accountNumber, pin)).thenReturn(account);
	        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/atm/" + accountNumber + "/" + pin + "/withdraw/" + widthdraw).accept(MediaType.APPLICATION_JSON)).andReturn();

	     
	        assertEquals(200, mvcResult.getResponse().getStatus());

	  }
	  
	  @Test
	  public void getWithdrawWithControl() throws Exception {
	     
	        int accountNumber = account.getAccount_number();
	        int pin = account.getPin();
	        int withdraw =123456789;
		  String account =  restApi.signin(accountNumber, pin);
		  
	      
	      Mockito.when(restApi.signin(accountNumber, pin)).thenReturn(account);
	        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/atm/" + accountNumber + "/" + pin + "/withdraw/" + withdraw).accept(MediaType.APPLICATION_JSON)).andReturn();
			      Mockito.when(accountService.ApiIsThereAccountFunds(accountNumber,pin,withdraw)).thenReturn(true);
	        if(safe1.IsThereSufficiantFundsInSafe(withdraw)) {
	        	assertEquals(200, mvcResult.getResponse().getStatus());
			}else {
				assertEquals("no avaliable funds in account" ,mvcResult.getResponse().getContentAsString());
			}
	        
			

	  }
	  
	  
	  @Test
	  public void showSafeTest() throws Exception {
	
	        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/atm/safe").accept(MediaType.APPLICATION_JSON)).andReturn();

	     
	        assertEquals(200, mvcResult.getResponse().getStatus());

	  }
	  
	  
	  @Test
	  public void showWelcomeTest() throws Exception {
	
	        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON)).andReturn();

	     
	        assertEquals(200, mvcResult.getResponse().getStatus());

	  }


	
	

}
