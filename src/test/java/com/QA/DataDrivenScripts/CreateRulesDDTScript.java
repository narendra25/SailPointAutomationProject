package com.QA.DataDrivenScripts;


import org.testng.annotations.Test;
import com.QA.Application.TestBase.TestBase;

public class CreateRulesDDTScript extends TestBase {

	@Test(priority=4)
	public static void verifyCreateApplicationRules() throws Exception {

		CreateExtentTest("Verify ApplicationRules of Sailpoint Through DDT", "Case 1: User needs to verify if Application Rules of sailpoint Script Through DDT Test","Functional_TestCase","Narendra Reddy");

		Application.CreateRuleOfSailPointApplication();
	}
	
}