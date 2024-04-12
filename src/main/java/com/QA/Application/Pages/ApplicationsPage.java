package com.QA.Application.Pages;

import org.openqa.selenium.By;

public class ApplicationsPage {
	public static By btnApplications = By.xpath("(//span[@role='presentation'])[3]");
	public static By btnApplicationDefination = By.xpath("(//a[contains(text(),'Application Definition')])[1]");
	public static By btnAddNewApplication = By.xpath("//span[contains(text(),'Add New Application')]");
	
	//Delimiter --//
	public static By txtApplicationName = By.id("editForm:appName");
	public static By selectOwner=By.xpath("//div[@id='ext-gen1067']");
	public static By txtOwnerName=By.id("applicationPageOwner-inputEl");
	public static By selectOwnerName=By.xpath("//div[contains(text(),'The Administrator')]");
	public static By selectApplicationType=By.id("editForm:connector");
	public static By selectAuthoritativeApplication =By.xpath("//span[contains(text(),'Authoritative Application')]//parent::td/child::input");
	public static By btnApplicationSave=By.xpath("//input[@name='editForm:saveAppBtn']");
	public static By btnConfiguration=By.xpath("//span[contains(text(),'Configuration')]");
	public static By txtFilePath=By.xpath("//span[contains(text(),'File Path')]//parent::div/parent::div/child::input");
	public static By txtDelimiter=By.xpath("//span[contains(text(),'Delimiter')]//parent::div//parent::div/child::input");
	public static By chkFilehascolumnheaderonfirstline=By.xpath("(//span[contains(text(),'File has column header on first line')]//parent::div/parent::div/child::div/child::input)[1]");
	public static By btnDelimiterTestConnection=By.xpath("//span[contains(text(),'Test Connection')]");
	public static By btnSchema=By.xpath("(//span[contains(text(),'Schema')])[1]");
	public static By txtDelimiterIdentityAttribute=By.xpath("//span[contains(text(),'Identity Attribute')]//parent::div/parent::div/child::div/child::input");
	public static By txtDelimiterDisplayAttribute=By.xpath("//span[contains(text(),'Display Attribute')]//parent::div/parent::div/child::div/input");
	public static By btnDelimiterDiscoverSchemaAttribute=By.xpath("//span[contains(text(),'Discover Schema Attributes')]");
	public static By btnDelimiterPreview=By.xpath("//input[@value='Preview']");
	public static By btnDelimiterPreviewClose=By.xpath("(//span[contains(text(),'Preview')]//parent::div//parent::div//parent::div)[4]/img");
	public static By btnDelimiterSave=By.name("editForm:saveAppBtn");
	
	//----Add Object Type --//
	public static By btnAddObjectType=By.xpath("//span[contains(text(),'Add Object Type')]");
	public static By txtNameObjectType=By.xpath("(//td[@role='presentation'])[9]/input");
	public static By btnOkObjectType=By.xpath("//span[text()='OK']");
	public static By txtObjectFilepath=By.xpath("(//span[contains(text(),'File Path')]//parent::div/parent::div/child::input)[2]");
	public static By txtObjectDelimiter=By.xpath("(//span[contains(text(),'Delimiter')]//parent::div//parent::div/child::input)[2]");
	public static By chkObjectFilehascolumnheaderonfirstline=By.xpath("(//span[contains(text(),'File has column header on first line')]//parent::div/parent::div/child::div/child::input)[3]");
	public static By txtObjectDelimiterIdentityAttribute=By.xpath("(//span[contains(text(),'Identity Attribute')]//parent::div/parent::div/child::div/child::input)[2]");
	public static By txtObjectDelimiterDisplayAttribute=By.xpath("(//span[contains(text(),'Display Attribute')]//parent::div/parent::div/child::div/input)[2]");
	public static By btnObjectDiscoverSchemaAttribute=By.xpath("(//span[contains(text(),'Discover Schema Attributes')])[2]");
	public static By btnObjectPreview=By.xpath("(//input[@value='Preview'])[2]");
	public static By btnObjectPreviewClose=By.xpath("(//span[contains(text(),'Preview')]//parent::div//parent::div//parent::div)[4]/img");

	//JDBC--//
	public static By txtConnectionUser=By.xpath("//span[contains(text(),'Connection User')]//parent::td/parent::tr/parent::tbody/child::tr[2]/td/input");
	public static By txtConnectionPassword=By.xpath("//span[contains(text(),'Connection Password')]//parent::td/parent::tr/parent::tbody/child::tr[4]/td/input");
	public static By txtDataBaseURL=By.xpath("//span[contains(text(),'Database URL')]//parent::td/parent::tr/parent::tbody/child::tr[6]/td/input");
	public static By txtSQLStatment=By.xpath("(//span[contains(text(),'Use Stored Procedure')]//parent::td/parent::tr/parent::tbody)[2]/tr[2]/td/textarea");
	public static By btnTestConnection=By.xpath("(//span[contains(text(),'Test Connection')])[2]");
	public static By tabSchema=By.xpath("(//span[contains(text(),'Schema')])[1]");
	public static By txtJDBCIdentityAttribute=By.xpath("//span[contains(text(),'Identity Attribute')]//parent::div/parent::div/child::div/child::input");
	public static By txtDispalyAttribute=By.xpath("//span[contains(text(),'Display Attribute')]//parent::div/parent::div/child::div/input");
	public static By btnDiscoverSchemaAttribute=By.xpath("//span[contains(text(),'Discover Schema Attributes')]");
	public static By btnPreview=By.xpath("//input[@value='Preview']");
	public static By btnPreviewClose=By.xpath("(//span[contains(text(),'Preview')]//parent::div//parent::div//parent::div)[4]/img");
}
