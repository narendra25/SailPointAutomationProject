package com.QA.Application.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.QA.Application.TestBase.TestBase;


public class ReUsableMethods extends TestBase{
//	static Calendar cal = Calendar.getInstance();
//    
//    // Get the current time as a Date object
//    static Date time = cal.getTime();
//    
//    // Convert the Date object to a timestamp string
//    static String timestamp = time.toString().replace(":", "").replace(" ", "");
   
	public static By PassLocator;
	public static String EnterText;
	//Enter Text by using PassPassLocator
	public void enterText(By PassLocator, String EnterText) {
		WebElement element = driver.findElement(PassLocator);
		element.sendKeys(EnterText);

	}
	public void DynamicXpathContains(String Text) {
		driver.findElement(By.xpath("//*[contains(text(),'"+Text+"')]")).click();
	}
	public void DynamicXpathText(String Text) {
		driver.findElement(By.xpath("//*[text()='"+Text+"']")).click();
	}
	
	//Dynamic Click Button of Rules
	public void Dynamic_Create_Rule(String  EnterText) throws InterruptedException {
		WebElement element=driver.findElement(By.xpath("(//*[text()='"+EnterText+"']//parent::td//parent::tr//parent::td)[3]/input"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
	}
	//(//*[text()='Correlation Rule']//parent::td//parent::tr//parent::td)[2]/select
	//Secting Rule Of SailPoint Application
	public void Dynamic_Selecting_Rule_Application(String  EnterText,String RuleName) throws InterruptedException {
		WebElement element=driver.findElement(By.xpath("(//*[text()='"+EnterText+"']//parent::td//parent::tr//parent::td)[2]/select"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		Select selectValue = new Select(element);
			selectValue.selectByVisibleText(RuleName);
		
	}
	//Clear Text Method
	public void clearText(By PassLocator) {

		WebElement element = driver.findElement(PassLocator);
		element.clear();
	}
	//Click Button
	public void clickOnButton(By PassLocator) {
		WebElement element = driver.findElement(PassLocator);
		element.click();
	}
	//GET TEXT METHOD 
	public void getText(By PassLocator) {
		WebElement element = driver.findElement(PassLocator);
		String Text=element.getAttribute("value");
		System.out.println(Text);
	}
	//GET ATTRIBUTE
	public String getPlaceholder(By PassLocator) {
		WebElement element = driver.findElement(PassLocator);
		return element.getAttribute("placeholder");
	}
	//BY USING TEXT OF DROPDOWN.
	public void selectTextOnDropDown(By PassLocator, String EnterText) {

		Select selectValue = new Select(driver.findElement(PassLocator));
		selectValue.selectByVisibleText(EnterText);
	}
	public static int IndexNumber;
	//BY USING INDEX OF DROPDOWN.
	public void selectIndexeOnDropDown(By PassLocator, int IndexNumber) {

		Select selectValue = new Select(driver.findElement(PassLocator));
		selectValue.selectByIndex(IndexNumber);
	}
	//BY USING VALUE OF DROPDOWN.
	public void selectValueOnDropDown(By PassLocator, String EnterText) {

		Select selectValue = new Select(driver.findElement(PassLocator));
		selectValue.selectByValue(EnterText);;
	}

	//CHECK VALUE IN CHECK BOX
	public void selectValueOnCheckBox(By chkBoxCollection, By labelText, By getInput, String EnterText) {

		List<WebElement> chkBoxCollections = driver.findElements(chkBoxCollection);
		for (WebElement webElement : chkBoxCollections) {
			WebElement getLabel = webElement.findElement(labelText);
			WebElement getInput1 = webElement.findElement(getInput);

			if (getLabel.getText().equals(EnterText)) {
				if (!getInput1.isSelected()) {
					getLabel.click();
					break;
				}
			}
		}

	}
	//SWITCH TABS
	public void switchTabs() {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String parent_window = driver.getWindowHandle();
		Set<String> s1 = driver.getWindowHandles();
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String child_window = i1.next();
			if (!parent_window.equalsIgnoreCase(child_window)) {
				driver.switchTo().window(child_window);
				driver.close();
			}
		}

		driver.switchTo().window(parent_window);
	}

	//WAIT FOR ELEMENT VISIBLE 
	public void waitForElementVisible(By PassLocator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(PassLocator));

	}
	//WAIT FOR ELEMENT TO BE CLICKABLE
	public void waitForElementToBeClickable(By PassLocator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(PassLocator));
	}
	//WAIT FOR ELEMENT LOCATED
	public void waitForElementLocated(By PassLocator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(PassLocator));
	}
	//BY USING JAVA SCRIPT EXECUTOR OF CLICKING BUTON
	public void clickByJS(By PassLocator) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();",PassLocator);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " +PassLocator);
		}
	}
	//Maximize and minimize the screens
	//MAXIMIZE THE SCREEN
	public  void MaximizeScreen() {
		driver.manage().window().maximize();
	}
	public static int Length;
	//passing random alphabetic 
	public String generateRandomString(int Length){
		return RandomStringUtils.randomAlphabetic(Length);
	} 

	//for passing random numbers 
	public String generateRandomNumber(int Length){
		return RandomStringUtils.randomNumeric(Length);
	} 
	//for passing alpha numeric
	public static String generateRandomAlphanumeric(int Length) {
		return RandomStringUtils.randomAlphanumeric(Length);
	}
	//--------------------------------------------------------------------------------//
	public static int Seconds;
	public void WaitForSometime(int Seconds) throws InterruptedException {
		Thread.sleep(Seconds);
	}
	//Element To Be Clickable 
	public void  WaitUntilElementToBeClickable(By PassLocator) {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(PassLocator));
	}

	//Presence of Element Located 
	public  void  PresenceOfElementLocated(By PassLocator) {
		WebDriverWait wait = new WebDriverWait(driver,5);

		wait.until(ExpectedConditions.presenceOfElementLocated(PassLocator));
	}
	//Capturing ScreenSHot 
	public static String CaptureScreenShot(String Folder,String filename) throws IOException {
		File ts=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File srcFile=ts.getScreenshotAs(OutputType.FILE);
		String destFile="./reports/screenshots"+"/"+Folder+"/"+filename+".png";
		File Path=new File(destFile);
		FileUtils.copyFile(ts,Path);
		return destFile;


	}
	//CLoses The Windows
	//Close the Current window
	public void CloseCurrentWindow() {
		driver.close();
	}

	//Close The all Windows
	public void CloseAllWinows() {
		driver.quit();
	}
	//------------------------------------------------------------------------------------------------------------//
	//SCrolling 
	//I Scroll Up The Page
	public static void ScrollThePage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3000)"); //Vertical Scroll</p>
	}

	//I Scroll Up The Page
	public void ScrollParticularElement(By PassLocator) {
		WebElement element=driver.findElement(PassLocator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element); //Vertical Scroll</p>
	}

	//I Click By Using JavaScript executor
	public void ClickByJavaScript_Executor(By PassLocator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement button =driver.findElement(PassLocator);
		js.executeScript("arguments[0].click();", button);
	}

	//ASSERTIONS
	//// Assertion using try-catch block (for handling exceptions)
	public static String FolderName;
	public static String ImageName;
	public  void AssertElementIsPresentOrNot(By PassLocator,String FolderName,String ImageName) throws IOException {
		WebElement element = driver.findElement(PassLocator);
		String Text=element.getAttribute("value");
		System.out.println(Text);
		if(Text.equals(ImageName)) {
			TestBase.TakeScreenshot("Assertion passed:The actual Text is "+ImageName +" as expected.",FolderName,ImageName);
			CaptureScreenShot(FolderName,ImageName);
		}else {
			System.out.println("Assertion failed:"+ImageName +" Element is not as expected.");
			TestBase.TakeScreenshot("Assertion failed:The actual Text is "+ImageName +" is not expected",FolderName,ImageName);
			CaptureScreenShot(FolderName,ImageName);
			driver.close();
		}
	}
	//I_Enter_Value_By_Using_JavaScriptExecutor  
	public void EnterValueByUsingJSE(By PassLocator, String data) {
		//find the element in selenium webdriver
		WebElement userNameTxt = driver.findElement(PassLocator); 
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		// set the text
		jsExecutor.executeScript("arguments[0].value='"+data+"'", userNameTxt);  
		//get the text
		String text = (String) jsExecutor.executeScript("return arguments[0].value", userNameTxt);  
		System.out.println(text); 
	}

	//I_Verify_Element is present or not 
	public void VerifyElementIsPresentorNot(By PassLocator,String FolderName,String ImageName) throws InterruptedException, IOException {
		WebElement ele=driver.findElement(PassLocator);
		Thread.sleep(1000);
		if(ele.isDisplayed()) {
			TestBase.TakeScreenshot("Assertion failed:The actual Text is "+ImageName +" is not expected",FolderName,ImageName);
			CaptureScreenShot(FolderName,ImageName);
		}
		else {
			TestBase.TakeScreenshot("Assertion failed:The actual Text is "+ImageName +" is not expected",FolderName,ImageName);
			CaptureScreenShot(FolderName,ImageName);

		}
	}
}
