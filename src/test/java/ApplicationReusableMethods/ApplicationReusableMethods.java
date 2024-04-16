package ApplicationReusableMethods;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;

import com.QA.Application.Pages.ApplicationsPage;
import com.QA.Application.Pages.IdentityMappingPage;
import com.QA.Application.Pages.LoginPage;
import com.QA.Application.TestBase.TestBase;

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
	TakeScreenshot("User Click On Logout Dropdown Button","LoginPage","LogoutDropdown");
	
	//User click On Logout Button
	webdriver.waitForElementLocated(LoginPage.btnLogout);
	webdriver.clickOnButton(LoginPage.btnLogout);
	LogInFo("User click On Logout Button");
	webdriver.WaitForSometime(2000);
	TakeScreenshot("User click On Logout Button","LoginPage","Logout");
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


}
