package com.homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class AmazonProject extends PageFactoryVariables {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", // We changed the system property. Setting up the driver property
				"/Users/shiblee/chromedriver/chromedriver");

		WebDriver driver = new ChromeDriver();

		AmazonProject obj = PageFactory.initElements(driver, AmazonProject.class);

		driver.navigate().to(obj.getURL());
		driver.manage().window().maximize();
		obj.getMyAccount().click();
		obj.getEmailAddress().sendKeys(obj.getUserName());
		obj.getPassword().sendKeys(obj.getPass());
		obj.getSignIn().click();
		obj.getUserNameAfterLogin().getText();

		//System.out.println(obj.getUserNameAfterLogin().getText());

		if (obj.getUserNameAfterLogin().getText().equalsIgnoreCase("Hi, Syed")) {
			System.out.println("Login Passed");
		} else {
			System.out.println("Login Failed");
		}

	}
}