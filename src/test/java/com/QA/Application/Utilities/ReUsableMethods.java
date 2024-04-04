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
	//Enter Text by using locator
	public void enterText(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.sendKeys(text);

	}
	//Clear Text Method
	public void clearText(By locator) {

		WebElement element = driver.findElement(locator);
		element.clear();
	}
	//Click Button
	public void clickOnButton(By locator) {
		WebElement element = driver.findElement(locator);
		element.click();
	}
	//GET TEXT METHOD 
	public void getText(By locator) {
		WebElement element = driver.findElement(locator);
		String Text=element.getAttribute("value");
		System.out.println(Text);
	}
	//GET ATTRIBUTE
	public String getPlaceholder(By locator) {
		WebElement element = driver.findElement(locator);
		return element.getAttribute("placeholder");
	}
	//BY USING TEXT OF DROPDOWN.
	public void selectTextOnDropDown(By locator, String Text) {

		Select selectValue = new Select(driver.findElement(locator));
		selectValue.selectByVisibleText(Text);
	}
	//BY USING INDEX OF DROPDOWN.
	public void selectIndexeOnDropDown(By locator, int index) {

		Select selectValue = new Select(driver.findElement(locator));
		selectValue.selectByIndex(index);
	}
	//BY USING VALUE OF DROPDOWN.
	public void selectValueOnDropDown(By locator, String Text) {

		Select selectValue = new Select(driver.findElement(locator));
		selectValue.selectByValue(Text);;
	}

	//CHECK VALUE IN CHECK BOX
	public void selectValueOnCheckBox(By chkBoxCollection, By labelText, By getInput, String Text) {

		List<WebElement> chkBoxCollections = driver.findElements(chkBoxCollection);
		for (WebElement webElement : chkBoxCollections) {
			WebElement getLabel = webElement.findElement(labelText);
			WebElement getInput1 = webElement.findElement(getInput);

			if (getLabel.getText().equals(Text)) {
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
	public void waitForElementVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	//WAIT FOR ELEMENT TO BE CLICKABLE
	public void waitForElementToBeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	//WAIT FOR ELEMENT LOCATED
	public void waitForElementLocated(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	//BY USING JAVA SCRIPT EXECUTOR OF CLICKING BUTON
	public void clickByJS(By locator) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", locator);
		} catch (NoSuchElementException e) {
			System.out.println("Element not found: " + locator);
		}
	}
	//Maximize and minimize the screens
	//MAXIMIZE THE SCREEN
	public  void MaximizeScreen() {
		driver.manage().window().maximize();
	}

	//passing random alphabetic 
	public static String generateRandomString(int length){
		return RandomStringUtils.randomAlphabetic(length);
	} 

	//for passing random numbers 
	public String generateRandomNumber(int length){
		return RandomStringUtils.randomNumeric(length);
	} 
	//for passing alpha numeric
	public static String generateRandomAlphanumeric(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}
	//--------------------------------------------------------------------------------//
	public void WaitForSometime(int mins) throws InterruptedException {
		Thread.sleep(mins);
	}
	//Element To Be Clickable 
	public void  WaitUntilElementToBeClickable(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	//Presence of Element Located 
	public  void  PresenceOfElementLocated(By locator) {
		WebDriverWait wait = new WebDriverWait(driver,5);

		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	//Capturing ScreenSHot 
	public static String CaptureScreenShot(String Folder,String filename) throws IOException {
		File ts=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File srcFile=ts.getScreenshotAs(OutputType.FILE);
		String destFile="./reports/screenshots/"+Folder+"/"+filename+".png";
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
	public void ScrollParticularElement(By locator) {
		WebElement element=driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element); //Vertical Scroll</p>
	}

	//I Click By Using JavaScript executor
	public static void ClickByJavaScript_Executor(By locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement button =driver.findElement(locator);
		js.executeScript("arguments[0].click();", button);
	}

	//ASSERTIONS
	//// Assertion using try-catch block (for handling exceptions)
	public  void AssertElementIsPresentOrNot(By locator,String Folder,String text) throws IOException {
		WebElement element = driver.findElement(locator);
		String Text=element.getAttribute("value");
		System.out.println(Text);
		if(Text.equals(text)) {
			TestBase.TakeScreenshot("Assertion passed:The actual Text is "+text +" as expected.",Folder,text);
			CaptureScreenShot(Folder,text);
		}else {
			System.out.println("Assertion failed:"+text +" Element is not as expected.");
			TestBase.TakeScreenshot("Assertion failed:The actual Text is "+text +" is not expected",Folder,text);
			CaptureScreenShot(Folder,text);
			driver.close();
		}
	}
	//I_Enter_Value_By_Using_JavaScriptExecutor  
	public void EnterValueByUsingJSE(By locator, String data) {
		//find the element in selenium webdriver
		WebElement userNameTxt = driver.findElement(locator); 
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;  
		// set the text
		jsExecutor.executeScript("arguments[0].value='"+data+"'", userNameTxt);  
		//get the text
		String text = (String) jsExecutor.executeScript("return arguments[0].value", userNameTxt);  
		System.out.println(text); 
	}

	//I_Verify_Element is present or not 
	public void VerifyElementIsPresentorNot(By locator,String Folder,String text) throws InterruptedException, IOException {
		WebElement ele=driver.findElement(locator);
		Thread.sleep(1000);
		if(ele.isDisplayed()) {
			String s=ele.getText();
			TestBase.TakeScreenshot("Assertion failed:The actual Text is "+text +" is not expected",Folder,text);
			CaptureScreenShot(Folder,text);
		}
		else {
			TestBase.TakeScreenshot("Assertion failed:The actual Text is "+text +" is not expected",Folder,text);
			CaptureScreenShot(Folder,text);

		}
	}
}
