package com.francescomalagrino.models;

public class Safe {

	public int fiftys;
	public int twentys;
	public int tens;
	public int fives;
	
	public Safe(int fiftys, int twentys, int tens, int fives) {
		super();
		this.fiftys = fiftys;
		this.twentys = twentys;
		this.tens = tens;
		this.fives = fives;
	}

	public int getFiftys() {
		return fiftys;
	}

	public void setFiftys(int fiftys) {
		this.fiftys = fiftys;
	}

	public int getTwentys() {
		return twentys;
	}

	public void setTwentys(int twentys) {
		this.twentys = twentys;
	}

	public int getTens() {
		return tens;
	}

	public void setTens(int tens) {
		this.tens = tens;
	}

	public int getFives() {
		return fives;
	}

	public void setFives(int fives) {
		this.fives = fives;
	}

	@Override
	public String toString() {
		return "Safe [fiftys=" + fiftys + ", twentys="
				+ twentys + ", tens=" + tens + ", fives=" + fives + "]";
	}
	
	public String displayTotalSafe() {
		
		return "Safe holds = €"+ TotalInSafe();
	}
	
	public int TotalInSafe() {
		int ans = (fiftys*50) + (twentys*20) + (tens*10) + (fives*5);
		return ans;
	}
}
