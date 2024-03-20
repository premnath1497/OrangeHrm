package com.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.PropertiesHandle.ProertiesUtility;

public class Base {
	
	public static WebDriver driver;
	
	 public static void launchBrowser(String browser) {
			
			if(browser.equalsIgnoreCase("firefox")){
				
			System.setProperty("Webdriver.gecko.driver", "C:\\Users\\1\\Desktop\\Driver\\geckodriver.exe");
	        driver=new FirefoxDriver();
	        
	        }else if(browser.equalsIgnoreCase("chrome")){
	        	System.setProperty("Webdriver.chrome.driver", "C:\\Users\\1\\Automation\\OrangeHrm\\Drivers\\chromedriver.exe");
	            driver=new ChromeDriver();
	        }else if(browser.equalsIgnoreCase("edge"))
	        {
	        	System.setProperty("Webdriver.edge.driver", "C:\\Users\\1\\Automation\\OrangeHrm\\Drivers\\msedgedriver.exe");
	            driver=new EdgeDriver();
	        }else {
	        	System.out.println("Please Enter Valid Browser Name");
	        }
			
		    driver.manage().window().maximize();
		    
		    String orangeUrl=ProertiesUtility.fromProperties("OrangeHrmUrl");
		    
		    driver.get(orangeUrl);
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
		}

}
