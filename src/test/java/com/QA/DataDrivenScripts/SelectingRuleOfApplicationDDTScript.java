package com.QA.DataDrivenScripts;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.QA.Application.Pages.ApplicationsPage;
import com.QA.Application.Pages.RulesPage;
import com.QA.Application.TestBase.TestBase;

public class SelectingRuleOfApplicationDDTScript extends TestBase{
	@Test(priority=5)
	public static void VerifySelectingRuleOfApplicationDDTScript()throws Exception {

		CreateExtentTest("Verify Selecting Rule Of Application Script Sailpoint Through DDT", "Case 1: User needs to verify if Selecting Rule Of Application DDT Script","Functional_TestCase","Narendra Reddy");
		String filePath=System.getProperty("user.dir");
		// Initialize Excel file
		FileInputStream file=new FileInputStream(filePath+properties.getProperty("DataFile"));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("SailPointApplicationJDBC");


		// Iterate through the rows and columns to read the data
		for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
			Row row = sheet.getRow(rowNum);
			String ApplicationName = row.getCell(2).getStringCellValue();
			String RuleType= row.getCell(13).getStringCellValue();
			String RuleName= row.getCell(14).getStringCellValue();
			
			//Application Login
			Application.Launch_Application();

			//Click On Applications
			webdriver.clickOnButton(ApplicationsPage.btnApplications);
			TestPass("User Click On Applications");

			//click on application defination
			webdriver.clickOnButton(ApplicationsPage.btnApplicationDefination);
			webdriver.VerifyElementIsPresentorNot(ApplicationsPage.btnApplicationDefination,"Application","ApplicationDefination");
			LogInFo("User able to Click On ApplicationDefinition");
			//Click On application Based On Application Name 
			webdriver.DynamicXpathContains(ApplicationName);
			TakeScreenshot("User Able to Click On Application","SelectRuleDDT","Application");
			webdriver.waitForElementLocated(RulesPage.btnRulesTab);
			
			
			//Click On Rules Button
			webdriver.clickOnButton(RulesPage.btnRulesTab);
			webdriver.waitForElementLocated(RulesPage.btnCorrelationRule);
			TakeScreenshot("User Able to Click On Rules Tab","SelectRuleDDT","RulesButton");
			webdriver.Dynamic_Selecting_Rule_Application(RuleType,RuleName);
			TakeScreenshot("User Able to Click On Rules Create","SelectRuleDDT","SelectingRule");
			
			//scrolling to particular element
			webdriver.ScrollParticularElement(RulesPage.btnSavebuttonRule);
			webdriver.clickOnButton(RulesPage.btnSavebuttonRule);
			TakeScreenshot("User Able to Click On Rules Save Button","SelectRuleDDT","Save");
			
			//LogOutApplication
			Application.LogOut_Application();
		}

	}
}
