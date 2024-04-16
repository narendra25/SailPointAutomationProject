package com.QA.Application.Pages;

import org.openqa.selenium.By;

public class DebugPage {
	
	public static By btnobject = By.xpath("(//div[@role='button'])[1]");
	public static By txtenterAppName = By.xpath("//input[@placeholder='Select an object']");
	public static By btnselectApp = By.xpath("//*[text()='Application']");
	public static By txtfilterName = By.xpath("//input[@placeholder='Filter by Name or ID']");
	public static By btnsearch = By.xpath("(//div[@role='button'])[3]");
	
	public static By btncheckboxResult = By.xpath("(//div[@class='x-grid-row-checker'])[1]");
	public static By btnAction = By.xpath("(//div[@role='button'])[5]");
	public static By btnDelete = By.xpath("//li[contains(text(),'Delete')]");
	public static By btnNew = By.xpath("//li[contains(text(),'New')]");
	
	public static By txtObjEditer = By.xpath("//*[@id=\"cmEditor-editorEl\"]/div/div[6]/div[1]/div/div/div/div[5]/div/pre");
	public static By btnSave = By.xpath("//span[contains(text(),'Save')]");
	public static By btnYes = By.xpath("//span[contains(text(),'Yes')]");

}
