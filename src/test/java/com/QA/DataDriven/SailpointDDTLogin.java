package com.QA.DataDriven;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.QA.Application.Pages.ApplicationsPage;
import com.QA.Application.Pages.LoginPage;
import com.QA.Application.TestBase.TestBase;
import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
public class SailpointDDTLogin extends TestBase{
	@Test
	public void Launch_Application_DDT() throws Exception {
		
		// Initialize Excel file
		FileInputStream file = new FileInputStream(new File("C:\\Users\\na21279\\eclipse-workspace\\SailPoint_Automation\\src\\test\\resources\\DataFiles\\loginData.xlsx"));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("LoginDetails");


		// Iterate through the rows and columns to read the data
		for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
			Row row = sheet.getRow(rowNum);
			String username = row.getCell(0).getStringCellValue();
			String password = row.getCell(1).getStringCellValue();
			
			CreateExtentTest("Verify LoginPage DDT Script", "Case 1: User needs to verify if Go Applicaton Through DDT is working or not.","Functional_TestCase","Narendra Reddy");
			
			//ENTER USERNAME OF APPLICATION.
			webdriver.enterText(LoginPage.txtUserName,username);
			TakeScreenshot("User Able to enter UserName","LoginPage","UserName");
			LogInFo("User Enter User Name");

			//ENTER PASSWORD OF APPLICATION.
			webdriver.enterText(LoginPage.txtPassword,password);
			webdriver.ScrollParticularElement(LoginPage.txtPassword);
			TakeScreenshot("User Able to enter Password","LoginPage","Password");
			LogInFo("User Enter The Password ");

			//SUBMIT BUTTON OF APPLICATION.
			webdriver.clickOnButton(LoginPage.btnLogIn);
			webdriver.waitForElementVisible(ApplicationsPage.btnApplications);
			webdriver.WaitForSometime(3000);
			TakeScreenshot("User Click On Login Successfully","LoginPage","Login");
			LogInFo("User Click On Login Page Successfully. ");
			//ASSERTING THE ACTUAL AND EXPECTED TITLE
			String expectedTitle = "SailPoint IdentityIQ - Home";
			String actualTitle = driver.getTitle();
			System.out.println(actualTitle);
			//driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
			if (expectedTitle.equals(actualTitle)) {
				TestPass("Verification Successful - The correct title is displayed on the web page.");
				LogInFo("Verification Successful - The User is Login The Application");
				Application.LogOut_Application();
			} else {
				TestFail("Verification Failed - An incorrect title is displayed on the web page.");
				LogWarn("Verification Failed - An incorrect title is displayed on the web page.");
			}

		}
		
	}
	
}
