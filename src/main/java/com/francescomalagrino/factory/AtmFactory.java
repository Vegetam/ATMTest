package com.francescomalagrino.factory;

import com.francescomalagrino.controllers.AccountController;
import com.francescomalagrino.controllers.RestApiController;
import com.francescomalagrino.controllers.SafeController;
import com.francescomalagrino.services.AccountService;
import com.francescomalagrino.services.SafeService;
import com.francescomalagrino.views.AtmView;

public class AtmFactory {
	
	public static AtmView getAtmView() {
		setRestApiController();
		return new AtmView(UtilFactory.getScanner(), getAccountController(), getSafeController());
	}
	

	private static RestApiController setRestApiController() {
		return new RestApiController(getAccountService(), getSafeService());
	}


	private static SafeController getSafeController() {
		return new SafeController(getSafeService());
	}

	private static SafeService getSafeService() {
		return new SafeService();
	}

	private static AccountController getAccountController() {
		return new AccountController(getAccountService());
	}

	
	private static AccountService getAccountService() {
		return new AccountService(UtilFactory.getAccountsList());
	}

	
}
