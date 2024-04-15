package com.QA.Application.Pages;

import org.openqa.selenium.By;

public class IdentityMappingPage  {	
	
	public static String identityAttribute = "Email";
		
	public static By identityResult = By.xpath("(//div[@class='x-grid-cell-inner '])[2]");
	public static By globalDropdown = By.xpath("(//span[@role='presentation'])[6]");
	public static By globalSetting = By.xpath("//*[contains(text(),'Global Settings')]");
	public static By identityMappings = By.xpath("//b[contains(text(),'Identity Mappings')]");
	
	public static By email = By.xpath("//div[contains(text(),'Email')]");
	public static By firstName = By.xpath("//div[contains(text(),'First Name')]");
	public static By lastName = By.xpath("//div[contains(text(),'Last Name')]");
	
	
	
	// Edit Identity Attribute
	public static By addSource = By.xpath("//span[contains(text(),'Add Source')]");
	public static By appValue = By.id("appSuggest-inputEl");
	public static By selectApp = By.xpath("//li[@class='x-boundlist-item']");
	public static By attributeValue = By.id("configForm:sourceAttributes");
	public static By addButton = By.xpath("(//span[contains(text(),'Add')])[4]");	
	public static By saveButton = By.id("configForm:saveButton");
	
	// Refresh Identity
	public static By refreshId = By.xpath("//div[contains(text(),'Refresh Identity Cube')]");
	public static By executeInBack = By.xpath("//span[contains(text(),'Execute In Background')]");
	public static By OKbutton = By.xpath("//span[contains(text(),'OK')]");
	
}
