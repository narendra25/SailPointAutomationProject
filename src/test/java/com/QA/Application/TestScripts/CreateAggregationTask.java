package com.QA.Application.TestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.QA.Application.Pages.TaskPageObjects;
import com.QA.Application.TestBase.TestBase;

public class CreateAggregationTask extends TestBase{
	@Test(priority=3)
	public static void tc03verifyCreateAggregationTask() throws InterruptedException, IOException, AWTException {
		CreateExtentTest("Verify Create Aggregation Task Of Application", "Case 1: User needs to verify Create Aggregation Task Of Application .","Functional_TestCase","Narendra Reddy");
		
		//Launching Application
		Application.Launch_Application();

		//Click On 	SetUp
		webdriver.clickOnButton(TaskPageObjects.btnSetUp);
		LogInFo("User Click on SetUpDropdown");
		TestPass("User Click on SetUpDropdown");
		webdriver.waitForElementLocated(TaskPageObjects.btnTasks);
		
		//Click On Tasks Button
		webdriver.clickOnButton(TaskPageObjects.btnTasks);
		webdriver.waitForElementLocated(TaskPageObjects.btnAddNewTask);
		TakeScreenshot("Create a Task For Application","Tasks","Task");
		webdriver.WaitForSometime(3000);
		//Click On AddNewTask
		webdriver.clickOnButton(TaskPageObjects.btnAddNewTask);
		webdriver.waitForElementLocated(TaskPageObjects.btnAccountAggregartion);
		TakeScreenshot("Create a Task","Tasks","AddNewTask");
		if(properties.getProperty("ApplicationAggregationType").equalsIgnoreCase("Account Aggregation")) 
			
		{
			webdriver.WaitForSometime(3000);
		//Click On Application Account Aggregation 
		webdriver.clickOnButton(TaskPageObjects.btnAccountAggregartion);
		TakeScreenshot("Create a Task For AccountAggregartion","Tasks","AccountAggregartion");
		webdriver.waitForElementVisible(TaskPageObjects.txtTaskName);
		
		//Enter Task Name
		webdriver.enterText(TaskPageObjects.txtTaskName,properties.getProperty("ApplicationName")+"aggregation");
		TakeScreenshot("Enter Task Name","Tasks","TaskName");
		webdriver.WaitForSometime(2000);
		LogInFo("User enter Task Name");
		
		//Scroll down to Task Select
		webdriver.ScrollParticularElement(TaskPageObjects.btnTaskDropdown);
		webdriver.clickOnButton(TaskPageObjects.btnTaskDropdown);
		TakeScreenshot("Click on Task DropDown","Tasks","TasksDropDown");
		webdriver.WaitForSometime(4000);
		//Select The Task
		webdriver.DynamicXpathContains(properties.getProperty("ApplicationName"));
		webdriver.WaitForSometime(2000);
		TakeScreenshot("User Select The Task","Tasks","SelectTask");
		//Scroll down To SAve And Execute
		webdriver.ScrollParticularElement(TaskPageObjects.saveAndExecute);
		webdriver.clickOnButton(TaskPageObjects.saveAndExecute);
		webdriver.DynamicXpathContains(properties.getProperty("DelimiterApplicationName"));
		TakeScreenshot("User click on save and execute Button","Tasks","saveAndExecute");
		webdriver.WaitForSometime(3000);
		//webdriver.waitForElementVisible(TaskPageObjects.OKButton);
		
		//Click On 
		
		webdriver.ClickByJavaScript_Executor(TaskPageObjects.OKButton);
		TakeScreenshot("User click on Ok Button","Tasks","OkButton");
		
		webdriver.WaitForSometime(2000);
		//Navigating Back
		//driver.navigate().back();
		webdriver.WaitForSometime(2000);
		}
		else {
			System.out.println("Getting Aggregation Error");
		}

	}
}