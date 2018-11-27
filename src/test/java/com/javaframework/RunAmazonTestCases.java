package com.javaframework;

import com.genericlibrary.BaseAmazonTestCases;

public class RunAmazonTestCases {

	public static void main(String[] args) throws InterruptedException {
		
		BaseAmazonTestCases obj = new BaseAmazonTestCases();
		
		obj.getSetup();
		obj.getLogin();
		obj.verifyLogin();
		obj.validateLogin();
		obj.searchForItems("iphone");
		obj.sortByHighToLowPrice();
		obj.getTotalPageNumber();
		obj.getCurrentPage();
		obj.findAllItemsOnPageOne();
		obj.findAllOccuranceOfASpecifProduct("iphone x");
		obj.getHighAndLowPrices();
		obj.addAnItemToCart();
		obj.addNewPayment();
		obj.tearDown();



	}
}
