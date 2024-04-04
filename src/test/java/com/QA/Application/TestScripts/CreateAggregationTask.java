package com.QA.Application.TestScripts;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.QA.Application.Pages.TaskPageObjects;
import com.QA.Application.TestBase.TestBase;

public class CreateAggregationTask extends TestBase{
	@Test
	public static void tc03verifyCreateAggregationTask() throws InterruptedException, IOException, AWTException {

		test = extent.createTest("Verify Create Aggregation Task Of Application", "Case 1: User needs to verify Create Aggregation Task Of Application .")
				.assignCategory("Functional_TestCase")
				.assignAuthor("Narendra Reddy");
		//Launching Application
		Launch_Application();

		//Click On 	SetUp
		webdriver.clickOnButton(TaskPageObjects.btnSetUp);
		LOG.info("User Click On SetUpDropdown");
		test.pass("User Click on SetUpDropdown");
		webdriver.waitForElementLocated(TaskPageObjects.btnTasks);
		//Click On Tasks Button
		webdriver.clickOnButton(TaskPageObjects.btnTasks);
		webdriver.waitForElementLocated(TaskPageObjects.btnAddNewTask);
		//Click On AddNewTask
		webdriver.clickOnButton(TaskPageObjects.btnAddNewTask);
		webdriver.waitForElementLocated(TaskPageObjects.btnAccountAggregartion);
		if(properties.getProperty("ApplicationAggregationType").equalsIgnoreCase("Account Aggregation")) 
		{
		//Click On Application Account Aggregation 
		webdriver.clickOnButton(TaskPageObjects.btnAccountAggregartion);
		//webdriver.waitForElementLocated(TaskPageObjects.btnAccountAggregartion);
		
		}
		else {
			System.out.println("Pora Pakkaki");
		}

	}
}