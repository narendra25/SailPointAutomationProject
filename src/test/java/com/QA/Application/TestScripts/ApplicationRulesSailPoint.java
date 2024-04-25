package com.QA.Application.TestScripts;

import org.testng.annotations.Test;

import com.QA.Application.Pages.ApplicationsPage;
import com.QA.Application.Pages.RulesPage;
import com.QA.Application.TestBase.TestBase;

public class ApplicationRulesSailPoint extends TestBase {
	@Test(priority=4,description="Write Rule for SailPOint")
	public static void tc01VerifyLogin() throws Exception {
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
		
		webdriver.Dynamic_Create_Rule(properties.getProperty("RuleType"));
		TakeScreenshot("User Able to Click On Rules Create","Rules","RulesCreate");
		webdriver.waitForElementVisible(RulesPage.txtCorrelationRuleName);
		//Enter Rule Name 
		webdriver.enterText(RulesPage.txtCorrelationRuleName,properties.getProperty("RuleName"));
		webdriver.WaitForSometime(2000);
		TakeScreenshot("User Able to Enter RuleName","Rules","RulesCreate");
		
		//Writing The Rule In Text Editor
		webdriver.enterText(RulesPage.txtRuleEditor,properties.getProperty("WritingRuleEditor"));
		webdriver.waitForElementVisible(RulesPage.btncancelCrossButton);
		TakeScreenshot("User Write The Rule For Correlation Rule for Application", "Rules","CorrelationName");
		webdriver.WaitForSometime(3000);
		//Click On Cancel Cross Button
		webdriver.clickOnButton(RulesPage.btnSaveButton);
		webdriver.WaitForSometime(3000);
		TakeScreenshot("User click On Save Button", "Rules","SavingRule");
		
		//Logout Application
		Application.LogOut_Application();
	
	}
}