package com.QA.DataDrivenScripts;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.QA.Application.Pages.TaskPageObjects;
import com.QA.Application.TestBase.TestBase;

public class CreateAggregationTaskDDT extends TestBase {
	static String filePath=System.getProperty("user.dir");

	@Test(priority=3)
	public static void verifyCreateIdentityMappingsDDTScript() throws Exception {

		// Initialize Excel file
		FileInputStream file=new FileInputStream(filePath+properties.getProperty("DataFile"));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("SailPointApplicationJDBC");


		// Iterate through the rows and columns to read the data
		for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
			Row row = sheet.getRow(rowNum);
			String ApplicationName= row.getCell(2).getStringCellValue();
			String AggregationTaskName= row.getCell(11).getStringCellValue();
			String ApplicationAggregationType = row.getCell(12).getStringCellValue();



			CreateExtentTest("Verify Create Aggregation Script Through DDT", "Case 1: User needs to verify if Create Aggregation Script Through DDT Test","Functional_TestCase","Narendra Reddy");


			Application.Launch_Application();
			//Click On 	SetUp
			webdriver.clickOnButton(TaskPageObjects.btnSetUp);
			LogInFo("User Click on SetUpDropdown");
			TestPass("User Click on SetUpDropdown");
			webdriver.waitForElementLocated(TaskPageObjects.btnTasks);

			//Click On Tasks Button
			webdriver.clickOnButton(TaskPageObjects.btnTasks);
			webdriver.waitForElementLocated(TaskPageObjects.btnAddNewTask);
			TakeScreenshot("Create a Task For Application","TasksDDT","Task");
			webdriver.WaitForSometime(2000);
			//Click On AddNewTask
			webdriver.clickOnButton(TaskPageObjects.btnAddNewTask);
			webdriver.waitForElementLocated(TaskPageObjects.btnAccountAggregartion);
			webdriver.WaitForSometime(2000);
			TakeScreenshot("Create a Task","TasksDDT","AddNewTask");
			if(ApplicationAggregationType.equalsIgnoreCase("AccountAggregartion"))
			{
				webdriver.WaitForSometime(2000);
				//Click On Application Account Aggregation 
				webdriver.clickOnButton(TaskPageObjects.btnAccountAggregartion);
				TakeScreenshot("Create a Task For AccountAggregartion","TasksDDT","AccountAggregartion");
				webdriver.waitForElementVisible(TaskPageObjects.txtTaskName);

				//Enter Task Name
				webdriver.enterText(TaskPageObjects.txtTaskName,AggregationTaskName);
				TakeScreenshot("Enter Task Name","TasksDDT","TaskName");
				webdriver.WaitForSometime(2000);
				LogInFo("User enter Task Name");

				//Scroll down to Task Select
				webdriver.ScrollParticularElement(TaskPageObjects.btnTaskDropdown);
				webdriver.clickOnButton(TaskPageObjects.btnTaskDropdown);
				TakeScreenshot("Click on Task DropDown","TasksDDT","TasksDropDown");
				webdriver.WaitForSometime(4000);
				//Select The Task
				webdriver.DynamicXpathContains(ApplicationName);
				webdriver.WaitForSometime(2000);
				TakeScreenshot("User Select The Task","TasksDDT","SelectTask");
				//Scroll down To SAve And Execute
				webdriver.ScrollParticularElement(TaskPageObjects.saveAndExecute);
				webdriver.clickOnButton(TaskPageObjects.saveAndExecute);
				webdriver.WaitForSometime(2000);
				TakeScreenshot("User click on save and execute Button","TasksDDT","saveAndExecute");
				webdriver.WaitForSometime(3000);
				//webdriver.waitForElementVisible(TaskPageObjects.OKButton);

				//Click On 

				webdriver.ClickByJavaScript_Executor(TaskPageObjects.OKButton);
				TakeScreenshot("User click on Ok Button","TasksDDT","OkButton");

				webdriver.WaitForSometime(2000);
			
				
			}
			else {
				System.out.println("Please Check Properly ..Getting Error");
			}
			webdriver.WaitForSometime(2000);
			Application.LogOut_Application();
		}
		
	}
}

