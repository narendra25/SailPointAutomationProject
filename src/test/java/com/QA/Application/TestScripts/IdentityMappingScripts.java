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
		TestPass("User Click On Global settings");
		
		//LogOutApplication
		LogOut_Application();
	}
	
	

}
