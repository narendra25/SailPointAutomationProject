package com.QA.Application.Pages;

import org.openqa.selenium.*;

public class AppCorrelationPage {
	
	// New Correlation
	public static By btnCorrelation = By.xpath("(//span[contains(text(),'Correlation')])[1]");
	public static By btnNew = By.id("newWizardButton");
	public static By btnWizardNext = By.id("wizard-next");
	public static By btnConfigName = By.id("editForm:configurationName");
    public static By btnConfigNext = By.id("wizard-next-btnInnerEl");
    public static By btnConfigAttributeNext = By.xpath("//span[text()='Next']");
    
    public static By selectAppAttribute = By.id("editForm:applicationAttributeSelection");
    public static By selectIdentityAttribute = By.id("editForm:extendedAttributeSelection");
    public static By btnSave = By.xpath("//span[contains(text(),'Save')]");
    
	// Manager Correlation
    public static By btnManagerCorrelation = By.xpath("//div[contains(text(),'Manager Correlation')]");
    //public static By select
}
