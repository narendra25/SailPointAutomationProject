package com.QA.DataDrivenScripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import org.testng.annotations.Test;
import com.QA.Application.Pages.ApplicationsPage;
import com.QA.Application.Pages.LoginPage;
import com.QA.Application.TestBase.TestBase;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
public class SailpointDDTLogin extends TestBase{
	static String filePath=System.getProperty("user.dir");
	@Test(priority=1)
	public static void Launch_Application_DDT() throws Exception {
		
		// Initialize Excel file
		FileInputStream file=new FileInputStream(filePath+properties.getProperty("DataFile"));
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheet("SailPointApplicationJDBC");


		// Iterate through the rows and columns to read the data
		for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
			Row row = sheet.getRow(rowNum);
			String username = row.getCell(0).getStringCellValue();
			String password = row.getCell(1).getStringCellValue();
			
			CreateExtentTest("Verify LoginPage DDT Script", "Case 1: User needs to verify if Go Applicaton Through DDT is working or not.","Functional_TestCase","Narendra Reddy");
			
			//ENTER USERNAME OF APPLICATION.
			webdriver.enterText(LoginPage.txtUserName,username);
			TakeScreenshot("User Able to enter UserName","LoginPageDDT","UserName");
			LogInFo("User Enter User Name");

			//ENTER PASSWORD OF APPLICATION.
			webdriver.enterText(LoginPage.txtPassword,password);
			webdriver.ScrollParticularElement(LoginPage.txtPassword);
			TakeScreenshot("User Able to enter Password","LoginPageDDT","Password");
			LogInFo("User Enter The Password ");

			//SUBMIT BUTTON OF APPLICATION.
			webdriver.clickOnButton(LoginPage.btnLogIn);
			webdriver.VerifyElementIsPresentorNot(ApplicationsPage.btnApplications,"LoginPageDDT","Login");
			TakeScreenshot("User Click On Login Successfully","LoginPageDDT","Login");
			webdriver.waitForElementVisible(ApplicationsPage.btnApplications);
			webdriver.WaitForSometime(3000);
			LogInFo("User Click On Login Page Successfully. ");
			//ASSERTING THE ACTUAL AND EXPECTED TITLE
			String expectedTitle = "SailPoint IdentityIQ - Home";
			String actualTitle = driver.getTitle();
			System.out.println(actualTitle);
			//driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
			if (expectedTitle.equals(actualTitle)) {
				TestPass("Verification Successful - The correct title is displayed on the web page.");
				LogInFo("Verification Successful - The User is Login The Application");
				//Application.LogOut_Application();
			} else {
				TestFail("Verification Failed - An incorrect title is displayed on the web page.");
				LogWarn("Verification Failed - An incorrect title is displayed on the web page.");
			}
			Application.LogOut_Application();
		}
	}
	
}
