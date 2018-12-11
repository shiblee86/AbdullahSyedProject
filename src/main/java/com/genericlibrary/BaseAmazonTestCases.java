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

import com.newpagefactory.AmazonPageFactory;
import com.util.Highlighter;
import com.util.ScreenShots;

import edu.emory.mathcs.backport.java.util.Collections;

public class BaseAmazonTestCases {

	WebDriver driver;
	AmazonPageFactory obj;
	Highlighter color;

	List<String> productList = new ArrayList<>();
	List<String> pricePerItemTable = new ArrayList<>();

	String parentWindowHandler;
	String subWindowHandler;

	WebDriverWait wait;

	/**
	 * Method getSetup() will declare browser driver and dictate PC to launch
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
			System.out.println(macPath);
			System.out.println(
					"*****************************************************************************************************");
		} else {
			System.setProperty("webdriver.chrome.driver", winDriverPath);
			System.out.println(winDriverPath);
			System.out.println(
					"*****************************************************************************************************");
		}
		driver = new ChromeDriver();
		obj = PageFactory.initElements(driver, AmazonPageFactory.class);
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
		obj.getSignIn().click();
		System.out.println("Logged into my account");
		System.out.println(
				"*****************************************************************************************************");

	}

	/** Verifying login credential of user */
	public void verifyLogin() throws Throwable {
		try {
			color.drawBorder(obj.getUserNameAfterLogin(), "pink");
			if (obj.getUserNameAfterLogin().getText().equalsIgnoreCase("Hi, Syed")) {
				System.out.println("Login Verification Passed");
				System.out.println(
						"*****************************************************************************************************");
			} else {
				System.out.println("Login Varification Failed");
				System.out.println(
						"*****************************************************************************************************");
			}
		} catch (Exception e) {
			System.out.println("Unable to verify Login");
			System.out.println(
					"*****************************************************************************************************");
		}
	}

	/** Validating login credential of user */
	public void validateLogin() {
		color.drawBorder(obj.getUserNameAfterLogin(), "pink");
		try {
			Assert.assertEquals(obj.getUserNameAfterLogin().getText(), "Hi, Syed");
		} catch (AssertionError e) {
			System.out.println("Login Validation FAILED");
			System.out.println(
					"*****************************************************************************************************");
		}
		System.out.println("Loging Validation PASSED");
		System.out.println(
				"*****************************************************************************************************");
	}

	/**
	 * User searches for an item
	 * 
	 * @throws InterruptedException
	 */
	public void searchForItems(String productName) throws InterruptedException {
		color.drawBorder(obj.searchForItems(), "orange");
		obj.searchForItems().sendKeys(productName);
		obj.searchForItems().submit();
		driver.navigate().refresh();
		Thread.sleep(5000);
		System.out.println("User searchs for items");
		System.out.println(
				"*****************************************************************************************************");
	}

