package com.TestCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.PageObjects.DashBoardPage;
import com.PageObjects.LoginPage;
import com.PropertiesHandle.ProertiesUtility;
import com.ReadExcel.ReadExcelSheet;

public class LoginTest extends ProertiesUtility {
	
	
	public WebDriver driver;
	public LoginPage lp;
	public DashBoardPage dp;
	
	@BeforeMethod
    public void setUp() {
		Base.launchBrowser("chrome");
	}
	
	@Test
	public void verifyLoginPageWithValidUsernameAndValidPassword() throws EncryptedDocumentException, IOException {
		lp=new LoginPage(driver);
		String username=ProertiesUtility.fromProperties("Username");
		lp.sendUsername(username);
		System.out.println(username);
		String password=ProertiesUtility.fromProperties("Password");
		lp.sendPassword(password);
		lp.clickOnLoginButton();
		dp=new DashBoardPage(driver);
		String actualTextOfDashboard=dp.getTextofDashboardPage();
		String expectedTextOfDashboard=ReadExcelSheet.readExcelsheet("LoginPageData", 3, 1);
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

//	@AfterMethod
//	public void closedriver() {
//		driver.close();
//	}
}
