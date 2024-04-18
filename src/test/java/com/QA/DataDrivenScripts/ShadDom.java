package com.QA.DataDrivenScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadDom {
	static WebDriver driver;
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\na21279\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver=(WebDriver) new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ojasinnovativetechnologies.greythr.com/uas/portal/auth/login?");
		Thread.sleep(10000);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("21279");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Nar@25081996");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[text()=' Log in ']")).click();
	Thread.sleep(5000);
	// Assume 'driver' is an instance of WebDriver

	// Find the host element containing the shadow DOM
	WebElement hostElement = driver.findElement(By.tagName("gt-ess-menu"));

	// Use JavaScriptExecutor to access the shadow root
	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", hostElement);

	// Use standard Selenium locators to locate shadow DOM elements within the shadow root
	WebElement shadowElement = shadowRoot.findElement(By.cssSelector("nav > ul > span:nth-child(1) > li > a > span"));

	// Interact with the shadow DOM element
	shadowElement.click();
	}

static WebElement getShadowDam(WebElement element ,WebDriver driver) {
	JavascriptExecutor js=(JavascriptExecutor)driver;
	WebElement shadowdom1=(WebElement)js.executeScript("return arguments[0].shadowRoot",element);
	return shadowdom1;
	
}
}