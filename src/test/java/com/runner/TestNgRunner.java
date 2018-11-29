package com.runner;

import java.io.File;

import org.testng.annotations.AfterClass;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)// need this line for junit

@CucumberOptions(plugin = { "pretty", "html:target", "json:target/cucumber.json",
		"com.cucumber.listener.ExtentCucumberFormatter:target/Cucumber_Extents_report.html" },

		features = {
				"src/main/resources/LoginTestCaseScenario.feature, src/main/resources/AddingNewPaymentMethod.feature" }, glue = {
						"com.stepdef" },

		monochrome = true, dryRun = false, strict = true)
public class TestNgRunner extends AbstractTestNGCucumberTests {// remove from extends if junit

	@AfterClass
	public static void teardown() throws Throwable {
		Reporter.loadXMLConfig(new File("./ExtentsReportCucumber.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", "Window 10");
		Reporter.setTestRunnerOutput("Sample test runner output message");

		// Reporter.addScreenCaptureFromPath("absolute screenshot path");
		// Reporter.addScreenCast("absolute screen cast path");
	}
}