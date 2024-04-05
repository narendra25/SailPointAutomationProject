package com.QA.Application.TestScripts;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.annotations.Test;
import com.QA.Application.Pages.TaskPageObjects;
import com.QA.Application.TestBase.TestBase;

public class CreateAggregationTask extends TestBase{
	@Test(priority=3)
	public static void tc03verifyCreateAggregationTask() throws InterruptedException, IOException, AWTException {
		CreateExtentTest("Verify Create Aggregation Task Of Application", "Case 1: User needs to verify Create Aggregation Task Of Application .","Functional_TestCase","Narendra Reddy");
		
		//Launching Application
		Launch_Application();

		//Click On 	SetUp
		webdriver.clickOnButton(TaskPageObjects.btnSetUp);
		LogInFo("User Click on SetUpDropdown");
		TestPass("User Click on SetUpDropdown");
		webdriver.waitForElementLocated(TaskPageObjects.btnTasks);
		
		//Click On Tasks Button
		webdriver.clickOnButton(TaskPageObjects.btnTasks);
		webdriver.waitForElementLocated(TaskPageObjects.btnAddNewTask);
		TakeScreenshot("Create a Task For Application","Tasks","Task");
		//Click On AddNewTask
		webdriver.clickOnButton(TaskPageObjects.btnAddNewTask);
		webdriver.waitForElementLocated(TaskPageObjects.btnAccountAggregartion);
		TakeScreenshot("Create a Task","Tasks","AddNewTask");
		if(properties.getProperty("ApplicationAggregationType").equalsIgnoreCase("Account Aggregation")) 
		{
		//Click On Application Account Aggregation 
		webdriver.clickOnButton(TaskPageObjects.btnAccountAggregartion);
		TakeScreenshot("Create a Task For AccountAggregartion","Tasks","AccountAggregartion");
		}
		else {
			System.out.println("Pora Pakkaki");
		}

	}
}