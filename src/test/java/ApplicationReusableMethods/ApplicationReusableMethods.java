package ApplicationReusableMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.detDSA;
import org.openqa.selenium.WebElement;

import com.QA.Application.Pages.ApplicationsPage;
import com.QA.Application.Pages.DebugPage;
import com.QA.Application.Pages.IdentityMappingPage;
import com.QA.Application.Pages.LoginPage;
import com.QA.Application.Pages.RulesPage;
import com.QA.Application.TestBase.TestBase;
import com.QA.DataDrivenScripts.*;

public class ApplicationReusableMethods extends TestBase{
public void Launch_Application() throws IOException, InterruptedException {
		
		//ENTER USERNAME OF APPLICATION.
		webdriver.enterText(LoginPage.txtUserName,properties.getProperty("ApplicationUserName"));
		webdriver.AssertElementIsPresentOrNot(LoginPage.txtUserName,"LoginPage","spadmin");
		LogInFo("User Enter User Name");
		
		//ENTER PASSWORD OF APPLICATION.
		webdriver.enterText(LoginPage.txtPassword,properties.getProperty("ApplicationPassword"));
		webdriver.ScrollParticularElement(LoginPage.txtPassword);
		webdriver.AssertElementIsPresentOrNot(LoginPage.txtPassword,"LoginPage","admin");
		LogInFo("User Enter The Password ");
		
		//SUBMIT BUTTON OF APPLICATION.
		webdriver.clickOnButton(LoginPage.btnLogIn);
		webdriver.waitForElementVisible(ApplicationsPage.btnApplications);
		webdriver.WaitForSometime(3000);
		TakeScreenshot("User Click On Login Successfully","LoginPage","Login");
		LogInFo("User Click On Login Page Successfully. ");
		//ASSERTING THE ACTUAL AND EXPECTED TITLE
		String expectedTitle = "SailPoint IdentityIQ - Home";
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		if (expectedTitle.equals(actualTitle)) {
			TestPass("Verification Successful - The correct title is displayed on the web page.");
			LogInFo("Verification Successful - The User is Login The Application");

		} else {
			TestFail("Verification Failed - An incorrect title is displayed on the web page.");
			LogWarn("Verification Failed - An incorrect title is displayed on the web page.");
		}
		
	}
	public void LogOut_Application() throws Exception {
		webdriver.waitForElementVisible(LoginPage.btnLogOutDropDown);
		webdriver.clickOnButton(LoginPage.btnLogOutDropDown);
		LogInFo("User Click On Logout Dropdown Button");
	TakeScreenshot("User Click On Logout Dropdown Button","LogOutPage","LogoutDropdown");
	
	//User click On Logout Button
	webdriver.WaitForSometime(2000);
	webdriver.waitForElementLocated(LoginPage.btnLogout);
	webdriver.clickOnButton(LoginPage.btnLogout);
	LogInFo("User click On Logout Button");
	webdriver.WaitForSometime(2000);
	TakeScreenshot("User click On Logout Button","LogOutPage","Logout");
	webdriver.waitForElementLocated(LoginPage.btnLogIn);
	}
	
	//Identity Mappings 
		public void IdentityMappings(String IdentityMappingName) throws Exception {
			//Click On setting Button icon
			webdriver.clickOnButton(IdentityMappingPage.globalDropdown);
			LogInFo("User click on Setting Icon");
			TakeScreenshot("User click on Setting Icon","IdentityMappings","SettingsIcon");
			
			//click on Global setting
			webdriver.clickOnButton(IdentityMappingPage.globalSetting);
			LogInFo("User Click On Global settings ");
			
			//user Click On Identity Mappings Button
			webdriver.clickOnButton(IdentityMappingPage.identityMappings);
			LogInFo("User Click on Identity Mapping");
			TakeScreenshot("User Click on Identity Mapping", "IdentityMappings", "IdentityMapping");
			
			//Based On Identity Mapping Name 
			webdriver.DynamicXpathContains(IdentityMappingName);
			LogInFo("User Click on Identity Attribute");
			TakeScreenshot("User selected Identity Attribute", "IdentityMappings", "IdentityAttribute");
			webdriver.waitForElementLocated(IdentityMappingPage.getAttributeName);
			webdriver.WaitForSometime(2000);
			
			//	Storing The Value Of Get Attribute Value
			WebElement element=driver.findElement(IdentityMappingPage.getAttributeName);
			String AttributeName=element.getAttribute("value");
			System.out.println(AttributeName);
			
			//Click On add source Button
			webdriver.clickOnButton(IdentityMappingPage.addSource);
			LogInFo("User click on Add Source");
			TakeScreenshot("User Click on Add Source", "IdentityMappings", "AddSource");
			webdriver.enterText(IdentityMappingPage.appValue, properties.getProperty("ApplicationName"));
			webdriver.WaitForSometime(3000);
			webdriver.DynamicXpathContains(properties.getProperty("ApplicationName"));
			webdriver.WaitForSometime(3000);
			
			//Selecting The Attribute Value
			webdriver.selectTextOnDropDown(IdentityMappingPage.attributeValue,AttributeName);
			webdriver.WaitForSometime(3000);
			LogInFo("User entered Source Data");
			TakeScreenshot("User entered Source Data", "IdentityMappings", "SourceData");
			
			//Click On Add Button
			webdriver.clickOnButton(IdentityMappingPage.addButton);
			webdriver.ScrollParticularElement(IdentityMappingPage.saveButton);
			webdriver.WaitForSometime(2000);
			
			//click On Save Button
			webdriver.clickOnButton(IdentityMappingPage.saveButton);
			LogInFo("User Edited Identity Attribute Successfully");
			TakeScreenshot("User Edited Identity Attribute Successfully", "IdentityMappings", "EditedAttribute");
			
		}
		
