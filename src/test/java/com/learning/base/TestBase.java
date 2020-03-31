package com.learning.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.learning.utilities.ExcelReader;

public class TestBase {

	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static ExcelReader excelReader = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\learning.xlsx");
	
	
	@BeforeSuite
	public void setUp() throws IOException {
		
		if (driver == null) {

			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			config.load(fis);			
			
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");	
			OR.load(fis);			
			
			if (config.getProperty("browser").equals("chrome")) {				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
				//System.setProperty("webdriver.chrome.driver", "./executables/chromedriver1.exe");
				driver = new ChromeDriver();
				
			}else if (config.getProperty("browser").equals("firefox")) {
				
			}
			driver.get(config.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		}
		
			
	}
	
	
	public Boolean isElementPresent(By by) {
		
		try {
			driver.findElement(by);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
            return false;		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterSuite
	public void tearDown() {
		
		
		
		
	}
	
	
	
	
}
