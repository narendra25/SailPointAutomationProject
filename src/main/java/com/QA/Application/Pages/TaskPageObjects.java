package com.QA.Application.Pages;

import org.openqa.selenium.By;

public class TaskPageObjects {
	public static By btnSetUp = By.xpath("(//span[@role='presentation'])[5]");
	public static By btnTasks = By.xpath("(//a[contains(text(),'Tasks')])[1]");
	public static By btnAddNewTask = By.xpath("//em[@id='newTaskButton-btnWrap']");
	public static By btnAccountAggregartion=By.xpath("//span[contains(text(),'Account Aggregation')]");
	public static By txtTaskName=By.xpath("//input[@name='editForm:name']");
	public static By btnTaskDropdown=By.id("ext-gen1125");
	public static By selectTaskName=By.xpath("//div[contains(text(),'EmployeeDetailsAuth')]");
	public static By saveAndExecute = By.xpath("//span[contains(text(),'Save and Execute')]");
	public static By OKButton = By.xpath("//span[contains(text(),'OK')]//parent::button");
}
