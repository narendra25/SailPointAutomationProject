package com.QA.DataDrivenScripts;

import org.testng.annotations.Test;
import com.QA.Application.TestBase.TestBase;

public class ApplicationCorrelation extends TestBase {

	@Test
	public void testCorrelation() throws Exception, InterruptedException {
		CreateExtentTest("Verify Create Aggregation Task Of Application",
				"Case 1: User needs to verify Create Aggregation Task Of Application .", "Functional_TestCase",
				"Narendra Reddy");

		// Launching Application
		Application.Launch_Application();
		
		// New Correlation	
		Application.newCorrelation("GraceApp", "EMAIL", "Email");
		
		// Manager Correlation
		Application.managerCorrelation("GraceApp", "LASTNAME", "Last Name");
		
		// LogOut Application
		Application.LogOut_Application();
	}

}
