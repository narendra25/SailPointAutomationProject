package com.QA.Application.TestScripts;

import org.testng.annotations.Test;

import com.QA.Application.Pages.IdentityMappingPage;
import com.QA.Application.TestBase.TestBase;

public class IdentityMappingScripts extends TestBase {
	
	@Test(priority=5)
	public static void tc05verifyCreateIdentityMappings() throws Exception {
		
		CreateExtentTest("VerifyIdentityMappings","Case 1: User needs to verify Create IdentityMappimgs", "Functional_TestCase","VinayKumar");
		
		//Launch Application
		Launch_Application();
		
		//Click On setting Button icon
		webdriver.clickOnButton(IdentityMappingPage.globalDropdown);
		LogInFo("User click on Setting Icon");
		TakeScreenshot("User click on Setting Icon","IdentityMappings","SettingsIcon");
		//click on Global setting
		webdriver.clickOnButton(IdentityMappingPage.globalSetting);
		LogInFo("User Click On Global settings ");
		webdriver.clickOnButton(IdentityMappingPage.identityMappings);
		LOG.info("User Click on Identity Mapping");
		TakeScreenshot("User Click on Identity Mapping", "IdentityMappings", "IdentityMapping");
		
		if(properties.getProperty("IdentityFirstName").equalsIgnoreCase("vinay")) {
			webdriver.clickOnButton(IdentityMappingPage.firstName);
		}
		if(properties.getProperty("IdentityLastName").equalsIgnoreCase("LastName")) {
			webdriver.clickOnButton(IdentityMappingPage.lastName);
		}
		if(properties.getProperty("IdentityEmail").equalsIgnoreCase("LastName")) {
			webdriver.clickOnButton(IdentityMappingPage.email);
		}	
		else {
			System.out.println("getting error");
		}
		LOG.info("User Click on Identity Attribute");
		TakeScreenshot("User selected Identity Attribute", "IdentityMappings", "IdentityAttribute");
		webdriver.clickOnButton(IdentityMappingPage.addSource);
		LOG.info("User click on Add Source");
		TakeScreenshot("User Click on Add Source", "IdentityMappings", "AddSource");
		webdriver.enterText(IdentityMappingPage.appValue, properties.getProperty("ApplicationName"));
		webdriver.clickOnButton(IdentityMappingPage.selectApp);
		Thread.sleep(1000);
		webdriver.selectTextOnDropDown(IdentityMappingPage.attributeValue, properties.getProperty("IdentityLastName").toUpperCase());
		LOG.info("User entered Source Data");
		TakeScreenshot("User entered Source Data", "IdentityMappings", "SourceData");
		webdriver.clickOnButton(IdentityMappingPage.addButton);
		webdriver.ScrollParticularElement(IdentityMappingPage.saveButton);
		Thread.sleep(1000);
		webdriver.clickOnButton(IdentityMappingPage.saveButton);
		LOG.info("User Edited Identity Attribute Successfully");
		TakeScreenshot("User Edited Identity Attribute Successfully", "IdentityMappings", "EditedAttribute");
		LogOut_Application();
	}
	
	

}
