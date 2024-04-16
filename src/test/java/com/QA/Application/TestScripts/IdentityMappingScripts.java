package com.QA.Application.TestScripts;

import org.testng.annotations.Test;
import com.QA.Application.TestBase.TestBase;

public class IdentityMappingScripts extends TestBase {
	
	@Test(priority=5)
	public static void tc05verifyCreateIdentityMappings() throws Exception {
		
		CreateExtentTest("VerifyIdentityMappings","Case 1: User needs to verify Create IdentityMappimgs", "Functional_TestCase","VinayKumar");
		Application.Launch_Application();
		Application.IdentityMappings("First Name");
		Application.IdentityMappings("Last Name");
		//Application.IdentityMappings("Email");

		Application.LogOut_Application();
		

	}
}
