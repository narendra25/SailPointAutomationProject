package com.QA.Application.Pages;

import org.openqa.selenium.By;

public class TaskActionsPage {
// EDit Page Objective
	public static By btnEditTask=By.xpath("//span[text()='Edit']//parent::a");
	public static By btnsaveAndExecute = By.xpath("//span[contains(text(),'Save and Execute')]");
	public static By OKButton = By.xpath("//span[contains(text(),'OK')]//parent::button");
	//Delete Objectives
	public static By btnDeleteTask=By.xpath("//span[text()='Delete']//parent::a");
	public static By btnDeleteTaskYes=By.xpath("//span[text()='Yes']//parent::button");
	public static By btnDeleteTaskNo=By.xpath("//span[text()='No']//parent::button");
	
	//Execute In Background
	public static By btnExecuteInBackground=By.xpath("(//img[@class='x-menu-item-icon executeNowBtn'])[3]//parent::a/span");
	public static By btnExecuteOk=By.xpath("//span[text()='OK']");
	
}
