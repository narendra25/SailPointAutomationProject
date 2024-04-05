package com.QA.Application.Pages;

import org.openqa.selenium.By;

public class TaskPageObjects {
	public static By btnSetUp = By.xpath("(//span[@role='presentation'])[5]");
	public static By btnTasks = By.xpath("(//a[contains(text(),'Tasks')])[1]");
	public static By btnAddNewTask = By.xpath("//em[@id='newTaskButton-btnWrap']");
	public static By btnAccountAggregartion=By.xpath("//span[contains(text(),'Account Aggregation')]");
	public static By txtTaskName=By.xpath("//input[@name='editForm:name']");
	//public static By 
}
