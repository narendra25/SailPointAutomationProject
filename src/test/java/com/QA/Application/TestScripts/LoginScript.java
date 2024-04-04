package com.QA.Application.TestScripts;

import java.io.IOException;
import org.testng.annotations.Test;
import com.QA.Application.TestBase.TestBase;

public class LoginScript extends TestBase{
	@Test
	public static void tc01VerifyLogin() throws InterruptedException, IOException {
		CreateExtentTest("Verify URL", "Case 1: User needs to verify if Go Applicaton  homepage works as expected.","Functional_TestCase","Narendra Reddy");
		Launch_Application();
	}
}
