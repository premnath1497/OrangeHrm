package com.TestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageObjects.DashBoardPage;
import com.PageObjects.LoginPage;

public class LoginTest {
	
	
	public WebDriver driver;
	public LoginPage lp;
	public DashBoardPage dp;
	
	@BeforeMethod
     public void launchBrowser() {
		
		System.setProperty("Webdriver.gecko.driver", "C:\\Users\\1\\Desktop\\Driver\\geckodriver.exe");
        driver=new FirefoxDriver();
	    driver.manage().window().maximize();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@Test
	public void verifyLoginPageWithValidUsernameAndValidPassword() {
		lp=new LoginPage(driver);
		lp.sendUsername("Admin");
		lp.sendPassword("admin123");
		lp.clickOnLoginButton();
		dp=new DashBoardPage(driver);
		String actualTextOfDashboard=dp.getTextofDashboardPage();
		String expectedTextOfDashboard="Dashboard";
	    Assert.assertEquals(actualTextOfDashboard, expectedTextOfDashboard);
	}
	
	@Test
	public void verifyLoginPageWithInValidUsernameAndInValidPassword() {
		lp=new LoginPage(driver);
		lp.sendUsername("Premnath");
		lp.sendPassword("premnath@123");
		lp.clickOnLoginButton();
		String actualerrorText=lp.getTextofErrorVerification();
		String expectederrorText="Invalid credentials";
		Assert.assertEquals(actualerrorText,expectederrorText);
	}

	@AfterMethod
	public void closedriver() {
		driver.close();
	}
}
