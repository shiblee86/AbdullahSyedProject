package com.newpagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageFactoryLoginXpath {

	private String URL = "https://www.amazon.com/";
	private String userName = "syed.r.abdullah@gmail.com";
	private String pass = "$Sa038575";
	
	private String nameOnAccountString = "Syed R. Abdullah";
	public String getNameOnAccountString() {
		return nameOnAccountString;
	}
	private String bankRountingNumberInt = "000000000";
	public String getBankRountingNumberInt() {
		return bankRountingNumberInt;
	}
	private String checkingAccountNumberInt = "00000000000000000001";
	public String getCheckingAccountNumberInt() {
		return checkingAccountNumberInt;
	}
	private String reEnterCheckingAccountNumberInt = "00000000000000000001";
	public String getReEnterCheckingAccountNumberInt() {
		return reEnterCheckingAccountNumberInt;
	}
	private String driverLincenseInt = "456123789";
	public String getDriverLincenseInt() {
		return driverLincenseInt;
	}

	@FindBy(xpath = "//*[@id='nav-link-accountList']")
	private WebElement myAccount;

	@FindBy(xpath = "//*[@id='ap_email']")
	private WebElement emailAddress;

	@FindBy(xpath = "//*[@id='ap_password']")
	private WebElement password;

	@FindBy(xpath = "//*[contains(@id,'signInSubmit')]")
	private WebElement signIn;

	@FindBy(xpath = "//*[contains(text(),'Hi, Syed')]")
	private WebElement userNameAfterLogin;
	
	@FindBy(css = "#twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(css = "#sort")
	private WebElement sortBy;
	
	@FindBy(css="#s-result-count")
	private WebElement productCountResult;
	
	public WebElement getProductCountResult() {
		return productCountResult;
	}
	
	public WebElement getSortBy() {
		return sortBy;
	}
	
	@FindBy(css="//*[contains(@id,'pagnNextString')]")
	private WebElement nextButton;
	
	public WebElement getNextButton() {
		return nextButton;
	}
	
	@FindBy(css=".sx-price-whole")
	private List<WebElement> dollarPriceOfItem;
	
	public List<WebElement> getDollarPriceOfItem() {
		return dollarPriceOfItem;
	}
	
	@FindBy(css=".sx-price-fractional")
	private List<WebElement> centPriceOfItem;
	
	public List<WebElement> getCentsPriceOfItem(){
		return centPriceOfItem;
	}
	
	@FindBy(css=".s-access-title")
	private List<WebElement>allItemsPageOne;
	
	@FindBy(css=".pagnDisabled")
	private WebElement lastPage;
	
	@FindBy(xpath="//*[contains(@class,'pagnLink')]")
	private List<WebElement> totalPageCount;
	
	public List<WebElement> getTotalPageCount() {
		return totalPageCount;
	}
	
	@FindBy(xpath="//*[@class='pagnCur']")
	private WebElement currentPage;
	
	@FindBy(xpath="//*[@id='s-result-count']")
	private WebElement totalProductCount;
	
	@FindBy(css=".sx-price-whole")
	private List<WebElement> pricePerItem;
	
	public List<WebElement> getPricePerItem() {
		return pricePerItem;
	}
	
	@FindBy(xpath="(//*[contains(@class,'s-access-title')])[1]")
	private WebElement addItemToCart;
	
	public WebElement getAddItemToCart() {
		return addItemToCart;
	}
	
	@FindBy(css="#add-to-cart-button")
	private WebElement addToCartButton;
	
	public WebElement getAddToCartButton(){
		return addToCartButton;
	}
	
	@FindBy(xpath="//*[contains(@class,'hlb-checkout-button')]")
	private WebElement proceedToCheckoutButton;
	
	public WebElement getProceedToCheckoutButton() {
		return proceedToCheckoutButton;
	}
	
	@FindBy(css="#payChangeButtonId")
	private WebElement changePaymentType;
	
	public WebElement getChangePaymentType() {
		return changePaymentType;
	}
	
	@FindBy(xpath="//*[contains(@id,'bank-account-popover-link')]")
	private WebElement addNewBankAccount;
	
	public WebElement getAddNewBankAccount() {
		return addNewBankAccount;
	}
	
	@FindBy(xpath="//*[contains(@class,'a-popover a-popover-modal')]")
	private WebElement newBankAccountPopup;
	
	public WebElement getNewBankAccountPopup(){
		return newBankAccountPopup;
	}
	
	@FindBy(xpath="(//*[contains(@class,'a-input-text a-span12')])[1]")
	private WebElement nameOnBank;
	
	public WebElement getNameOnBank() {
		return nameOnBank;
	}
	
	@FindBy(xpath="//*[contains(@id,'bank-routing-number')]")
	private WebElement bankRoutingNumber;
	
	public WebElement getBankRoutingNumber() {
		return bankRoutingNumber;
	}
	
	@FindBy(xpath="(//*[contains(@id,'bank-account-number')])[1]")
	private WebElement checkingAccountNumber;
	
	public WebElement getCheckingAccountNumber() {
		return checkingAccountNumber;
	}
	
	@FindBy(xpath="(//*[contains(@id,'bank-account-number-confirm')])[2]")
	private WebElement reEnterCheckingAccountNumber;
	
	public WebElement getReEnterCheckingAccountNumber() {
		return reEnterCheckingAccountNumber;
	}
	
	@FindBy(xpath="(//*[contains(@id,'bank-dl')])[1]")
	private WebElement drLicenseNumber;
	
	public WebElement getDrLicenseNumber() {
		return drLicenseNumber;
	}
	public WebElement getTotalProductCount() {
		return totalProductCount;
	}
	
	@FindBy(xpath="(//*[contains(text(),'There was a problem')])[3]")
	private WebElement paymentFailureValidationMessage;
	
	public WebElement getPaymentFailureValidationMessage() {
		return paymentFailureValidationMessage;
	}
	
	@FindBy(xpath="(//*[contains(@class,'a-dropdown-prompt')])[16]")
	private WebElement stateDropdownButton;
	
	public WebElement getStateDropdown() {
		return stateDropdownButton;
	}
	
	@FindBy(xpath="//*[contains(@class,'a-list-link')]//li")
	private List<WebElement> stateList;
	
	public List<WebElement> getStateList() {
		return stateList;
	}
	
	@FindBy(xpath="//*[contains(text(),'Add this checking account')]")
	private WebElement addThisCheckingAccount;
	
	public WebElement getAddThisCheckingAccount() {
		return addThisCheckingAccount;
	}
	
	public WebElement getCurrentPage() {
		return currentPage;
	}
	
	public WebElement getLastPage() {
		return lastPage;
	}
	
	public List<WebElement> findAllItemsPageOne() {
		return allItemsPageOne;
	}
	
	public WebElement searchForItems() {
		return searchBox;
	}

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
