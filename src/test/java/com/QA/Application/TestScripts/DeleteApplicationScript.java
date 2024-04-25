package com.QA.Application.TestScripts;

import org.testng.annotations.Test;
import com.QA.Application.TestBase.TestBase;
import ApplicationReusableMethods.ApplicationReusableMethods;

public class DeleteApplicationScript extends TestBase {
	
	ApplicationReusableMethods appreuse = new ApplicationReusableMethods();
	
	@Test
	public void deleteApp() throws Exception, InterruptedException
	{
		CreateExtentTest("Verify Application is Deleted", "Case 1: User needs to verify Application is Successfully Deleted.","Functional_TestCase","Vinay Kumar");
		
		//Launching Application
		Application.Launch_Application();
		
		// Select Application and Name
		appreuse.deleteApplication("Custom","Identity Attributes List", "Delete");
		
		//LogOut The AppliCation 
		Application.LogOut_Application();
	}

}
