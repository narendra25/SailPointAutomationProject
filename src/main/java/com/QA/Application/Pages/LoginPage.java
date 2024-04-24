package com.QA.Application.Pages;

import org.openqa.selenium.By;

public class LoginPage {
	//Login Page Locators
		public static By txtUserName = By.xpath("//input[@name='loginForm:accountId']");
	    public static By txtPassword = By.id("loginForm:password");
	    public static By btnLogIn=By.id("loginForm:loginButton");
	    
	    
	//Logout Locators
	    public static By btnLogOutDropDown=By.xpath("//span[contains(text(),'The Administrator')]");
	    public static By btnLogout=By.xpath("//a[@onclick='doLogout(); return false;']");
}
