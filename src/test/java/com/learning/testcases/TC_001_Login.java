package com.learning.testcases;

import org.apache.poi.sl.usermodel.Sheet;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learning.base.TestBase;

public class TC_001_Login extends TestBase{
	@Test(dataProvider="getData")
	public void tc_001_Login(String username, String password) {
				
		driver.findElement(By.id(OR.getProperty("username"))).sendKeys("demosalesmanager");
		driver.findElement(By.id(OR.getProperty("password"))).sendKeys("crmsfas");
		driver.findElement(By.xpath(OR.getProperty("loginBtn"))).click();			
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("crmsfaBtn"))), "Login not successful");
		
	}
	
	@DataProvider
	public Object[][] getData(){
		   String sheetName = "TC_001_Login";
		   int rowCount = excelReader.getRowCount(sheetName);
		
		
		
		
		return null;
		
		
		
		
		
	}

}
