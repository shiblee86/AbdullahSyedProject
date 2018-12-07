package com.javaframework;

import java.util.ArrayList;
import java.util.List;

import com.genericlibrary.BaseAmazonTestCases;

public class RunAmazonTestCases {

	public static void main(String[] args) throws Throwable {

		List<String> itemsToSearch = new ArrayList<>();
		List<String> specificItemsToSearch = new ArrayList<>();

		BaseAmazonTestCases baseObj = new BaseAmazonTestCases();
		baseObj.getSetup();
		baseObj.getLogin();
		// baseObj.verifyLogin();
		// baseObj.validateLogin();

		itemsToSearch.add("iphone");
		itemsToSearch.add("hp laptop");

		specificItemsToSearch.add("iPhone X");
		specificItemsToSearch.add("Elitebook");

		for (int product = 0; product < itemsToSearch.size(); product++) {

			baseObj.searchForItems(itemsToSearch.get(product));
			baseObj.sortByHighToLowPrice();
			baseObj.getTotalPageNumber();
			baseObj.getCurrentPage();
			baseObj.findAllItemsOnPageOne();
			baseObj.getHighAndLowPrices();
			baseObj.sortByLowToHighPrice();
			baseObj.findAllOccuranceOfASpecifProduct(specificItemsToSearch.get(product));
			baseObj.viewItemDetails();
			baseObj.getRidOfWarrenty();
		}

		baseObj.proceedToPayment();
		baseObj.changePaymentType();
		baseObj.addNewPayment();
		baseObj.confirmationMessage();
		baseObj.goBackToLandingPage();
		baseObj.tearDown();
	}
}
