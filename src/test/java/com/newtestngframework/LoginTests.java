package com.newtestngframework;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.genericlibrary.BaseAmazonTestCases;

public class LoginTests {

	BaseAmazonTestCases obj = new BaseAmazonTestCases();

	@BeforeTest
	public void getSetup() {
		obj.getSetup();
	}

	@Test
	public void getLogin() {
		obj.getLogin();
	}

	@Test
	public void verifyLogin() {
		obj.verifyLogin();
	}

	@Test
	public void validateLogin() {
		obj.validateLogin();
	}

	@AfterTest
	public void tearDown() {
		obj.tearDown();
	}

}