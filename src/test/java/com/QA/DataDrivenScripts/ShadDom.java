package com.QA.DataDrivenScripts;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.QA.Application.Pages.ApplicationsPage;
import com.QA.Application.Pages.LoginPage;
import com.QA.Application.TestBase.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ShadDom extends TestBase{
	//static WebDriver driver;
	public static void main(String args[]) throws InterruptedException, IOException {
		Launch_Application() ;
	}
	
		public static void Launch_Application() throws IOException, InterruptedException {
			
			//ENTER USERNAME OF APPLICATION.
			webdriver.enterText(LoginPage.txtUserName,properties.getProperty("ApplicationUserName"));
			webdriver.AssertElementIsPresentOrNot(LoginPage.txtUserName,"LoginPage","spadmin");
			LogInFo("User Enter User Name");
			
			//ENTER PASSWORD OF APPLICATION.
			webdriver.enterText(LoginPage.txtPassword,properties.getProperty("ApplicationPassword"));
			webdriver.ScrollParticularElement(LoginPage.txtPassword);
			webdriver.AssertElementIsPresentOrNot(LoginPage.txtPassword,"LoginPage","admin");
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
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			if (expectedTitle.equals(actualTitle)) {
				TestPass("Verification Successful - The correct title is displayed on the web page.");
				LogInFo("Verification Successful - The User is Login The Application");

			} else {
				TestFail("Verification Failed - An incorrect title is displayed on the web page.");
				LogWarn("Verification Failed - An incorrect title is displayed on the web page.");
			}
			
		
		}	

}
