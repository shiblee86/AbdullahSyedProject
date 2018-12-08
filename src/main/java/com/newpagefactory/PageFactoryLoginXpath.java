package com.newpagefactory;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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
	
	@FindBy(xpath="(//*[contains(@class,'nav-logo-base')])[1]")
	private WebElement homeButton;
	
	public WebElement getHomeButton() {
		return homeButton;
	}

	@FindBy(xpath = "//*[@id='nav-link-accountList']")
	private WebElement myAccount;

	@FindBy(xpath = "//*[@id='ap_email']")
	private WebElement emailAddress;

	@FindBy(xpath = "//*[@id='ap_password']")
	private WebElement password;

	@FindBy(xpath = "//*[contains(@id,'signInSubmit')]")
	private WebElement signIn;

	@FindBy(xpath = "//*[contains(text(),'Hi, Jamjam')]")
	private WebElement userNameAfterLogin;
	
	@FindBy(css = "#twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(css = "#sort")
	private WebElement sortBy;
	
	@FindBy(css="#s-result-count")
	private WebElement productCountResult;
	
	@FindBy(css=".a-icon-logo")
	private WebElement amazonLogoOnCheckoutPage;
	
	public WebElement getAmazonLogoOnChekoutPage() {
		return amazonLogoOnCheckoutPage;
	}
	
	@FindBy(css="#a-autoid-1-announce")
	private WebElement returnToCart;
	
	public WebElement getReturnToCart() {
		return returnToCart;
	}
	
	
	@FindBy(xpath="(//*[contains(@class,'nav-a-2')])[5]")
	private WebElement cartButton;
	
	public WebElement getCartButton() {
		return cartButton;
	}
	
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
	private WebElement viewItem;
	
	public WebElement getViewItem() {
		return viewItem;
	}
	
	@FindBy(xpath="//*[contains(@id,'add-to-cart-button')]")
	private WebElement addToCartButton;
	
	public WebElement getAddToCartButton(){
		return addToCartButton;
	}
	
	//@FindBy(xpath="(//*[contains(@id,'hlb-ptc-btn-native')])[1]")
	@FindBy(xpath="(//*[contains(@class,'a-button-inner')])[2]")
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
	
	@FindBy(css=".a-popover-modal")
	private WebElement warrentyPopup;
	
	public WebElement getWarrentyPopup() {
		return warrentyPopup;
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
	
	@FindBy(xpath="(//*[contains(@class,'a-declarative')])[140]")
	private WebElement stateDropdownButton;
	
	public WebElement getStateDropdown() {
		return stateDropdownButton;
	}
	
	@FindBy (css="#siNoCoverage-announce")
	private WebElement noThanksToWarrenty;
	
	public WebElement clickNoThanksToWarrenty() {
		return noThanksToWarrenty;
	}
	
	@FindBy (how = How.XPATH, using = "//*[contains(text(),'No thanks')]")
	private WebElement nothankbtn2;
	
	public WebElement clickNoThanksToProtection2() {
		return nothankbtn2;
	}
	@FindBy(css=".a-dropdown-link")
	private List<WebElement> stateList;
	
	public List<WebElement> getStateList() {
		return stateList;
	}
	
	@FindBy(xpath="(//*[contains(@class,'a-button-input')])[16]")
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
