package com.genericlibrary;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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

	String parentWindowHandler;
	String subWindowHandler;

	WebDriverWait wait;

	/**
	 * Method getSetup() will declare browser driver and dictate pc to launch
	 * browser
	 */
	public void getSetup() {
		/** Making OS dynamic between Mac and Windows */
		String os = System.getProperty("os.name").toLowerCase();

		/** Windows driver path */
		String winPath = System.getProperty("user.dir");
		String winDriverPath = winPath + "\\Driver\\chromedriver.exe";

		/** Mac driver path */
		String macPath = System.getProperty("user.home");
		String macDriverPath = macPath + "/chromedriver/chromedriver";

		/** Tell Eclipse which driver to use depending on OS */
		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", macDriverPath);
		} else {
			System.setProperty("webdriver.chrome.driver", winDriverPath);
		}
		driver = new ChromeDriver();
		obj = PageFactory.initElements(driver, PageFactoryLoginXpath.class);
		color = new Highlighter(driver);
		driver.manage().deleteAllCookies();
		driver.navigate().to(obj.getURL());
		// driver.manage().window().maximize();
	}

	/** User Logs into the app */
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

	/** Verifying login */
	public void verifyLogin() {
		color.drawBorder(obj.getUserNameAfterLogin(), "pink");
		if (obj.getUserNameAfterLogin().getText().equalsIgnoreCase("Hi, Jamjam")) {
			System.out.println("Login Verification Passed");
		} else {
			System.out.println("Login Varification Failed");
		}
		ScreenShots.captureScreenShot(driver, "Login Verification");

	}

	/** Validating login */
	public void validateLogin() {
		color.drawBorder(obj.getUserNameAfterLogin(), "pink");
		try {
			Assert.assertEquals(obj.getUserNameAfterLogin().getText(), "Hi, Jamjam");
		} catch (AssertionError e) {
			System.out.println("Login Validation FAILED");
			throw e;
		}
		System.out.println("Loging Validation PASSED");
		ScreenShots.captureScreenShot(driver, "Login Verification");

	}

	/**
	 * Searching for an item
	 * 
	 * @throws InterruptedException
	 */
	public void searchForItems(String productName) throws InterruptedException {
		color.drawBorder(obj.searchForItems(), "orange");
		obj.searchForItems().sendKeys(productName);
		obj.searchForItems().submit();
		driver.navigate().refresh();
		Thread.sleep(5000);
	}

	/** Sort by price high to low */
	public void sortByHighToLowPrice() {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getSortBy()));

		color.drawBorder(obj.getSortBy(), "cyan");
		Select sortDropDown = new Select(obj.getSortBy());
		sortDropDown.selectByValue("price-desc-rank");
	}

	/**
	 * Find total page number
	 * 
	 * @throws InterruptedException
	 */
	public void getTotalPageNumber() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getLastPage()));
		System.out.println("-----------------------------------------------------------------------------------------");
		color.drawBorder(obj.getLastPage(), "red");
		System.err.println("The last page number is ::\n" + obj.getLastPage().getText()
				+ "\n-----------------------------------------------------------------------------------------");
	}

	/** Find current page number */
	public void getCurrentPage() {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getCurrentPage()));
		// ac.moveToElement(obj.getCurrentPage()).build().perform();
		color.drawBorder(obj.getCurrentPage(), "green");
		System.out.println("The current page number is\n" + obj.getCurrentPage().getText()
				+ "\n-----------------------------------------------------------------------------------------");
	}

	/** Find all product and count */
	public void findAllItemsOnPageOne() {
		System.out.println(
				"ITEMS DISPLAYED ON CURRENT PAGE\n-----------------------------------------------------------------------------------------");
		driver.navigate().refresh();

		wait = new WebDriverWait(driver, 5);
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

	/** Find out total count of a specific product */
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

	/** Sort by low to high price */
	public void sortByLowToHighPrice() throws InterruptedException {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getSortBy()));
		color.drawBorder(obj.getSortBy(), "cyan");
		Select sortDropDown = new Select(obj.getSortBy());
		sortDropDown.selectByValue("price-asc-rank");
		Thread.sleep(6000);
	}

	/** Find High and Low prices */
	public void getHighAndLowPrices() throws Throwable {
		// Converting WebElement dollar to float
		List<Float> storeDollarValue = new ArrayList<>();
		for (WebElement dollarPrice : obj.getDollarPriceOfItem()) {
			try {
				storeDollarValue.add(Float.parseFloat(dollarPrice.getText().trim().replaceAll(",", "")));
			} catch (Exception $error) {
				System.out.println($error);
			}
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
			try {
				storeCentValue.add((Float.parseFloat(centPrice.getText().trim().replaceAll(",", "")) / 100));
			} catch (Exception error) {
				System.out.println(error);
			}
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
			if (storeDollarValue.get(p) != null) {
				dollarValue = storeDollarValue.get(p);
			} else {
				dollarValue = 0.0f;
			}
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

	/** View item details */
	public void viewItemDetails() {

		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getViewItem()));
		color.drawBorder(obj.getViewItem(), "blue");
		obj.getViewItem().click();
	}

	/** Add item to cart */
	public void addAnItemToCart() {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getAddToCartButton()));

		color.drawBorder(obj.getAddToCartButton(), "black");
		obj.getAddToCartButton().click();
	}

	/** User clicks on cart button */
	public void clickOnCart() {

		color.drawBorder(obj.getProductCountResult(), "blue");
		obj.getProductCountResult().click();

	}

	/** If warranty pop-up appears */
	public void clickNoOnProtectionPlan() throws Throwable {
		obj.getAddToCartButton().click();
		Thread.sleep(2000);
		try {
			color.drawBorder(obj.clickNoThanksToWarrenty(), "green");
			obj.clickNoThanksToWarrenty().click();
		} catch (NoSuchElementException | ElementNotVisibleException e) {
			System.out.println("No protection plan is offered");
		}
		try {
			color.drawBorder(obj.clickonCartButton(), "magenta");
			obj.clickonCartButton().click();
		} catch (NoSuchElementException | ElementNotVisibleException error) {
			System.out.println(error);
		}
		try {
			color.drawBorder(obj.getCartOnProtectionPlanPage(), "black");
			obj.getCartOnProtectionPlanPage().click();
		} catch (NoSuchElementException | ElementNotVisibleException error2) {
			System.out.println(error2);
		}
		obj.getProceedToCheckoutButton();
	}

	/** Proceed to payment */
	public void proceedToPayment() throws InterruptedException {
		Thread.sleep(3000);
		try {
			wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(obj.getProceedToCheckoutButton()));

			color.drawBorder(obj.getProceedToCheckoutButton(), "orange");
			obj.getProceedToCheckoutButton().click();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** Change payment type */
	public void changePaymentType() throws InterruptedException {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getChangePaymentType()));

		color.drawBorder(obj.getChangePaymentType(), "black");
		obj.getChangePaymentType().click();
	}

	/** Add new payment */
	public void addNewPayment() throws InterruptedException {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getAddNewBankAccount()));
		color.drawBorder(obj.getAddNewBankAccount(), "orange");
		obj.getAddNewBankAccount().click();

		/*
		 * // Store your parent window parentWindowHandler = driver.getWindowHandle();
		 * subWindowHandler = null;
		 * 
		 * // get all window handles Set<String> handles = driver.getWindowHandles();
		 * Iterator<String> iterator = handles.iterator(); while (iterator.hasNext()) {
		 * subWindowHandler = iterator.next(); }
		 * driver.switchTo().window(subWindowHandler); // switch to popup window
		 * 
		 * // Now you are in the popup window, perform necessary actions here // Now you
		 * are in the popup window, perform necessary actions here
		 * 
		 * // driver.switchTo().window(parentWindowHandler); // switch back to parent //
		 * window
		 * 
		 */
		try {
			color.drawBorder(obj.getNameOnBank(), "blue");
			obj.getNameOnBank().sendKeys(obj.getNameOnAccountString());
			color.drawBorder(obj.getBankRoutingNumber(), "blue");
			obj.getBankRoutingNumber().sendKeys(obj.getBankRountingNumberInt());
			color.drawBorder(obj.getReEnterCheckingAccountNumber(), "blue");
			obj.getReEnterCheckingAccountNumber().sendKeys(obj.getReEnterCheckingAccountNumberInt());
			color.drawBorder(obj.getDrLicenseNumber(), "blue");
			obj.getDrLicenseNumber().sendKeys(obj.getDriverLincenseInt());
			color.drawBorder(obj.getStateDropdown(), "blue");
			obj.getStateDropdown().click();

			for (WebElement selectState : obj.getStateList()) {
				Thread.sleep(1000);
				if (selectState.getText().equalsIgnoreCase("NY")) {
					color.drawBorder(selectState, "blue");
					selectState.click();
				}
			}
		} catch (NoSuchElementException | ElementNotVisibleException e) {
			System.out.println("State dropdown not available");

		}
		driver.navigate().to(obj.getURL());

	}

	/** Confirmation message for new payment type */
	public void confirmationMessage() {

		color.drawBorder(obj.getAddThisCheckingAccount(), "orange");
		obj.getAddThisCheckingAccount().click();
		color.drawBorder(obj.getPaymentFailureValidationMessage(), "red");
		if (obj.getPaymentFailureValidationMessage().getText().equalsIgnoreCase("There was a problem")) {
			System.out.println("Adding payment failed. Test Passed.");
		} else {
			System.out.println("Account added");
		}

		// Now you are in the popup window, perform necessary actions here

		// driver.switchTo().window(parentWindowHandler); // switch back to parent
		// window
		// driver.navigate().to(obj.getURL());
	}

	public void goBackToLandingPage() {

		driver.navigate().to(obj.getURL());

	}

	/** User is able to close the browser */
	public void tearDown() {
		driver.quit();
	}

}