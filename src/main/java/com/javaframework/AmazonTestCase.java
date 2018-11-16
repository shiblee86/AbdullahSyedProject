package com.javaframework;
import com.genericlibrary.BaseAmazonTestCases;

public class AmazonTestCase {

	public static void main(String[] args) {

		BaseAmazonTestCases obj = new BaseAmazonTestCases();

		obj.getSetup();
		obj.getLogin();
		obj.verifyLogin();
		obj.validateLogin();
		obj.tearDown();

	}
}
