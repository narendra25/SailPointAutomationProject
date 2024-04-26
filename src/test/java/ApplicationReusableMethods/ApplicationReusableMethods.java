package ApplicationReusableMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import com.QA.Application.Pages.AppCorrelationPage;
import com.QA.Application.Pages.AppCorrelationPage;
import com.QA.Application.Pages.ApplicationsPage;
import com.QA.Application.Pages.LoginPage;
import com.QA.Application.Pages.RulesPage;
import com.QA.Application.TestBase.TestBase;

public class ApplicationReusableMethods extends TestBase {
	public void Launch_Application() throws IOException, InterruptedException {

		// ENTER USERNAME OF APPLICATION.
		webdriver.enterText(LoginPage.txtUserName, properties.getProperty("ApplicationUserName"));
		webdriver.AssertElementIsPresentOrNot(LoginPage.txtUserName, "LoginPage", "spadmin");
		LogInFo("User Enter User Name");

		// ENTER PASSWORD OF APPLICATION.
		webdriver.enterText(LoginPage.txtPassword, properties.getProperty("ApplicationPassword"));
		webdriver.ScrollParticularElement(LoginPage.txtPassword);
		webdriver.AssertElementIsPresentOrNot(LoginPage.txtPassword, "LoginPage", "admin");
		LogInFo("User Enter The Password ");

		// SUBMIT BUTTON OF APPLICATION.
		webdriver.clickOnButton(LoginPage.btnLogIn);
		webdriver.waitForElementVisible(ApplicationsPage.btnApplications);
		webdriver.WaitForSometime(3000);
		TakeScreenshot("User Click On Login Successfully", "LoginPage", "Login");
		LogInFo("User Click On Login Page Successfully. ");
		// ASSERTING THE ACTUAL AND EXPECTED TITLE
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

		TakeScreenshot("User Click On Logout Dropdown Button", "LoginPage", "LogoutDropdown");

		// User click On Logout Button
		webdriver.waitForElementLocated(LoginPage.btnLogout);
		webdriver.clickOnButton(LoginPage.btnLogout);
		LogInFo("User click On Logout Button");
		webdriver.WaitForSometime(2000);
		TakeScreenshot("User click On Logout Button", "LoginPage", "Logout");
		webdriver.waitForElementLocated(LoginPage.btnLogIn);
	TakeScreenshot("User Click On Logout Dropdown Button","LogOutPage","LogoutDropdown");
	
	//User click On Logout Button
	webdriver.WaitForSometime(2000);
	webdriver.waitForElementLocated(LoginPage.btnLogout);
	webdriver.clickOnButton(LoginPage.btnLogout);
	LogInFo("User click On Logout Button");
	TakeScreenshot("User click On Logout Button","LogOutPage","Logout");
	webdriver.waitForElementLocated(LoginPage.btnLogIn);
	webdriver.WaitForSometime(2000);
	}

	
	public void newCorrelation(String AppName, String AppAttribute, String IdentityAttribute) throws Exception {
		webdriver.clickOnButton(ApplicationsPage.btnApplications);
		webdriver.clickOnButton(ApplicationsPage.btnApplicationDefination);
		webdriver.DynamicXpathText(AppName);
		LogInFo("User Selected Application");
		TakeScreenshot("User Selected Application", "APPCorrelation", "ApplicationPage");
		webdriver.clickOnButton(AppCorrelationPage.btnCorrelation);
		LogInFo("User Entered Correlation Page");
		TakeScreenshot("User Entered Correlation Page", "APPCorrelation", "CorrelationPage");
		webdriver.WaitForSometime(2000);
		webdriver.clickOnButton(AppCorrelationPage.btnNew);
		webdriver.clickOnButton(AppCorrelationPage.btnWizardNext);
		webdriver.enterText(AppCorrelationPage.btnConfigName, "Corr1");
		LogInFo("User Entered Configuration Name");
		TakeScreenshot("User Entered Configuration Name", "APPCorrelation", "ConfigName");
		webdriver.clickOnButton(AppCorrelationPage.btnConfigNext);
		webdriver.clickOnButton(AppCorrelationPage.btnConfigAttributeNext);
		LogInFo("User Entered Correlation Assignment Page");
		TakeScreenshot("User Entered Correlation Assignment Page", "APPCorrelation", "CorrelationAssignment");
		webdriver.selectTextOnDropDown(AppCorrelationPage.selectAppAttribute, AppAttribute);
		webdriver.selectTextOnDropDown(AppCorrelationPage.selectIdentityAttribute, IdentityAttribute);
		webdriver.WaitForSometime(2000);
		webdriver.clickOnButton(AppCorrelationPage.btnSave);
		LogInFo("User Created New Correlation");
		TakeScreenshot("User Created New Correlation", "APPCorrelation", "NewCorrelation");
	}

	public void managerCorrelation(String AppName, String AppAttribute, String IdentityAttribute) throws Exception {
		webdriver.clickOnButton(ApplicationsPage.btnApplications);
		webdriver.clickOnButton(ApplicationsPage.btnApplicationDefination);
		webdriver.DynamicXpathText(AppName);
		LogInFo("User Selected Application");
		TakeScreenshot("User Selected Application", "APPCorrelation", "ApplicationPage");
		webdriver.clickOnButton(AppCorrelationPage.btnCorrelation);
		LogInFo("User Entered Correlation Page");
		TakeScreenshot("User Entered Correlation Page", "APPCorrelation", "CorrelationPage");
		webdriver.WaitForSometime(2000);
		webdriver.ScrollParticularElement(AppCorrelationPage.btnManagerCorrelation);
		LogInFo("User scroll to Manager Correlation");
		TakeScreenshot("User scroll to Manager Correlation", "APPCorrelation", "ManagerCorrelation");
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
