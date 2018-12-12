package com.newpagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonPageFactory {

	private String URL = "https://www.amazon.com/";

	public String getURL() {
		return URL;
	}

	private String userName = "syed.r.abdullah@gmail.com";

	public String getUserName() {
		return userName;

	}

	private String password = "$Sa038575";

	public String getPass() {
		return password;
	}

	private String nameOnAccountString = "Syed R. Abdullah";

	public String getNameOnAccountString() {
		return nameOnAccountString;
	}

	private String bankRountingNumberInt = "000000000";

	public String getBankRountingNumberInt() {
		return bankRountingNumberInt;
	}

	private String checkingAccountNumberInt = "00000000001";

	public String getCheckingAccountNumberInt() {
		return checkingAccountNumberInt;
	}

	private String reEnterCheckingAccountNumberInt = "00000000001";

	public String getReEnterCheckingAccountNumberInt() {
		return reEnterCheckingAccountNumberInt;
	}

	private String driverLincenseInt = "456123789";

	public String getDriverLincenseInt() {
		return driverLincenseInt;
	}

	@FindBy(xpath = "//*[@id='nav-link-accountList']")
	private WebElement myAccount;

	public WebElement getMyAccount() {
		return myAccount;
	}

	@FindBy(xpath = "//*[@id='ap_email']")
	private WebElement emailAddress;

	public WebElement getEmailAddress() {
		return emailAddress;
	}

	@FindBy(xpath = "//*[@id='ap_password']")
	private WebElement passwordInputField;

	public WebElement getPassword() {
		return passwordInputField;
	}

	@FindBy(xpath = "//*[contains(@id,'signInSubmit')]")
	private WebElement signIn;

	public WebElement getSignIn() {
		return signIn;
	}

	@FindBy(xpath = "//*[contains(text(),'Hi, Syed')]")
	private WebElement userNameAfterLogin;

	public WebElement getUserNameAfterLogin() {
		return userNameAfterLogin;
	}

	@FindBy(css = "#twotabsearchtextbox")
	private WebElement searchBox;

	public WebElement searchForItems() {
		return searchBox;
	}

	@FindBy(css = "#sort")
	private WebElement sortBy;

	public WebElement getSortBy() {
		return sortBy;
	}

	@FindBy(css = "#s-result-count")
	private WebElement productCountResult;

	public WebElement getProductCountResult() {
		return productCountResult;
	}

	@FindBy(css = "#nav-cart-count")
	private WebElement cartButton;

	public WebElement clickonCartButton() {
		return cartButton;
	}

	@FindBy(xpath = "(//*[contains(@class,'a-button-inner')])[4]")
	private WebElement proceedToCheckOutAfteraddingFirstItem;

	public WebElement clickOnroceedToCheckOutAfteraddingFirstItem() {
		return proceedToCheckOutAfteraddingFirstItem;
	}

	@FindBy(xpath = "(//span[contains(text(), 'Proceed to checkout')]//parent::span//preceding-sibling::input)[1]")
	private WebElement cartOnProtectionPlanPage;

	public WebElement getCartOnProtectionPlanPage() {
		return cartOnProtectionPlanPage;
	}

	@FindBy(css = "//*[contains(@id,'pagnNextString')]")
	private WebElement nextButton;

	public WebElement getNextButton() {
		return nextButton;
	}

	@FindBy(css = ".sx-price-whole")
	private List<WebElement> dollarPriceOfItem;

	public List<WebElement> getDollarPriceOfItem() {
		return dollarPriceOfItem;
	}

	@FindBy(css = ".sx-price-fractional")
	private List<WebElement> centPriceOfItem;

	public List<WebElement> getCentsPriceOfItem() {
		return centPriceOfItem;
	}

	@FindBy(css = ".s-access-title")
	private List<WebElement> allItemsPageOne;

	public List<WebElement> findAllItemsPageOne() {
		return allItemsPageOne;
	}

	@FindBy(css = ".pagnDisabled")
	private WebElement lastPage;

	public WebElement getLastPage() {
		return lastPage;
	}

	@FindBy(xpath = "//*[contains(@class,'pagnLink')]")
	private List<WebElement> totalPageCount;

	public List<WebElement> getTotalPageCount() {
		return totalPageCount;
	}

	@FindBy(xpath = "//*[@class='pagnCur']")
	private WebElement currentPage;

	public WebElement getCurrentPage() {
		return currentPage;
	}

	@FindBy(xpath = "//*[@id='s-result-count']")
	private WebElement totalProductCount;

	public WebElement getTotalProductCount() {
		return totalProductCount;
	}

	@FindBy(css = ".sx-price-whole")
	private List<WebElement> pricePerItem;

	public List<WebElement> getPricePerItem() {
		return pricePerItem;
	}

	@FindBy(xpath = "(//*[contains(@class,'s-access-title')])[1]")
	private WebElement viewItem;

	public WebElement getViewItem() {
		return viewItem;
	}

	@FindBy(xpath = "//*[contains(@id,'add-to-cart-button')]")
	private WebElement addToCartButton;

	public WebElement getAddToCartButton() {
		return addToCartButton;
	}

	@FindBy(xpath = "//*[contains(text(),'Proceed to checkout')]")
	// @FindBy(xpath="//*[contains(text(),'Proceed to
	// checkout')]//preceding-sibling::input")
	// @FindBy(xpath="(//*[contains(@class,'a-button-inner')])[2]/a")
	private WebElement proceedToCheckoutButton;

	public WebElement getProceedToCheckoutButton() {
		return proceedToCheckoutButton;
	}

	@FindBy(css = "#payChangeButtonId")
	private WebElement changePaymentType;

	public WebElement getChangePaymentType() {
		return changePaymentType;
	}

	@FindBy(xpath = "//*[contains(@id,'bank-account-popover-link')]")
	private WebElement addNewBankAccount;

	public WebElement getAddNewBankAccount() {
		return addNewBankAccount;
	}

	@FindBy(css = ".a-popover-modal")
	private WebElement warrentyPopup;

	public WebElement getWarrentyPopup() {
		return warrentyPopup;
	}

	@FindBy(xpath = "//*[contains(@class,'a-popover a-popover-modal')]")
	private WebElement newBankAccountPopup;

	public WebElement getNewBankAccountPopup() {
		return newBankAccountPopup;
	}

	@FindBy(xpath = "(//*[contains(@class,'a-input-text a-span12')])[1]")
	private WebElement nameOnBank;

	public WebElement getNameOnBank() {
		return nameOnBank;
	}

	@FindBy(xpath = "//*[contains(@id,'bank-routing-number')]")
	private WebElement bankRoutingNumber;

	public WebElement getBankRoutingNumber() {
		return bankRoutingNumber;
	}

	@FindBy(css = "#bank-account-number")
	private WebElement checkingAccountNumber;

	public WebElement getCheckingAccountNumber() {
		return checkingAccountNumber;
	}

	@FindBy(css = "#bank-account-number-confirm")
	private WebElement reEnterCheckingAccountNumber;

	public WebElement getReEnterCheckingAccountNumber() {
		return reEnterCheckingAccountNumber;
	}

	@FindBy(xpath = "(//*[contains(@id,'bank-dl')])[1]")
	private WebElement drLicenseNumber;

	public WebElement getDrLicenseNumber() {
		return drLicenseNumber;
	}

	// @FindBy(xpath = "//*[@id='new-bank-error-box']/div/div/h4")
	// @FindBy(xpath="(//*[contains(text(),'There was a problem')])[3]")
	@FindBy(xpath = "(//*[contains(@class,'a-alert-heading')])[4]")
	private WebElement paymentFailureValidationMessage;

	public WebElement getPaymentFailureValidationMessage() {
		return paymentFailureValidationMessage;
	}

	@FindBy(xpath = "(//*[contains(@class,'a-declarative')])[139]")
	// @FindBy(xpath="(//*[contains(@class,'a-button-inner')])[50]")
	// @FindBy(xpath"(//*[contains(@class,'a-dropdown-prompt')])[21]")
	private WebElement stateDropdownButton;

	public WebElement getStateDropdown() {
		return stateDropdownButton;
	}

	@FindBy(xpath = "//*[contains(text(),'No Thanks')]")
	private WebElement noThanksToWarrenty;

	public WebElement clickNoThanksToWarrenty() {
		return noThanksToWarrenty;
	}

	@FindBy(xpath = "//*[contains(@id,'bank-dl-state')]")
	private List<WebElement> stateList;

	public List<WebElement> getStateList() {
		return stateList;
	}

	// @FindBy(xpath = "(//*[contains(@class,'a-button-inner')])[53]")
	// @FindBy(xpath="//*[contains(@id,'addBankAccountButtonId-announce')]/span/input")
	// @FindBy(xpath="//*[contains(text(),'Add this checking account')]")
	@FindBy(xpath = "(//*[contains(@class,'a-button-input')])[20]")
	// @FindBy(css="#addBankAccountButtonId-announce")
	private WebElement addThisCheckingAccount;

	public WebElement getAddThisCheckingAccount() {
		return addThisCheckingAccount;
	}

	// @FindBy(xpath = "//*[@id="header"]/div/div[3]/h1/span/span/span/span")
	// @FindBy(xpath = "(//span[contains(text(),'item')])[1]")
	// @FindBy(css="#header > div > div.a-column.a-span8 > h1 > span > span > span >
	// span")
	// @FindBy(xpath="(//*[contains(@class,'a-declarative')])[5]")
	// @FindBy(xpath="(//*[contains(text(),'item')])[2]")
	@FindBy(xpath = "//div[@id='header']/div/div[@class='a-column a-span8']/h1/span/span/span/span")

	private WebElement itemsOnCheckoutPage;

	public WebElement clickOnItemsOnCheckoutPage() {
		return itemsOnCheckoutPage;
	}

	// @FindBy(css="#a-autoid-3-announce")
	@FindBy(xpath = "//*[@id='a-autoid-3-announce']")
	private WebElement returnToCartOnPaymentPage;

	public WebElement clickOnReturnToCartOnPaymentPage() {
		return returnToCartOnPaymentPage;
	}

	// @FindBy(css = "#cancelAddBankAccountButtonId")
	// @FindBy(xpath="[@id="cancelAddBankAccountButtonId"]/span/input")
	@FindBy(xpath = "(//*[contains(@class,'a-button-input')])[21]")
	private WebElement cancelAddBankAccountButton;

	public WebElement clickOnCancelAddBankAccountButton() {
		return cancelAddBankAccountButton;
	}

	@FindBy(xpath = "(//*[contains(@value,'Delete')])[1]")
	private WebElement deleteFirstItemFromCart;

	public WebElement clickOnDeleteFirstItemFromCart() {
		return deleteFirstItemFromCart;
	}

	@FindBy(xpath = "(//*[contains(@value,'Delete')])[2]")
	private WebElement deleteSecondItemFromCart;

	public WebElement clickOnDeleteSecondItemFromCart() {
		return deleteSecondItemFromCart;
	}

}
