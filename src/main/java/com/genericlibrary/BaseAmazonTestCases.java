package com.genericlibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.newpagefactory.PageFactoryLoginXpath;
import com.util.Highlighter;
import com.util.ScreenShots;

public class BaseAmazonTestCases {

	WebDriver driver;
	PageFactoryLoginXpath obj;
	Highlighter color;

	public void getSetup() {
		// Operating System
		String os = System.getProperty("os.name").toLowerCase();

		// Windows driver path
		String winPath = System.getProperty("user.dir");
		String winDriverPath = winPath + "\\Driver\\chromedriver.exe";

		// Mac driver path
		String macPath = System.getProperty("user.home");
		String macDriverPath = macPath + "/chromedriver/chromedriver";

		// Tell Eclipse which driver to use depending on OS
		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", macDriverPath);
		} else {
			System.setProperty("webdriver.chrome.driver", winDriverPath);
		}
		driver = new ChromeDriver();
		obj = PageFactory.initElements(driver, PageFactoryLoginXpath.class);
		color = new Highlighter(driver);
		driver.navigate().to(obj.getURL());
		driver.manage().window().fullscreen();
	}

	public void getLogin() {
		color.drawBorder(obj.getMyAccount(), "green");
		ScreenShots.captureScreenShot(driver, "LoginPage");
		obj.getMyAccount().click();
		color.drawBorder(obj.getEmailAddress(), "red");
		obj.getEmailAddress().sendKeys(obj.getUserName());
		color.drawBorder(obj.getPassword(), "blue");
		obj.getPassword().sendKeys(obj.getPass());
		color.drawBorder(obj.getSignIn(), "cyan");
		ScreenShots.captureScreenShot(driver, "Screenshot Email and password input fields");
		obj.getSignIn().click();
		System.out.println("Logged into my account");

	}

	public void verifyLogin() {
		color.drawBorder(obj.getUserNameAfterLogin(), "pink");
		if (obj.getUserNameAfterLogin().getText().equalsIgnoreCase("Hi, Syed")) {
			System.out.println("Login Verification Passed");
		} else {
			System.out.println("Login Varification Failed");
		}
		ScreenShots.captureScreenShot(driver, "Login Verification");

	}

	public void validateLogin() {
		color.drawBorder(obj.getUserNameAfterLogin(), "pink");
		try {
			Assert.assertEquals(obj.getUserNameAfterLogin().getText(), "Hi, Syed");
		} catch (AssertionError e) {
			System.out.println("Login Validation FAILED");
			throw e;
		}
		System.out.println("Loging Validation PASSED");
		ScreenShots.captureScreenShot(driver, "Login Verification");

	}

	public void tearDown() {
		driver.quit();
	}
}