		public void deleteApplication(String Object, String SearchByNameOrID, String Action) throws Exception
		{
			driver.get("http://localhost:8080/identityiq/debug/debug.jsf");
			LogInFo("User enter into Debug Page");
			TakeScreenshot("User enter into Debug Page", "DeleteApp", "DebugHomePage");
			webdriver.clickOnButton(DebugPage.btnobject);
			LogInFo("User click on object dropdown");
			TakeScreenshot("User click on object dropdown", "DeleteApp", "selectDropdown");
			webdriver.enterText(DebugPage.txtenterAppName, Object);
			webdriver.WaitForSometime(1000);
			webdriver.DynamicXpathText(Object);
			LogInFo("User selected Object");
			TakeScreenshot("User selected Object", "DeleteApp", "AppSelect");
			
			webdriver.waitForElementLocated(DebugPage.txtfilterName);
			webdriver.ClickByJavaScript_Executor(DebugPage.txtfilterName);
			webdriver.enterText(DebugPage.txtfilterName, SearchByNameOrID);
			webdriver.clickOnButton(DebugPage.btnsearch);
			LogInFo("User entered Name or ID");
			TakeScreenshot("User entered Name or ID", "DeleteApp", "NameOrID");
			webdriver.clickOnButton(DebugPage.btncheckboxResult);
			webdriver.clickOnButton(DebugPage.btnAction);
			LogInFo("User click on Action Button");
			TakeScreenshot("User click on Action Button", "DeleteApp", "ActionBtn");
			if(Action.equalsIgnoreCase("Delete"))
			{
			webdriver.clickOnButton(DebugPage.btnDelete);
			webdriver.clickOnButton(DebugPage.btnYes);
			LogInFo("Validate User Deleted Application Successfully");
			TakeScreenshot("Validate User Deleted Application Successfully", "DeleteApp", "AppDelete");
			}
			if(Action.equalsIgnoreCase("New"))
			{
			webdriver.clickOnButton(DebugPage.btnNew);
			webdriver.WaitForSometime(1000);
			webdriver.clickOnButton(DebugPage.txtObjEditer);
			webdriver.WaitForSometime(1000);
			webdriver.enterText(DebugPage.txtObjEditer, "Test Data Passed");
			webdriver.clickOnButton(DebugPage.btnSave);
			LogInFo("Validate User New Application Data added Successfully");
			TakeScreenshot("Validate User New Application Data added Successfully", "DeleteApp", "NewData");
			}
			
		}
		
		public void CreateRuleOfSailPointApplication() throws Exception {
			String filePath=System.getProperty("user.dir");
			// Initialize Excel file
			FileInputStream file=new FileInputStream(filePath+properties.getProperty("DataFile"));
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet("SailPointApplicationJDBC");


			// Iterate through the rows and columns to read the data
			for (int rowNum = 2; rowNum <= sheet.getLastRowNum(); rowNum++) {
				Row row = sheet.getRow(rowNum);
							String ApplicationName = row.getCell(2).getStringCellValue();
							String RuleType= row.getCell(13).getStringCellValue();
							String RuleName= row.getCell(14).getStringCellValue();
							String WritingRuleEditor= row.getCell(15).getStringCellValue();
							
							Application.Launch_Application();
							
							//Click On Applications
							webdriver.clickOnButton(ApplicationsPage.btnApplications);
							TestPass("User Click On Applications");

							//click on application defination
							webdriver.clickOnButton(ApplicationsPage.btnApplicationDefination);
							webdriver.VerifyElementIsPresentorNot(ApplicationsPage.btnApplicationDefination,"Application","ApplicationDefination");
							LogInFo("User able to Click On ApplicationDefinition");
							//Click On application Based On Application Name 
							webdriver.DynamicXpathContains(ApplicationName);
							webdriver.waitForElementLocated(RulesPage.btnRulesTab);

							//Click On Rules Button
							webdriver.clickOnButton(RulesPage.btnRulesTab);
							webdriver.waitForElementLocated(RulesPage.btnCorrelationRule);
							TakeScreenshot("User Able to Click On Rules Tab","RulesDDT","RulesButton");
							webdriver.Dynamic_Create_Rule(RuleType);
							TakeScreenshot("User Able to Click On Rules Create","RulesDDT","RulesCreate");
							webdriver.waitForElementVisible(RulesPage.txtCorrelationRuleName);
							//Enter Rule Name 
							webdriver.enterText(RulesPage.txtCorrelationRuleName,RuleName);
							webdriver.WaitForSometime(2000);
							TakeScreenshot("User Able to Enter RuleName","RulesDDT","RulesCreate");
							
							//Writing The Rule In Text Editor
							webdriver.enterText(RulesPage.txtRuleEditor,WritingRuleEditor);
							webdriver.waitForElementVisible(RulesPage.btncancelCrossButton);
							TakeScreenshot("User Write The Rule For Correlation Rule for Application", "RulesDDT","CorrelationName");
							webdriver.WaitForSometime(3000);
							//Click On Cancel Cross Button
							webdriver.clickOnButton(RulesPage.btnSaveButton);
							webdriver.WaitForSometime(3000);
							TakeScreenshot("User click On Save Button", "RulesDDT","SavingRule");
							
							//Logout Application
							Application.LogOut_Application();

						
			}
		}


}
