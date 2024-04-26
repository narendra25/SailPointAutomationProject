package com.QA.DataDrivenScripts;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.QA.Application.Pages.DebugPage;
import com.QA.Application.TestBase.TestBase;

public class DeBugDDTScipts extends TestBase {
	static String filePath=System.getProperty("user.dir");

	@Test
	public static void verifyCreateIdentityMappingsDDTScript() throws Exception {

		// Initialize Excel file
		FileInputStream file=new FileInputStream(filePath+properties.getProperty("DataFile"));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("SailPointApplicationJDBC");


		// Iterate through the rows and columns to read the data
		for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
			Row row = sheet.getRow(rowNum);
			String SelectAnObject = row.getCell(20).getStringCellValue();
			String SearchByNameOrID= row.getCell(2).getStringCellValue(); //14
			String Action= row.getCell(21).getStringCellValue();
			


			CreateExtentTest("Verify DeBugScripts(Application,Task,Rule) Through DDT", "Case 1: User needs to verify if Debug Script Through DDT Test","Functional_TestCase","Narendra Reddy");


			Application.Launch_Application();
			
			
			driver.get(properties.getProperty("DeBugPageUrl"));
			LogInFo("User enter into Debug Page");
			TakeScreenshot("User enter into Debug Page", "DeBugDDT", "DebugHomePage");
			webdriver.clickOnButton(DebugPage.btnobject);
			LogInFo("User click on object dropdown");
			TakeScreenshot("User click on object dropdown", "DeBugDDT", "selectDropdown");
			webdriver.enterText(DebugPage.txtenterAppName, SelectAnObject);
			webdriver.WaitForSometime(5000);
			webdriver.DynamicXpathText(SelectAnObject);
			LogInFo("User selected Object");
			TakeScreenshot("User selected Object", "DeBugDDT",SelectAnObject);
			
			webdriver.waitForElementLocated(DebugPage.txtfilterName);
			webdriver.ClickByJavaScript_Executor(DebugPage.txtfilterName);
			webdriver.enterText(DebugPage.txtfilterName, SearchByNameOrID);
			webdriver.clickOnButton(DebugPage.btnsearch);
			LogInFo("User entered Name or ID");
			TakeScreenshot("User entered Name or ID", "DeBugDDT",SearchByNameOrID);
			webdriver.clickOnButton(DebugPage.btncheckboxResult);
			webdriver.clickOnButton(DebugPage.btnAction);
			LogInFo("User click on Action Button");
			TakeScreenshot("User click on Action Button", "DeBugDDT", "ActionBtn");
			if(Action.equalsIgnoreCase("Delete"))
			{
			webdriver.clickOnButton(DebugPage.btnDelete);
			webdriver.WaitForSometime(2000);
			TakeScreenshot("Validate User Deleted Application Successfully", "DeBugDDT", "AppDeleteButton");
			webdriver.clickOnButton(DebugPage.btnYes);
			LogInFo("Validate User Deleted Application Successfully");
			TakeScreenshot("Validate User Deleted Application Successfully", "DeBugDDT", "AppDelete");
			
			}
			else if(Action.equalsIgnoreCase("New"))
			{
			webdriver.clickOnButton(DebugPage.btnNew);
			webdriver.WaitForSometime(1000);
			webdriver.clickOnButton(DebugPage.txtObjEditer);
			webdriver.WaitForSometime(1000);
			webdriver.enterText(DebugPage.txtObjEditer, "Test Data Passed");
			webdriver.clickOnButton(DebugPage.btnSave);
			LogInFo("Validate User New Application Data added Successfully");
			TakeScreenshot("Validate User New Application Data added Successfully", "DeBugDDT", "NewData");
			
			}
			webdriver.WaitForSometime(3000);
			Application.LogOut_Application();
		}
		

}
	
}