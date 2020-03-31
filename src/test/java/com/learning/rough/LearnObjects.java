package com.learning.rough;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LearnObjects {
	
	
	@Test(dataProvider="getData")
	public void displayData(String user, String pass) {
		
	System.out.println(user+"......"+pass);
	System.out.println(".........................");
	System.out.println("Changes from user2");
	System.out.println("Changes Y");

		
		
	}
	
	
	@DataProvider
	public Object[][] getData() {
		System.out.println("changes made by user1............");
		Object[][] data = new Object[2][2];
		data[0][0] = "user1";
		data[0][1] = "pass1";
				
		data[1][0]="user2";
		data[1][1]="pass2";
		return data;
				
	}

	
	
	
	
	

}
