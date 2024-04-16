package com.QA.Application.TestScripts;

import java.io.IOException;


import org.testng.annotations.Test;

import com.QA.Application.Pages.ApplicationsPage;
import com.QA.Application.Pages.RulesPage;
import com.QA.Application.TestBase.TestBase;

public class ApplicationRulesSailPoint extends TestBase {
	@Test(priority=4,description="Write Rule for SailPOint")
	public static void tc01VerifyLogin() throws InterruptedException, IOException {
		CreateExtentTest("Write Rule for SailPOint", "Case 1: User needs to verify if Rules Are working as expected.","Functional_TestCase","Narendra Reddy");
		Application.Launch_Application();
		//Click On Applications
		webdriver.clickOnButton(ApplicationsPage.btnApplications);
		TestPass("User Click On Applications");

		//click on application defination
		webdriver.clickOnButton(ApplicationsPage.btnApplicationDefination);
		webdriver.VerifyElementIsPresentorNot(ApplicationsPage.btnApplicationDefination,"Application","ApplicationDefination");
		LogInFo("User able to Click On ApplicationDefinition");
		//Click On application Based On Application Name 
		webdriver.DynamicXpathContains(properties.getProperty("ApplicationName"));
		webdriver.waitForElementLocated(RulesPage.btnRulesTab);
		
		//Click On Rules Button
		webdriver.clickOnButton(RulesPage.btnRulesTab);
		webdriver.waitForElementLocated(RulesPage.btnCorrelationRule);
		TakeScreenshot("User Able to Click On Rules Tab","Rules","RulesButton");
		
		try {

			if(properties.getProperty("CorrelationRule").equalsIgnoreCase("CorrelationRule")) 
			{
			
			//clck on Correlation rules Button
			webdriver.clickOnButton(RulesPage.btnCorrelationRule);
			webdriver.WaitForSometime(3000);
			//Enter Rule Name 
			webdriver.enterText(RulesPage.txtCorrelationRuleName,properties.getProperty("CorrelationRuleName"));
			webdriver.WaitForSometime(3000);
			webdriver.enterText(RulesPage.txtRuleEditor,properties.getProperty("CorrelationRuleEditor"));
			webdriver.waitForElementVisible(RulesPage.btncancelCrossButton);
			TakeScreenshot("User Write The Rule For Correlation Rule for Application", "Rules","CorrelationName");
			webdriver.WaitForSometime(3000);
			//Click On Cancel Cross Button
			webdriver.clickOnButton(RulesPage.btnSaveButton);
			webdriver.WaitForSometime(3000);
			}
			if(properties.getProperty("CreationRule").equalsIgnoreCase("CreationRule")) 
			{
				//clck on Correlation rules Button
				webdriver.clickOnButton(RulesPage.btnCreationRule);
				TakeScreenshot("User Write The Rule For Creation Rule for Application", "Rules","CreationName");
				webdriver.WaitForSometime(3000);
				
				//Enter Rule Name 
				webdriver.enterText(RulesPage.txtCreationRuleName,properties.getProperty("CreationRuleName"));
				webdriver.WaitForSometime(3000);
				webdriver.enterText(RulesPage.txtRuleEditor,properties.getProperty("CorrelationRuleEditor"));
				webdriver.waitForElementVisible(RulesPage.btncancelCrossButton);
				TakeScreenshot("User Write The Rule For Correlation Rule for Application", "Rules","CorrelationName");
				webdriver.WaitForSometime(3000);
				//Click On Cancel Cross Button
				webdriver.clickOnButton(RulesPage.btnSaveButton);
				webdriver.WaitForSometime(3000);
			}
		} catch (Exception e) {
			System.out.println("Getting An error");
			
		}
		
		
	
	}
}