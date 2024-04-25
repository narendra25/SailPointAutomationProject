package com.QA.DataDrivenScripts;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.QA.Application.Pages.ApplicationsPage;
import com.QA.Application.TestBase.TestBase;

public class JDBCDDTScript extends TestBase {
	String filePath=System.getProperty("user.dir");
	@Test(priority=2)
	public void JDBC_APPLICATION_ONBOARDING_DDT() throws Exception {
		
		// Initialize Excel file
		FileInputStream file=new FileInputStream(filePath+properties.getProperty("DataFile"));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("SailPointApplicationJDBC");

		
		// Iterate through the rows and columns to read the data
		for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
			Row row = sheet.getRow(rowNum);
			String ApplicationName = row.getCell(2).getStringCellValue();
			String ApplicationOwner= row.getCell(3).getStringCellValue();
			String ApplicationType= row.getCell(4).getStringCellValue();
			String JDBCConnectionUser= row.getCell(5).getStringCellValue();
			String JDBCConnectionPassword= row.getCell(6).getStringCellValue();
			String JDBCDatabaseURL= row.getCell(7).getStringCellValue();
			String JDBCSqlStatement= row.getCell(8).getStringCellValue();
			String JDBCIdentityAttribute= row.getCell(9).getStringCellValue();
			String JDBCDisplayAttribute= row.getCell(10).getStringCellValue();
			
			
			CreateExtentTest("Verify JDBC Application OnBoarding Through DDT", "Case 1: User needs to verify if JDBC Application On Boarding Script Through JDBC","Functional_TestCase","Narendra Reddy");
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
			TakeScreenshot("AddNew Application","ApplicationDDT","AddNewApplication");
			
			//Enter Application Name
			webdriver.enterText(ApplicationsPage.txtApplicationName,ApplicationName);
			webdriver.getText(ApplicationsPage.txtApplicationName);
			webdriver.waitForElementVisible(ApplicationsPage.btnDelimiterSave);
			webdriver.WaitForSometime(2000);
			TakeScreenshot("User Select The Application Type","JDBCAPPLICATIONDDT" ,"ApplicationName");
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
			TakeScreenshot("User Select The Application Type","JDBCAPPLICATIONDDT" ,"ApplicationType");
			webdriver.WaitForSometime(2000);
			
			//Navigate To Configuration Tab
			webdriver.clickOnButton(ApplicationsPage.btnConfiguration);
			LogInFo("User Navigate The Configuration Tab");
			TestPass("User Navigate The Configuration Tab");
			webdriver.WaitForSometime(3000);

			//Enter Connection User 
			webdriver.clearText(ApplicationsPage.txtConnectionUser);
			webdriver.WaitForSometime(3000);
			webdriver.enterText(ApplicationsPage.txtConnectionUser,JDBCConnectionUser);
			LogInFo("User Enter The Connection User Name");
			TakeScreenshot("User Enter The Connection User Name", "JDBCAPPLICATIONDDT","ConnectionUser");
			//Enter Connection Password
			webdriver.clearText(ApplicationsPage.txtConnectionPassword);
			webdriver.WaitForSometime(3000);
			webdriver.enterText(ApplicationsPage.txtConnectionPassword,JDBCConnectionPassword);
			LogInFo("User Enter The Connection Password");
			TakeScreenshot("User Enter The Connection Password", "JDBCAPPLICATIONDDT","ConnectionPassword");

			//Enter Database URL
			webdriver.clearText(ApplicationsPage.txtDataBaseURL);
			webdriver.WaitForSometime(2000);
			webdriver.enterText(ApplicationsPage.txtDataBaseURL,JDBCDatabaseURL);
			LogInFo("User Enter The Connection Database URL");
			TakeScreenshot("User Enter The Connection DatabaseURL", "JDBCAPPLICATIONDDT","ConnectionDataBaseURL");
			//Scroll down to SQL Statement
			webdriver.ScrollParticularElement(ApplicationsPage.txtSQLStatment);

			//Enter The SQL Statement
			webdriver.clearText(ApplicationsPage.txtSQLStatment);
			webdriver.WaitForSometime(2000);
			webdriver.enterText(ApplicationsPage.txtSQLStatment,JDBCSqlStatement);
			LogInFo("User Enter The Connection SQL Statement");
			TakeScreenshot("User Enter The Connection SQL Statement", "JDBCAPPLICATIONDDT","ConnectionSQLStatement");

			//Click On TestConnection
			webdriver.clickOnButton(ApplicationsPage.btnTestConnection);
			LOG.info("User Checking The Test Connection");
			test.pass("User Checking The Test Connection");
			webdriver.WaitForSometime(5000);
			//Navigate Schema Tab
			webdriver.clickOnButton(ApplicationsPage.tabSchema);
			LOG.info("User Navigate To Schema Tab");
			test.pass("User Navigate To Schema Tab");
			webdriver.WaitForSometime(3000);

			//Enter Identity Attribute
			webdriver.enterText(ApplicationsPage.txtJDBCIdentityAttribute,JDBCIdentityAttribute);
			LogInFo("User Enter JDBC Dispaly Attribute");
			TakeScreenshot("User Enter JDBC Dispaly Attribute", "JDBCAPPLICATIONDDT","JDBCIdentityAttribute");
			webdriver.WaitForSometime(3000);
			//Enter Dispaly Attribute
			webdriver.enterText(ApplicationsPage.txtDispalyAttribute,JDBCDisplayAttribute);
			LOG.info("User Enter JDBC Dispaly Attribute");
			test.pass("User Enter JDBC Display Attribute");
			webdriver.WaitForSometime(2000);


			//Click On DiscoverSchemaAttribute Button
			webdriver.clickOnButton(ApplicationsPage.btnDiscoverSchemaAttribute);
			LogInFo("User Click on Discover Schema Attribute");
			TakeScreenshot("User Click on Discover Schema Attribute", "JDBCAPPLICATIONDDT","JDBCDiscoverAttribute");
			webdriver.WaitForSometime(3000);
			//Click On Preview Button
			webdriver.clickOnButton(ApplicationsPage.btnPreview);
			LogInFo("User Click on Preview");
			webdriver.WaitForSometime(3000);
			TakeScreenshot("User Click on Preview", "JDBCAPPLICATIONDDT","JDBCDPreview");
			webdriver.WaitForSometime(2000);
			webdriver.clickOnButton(ApplicationsPage.btnPreviewClose);
			LogInFo("User Click on Preview close Button");
			webdriver.WaitForSometime(2000);
			webdriver.clickOnButton(ApplicationsPage.btnApplicationSave);
			webdriver.WaitForSometime(5000);
			
			//LogOut The AppliCation 
			Application.LogOut_Application();

		}
		
		
	}
}
