package com.homework;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFactoryVariables {

	private String URL = "https://www.amazon.com/";
	private String userName = "syed.r.abdullah@gmail.com";
	private String pass = "$Sa038575";

	@FindBy(xpath = "//*[@id='nav-link-accountList']")
	private WebElement myAccount;

	@FindBy(xpath = "//*[@id='ap_email']")
	private WebElement emailAddress;

	@FindBy(xpath = "//*[@id='ap_password']")
	private WebElement password;

	@FindBy(xpath = "//*[@id='signInSubmit']")
	private WebElement signIn;

	@FindBy(xpath = "//*[contains(text(),'Hi, Syed')]")
	private WebElement userNameAfterLogin;

	public String getURL() {
		return URL;
	}

	public String getUserName() {
		return userName;
	}

	public String getPass() {
		return pass;
	}

	public WebElement getMyAccount() {
		return myAccount;
	}

	public WebElement getEmailAddress() {
		return emailAddress;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignIn() {
		return signIn;
	}

	public WebElement getUserNameAfterLogin() {
		return userNameAfterLogin;
	}
	
	

}