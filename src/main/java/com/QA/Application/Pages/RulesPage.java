package com.QA.Application.Pages;

import org.openqa.selenium.By;

public class RulesPage {
public static By btnRulesTab=By.xpath("(//span[contains(text(),'Rules')])[1]");
public static By btnCorrelationRule=By.xpath("(//input[@class='ruleEditorBtn'])[1]");
public static By txtCorrelationRuleName=By.xpath("//input[@class='ruleEditorField x-form-field x-form-text']");
public static By txtRuleEditor=By.id("source-inputEl");
public static By btncancelCrossButton=By.xpath("(//img[@role='presentation'])[5]");
public static By btnSaveButton=By.xpath("(//span[contains(text(),'Save')])[1]");
public static By btnCancelButton=By.xpath("(//span[contains(text(),'Cancel')])[2]");

///Creation rule///
public static By btnCreationRule=By.xpath("(//input[@class='ruleEditorBtn'])[2]");
public static By txtCreationRuleName=By.xpath("//input[@class='ruleEditorField x-form-field x-form-text']");


//DYnamic Xpath Of Rules
}
