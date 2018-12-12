package com.stepdef;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.newpagefactory.AmazonPageFactory;
import com.util.Highlighter;
import com.util.ScreenShots;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import edu.emory.mathcs.backport.java.util.Collections;

public class SearchFilterStoreCartPaymentBank {

	WebDriver driver;
	AmazonPageFactory obj;
	Highlighter color;
	List<String> productList = new ArrayList<>();
	List<String> pricePerItemTable = new ArrayList<>();
	Actions action;
	String parentWindowHandler;
	String subWindowHandler;

	@Given("^User is able to launch any browser$")
	public void user_is_able_to_launch_any_browser() throws Throwable {
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
		obj = PageFactory.initElements(driver, AmazonPageFactory.class);
		color = new Highlighter(driver);
		driver.manage().window().fullscreen();
	}

	@Given("^User is able to navigate to the url$")
	public void user_is_able_to_navigate_to_the_url() throws Throwable {
		driver.navigate().to(obj.getURL());
	}

	@When("^User clicks on Account & List$")
	public void user_clicks_on_Account_List() throws Throwable {
		color.drawBorder(obj.getMyAccount(), "green");
		ScreenShots.captureScreenShot(driver, "LoginPage");
		obj.getMyAccount().click();
	}

	@Given("^User enters valid userName$")
	public void user_enters_userName() throws Throwable {
		color.drawBorder(obj.getEmailAddress(), "red");
		obj.getEmailAddress().sendKeys(obj.getUserName());
	}

	@Given("^User enters valid password$")
	public void user_enters_password() throws Throwable {
		color.drawBorder(obj.getPassword(), "blue");
		obj.getPassword().sendKeys(obj.getPass());
	}

	@Given("^User clicks on SignIn button$")
	public void user_clicks_on_SignIn_button() throws Throwable {
		color.drawBorder(obj.getSignIn(), "cyan");
		ScreenShots.captureScreenShot(driver, "Screenshot Email and password input fields");
		obj.getSignIn().click();
		System.out.println("Logged into my account");

	}

	@Given("^the user is able to click on the search button and search for product \"([^\"]*)\"$")
	public void the_user_is_able_to_click_on_the_search_button_and_search_for_product(String productName)
			throws Throwable {
		obj.searchForItems().sendKeys(productName);
		obj.searchForItems().submit();
		// Write code here that turns the phrase above into concrete actions

	}

	@Given("^the user is able to sort item by high to low price$")
	public void the_user_is_able_to_sort_item_by_high_to_low_price() throws Throwable {
		Select sortDropDown = new Select(obj.getSortBy());
		sortDropDown.selectByValue("price-desc-rank");

	}

	@Given("^the user is able to find total page number$")
	public void the_user_is_able_to_find_total_page_number() throws Throwable {
		System.out.println("Total number of pages with class '.pagnLink' ::\n" + obj.getTotalPageCount().size());
		for (int j = 0; j < obj.getTotalPageCount().size(); j++) {
			color.drawBorder(obj.getTotalPageCount().get(j), "cyan");
		}
		System.out.println("-----------------------------------------------------------------------------------------");
		System.err.println("The last page number is ::\n" + obj.getLastPage().getText()
				+ "\n-----------------------------------------------------------------------------------------");
	}

	@Given("^the user is able to find current page number$")
	public void the_user_is_able_to_find_current_page_number() throws Throwable {
		// ac.moveToElement(obj.getCurrentPage()).build().perform();
		color.drawBorder(obj.getCurrentPage(), "green");
		System.out.println("The current page number is\n" + obj.getCurrentPage().getText()
				+ "\n-----------------------------------------------------------------------------------------");
	}

	@Given("^the user is able to see all searched products and count$")
	public void the_user_is_able_to_see_all_searched_products_and_count() throws Throwable {
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

	@Given("^the user is able to filter specific products count of a specific product \"([^\"]*)\"$")
	public void the_user_is_able_to_filter_specific_products_count_of_a_specific_product(String specificProduct)
			throws Throwable {
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

	@Given("^the user is able to see item with highest and item with lowset price$")
	public void the_user_is_able_to_see_item_with_highest_and_item_with_lowset_price() throws Throwable {
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

	@Given("^the user is able to sort item by low to high price$")
	public void the_user_is_able_to_sort_item_by_low_to_high_price() throws Throwable {
		Select sortDropDown = new Select(obj.getSortBy());
		sortDropDown.selectByValue("price-asc-rank");
		Thread.sleep(6000);
	}

	@Given("^the user is able to add click on an item and see details$")
	public void the_user_is_able_to_add_click_on_an_item_and_see_details() throws Throwable {
		obj.getViewItem().click();
	}

	@Given("^the user is able to add the item to the cart$")
	public void the_user_is_able_to_add_the_item_to_the_cart() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getAddToCartButton()));
		obj.getAddToCartButton().click();
	}

	@Given("^the user is able to proceed to payment$")
	public void the_user_is_able_to_proceed_to_payment() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getProceedToCheckoutButton()));
		obj.getProceedToCheckoutButton().click();
	}

	@Given("^the user is able to click change payment$")
	public void the_user_is_able_to_click_change_payment() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getChangePaymentType()));
		obj.getChangePaymentType().click();
	}

	@Given("^the user is able to add new bank account$")
	public void the_user_is_able_to_add_new_bank_account() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getAddNewBankAccount()));
		color.drawBorder(obj.getAddNewBankAccount(), "orange");
		obj.getAddNewBankAccount().click();

		// Store your parent window
		parentWindowHandler = driver.getWindowHandle();
		subWindowHandler = null;

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

		for (WebElement selectState : obj.getStateList()) {
			if (selectState.getText().equalsIgnoreCase("NY")) {
				selectState.click();
			}
		}
		obj.getAddThisCheckingAccount().click();
		if (obj.getPaymentFailureValidationMessage().getText().equalsIgnoreCase("There was a problem")) {
			System.out.println("Adding payment failed. Test Passed.");
		}

		// Now you are in the popup window, perform necessary actions here
	}

	@Then("^the User should be able should see success message on screen$")
	public void the_User_should_be_able_should_see_success_message_on_screen() throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(obj.getAddThisCheckingAccount()));
		obj.getAddThisCheckingAccount().click();
		if (obj.getPaymentFailureValidationMessage().getText().equalsIgnoreCase("There was a problem")) {
			System.out.println("Adding payment failed. Test Passed.");
		}
		// Now you are in the popup window, perform necessary actions here
		driver.switchTo().window(parentWindowHandler); // switch back to parent window
		driver.navigate().to(obj.getURL());

	}

	@Then("^the user will be able to proceed to finishing transaction$")
	public void the_user_will_be_able_to_proceed_to_finishing_transaction() throws Throwable {
		parentWindowHandler = driver.getWindowHandle();
		subWindowHandler = null;
		driver.switchTo().window(parentWindowHandler); // switch back to parent window
		driver.navigate().to(obj.getURL());
	}

	@Then("^the user should be able to close the browser$")
	public void the_user_should_be_able_to_close_the_browser() throws Throwable {
		driver.quit();

	}

}
