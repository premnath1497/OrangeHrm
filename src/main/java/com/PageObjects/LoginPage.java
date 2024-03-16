package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	
	
	@FindBy(xpath="//button[text()=' Login ']")
	private WebElement loginButton;
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	private WebElement errorElement;
	
	public void sendUsername(String user) {
		username.sendKeys(user);
	}
	
	public void sendPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton(){
		loginButton.click();
	}
	
	public String getTextofErrorVerification() {
		String invalidCredentials=errorElement.getText();
		return invalidCredentials;
	}
}
