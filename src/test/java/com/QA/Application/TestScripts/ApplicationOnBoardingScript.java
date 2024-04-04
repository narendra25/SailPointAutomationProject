package com.QA.Application.TestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import org.testng.annotations.Test;
import com.QA.Application.Pages.ApplicationsPage;
import com.QA.Application.TestBase.TestBase;

public class ApplicationOnBoardingScript extends TestBase{
	@Test
	public static void tc02verifyApplicationOnBoarding() throws InterruptedException, IOException, AWTException {
		CreateExtentTest("Verify Application On Boarding In Sailpoint", "Case 1: User needs to verify Application On Boarding in Sailpoint.","Functional_TestCase","Narendra Reddy");
		//Launching Application
		Launch_Application();
		
		//Click On Applications
		webdriver.clickOnButton(ApplicationsPage.btnApplications);
		TestPass("User Click On Applications");

		//click on application defination
		webdriver.clickOnButton(ApplicationsPage.btnApplicationDefination);
		webdriver.VerifyElementIsPresentorNot(ApplicationsPage.btnApplicationDefination,"Application","ApplicationDefination");
		LogInFo("User able to Click On ApplicationDefinition");

		//Click On Add New Application
		webdriver.waitForElementVisible(ApplicationsPage.btnAddNewApplication);
		webdriver.clickOnButton(ApplicationsPage.btnAddNewApplication);
		TakeScreenshot("AddNew Application","Application","AddNewApplication");
		
		////////////////////// ---CONDITION IS BASED APPLICATION IT WILL EXECUTE --/////////////////
		if(properties.getProperty("ApplicationTypeofOnBoardingType").equalsIgnoreCase("Delimiter")) 
		{
			//Enter Application Name
			webdriver.enterText(ApplicationsPage.txtApplicationName,webdriver.generateRandomString(10));
			webdriver.getText(ApplicationsPage.txtApplicationName);
			webdriver.waitForElementVisible(ApplicationsPage.btnDelimiterSave);

			//Select Application Owner
			webdriver.clickOnButton(ApplicationsPage.selectOwner);
			webdriver.enterText(ApplicationsPage.txtOwnerName,properties.getProperty("DelimiterApplicationOwner"));
			webdriver.WaitForSometime(1000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			TestPass("User Select The Application Owner");
			LogInFo("User Select The Application Owner");
			webdriver.WaitForSometime(1000);

			//Select Application Type 
			webdriver.selectValueOnDropDown(ApplicationsPage.selectApplicationType,properties.getProperty("DelimiterApplicationType"));
			TestPass("User select Application Type");
			webdriver.WaitForSometime(1000);

			//Select Authoritative Application 
			webdriver.clickOnButton(ApplicationsPage.selectAuthoritativeApplication);
			webdriver.WaitForSometime(1000);
			TakeScreenshot("User Select Application As Authorative Application","Application","AuthorativeApplication");

			//Navigate To Configuration Tab
			webdriver.clickOnButton(ApplicationsPage.btnConfiguration);
			LogInFo("User Navigate To Configuration Tab");
			TakeScreenshot("User is Navigate To Configauration Tab","Application","Configuration");
			webdriver.WaitForSometime(2000);

			//Enter The File Path
			webdriver.enterText(ApplicationsPage.txtFilePath,properties.getProperty("DelimiterFilePath"));
			LogInFo("User Enter The File Path");
			TestPass("User Enter The File Path");
			webdriver.WaitForSometime(2000);
//Tommorrow 
			//Enter The Delimiter
			webdriver.enterText(ApplicationsPage.txtDelimiter,properties.getProperty("Delimiter"));
			test.pass("User  Enter The Delimiter");
			webdriver.WaitForSometime(1000);
			
			//CheckBox of Firstline as header
			webdriver.clickOnButton(ApplicationsPage.chkFilehascolumnheaderonfirstline);
			test.pass("User  Select The Check Box of Filehascolumnheaderonfirstline");
			webdriver.WaitForSometime(1000);
			if(properties.getProperty("UserAddObjectType").equalsIgnoreCase("ObjectType")) {
				webdriver.ScrollParticularElement(ApplicationsPage.btnAddObjectType);
				webdriver.clickOnButton(ApplicationsPage.btnAddObjectType);
				webdriver.waitForElementLocated(ApplicationsPage.txtNameObjectType);
				webdriver.WaitForSometime(2000);

				//Name Of Object Type
				webdriver.enterText(ApplicationsPage.txtNameObjectType,properties.getProperty("NameObjectType"));
				//Click On Ok Button
				webdriver.WaitForSometime(2000);
				webdriver.clickOnButton(ApplicationsPage.btnOkObjectType);
				webdriver.waitForElementLocated(ApplicationsPage.txtObjectFilepath);
				webdriver.ScrollParticularElement(ApplicationsPage.txtObjectFilepath);
				//File Path
				webdriver.enterText(ApplicationsPage.txtObjectFilepath,properties.getProperty("ObjectTypeFilePath"));
				webdriver.waitForElementLocated(ApplicationsPage.txtObjectDelimiter);
				//Delimiter
				webdriver.enterText(ApplicationsPage.txtObjectDelimiter,properties.getProperty("txtObjectDelimiter"));
				webdriver.waitForElementLocated(ApplicationsPage.chkObjectFilehascolumnheaderonfirstline);
				//First Line Has First Column
				webdriver.clickOnButton(ApplicationsPage.chkObjectFilehascolumnheaderonfirstline);
				//Navigating To schema Tab
				webdriver.ScrollParticularElement(ApplicationsPage.btnSchema);
				webdriver.clickOnButton(ApplicationsPage.btnSchema);
				LOG.info("User Navigationg To schema Page ");
				test.pass("User Navigationg To schema Page");
				webdriver.WaitForSometime(1000);
				
				//Enter delimiter Identity Attribute Of Application 
				webdriver.enterText(ApplicationsPage.txtDelimiterIdentityAttribute,properties.getProperty("DelimitedIdentityAttribute"));
				test.pass("User Enter Delimited Identity Attribute");
				webdriver.WaitForSometime(1000);
				
				//Enter delimiter Identity Display Attribute Of Application 
				webdriver.enterText(ApplicationsPage.txtDelimiterDisplayAttribute,properties.getProperty("DelimitedDispalyAttribute"));
				test.pass("User Enter DelimitedDispalyAttribute");
				webdriver.WaitForSometime(1000);
				
				//Enter Object Identity Attribute Of Application 
				webdriver.waitForElementLocated(ApplicationsPage.txtObjectDelimiterIdentityAttribute);
				webdriver.ScrollParticularElement(ApplicationsPage.txtObjectDelimiterIdentityAttribute);
				webdriver.enterText(ApplicationsPage.txtObjectDelimiterIdentityAttribute,properties.getProperty("txtObjectDelimiterIdentityAttribute"));
				test.pass("User Enter ObjectIdentity Attribute");
				webdriver.WaitForSometime(1000);
				
				//Enter Object Identity Display Attribute Of Application 
				webdriver.enterText(ApplicationsPage.txtObjectDelimiterDisplayAttribute,properties.getProperty("txtObjectDelimiterDisplayAttribute"));
				test.pass("User Enter ObjectDispalyAttribute");
				webdriver.WaitForSometime(1000);
				//Click On DiscoverSchemaAttribute Button
				webdriver.clickOnButton(ApplicationsPage.btnDelimiterDiscoverSchemaAttribute);
				LOG.info("User Click on Discover Schema Attribute");
				test.pass("User Click on Discover Schema Attribute");
				webdriver.WaitForSometime(2000);
				//Click On Preview Button
				webdriver.clickOnButton(ApplicationsPage.btnDelimiterPreview);
				LOG.info("User Click on Preview");
				test.pass("User Click on Preview");
				webdriver.WaitForSometime(2000);
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
				webdriver.WaitForSometime(1000);
				
				//-----------Object Type Schema------------///
				//Click On DiscoverSchemaAttribute Button
				webdriver.ScrollParticularElement(ApplicationsPage.btnObjectDiscoverSchemaAttribute);
				webdriver.clickOnButton(ApplicationsPage.btnObjectDiscoverSchemaAttribute);
				LOG.info("User Click on Object Discover Schema Attribute");
				test.pass("User Click on Object Discover Schema Attribute");
				webdriver.WaitForSometime(2000);
				//Click On Preview Button
				webdriver.clickOnButton(ApplicationsPage.btnObjectPreview);
				LOG.info("User Click on Object Preview");
				test.pass("User Click on Object Preview");

				webdriver.WaitForSometime(2000);
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
				webdriver.WaitForSometime(1000);
				
				//Click On Save Button Of Delimiter File
				//webdriver.clickOnButton(ApplicationsPage.btnDelimiterSave);
				test.pass("User Click on Delimiter Save Button");
				webdriver.WaitForSometime(5000);
				
			}

			//TestConnection
//			webdriver.ScrollParticularElement(ApplicationsPage.btnDelimiterTestConnection);
//			webdriver.clickOnButton(ApplicationsPage.btnDelimiterTestConnection);
//			test.pass(.createScreenCaptureFromPath(webdriver.CaptureScreenShot("DelimiterTestConnection")).build());
//
//			test.pass("User Check The Test Connection");
//			webdriver.WaitForSometime(9000);
			//Navigating To Schema Page
			else {
			webdriver.clickOnButton(ApplicationsPage.btnSchema);
			LOG.info("User Navigationg To schema Page ");
			test.pass("User Navigationg To schema Page");
			webdriver.WaitForSometime(1000);
			
			//Enter delimiter Identity Attribute Of Application 
			webdriver.enterText(ApplicationsPage.txtDelimiterIdentityAttribute,properties.getProperty("DelimitedIdentityAttribute"));
			test.pass("User Enter Delimited Identity Attribute");
			webdriver.WaitForSometime(1000);
			
			//Enter delimiter Identity Display Attribute Of Application 
			webdriver.enterText(ApplicationsPage.txtDelimiterDisplayAttribute,properties.getProperty("DelimitedDispalyAttribute"));
			test.pass("User Enter DelimitedDispalyAttribute");
			webdriver.WaitForSometime(1000);
			//Click On DiscoverSchemaAttribute Button
			webdriver.clickOnButton(ApplicationsPage.btnDelimiterDiscoverSchemaAttribute);
			LOG.info("User Click on Discover Schema Attribute");
			test.pass("User Click on Discover Schema Attribute");
			webdriver.WaitForSometime(2000);
			//Click On Preview Button
			webdriver.clickOnButton(ApplicationsPage.btnDelimiterPreview);
			LOG.info("User Click on Preview");
			test.pass("User Click on Preview");

			webdriver.WaitForSometime(2000);
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			webdriver.WaitForSometime(1000);
			
			//Click On Save Button Of Delimiter File
			webdriver.clickOnButton(ApplicationsPage.btnDelimiterSave);
			test.pass("User Click on Delimiter Save Button");
			webdriver.WaitForSometime(5000);
			System.out.println("___________________________________________________________________________________________________________");
		}}
		else if(properties.getProperty("ApplicationTypeofOnBoardingType").equalsIgnoreCase("JDBC")) 
		{
			//Enter Application Name
			webdriver.enterText(ApplicationsPage.txtApplicationName,properties.getProperty("JDBCApplicationName"));
			webdriver.WaitForSometime(1000);
			
			LOG.info("User Enter Application Name");
			test.pass("User Enter Application Name");

			//Select Application Owner
			webdriver.clickOnButton(ApplicationsPage.selectOwner);
			webdriver.enterText(ApplicationsPage.txtOwnerName,properties.getProperty("JDBCApplicationOwner"));
			webdriver.WaitForSometime(2000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			LOG.info("User Select The Application Owner");
			test.pass("User Select The Application Owner");
			webdriver.WaitForSometime(1000);

			//Select Application Type 
			webdriver.selectValueOnDropDown(ApplicationsPage.selectApplicationType,properties.getProperty("JDBCApplicationType"));
			LOG.info("User Select The Application Type");
			test.pass("User Select The Application Type");
			webdriver.WaitForSometime(2000);
			//Navigate To Configuration Tab
			webdriver.clickOnButton(ApplicationsPage.btnConfiguration);
			LOG.info("User Navigate The Configuration Tab");
			test.pass("User Navigate The Configuration Tab");
			webdriver.WaitForSometime(3000);

			//Enter Connection User 
			webdriver.clearText(ApplicationsPage.txtConnectionUser);
			webdriver.WaitForSometime(1000);
			webdriver.enterText(ApplicationsPage.txtConnectionUser,properties.getProperty("JDBCConnectionUser"));
			LOG.info("User Enter The Connection User Name");
			test.pass("User Enter The Connection User Name");

			//Enter Connection Password
			webdriver.clearText(ApplicationsPage.txtConnectionPassword);
			webdriver.WaitForSometime(1000);
			webdriver.enterText(ApplicationsPage.txtConnectionPassword,properties.getProperty("JDBCConnectionPassword"));
			LOG.info("User Enter The Connection Password");
			test.pass("User Enter The Connection Password");

			//Enter Database URL
			webdriver.clearText(ApplicationsPage.txtDataBaseURL);
			webdriver.WaitForSometime(1000);
			webdriver.enterText(ApplicationsPage.txtDataBaseURL,properties.getProperty("JDBCDatabaseURL"));
			LOG.info("User Enter The DatabaseURL");
			test.pass("User Enter The DatabaseURL");
			//Scroll down to SQL Statement
			webdriver.ScrollParticularElement(ApplicationsPage.txtSQLStatment);

			//Enter The SQL Statement
			webdriver.clearText(ApplicationsPage.txtSQLStatment);
			webdriver.WaitForSometime(1000);
			webdriver.enterText(ApplicationsPage.txtSQLStatment,properties.getProperty("JDBCSqlStatement"));
			LOG.info("User Enter The SQL Statement");
			test.pass("User Enter The SQL Statement");

			//Click On TestConnection
			webdriver.clickOnButton(ApplicationsPage.btnTestConnection);
			LOG.info("User Checking The Test Connection");
			test.pass("User Checking The Test Connection");
			webdriver.WaitForSometime(1000);
			//Navigate Schema Tab
			webdriver.clickOnButton(ApplicationsPage.tabSchema);
			LOG.info("User Navigate To Schema Tab");
			test.pass("User Navigate To Schema Tab");
			webdriver.WaitForSometime(1000);

			//Enter Identity Attribute
			webdriver.enterText(ApplicationsPage.txtJDBCIdentityAttribute,properties.getProperty("JDBCIdentityAttribute"));
			LOG.info("User Enter JDBC Identity Attribute");
			test.pass("User Enter JDBC Identity Attribute");
			webdriver.WaitForSometime(1000);
			//Enter Dispaly Attribute
			webdriver.enterText(ApplicationsPage.txtDispalyAttribute,properties.getProperty("JDBCDisplayAttribute"));
			LOG.info("User Enter JDBC Dispaly Attribute");
			test.pass("User Enter JDBC Display Attribute");
			webdriver.WaitForSometime(1000);
			

			//Click On DiscoverSchemaAttribute Button
			webdriver.clickOnButton(ApplicationsPage.btnDiscoverSchemaAttribute);
			LOG.info("User Click on Discover Schema Attribute");
			test.pass("User Click on Discover Schema Attribute");
			webdriver.WaitForSometime(2000);
			//Click On Preview Button
			webdriver.clickOnButton(ApplicationsPage.btnPreview);
			LOG.info("User Click on Preview");
			test.pass("User Click on Preview");
			webdriver.WaitForSometime(2000);

			webdriver.clickOnButton(ApplicationsPage.btnPreviewClose);
			webdriver.WaitForSometime(2000);
			webdriver.clickOnButton(ApplicationsPage.btnApplicationSave);
			webdriver.WaitForSometime(3000);
		}
		else if(properties.getProperty("ApplicationTypeofOnBoardingType").equalsIgnoreCase("LDAP")) 
		{
	}
	}
}
