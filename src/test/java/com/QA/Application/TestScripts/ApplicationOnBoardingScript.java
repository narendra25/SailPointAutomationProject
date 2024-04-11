package com.QA.Application.TestScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import com.QA.Application.Pages.ApplicationsPage;
import com.QA.Application.TestBase.TestBase;

public class ApplicationOnBoardingScript extends TestBase{
	@Test(priority=2)
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
			webdriver.enterText(ApplicationsPage.txtApplicationName,properties.getProperty("ApplicationName"));
			webdriver.getText(ApplicationsPage.txtApplicationName);
			webdriver.waitForElementVisible(ApplicationsPage.btnDelimiterSave);
			webdriver.WaitForSometime(3000);

			//Select Application Owner
			webdriver.clickOnButton(ApplicationsPage.selectOwner);
			webdriver.enterText(ApplicationsPage.txtOwnerName,properties.getProperty("ApplicationOwner"));
			webdriver.WaitForSometime(3000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			TestPass("User Select The Application Owner");
			LogInFo("User Select The Application Owner");
			webdriver.WaitForSometime(3000);

			//Select Application Type 
			webdriver.selectValueOnDropDown(ApplicationsPage.selectApplicationType,properties.getProperty("ApplicationType"));
			webdriver.WaitForSometime(2000);
			TakeScreenshot("User Select Application Type","Application","Application Type");
			//Here Selecting Application AUTHORItative Type
			
			//Select Authoritative Application 
			webdriver.clickOnButton(ApplicationsPage.selectAuthoritativeApplication);
			webdriver.WaitForSometime(2000);
			TakeScreenshot("User Select Application As Authorative Application","Application","AuthorativeApplication");
			
			//Navigate To Configuration Tab
			webdriver.clickOnButton(ApplicationsPage.btnConfiguration);
			webdriver.waitForElementLocated(ApplicationsPage.txtFilePath);
			LogInFo("User Navigate To Configuration Tab");
			webdriver.WaitForSometime(2000);
			TakeScreenshot("User is Navigate To Configauration Tab","Application","Configuration");

			//Enter The File Path
			webdriver.enterText(ApplicationsPage.txtFilePath,properties.getProperty("DelimiterFilePath"));
			webdriver.waitForElementLocated(ApplicationsPage.txtDelimiter);
			LogInFo("User Enter The File Path");
			TestPass("User Enter The File Path");


			//Enter The Delimiter
			webdriver.enterText(ApplicationsPage.txtDelimiter,properties.getProperty("Delimiter"));
			webdriver.waitForElementLocated(ApplicationsPage.chkFilehascolumnheaderonfirstline);
			TestPass("User  Enter The Delimiter");

			//CheckBox of Firstline as header
			webdriver.clickOnButton(ApplicationsPage.chkFilehascolumnheaderonfirstline);
			TakeScreenshot("User  Select The Check Box of Filehascolumnheaderonfirstline","Application","Filehascolumnheaderonfirstline");
			webdriver.WaitForSometime(2000);
			
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
				LogInFo("User Navigationg To schema Page");
				TestPass("User Navigationg To schema Page");
				webdriver.WaitForSometime(1000);

				//Enter delimiter Identity Attribute Of Application 
				webdriver.enterText(ApplicationsPage.txtDelimiterIdentityAttribute,properties.getProperty("DelimitedIdentityAttribute"));
				TestPass("User Enter Delimited Identity Attribute");
				webdriver.WaitForSometime(1000);

				//Enter delimiter Identity Display Attribute Of Application 
				webdriver.enterText(ApplicationsPage.txtDelimiterDisplayAttribute,properties.getProperty("DelimitedDispalyAttribute"));
				TestPass("User Enter DelimitedDispalyAttribute");
				webdriver.WaitForSometime(1000);

				//Enter Object Identity Attribute Of Application 
				webdriver.waitForElementLocated(ApplicationsPage.txtObjectDelimiterIdentityAttribute);
				webdriver.ScrollParticularElement(ApplicationsPage.txtObjectDelimiterIdentityAttribute);
				webdriver.enterText(ApplicationsPage.txtObjectDelimiterIdentityAttribute,properties.getProperty("txtObjectDelimiterIdentityAttribute"));
				TestPass("User Enter ObjectIdentity Attribute");
				webdriver.WaitForSometime(1000);

				//Enter Object Identity Display Attribute Of Application 
				webdriver.enterText(ApplicationsPage.txtObjectDelimiterDisplayAttribute,properties.getProperty("txtObjectDelimiterDisplayAttribute"));
				TestPass("User Enter ObjectDispalyAttribute");
				webdriver.WaitForSometime(1000);
				TakeScreenshot("User Enter ObjectDispalyAttribute","Application","DelimiterDisplayAttribute");
				
				//Click On DiscoverSchemaAttribute Button
				webdriver.clickOnButton(ApplicationsPage.btnDelimiterDiscoverSchemaAttribute);
				LogTrace("User Click on Discover Schema Attribute");
				webdriver.WaitForSometime(2000);
				TakeScreenshot("User Click on Discover Schema Attribute","Application","DelimiterDiscoverSchemaAttribute");
				
				//Click On Preview Button
				webdriver.clickOnButton(ApplicationsPage.btnDelimiterPreview);
				LogInFo("User Click on Preview");
				TakeScreenshot("User Click on Preview","Application","PreviewObject");
				webdriver.WaitForSometime(2000);
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
				webdriver.WaitForSometime(1000);

				//-----------Object Type Schema------------///
				//Click On DiscoverSchemaAttribute Button
				webdriver.ScrollParticularElement(ApplicationsPage.btnObjectDiscoverSchemaAttribute);
				webdriver.clickOnButton(ApplicationsPage.btnObjectDiscoverSchemaAttribute);
				LogInFo("User Click on Object Discover Schema Attribute");
				TestPass("User Click on Object Discover Schema Attribute");
				webdriver.WaitForSometime(2000);
				
				//Click On Preview Button
				webdriver.clickOnButton(ApplicationsPage.btnObjectPreview);
				LogInFo("User Click on Object Preview");
				TestPass("User Click on Object Preview");
				webdriver.WaitForSometime(2000);
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
				webdriver.WaitForSometime(1000);

				//Click On Save Button Of Delimiter File
				//webdriver.clickOnButton(ApplicationsPage.btnDelimiterSave);
				TestPass("User Click on Delimiter Save Button");
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
				LogInFo("User Navigationg To schema Page ");
				TestPass("User Navigationg To schema Page ");
				webdriver.waitForElementVisible(ApplicationsPage.txtDelimiterIdentityAttribute);

				//Enter delimiter Identity Attribute Of Application 
				webdriver.enterText(ApplicationsPage.txtDelimiterIdentityAttribute,properties.getProperty("DelimitedIdentityAttribute"));
				TestPass("User Enter Delimited Identity Attribute");
				webdriver.waitForElementVisible(ApplicationsPage.txtDelimiterDisplayAttribute);

				//Enter delimiter Identity Display Attribute Of Application 
				webdriver.enterText(ApplicationsPage.txtDelimiterDisplayAttribute,properties.getProperty("DelimitedDispalyAttribute"));
				webdriver.WaitForSometime(1000);
				TakeScreenshot("User Enter DelimitedDispalyAttribute","Application","DisplayAttribute");
				
				//Click On DiscoverSchemaAttribute Button
				webdriver.clickOnButton(ApplicationsPage.btnDelimiterDiscoverSchemaAttribute);
				LogInFo("User Click on Discover Schema Attribute");
				webdriver.WaitForSometime(2000);
				TakeScreenshot("User Click on Discover Schema Attribute","Application","DiscoverSchema");
				
				//Click On Preview Button
				webdriver.clickOnButton(ApplicationsPage.btnDelimiterPreview);
				LogInFo("User Click on Preview");
				TakeScreenshot("User Click on Preview","Application","Preview");
				webdriver.WaitForSometime(2000);
				r.keyPress(KeyEvent.VK_ESCAPE);
				r.keyRelease(KeyEvent.VK_ESCAPE);
				webdriver.WaitForSometime(1000);

				//Click On Save Button Of Delimiter File
				//webdriver.clickOnButton(ApplicationsPage.btnDelimiterSave);
				test.pass("User Click on Delimiter Save Button");
				webdriver.WaitForSometime(5000);
				System.out.println("___________________________________________________________________________________________________________");
			}}
		else if(properties.getProperty("ApplicationTypeofOnBoardingType").equalsIgnoreCase("JDBC")) 
		{
			//Enter Application Name
			webdriver.enterText(ApplicationsPage.txtApplicationName,properties.getProperty("ApplicationName"));
			webdriver.getText(ApplicationsPage.txtApplicationName);
			webdriver.waitForElementVisible(ApplicationsPage.btnDelimiterSave);
			webdriver.WaitForSometime(3000);

			//Select Application Owner
			webdriver.clickOnButton(ApplicationsPage.selectOwner);
			webdriver.enterText(ApplicationsPage.txtOwnerName,properties.getProperty("ApplicationOwner"));
			webdriver.WaitForSometime(3000);
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			TestPass("User Select The Application Owner");
			LogInFo("User Select The Application Owner");
			webdriver.WaitForSometime(3000);

			//Select Application Type 
			webdriver.selectValueOnDropDown(ApplicationsPage.selectApplicationType,properties.getProperty("ApplicationType"));
			LOG.info("User Select The Application Type");
			TakeScreenshot("User Select The Application Type","JDBCAPPLICATION" ,"ApplicationType");
			webdriver.WaitForSometime(2000);
			
			//Navigate To Configuration Tab
			webdriver.clickOnButton(ApplicationsPage.btnConfiguration);
			LogInFo("User Navigate The Configuration Tab");
			TestPass("User Navigate The Configuration Tab");
			webdriver.WaitForSometime(3000);

			//Enter Connection User 
			webdriver.clearText(ApplicationsPage.txtConnectionUser);
			webdriver.WaitForSometime(3000);
			webdriver.enterText(ApplicationsPage.txtConnectionUser,properties.getProperty("JDBCConnectionUser"));
			LogInFo("User Enter The Connection User Name");
			TakeScreenshot("User Enter The Connection User Name", "JDBCAPPLICATION","ConnectionUser");
			//Enter Connection Password
			webdriver.clearText(ApplicationsPage.txtConnectionPassword);
			webdriver.WaitForSometime(3000);
			webdriver.enterText(ApplicationsPage.txtConnectionPassword,properties.getProperty("JDBCConnectionPassword"));
			LogInFo("User Enter The Connection Password");
			TakeScreenshot("User Enter The Connection Password", "JDBCAPPLICATION","ConnectionPassword");

			//Enter Database URL
			webdriver.clearText(ApplicationsPage.txtDataBaseURL);
			webdriver.WaitForSometime(2000);
			webdriver.enterText(ApplicationsPage.txtDataBaseURL,properties.getProperty("JDBCDatabaseURL"));
			LogInFo("User Enter The Connection Database URL");
			TakeScreenshot("User Enter The Connection DatabaseURL", "JDBCAPPLICATION","ConnectionDataBaseURL");
			//Scroll down to SQL Statement
			webdriver.ScrollParticularElement(ApplicationsPage.txtSQLStatment);

			//Enter The SQL Statement
			webdriver.clearText(ApplicationsPage.txtSQLStatment);
			webdriver.WaitForSometime(2000);
			webdriver.enterText(ApplicationsPage.txtSQLStatment,properties.getProperty("JDBCSqlStatement"));
			LogInFo("User Enter The Connection SQL Statement");
			TakeScreenshot("User Enter The Connection SQL Statement", "JDBCAPPLICATION","ConnectionSQLStatement");

			//Click On TestConnection
			webdriver.clickOnButton(ApplicationsPage.btnTestConnection);
			LOG.info("User Checking The Test Connection");
			test.pass("User Checking The Test Connection");
			webdriver.WaitForSometime(5000);
			//Navigate Schema Tab
			webdriver.clickOnButton(ApplicationsPage.tabSchema);
			LOG.info("User Navigate To Schema Tab");
			test.pass("User Navigate To Schema Tab");
			webdriver.WaitForSometime(3000);

			//Enter Identity Attribute
			webdriver.enterText(ApplicationsPage.txtJDBCIdentityAttribute,properties.getProperty("JDBCIdentityAttribute"));
			LogInFo("User Enter JDBC Dispaly Attribute");
			TakeScreenshot("User Enter JDBC Dispaly Attribute", "JDBCAPPLICATION","JDBCIdentityAttribute");
			webdriver.WaitForSometime(3000);
			//Enter Dispaly Attribute
			webdriver.enterText(ApplicationsPage.txtDispalyAttribute,properties.getProperty("JDBCDisplayAttribute"));
			LOG.info("User Enter JDBC Dispaly Attribute");
			test.pass("User Enter JDBC Display Attribute");
			webdriver.WaitForSometime(4000);


			//Click On DiscoverSchemaAttribute Button
			webdriver.clickOnButton(ApplicationsPage.btnDiscoverSchemaAttribute);
			LogInFo("User Click on Discover Schema Attribute");
			TakeScreenshot("User Click on Discover Schema Attribute", "JDBCAPPLICATION","JDBCDiscoverAttribute");
			webdriver.WaitForSometime(5000);
			//Click On Preview Button
			webdriver.clickOnButton(ApplicationsPage.btnPreview);
			LogInFo("User Click on Preview");
			webdriver.WaitForSometime(5000);
			TakeScreenshot("User Click on Preview", "JDBCAPPLICATION","JDBCDPreview");
			webdriver.WaitForSometime(3000);
			r.keyPress(KeyEvent.VK_ESCAPE);
			r.keyRelease(KeyEvent.VK_ESCAPE);
			webdriver.WaitForSometime(3000);
			webdriver.clickOnButton(ApplicationsPage.btnApplicationSave);
			webdriver.WaitForSometime(3000);
		}
		else if(properties.getProperty("ApplicationTypeofOnBoardingType").equalsIgnoreCase("LDAP")) 
		{
		}
	}
}
