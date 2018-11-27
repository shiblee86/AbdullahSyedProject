package com.genericlibrary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.newpagefactory.PageFactoryLoginXpath;
import com.util.Highlighter;
import com.util.ScreenShots;

import edu.emory.mathcs.backport.java.util.Collections;

public class BaseAmazonTestCases {

	WebDriver driver;
	PageFactoryLoginXpath obj;
	Highlighter color;
	List<String> productList = new ArrayList<>();
	List<String> pricePerItemTable = new ArrayList<>();
	Actions action;

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
		driver.manage().window().maximize();
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

	// Search for item
	public void searchForItems(String productname) {
		obj.searchForItems().sendKeys(productname);
		obj.searchForItems().submit();
	}

	// Sort by price high to low
	public void sortByHighToLowPrice() {
		Select sortDropDown = new Select(obj.getSortBy());
		sortDropDown.selectByValue("price-desc-rank");
	}

	// Find total page number
	public void getTotalPageNumber() {
		System.out.println("Total number of pages with class '.pagnLink' ::\n" + obj.getTotalPageCount().size());
		for (int j = 0; j < obj.getTotalPageCount().size(); j++) {
			color.drawBorder(obj.getTotalPageCount().get(j), "cyan");
		}
		System.out.println("-----------------------------------------------------------------------------------------");
		System.err.println("The last page number is ::\n" + obj.getLastPage().getText()
				+ "\n-----------------------------------------------------------------------------------------");
	}

	// Find current page number
	public void getCurrentPage() {
		// ac.moveToElement(obj.getCurrentPage()).build().perform();
		color.drawBorder(obj.getCurrentPage(), "green");
		System.out.println("The current page number is\n" + obj.getCurrentPage().getText()
				+ "\n-----------------------------------------------------------------------------------------");
	}

	// Find all product and count
	public void findAllItemsOnPageOne() {
		System.out.println(
				"ITEMS DISPLAYED ON CURRENT PAGE\n-----------------------------------------------------------------------------------------");
		driver.navigate().refresh();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(obj.findAllItemsPageOne().get(0)));

		for (WebElement productName : obj.findAllItemsPageOne()) {
			productList.add(productName.getText());
		}
		for (int printProductName = 0; printProductName < productList.size(); printProductName++) {
			System.out.println(productList.get(printProductName));
			System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
		}
		System.out.println("Total number of items displayed on page ::\n" + productList.size());
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Total product count on Site message ---------->\n" + obj.getTotalProductCount().getText());
		System.out.println("========================================================================================");
	}

	// Find out total count of a specific product
	public void findAllOccuranceOfASpecifProduct(String specificProduct) {
		List<String> totalForSpecificProduct = new ArrayList<>();
		for (int a = 0; a < productList.size(); a++) {
			if (productList.get(a).contains(specificProduct)) {
				totalForSpecificProduct.add(productList.get(a));
			}
		}
		System.out.println("Specific Product ::\n ============================================================");
		for (int i = 0; i < totalForSpecificProduct.size(); i++) {
			System.out.println(totalForSpecificProduct.get(i)
					+ "\n..............................................................................");
		}
		System.out.println("/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+/+");
		System.out.println("Total number of Specific items ::\n" + totalForSpecificProduct.size()
				+ "\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
	}

	public void getHighAndLowPrices() {
		// Converting WebElement dollar to float
		List<Float> storeDollarValue = new ArrayList<>();
		for (WebElement dollarPrice : obj.getDollarPriceOfItem()) {
			storeDollarValue.add(Float.parseFloat(dollarPrice.getText().trim().replaceAll(",", "")));
		}
		System.out.println("Price of item in Dollar --> Float ::\n++++++++++++++++++++++++++++++++++++++++++++");
		for (int j = 0; j < storeDollarValue.size(); j++) {
			System.out.println(storeDollarValue.get(j) + "\n.....");
		}
		System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");

		// Converting WebElement cent to float
		List<Float> storeCentValue = new ArrayList<>();

		System.out.println("Price of item in Cent --> Flaot ::\n ++++++++++++++++++++++++++++++++++++++++++++++++");
		for (WebElement centPrice : obj.getCentsPriceOfItem()) {
			storeCentValue.add((Float.parseFloat(centPrice.getText().trim().replaceAll(",", "")) / 100));
		}
		for (int i = 0; i < storeCentValue.size(); i++) {
			System.out.println(storeCentValue.get(i) + "\n.....");
		}
		System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");

		// Adding dollar and price and adding to a new array
		List<Float> itemPrice = new ArrayList<>();
		for (int p = 0; p < storeDollarValue.size(); p++) {
			float dollarValue = storeDollarValue.get(p);
			float centValue;
			if (storeCentValue.get(p) != null) {
				centValue = storeCentValue.get(p);
			} else {
				centValue = 0.0f;
			}
			itemPrice.add(dollarValue + centValue);
		}
		float maxPrice = (float) Collections.max(itemPrice);
		System.out.println("The highest price is ::\n" + maxPrice + "\n......");

		float minPrice = (float) Collections.min(itemPrice);
		System.out.println("The lowest price is ::\n" + minPrice);
		System.out.println(
				"*****************************************************************************************************");
	}

	// Sort by low to high price
	public void sortByLowToHighPrice() throws InterruptedException {
		Select sortDropDown = new Select(obj.getSortBy());
		sortDropDown.selectByValue("price-asc-rank");
		Thread.sleep(6000);
	}

	// Adding an item to the cart
	public void addAnItemToCart() {
		obj.getAddItemToCart().click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getAddToCartButton()));
		obj.getAddToCartButton().click();
	}

	public void addNewPayment() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getProceedToCheckoutButton()));
		obj.getProceedToCheckoutButton().click();
		wait.until(ExpectedConditions.visibilityOf(obj.getChangePaymentType()));
		obj.getChangePaymentType().click();
		wait.until(ExpectedConditions.visibilityOf(obj.getAddNewBankAccount()));
		color.drawBorder(obj.getAddNewBankAccount(), "orange");
		obj.getAddNewBankAccount().click();

		// Store your parent window
		String parentWindowHandler = driver.getWindowHandle();
		String subWindowHandler = null;

		// get all window handles
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()) {
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window

		// Now you are in the popup window, perform necessary actions here
		obj.getNameOnBank().sendKeys(obj.getNameOnAccountString());
		obj.getBankRoutingNumber().sendKeys(obj.getBankRountingNumberInt());
		obj.getReEnterCheckingAccountNumber().sendKeys(obj.getReEnterCheckingAccountNumberInt());
		obj.getDrLicenseNumber().sendKeys(obj.getDriverLincenseInt());
		obj.getStateDropdown().click();

		/*
		for (WebElement selectState : obj.getStateList()) {
			System.out.println(selectState.getText());
		}
		System.out.println(obj.getStateList().size());
		*/

		for (WebElement selectState : obj.getStateList()) {
			Thread.sleep(1000);
			if (selectState.getText().equalsIgnoreCase("NY")) {
				selectState.click();
			}
		}
		obj.getAddThisCheckingAccount().click();
		if (obj.getPaymentFailureValidationMessage().getText().equalsIgnoreCase("There was a problem")) {
			System.out.println("Adding payment failed. Test Passed.");
		}

		// Now you are in the popup window, perform necessary actions here

		driver.switchTo().window(parentWindowHandler); // switch back to parent window
		driver.navigate().to(obj.getURL());
	}

	public void tearDown() {
		driver.quit();
	}
}
