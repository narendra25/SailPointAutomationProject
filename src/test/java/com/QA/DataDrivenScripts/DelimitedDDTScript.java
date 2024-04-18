package com.QA.DataDrivenScripts;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.QA.Application.Pages.ApplicationsPage;
import com.QA.Application.TestBase.TestBase;

public class DelimitedDDTScript extends TestBase {
	
	String filePath=System.getProperty("user.dir");
	@Test
	public void delimitedFileTest() throws Exception
	{
		// Initialize Excel file
				FileInputStream file = new FileInputStream(filePath+"/src/test/resources/DataFiles/loginData.xlsx");
				Workbook workbook = new XSSFWorkbook(file);
				Sheet sheet = workbook.getSheet("DelimitedFile");


				// Iterate through the rows and columns to read the data
				for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
					Row row = sheet.getRow(rowNum);
					String ApplicationName = row.getCell(0).getStringCellValue();
					String ApplicationOwner= row.getCell(1).getStringCellValue();
					String ApplicationType= row.getCell(2).getStringCellValue();
					String DelimitedTxt= row.getCell(3).getStringCellValue();
					String DelimitedIdentityAttribute= row.getCell(4).getStringCellValue();
					String DelimitedDisplayAttribute= row.getCell(5).getStringCellValue();
			
				
				CreateExtentTest("Verify Delimited File Application OnBoarding Through DDT", "Case 1: User needs to verify if Delimited File Application On Boarding Script Through JDBC","Functional_TestCase","Vinay Kumar");
				
				
				Application.Launch_Application();
				
				
				//Click On Applications
				webdriver.clickOnButton(ApplicationsPage.btnApplications);
				TestPass("User Click On Applications");

				//click on application defination
				webdriver.clickOnButton(ApplicationsPage.btnApplicationDefination);
				webdriver.VerifyElementIsPresentorNot(ApplicationsPage.btnApplicationDefination,"ApplicationDDT","ApplicationDefination");
				LogInFo("User able to Click On ApplicationDefinition");

				//Click On Add New Application
				webdriver.waitForElementVisible(ApplicationsPage.btnAddNewApplication);
				webdriver.clickOnButton(ApplicationsPage.btnAddNewApplication);
				TakeScreenshot("AddNew Application","DelimitedFileDDT","AddNewApplication");
				
				//Enter Application Name
				webdriver.enterText(ApplicationsPage.txtApplicationName,ApplicationName);
				webdriver.getText(ApplicationsPage.txtApplicationName);
				webdriver.WaitForSometime(2000);
				TakeScreenshot("User Select The Application Type","DelimitedFileDDT" ,"ApplicationName");
				
				//Select Application Owner
				webdriver.clickOnButton(ApplicationsPage.selectOwner);
				webdriver.enterText(ApplicationsPage.txtOwnerName,ApplicationOwner);
				webdriver.WaitForSometime(3000);
				webdriver.clickOnButton(ApplicationsPage.selectOwnerName);
				TestPass("User Select The Application Owner");
				LogInFo("User Select The Application Owner");
				webdriver.WaitForSometime(3000);

				//Select Application Type 
				webdriver.selectValueOnDropDown(ApplicationsPage.selectApplicationType,ApplicationType);
				LOG.info("User Select The Application Type");
				webdriver.WaitForSometime(2000);
				TakeScreenshot("User Select The Application Type","DelimitedFileDDT" ,"ApplicationType");
				webdriver.WaitForSometime(2000);
				
				//Navigate To Configuration Tab
				webdriver.clickOnButton(ApplicationsPage.btnConfiguration);
				LogInFo("User Navigate The Configuration Tab");
				TestPass("User Navigate The Configuration Tab");
				webdriver.WaitForSometime(3000);
				
				//File Data
				webdriver.enterText(ApplicationsPage.txtFilePath, filePath+"/src/test/resources/DataFiles/Details.txt");
				webdriver.enterText(ApplicationsPage.txtDelimiter, DelimitedTxt);
				webdriver.clickOnButton(ApplicationsPage.chkFilehascolumnheaderonfirstline);
				webdriver.clickOnButton(ApplicationsPage.btnDelimiterTestConnection);
				
				//Schema
				webdriver.clickOnButton(ApplicationsPage.btnSchema);
				LogInFo("User Navigate The Schema Tab");
				TakeScreenshot("User Navigate The Schema Tab","DelimitedFileDDT" ,"SchemaPage");
				webdriver.enterText(ApplicationsPage.txtDelimiterIdentityAttribute, DelimitedIdentityAttribute);
				webdriver.enterText(ApplicationsPage.txtDelimiterDisplayAttribute, DelimitedDisplayAttribute);
				
				
				//Click On DiscoverSchemaAttribute Button
				webdriver.clickOnButton(ApplicationsPage.btnDiscoverSchemaAttribute);
				LogInFo("User Click on Discover Schema Attribute");
				TakeScreenshot("User Click on Discover Schema Attribute", "DelimitedFileDDT","JDBCDiscoverAttribute");
				webdriver.WaitForSometime(3000);
				//Click On Preview Button
				webdriver.clickOnButton(ApplicationsPage.btnPreview);
				LogInFo("User Click on Preview");
				webdriver.WaitForSometime(3000);
				TakeScreenshot("User Click on Preview", "DelimitedFileDDT","JDBCDPreview");
				webdriver.WaitForSometime(2000);
				webdriver.clickOnButton(ApplicationsPage.btnPreviewClose);
				LogInFo("User Click on Preview close Button");
				webdriver.WaitForSometime(2000);
				webdriver.clickOnButton(ApplicationsPage.btnApplicationSave);
				webdriver.WaitForSometime(2000);
				
				//LogOut The AppliCation 
				//Application.LogOut_Application();

	}
	}
}
