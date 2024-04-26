package com.QA.DataDrivenScripts;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import com.QA.Application.Pages.IdentityMappingPage;
import com.QA.Application.TestBase.TestBase;

public class IdentityMappingsDDTScript extends TestBase{
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
			String ApplicationName = row.getCell(2).getStringCellValue();
			String IdentityMappingName= row.getCell(16).getStringCellValue();
			String AttributeName= row.getCell(17).getStringCellValue();

			CreateExtentTest("Verify Identity Mappings  Through DDT", "Case 1: User needs to verify if Identity Mappings Script Through DDT Test","Functional_TestCase","VinayKumar");

			Application.Launch_Application();

			//Click On setting Button icon
			webdriver.clickOnButton(IdentityMappingPage.globalDropdown);
			LogInFo("User click on Setting Icon");
			TakeScreenshot("User click on Setting Icon","IdentityMappingsDDT","SettingsIcon");

			//click on Global setting
			webdriver.clickOnButton(IdentityMappingPage.globalSetting);
			LogInFo("User Click On Global settings ");

			//user Click On Identity Mappings Button
			webdriver.clickOnButton(IdentityMappingPage.identityMappings);
			LogInFo("User Click on Identity Mapping");
			TakeScreenshot("User Click on Identity Mapping", "IdentityMappingsDDT", "IdentityMapping");

			//Based On Identity Mapping Name 
			webdriver.DynamicXpathContains(IdentityMappingName);
			LogInFo("User Click on Identity Attribute");
			TakeScreenshot("User selected Identity Attribute", "IdentityMappingsDDT", "IdentityAttribute");
			webdriver.waitForElementLocated(IdentityMappingPage.getAttributeName);
			webdriver.WaitForSometime(2000);

			//Click On add source Button
			webdriver.clickOnButton(IdentityMappingPage.addSource);
			LogInFo("User click on Add Source");
			TakeScreenshot("User Click on Add Source", "IdentityMappingsDDT", "AddSource");
			webdriver.enterText(IdentityMappingPage.appValue,ApplicationName);
			webdriver.WaitForSometime(3000);
			webdriver.DynamicXpathContains(ApplicationName);
			webdriver.WaitForSometime(3000);

			//Selecting The Attribute Value
			webdriver.selectTextOnDropDown(IdentityMappingPage.attributeValue,AttributeName);
			webdriver.WaitForSometime(3000);
			LogInFo("User entered Source Data");
			TakeScreenshot("User entered Source Data", "IdentityMappingsDDT", "SourceData");

			//Click On Add Button
			webdriver.clickOnButton(IdentityMappingPage.addButton);
			webdriver.ScrollParticularElement(IdentityMappingPage.saveButton);
			webdriver.WaitForSometime(2000);

			//click On Save Button
			webdriver.clickOnButton(IdentityMappingPage.saveButton);
			LogInFo("User Edited Identity Attribute Successfully");
			TakeScreenshot("User Edited Identity Attribute Successfully", "IdentityMappingsDDT", "EditedAttribute");
			
			Application.LogOut_Application();;

		}

	}
}

