package com.genericlibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.JavascriptExecutor;
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

public class BaseAmazonTestCases {

	WebDriver driver;
	PageFactoryLoginXpath obj;
	Highlighter color;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Actions ac;
	List<String> productList = new ArrayList<>();
	List<String> pricePerItemTable = new ArrayList<>();

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

	// Search for ihone
	public void searchForItems() {
		obj.searchForItems().sendKeys("iphone");
		obj.searchForItems().submit();
	}

	// Sort by price high to low
	public void sortItemsByHighToLowPrice() {
		Select sortDropDown = new Select(obj.getSortBy());
		sortDropDown.selectByValue("price-desc-rank");
	}

	// Find total page number
	public void getTotalPageNumber() {
		System.out.println("Total number of pages with class '.pagnLink' :: " + obj.getTotalPageCount().size());
		for (int j = 0; j < obj.getTotalPageCount().size(); j++) {
			color.drawBorder(obj.getTotalPageCount().get(j), "cyan");
		}
		System.out.println("-----------------------------------------------------------------------------------------");
		System.err.println("The last page number is :: " + obj.getLastPage().getText());
		System.out.println("-----------------------------------------------------------------------------------------");
	}

	// Find current page number
	public void getCurrentPage() {
		// ac.moveToElement(obj.getCurrentPage()).build().perform();
		color.drawBorder(obj.getCurrentPage(), "green");
		System.out.println("The current page number is " + obj.getCurrentPage().getText());
		System.out.println("-----------------------------------------------------------------------------------------");
	}

	// Find all product and count
	public void findAllItemsOnPageOne() {
		System.out.println("ITEMS DISPLAYED ON CURRENT PAGE");
		System.out.println("-----------------------------------------------------------------------------------------");
		
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(obj.findAllItemsPageOne().get(0)));
		
		 /* for (int product = 0; product < obj.findAllItemsPageOne().size(); product++)
		 * { // color.drawBorder(obj.findAllItemsPageOne().get(product), "organge");
		 * System.out.println(obj.findAllItemsPageOne().get(product).getText());
		 * System.out.println(
		 * "|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||"
		 * );
		 */
		for (WebElement productName : obj.findAllItemsPageOne()) {
			productList.add(productName.getText());

		}
		for (int printProductName = 0; printProductName < productList.size(); printProductName++) {
			System.out.println(productList.get(printProductName));
			System.out.println("-------------------------------------------------------------------------------------");
		}
		System.out.println("Total number of items displayed on page :: " + productList.size());
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("Total product count on Site message ----------> " + obj.getTotalProductCount().getText());
		System.out.println("========================================================================================");

	}

	// Find out total count of a specific product
	public void findAllOccuranceOfASpecifProduct() {
		int count = 0;
		List<Integer> totalForSpecificProduct = new ArrayList<>();
		for (int a = 0; a < productList.size(); a++) {
			if (productList.get(a).contains("iPhone X")) {
				count++;
				totalForSpecificProduct.add(count);
			}
		}
		System.out.println("Total number of specific product on Page 1 :: " + totalForSpecificProduct.size());
		System.out.println("Specific Products :: +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");

	}

	public void getHighAndLowPrices() {
		int count = 0;
		for (int i = 0; i < obj.getPricePerItem().size(); i++) {
			count++;

		}

	}

	public void tearDown() {
		driver.quit();
	}
}
