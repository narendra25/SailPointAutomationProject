package com.QA.DataDrivenScripts;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.QA.Application.Pages.TaskActionsPage;
import com.QA.Application.Pages.TaskPageObjects;
import com.QA.Application.TestBase.TestBase;

public class TaskActionScript extends TestBase {
	static String filePath=System.getProperty("user.dir");

	@Test
	public static void verifyUserPerformTaskActions() throws Exception {

		// Initialize Excel file
		FileInputStream file=new FileInputStream(filePath+properties.getProperty("DataFile"));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("SailPointApplicationJDBC");


		// Iterate through the rows and columns to read the data
		for (int rowNum = 2; rowNum <=sheet.getLastRowNum(); rowNum++) {
			Row row = sheet.getRow(rowNum);
			String AggregationTaskName= row.getCell(11).getStringCellValue();
			String TaskAction= row.getCell(20).getStringCellValue();
			CreateExtentTest("Verify Delete The Task", "Case 1: User needs to verify if Task Is Deleted Or Not","Functional_TestCase","Narendra Reddy");


			Application.Launch_Application();
			//Click On 	SetUp
			webdriver.clickOnButton(TaskPageObjects.btnSetUp);
			LogInFo("User Click on SetUpDropdown");
			TestPass("User Click on SetUpDropdown");
			webdriver.waitForElementLocated(TaskPageObjects.btnTasks);

			//Click On Tasks Button
			webdriver.clickOnButton(TaskPageObjects.btnTasks);
			webdriver.waitForElementLocated(TaskPageObjects.btnAddNewTask);
			TakeScreenshot("Verify User Task Actions","TaskAction","Task");
			webdriver.WaitForSometime(2000);
			Actions action = new Actions(driver);
			WebElement link = driver.findElement(By.xpath("//*[contains(text(),'"+AggregationTaskName+"')]"));
			action.contextClick(link).perform();
			webdriver.WaitForSometime(2000);
			TakeScreenshot("User Click ON Task Actions","TaskAction",AggregationTaskName);
			webdriver.waitForElementVisible(TaskActionsPage.btnDeleteTask);
			if(TaskAction.equalsIgnoreCase("Delete")) {
				webdriver.WaitForSometime(1000);
				webdriver.clickOnButton(TaskActionsPage.btnDeleteTask);
				TakeScreenshot("User Click On Delete Button","TaskAction",TaskAction);
				webdriver.waitForElementLocated(TaskActionsPage.btnDeleteTaskYes);
				webdriver.clickOnButton(TaskActionsPage.btnDeleteTaskYes);
				
				
			}
			
			if(TaskAction.equalsIgnoreCase("Edit")) {
				webdriver.WaitForSometime(1000);
				webdriver.clickOnButton(TaskActionsPage.btnEditTask);
				TakeScreenshot("User Click On Delete Button","TaskAction",TaskAction);
				webdriver.waitForElementLocated(TaskActionsPage.btnsaveAndExecute);
				webdriver.ScrollParticularElement(TaskActionsPage.btnsaveAndExecute);
				TakeScreenshot("User Scroll to Save and Execute Button","TaskAction","Save and Execute");
				webdriver.clickOnButton(TaskActionsPage.btnsaveAndExecute);
				TakeScreenshot("User Click On Save and Execute Button","TaskAction","OkButton");
				webdriver.clickOnButton(TaskActionsPage.OKButton);
				TakeScreenshot("User After Save Button","TaskAction","AfterSave");
			}
			if(TaskAction.equalsIgnoreCase("Execute In Background")) {
				webdriver.WaitForSometime(1000);
				//webdriver.clickOnButton(TaskActionsPage.btnExecuteInBackground);
				webdriver.ClickByJavaScript_Executor(TaskActionsPage.btnExecuteInBackground);
				TakeScreenshot("User Click On Delete Button","TaskAction",TaskAction);
				webdriver.waitForElementVisible(TaskActionsPage.btnExecuteOk);
				
				webdriver.clickOnButton(TaskActionsPage.btnExecuteOk);
				
				webdriver.WaitForSometime(67000);
				
			}

			Application.LogOut_Application();
		}
		
	}
	}