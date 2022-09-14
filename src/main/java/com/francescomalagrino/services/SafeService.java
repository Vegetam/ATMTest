package com.francescomalagrino.services;

import com.francescomalagrino.models.Safe;

import org.springframework.stereotype.Service;

@Service
public class SafeService {
	
	private Safe atmSafe = new Safe(10,30,30,20);  
	
	//Safe s = getBean(Safe.class);
	
	public SafeService() {
		
	}

	public void displaySafe() {
		System.out.println(atmSafe.toString());
		System.out.println(atmSafe.displayTotalSafe());
	}
	
	public String ApiDisplaySafe() {
		String ans = atmSafe.toString();
		String ans2 = atmSafe.displayTotalSafe();
		
		return ans + "\n" +ans2;
	}

	public boolean IsThereSufficiantFundsInSafe(int ans) {
		if(ans <= atmSafe.TotalInSafe()) {
			return true;
		}
		else {
			return false;
		}
	}

	public String calulateNotes(int ans) {
		
		//50
		int fiftys = ans/50;
		if(fiftys <= atmSafe.getFiftys()) {			
			ans = ans - (fiftys*50);
			if(ans == 0) {
				removeFiftys(fiftys);
				return "You are now recieving [fiftys= " +fiftys + "]";
			}
		}
		else {
			while(fiftys > atmSafe.getFiftys()) {
				fiftys --;
			}
			ans = ans - (fiftys*50);
		}
		removeFiftys(fiftys);
		
		
		//20
		int twentys = ans/20;
		if(twentys <= atmSafe.getTwentys()) {			
			ans = ans - (twentys*20);
			if(ans == 0) {
				removeTwentys(twentys);
				return "You are now recieving [fiftys= " +fiftys + ", twentys= " +twentys + "]";
			}
		}
		else {
			while(twentys > atmSafe.getTwentys()) {
				twentys --;
			}
			ans = ans - (twentys*20);
		}
		removeTwentys(twentys);
		
		
		//10
		int tens = ans/10;
		if(tens <= atmSafe.getTens()) {			
			ans = ans - (tens*10);
			if(ans == 0) {
				removeTens(tens);
				return "You are now recieving [fiftys= " +fiftys + ", twentys= " +twentys + ", tens=" + tens +"]";
			}
		}
		else {
			while(tens > atmSafe.getTens()) {
				tens --;
			}
			ans = ans - (tens*10);
		}
		removeTens(tens);
		
		
		//5
		int fives = ans/5;
		removeFives(fives);
		return "You are now recieving [fiftys= " +fiftys + ", twentys= " +twentys + ", tens=" + tens + ", fives=" + fives + "]";
		

	}

	private void removeFiftys(int fiftys) {
		int ans = atmSafe.getFiftys() - fiftys;
		atmSafe.setFiftys(ans);
	}
	
	private void removeTwentys(int twentys) {
		int ans = atmSafe.getTwentys() - twentys;
		atmSafe.setTwentys(ans);
	}
	
	private void removeTens(int tens) {
		int ans = atmSafe.getTens() - tens;
		atmSafe.setTens(ans);
	}
	
	private void removeFives(int fives) {
		int ans = atmSafe.getFives() - fives;
		atmSafe.setFives(ans);
	}

	public int CalculatingHowManyNotes(int ans, int nomination) {
		return ans;
	}

}