	/** User sorts by price high to low */
	public void sortByHighToLowPrice() {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getSortBy()));

		color.drawBorder(obj.getSortBy(), "cyan");
		Select sortDropDown = new Select(obj.getSortBy());
		sortDropDown.selectByValue("price-desc-rank");
		System.out.println("User sorts item by high to low prices");
		System.out.println(
				"*****************************************************************************************************");
	}

	/**
	 * User finds total page number
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

	/** User finds current page number */
	public void getCurrentPage() {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getCurrentPage()));
		// ac.moveToElement(obj.getCurrentPage()).build().perform();
		color.drawBorder(obj.getCurrentPage(), "green");
		System.out.println("The current page number is\n" + obj.getCurrentPage().getText()
				+ "\n-----------------------------------------------------------------------------------------");
	}

	/** User finds all product and receives a count of all products */
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

	/** User finds the total count of a specific product */
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

	/** User sorts items by low to high price */
	public void sortByLowToHighPrice() throws InterruptedException {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getSortBy()));
		color.drawBorder(obj.getSortBy(), "cyan");
		Select sortDropDown = new Select(obj.getSortBy());
		sortDropDown.selectByValue("price-asc-rank");
		Thread.sleep(6000);
		System.out.println("User sorts item by low to high prices");
		System.out.println(
				"*****************************************************************************************************");
	}

	/** User finds High and Low prices */
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

	/** User views an item details */
	public void viewItemDetails() {

		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getViewItem()));
		color.drawBorder(obj.getViewItem(), "blue");
		obj.getViewItem().click();
		System.out.println("User views item details");
		System.out.println(
				"*****************************************************************************************************");
	}

	/** User adds an item to cart */
	public void addAnItemToCart() {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getAddToCartButton()));

		color.drawBorder(obj.getAddToCartButton(), "black");
		obj.getAddToCartButton().click();
		System.out.println("User adds an item to cart");
		System.out.println(
				"*****************************************************************************************************");
	}

	/**
	 * User clicks on cart button public void clickOnCart() {
	 * 
	 * color.drawBorder(obj.getProductCountResult(), "blue");
	 * obj.getProductCountResult().click();
	 * 
	 * }
	 */

	/** User cancels warranty if it appears */
	public void clickNoOnProtectionPlan() throws Throwable {
		obj.getAddToCartButton().click();
		Thread.sleep(2000);
		try {
			color.drawBorder(obj.clickNoThanksToWarrenty(), "green");
			obj.clickNoThanksToWarrenty().click();
		} catch (NoSuchElementException | ElementNotVisibleException e) {
			System.out.println("No protection plan is offered");
			System.out.println(
					"*****************************************************************************************************");
		}
		System.out.println("User doesn't accept propection plan");
		System.out.println(
				"*****************************************************************************************************");
	}

	/**
	 * User clicks on Cart Button after adding a product public void
	 * clickOnAnyCartButton() throws InterruptedException { Thread.sleep(2000); try
	 * { wait = new WebDriverWait(driver, 5);
	 * wait.until(ExpectedConditions.visibilityOf(obj.clickonCartButton()));
	 * color.drawBorder(obj.clickonCartButton(), "magenta");
	 * obj.clickonCartButton().click(); } catch (NoSuchElementException |
	 * ElementNotVisibleException error) { System.out.println(error); } try {
	 * Thread.sleep(3000); wait = new WebDriverWait(driver, 5);
	 * wait.until(ExpectedConditions.visibilityOf(obj.getCartOnProtectionPlanPage()));
	 * color.drawBorder(obj.getCartOnProtectionPlanPage(), "black");
	 * obj.getCartOnProtectionPlanPage().click(); } catch (NoSuchElementException |
	 * ElementNotVisibleException error2) { System.out.println(error2); }
	 * obj.clickOnroceedToCheckOutAfteraddingFirstItem().click(); }
	 * 
	 * public void clickOnProceedToPayment() throws InterruptedException {
	 * Thread.sleep(2000); try {
	 * obj.clickOnroceedToCheckOutAfteraddingFirstItem().click(); } catch
	 * (NoSuchElementException | ElementNotVisibleException error3) {
	 * System.out.println("The proceed to payment button is not available"); } }
	 */

	/** User proceeds to payment */
	public void proceedToCheckout() throws InterruptedException {
		Thread.sleep(3000);
		try {
			wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(obj.getProceedToCheckoutButton()));

			color.drawBorder(obj.getProceedToCheckoutButton(), "orange");
			obj.getProceedToCheckoutButton().click();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println(
					"*****************************************************************************************************");
		}
		System.out.println("User is able to proceed to checout");
		System.out.println(
				"*****************************************************************************************************");
	}

	/** User changes payment type */
	public void changePaymentType() throws InterruptedException {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getChangePaymentType()));

		color.drawBorder(obj.getChangePaymentType(), "black");
		obj.getChangePaymentType().click();
		System.out.println("User is able to change payment type");
		System.out.println(
				"*****************************************************************************************************");
	}

	/** User adds a new payment */
	public void addNewPayment() throws InterruptedException {
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getAddNewBankAccount()));
		color.drawBorder(obj.getAddNewBankAccount(), "orange");
		obj.getAddNewBankAccount().click();
		System.out.println("User is able to add new bank account");
		System.out.println(
				"*****************************************************************************************************");

		/**
		 * ------------------ How to Handle pop-up window --------- // Store your parent
		 * window parentWindowHandler = driver.getWindowHandle(); subWindowHandler =
		 * null;
		 * 
		 * // get all window handles Set<String> handles = driver.getWindowHandles();
		 * Iterator<String> iterator = handles.iterator(); while (iterator.hasNext()) {
		 * subWindowHandler = iterator.next(); }
		 * driver.switchTo().window(subWindowHandler); // switch to popup window
		 * 
		 * // Now you are in the popup window, perform necessary actions here // Now you
		 * are in the popup window, perform necessary actions here
		 * 
		 * driver.switchTo().window(parentWindowHandler); // switch back to parent //
		 * window
		 */
		try {
			wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(obj.getNameOnBank()));
			wait.until(ExpectedConditions.visibilityOf(obj.getBankRoutingNumber()));
			wait.until(ExpectedConditions.visibilityOf(obj.getReEnterCheckingAccountNumber()));
			wait.until(ExpectedConditions.visibilityOf(obj.getDrLicenseNumber()));
			wait.until(ExpectedConditions.visibilityOf(obj.getStateDropdown()));

			color.drawBorder(obj.getNameOnBank(), "blue");
			obj.getNameOnBank().sendKeys(obj.getNameOnAccountString());
			color.drawBorder(obj.getBankRoutingNumber(), "blue");
			obj.getBankRoutingNumber().sendKeys(obj.getBankRountingNumberInt());
			color.drawBorder(obj.getCheckingAccountNumber(), "red");
			obj.getCheckingAccountNumber().sendKeys(obj.getCheckingAccountNumberInt());
			color.drawBorder(obj.getReEnterCheckingAccountNumber(), "blue");
			obj.getReEnterCheckingAccountNumber().sendKeys(obj.getReEnterCheckingAccountNumberInt());
			color.drawBorder(obj.getDrLicenseNumber(), "blue");
			obj.getDrLicenseNumber().sendKeys(obj.getDriverLincenseInt());
			System.out.println("User is able to add new bank info");
			System.out.println(
					"*****************************************************************************************************");

			color.drawBorder(obj.getStateDropdown(), "blue");
			obj.getStateDropdown().click();
			System.out.println("User is able to click on Bank state drop-down");
			System.out.println(
					"*****************************************************************************************************");

			Thread.sleep(1000);
			for (WebElement selectState : obj.getStateList()) {
				Thread.sleep(1000);

				if (selectState.getText().equalsIgnoreCase("NY")) {
					// color.drawBorder(selectState, "blue");
					selectState.click();
					System.out.println("User selects Bank state");
					System.out.println(selectState.getText());
					System.out.println(
							"*****************************************************************************************************");
				}
			}
		} catch (NoSuchElementException | ElementNotVisibleException e) {
			System.out.println("Unable to click from state dropdown");
			System.out.println(
					"*****************************************************************************************************");

		}

	}

	/**
	 * User sees confirmation message for new payment type
	 * 
	 * @throws InterruptedException
	 */
	public void getConfirmationMessage() throws InterruptedException {
		Thread.sleep(2000);

		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getAddThisCheckingAccount()));

		color.drawBorder(obj.getAddThisCheckingAccount(), "black");
		obj.getAddThisCheckingAccount().click();
		System.out.println("Add this bank account is clicked");
		System.out.println(
				"*****************************************************************************************************");

		Thread.sleep(3000);
		try {
			color.drawBorder(obj.getPaymentFailureValidationMessage(), "red");
			if (obj.getPaymentFailureValidationMessage().getText().equalsIgnoreCase("There was a problem")) {
				System.out.println("Adding payment failed. Test Passed.");
				System.out.println(
						"*****************************************************************************************************");
			} else {
				System.out.println("Account added");
				System.out.println(
						"*****************************************************************************************************");
			}
		} catch (Exception e) {
			System.out.println("Account addtion confirmation is not shown");

		}

		// Now you are in the popup window, perform necessary actions here
		// driver.switchTo().window(parentWindowHandler); // switch back to parent
		// window
		// driver.navigate().to(obj.getURL());

		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(obj.clickOnCancelAddBankAccountButton()));
		color.drawBorder(obj.clickOnCancelAddBankAccountButton(), "black");
		obj.clickOnCancelAddBankAccountButton().click();
		System.out.println("User clicks on cancel");
		System.out.println(
				"*****************************************************************************************************");
	}

	/**
	 * After Canceling Payment, user clicks on Items, return to cart and deletes the
	 * item from the cart
	 */
	public void returnBackToCart() throws Throwable {
		try {
			wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(obj.clickOnCheckoutWithItemsOnPaymentPage()));
			wait.until(ExpectedConditions.visibilityOf(obj.clickOnReturnToCartOnPaymentPage()));

			color.drawBorder(obj.clickOnCheckoutWithItemsOnPaymentPage(), "red");
			obj.clickOnCheckoutWithItemsOnPaymentPage().click();
			System.out.println("User click on return to cart button");

			color.drawBorder(obj.clickOnReturnToCartOnPaymentPage(), "blue");
			obj.clickOnReturnToCartOnPaymentPage().click();
		} catch (Exception e) {
			System.out.println("Unable to go back to cart");
			System.out.println(
					"*****************************************************************************************************");
		}
	}

	/** User tries to delete items from the cart */
	public void deleteItemsFromCart() throws Throwable {
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.clickOnDeleteFirstItemFromCart()));
			wait.until(ExpectedConditions.visibilityOf(obj.clickOnDeleteSecondItemFromCart()));

			color.drawBorder(obj.clickOnDeleteFirstItemFromCart(), "red");
			obj.clickOnDeleteFirstItemFromCart().click();
			System.out.println("User deletes the first item in cart");
			System.out.println(
					"*****************************************************************************************************");
			color.drawBorder(obj.clickOnDeleteSecondItemFromCart(), "red");
			obj.clickOnDeleteSecondItemFromCart().click();
			System.out.println("User deletes the second item in cart");
			System.out.println(
					"*****************************************************************************************************");
		} catch (Exception e) {
			System.out.println("Unable to delete items from cart");
			System.out.println(
					"*****************************************************************************************************");
		}

	}

	/** User tries to go back to the landing page */
	public void goBackToLandingPage() {

		driver.navigate().to(obj.getURL());
		System.out.println("User goes back to landing page");
		System.out.println(
				"*****************************************************************************************************");
		System.out.println(driver.getCurrentUrl());
		System.out.println(
				"*****************************************************************************************************");
	}

	/** User closes the browser */
	public void closeAndExitBrowser() {
		driver.quit();
		System.out.println("User closes the browser");
		System.out.println(
				"*****************************************************************************************************");
	}

}