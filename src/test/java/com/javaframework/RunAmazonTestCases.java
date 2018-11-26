package com.javaframework;

import com.genericlibrary.BaseAmazonTestCases;

public class RunAmazonTestCases {

	public static void main(String[] args) {
		
		BaseAmazonTestCases obj = new BaseAmazonTestCases();
		
		obj.getSetup();
		obj.searchForItems();
		obj.sortItemsByHighToLowPrice();
		obj.getTotalPageNumber();
		obj.getCurrentPage();
		obj.findAllItemsOnPageOne();
		obj.findAllOccuranceOfASpecifProduct();



	}
}
