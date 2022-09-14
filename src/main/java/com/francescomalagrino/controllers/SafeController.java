package com.francescomalagrino.controllers;

import com.francescomalagrino.services.SafeService;

public class SafeController {
	
	private SafeService safeService;

	public SafeController(SafeService safeService) {
		this.safeService = safeService;
	}

	public void accessSafe() {
		safeService.displaySafe();
	}

	public boolean checkSafe(int ans) {
		return safeService.IsThereSufficiantFundsInSafe(ans);
	}

	public String getNotes(int ans) {
		return safeService.calulateNotes(ans);
	}

	
	
}
