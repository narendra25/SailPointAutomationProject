package com.QA.DataDrivenScripts;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.QA.Application.Pages.ApplicationsPage;
import com.QA.Application.Pages.LoginPage;
import com.QA.Application.TestBase.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ShadDom extends TestBase{
	public static void main(String[] args) {
        // Create a Calendar instance
        Calendar cal = Calendar.getInstance();
        
        // Get the current time as a Date object
        Date time = cal.getTime();
        
        // Convert the Date object to a timestamp string
        String timestamp = time.toString().replace(":", "").replace(" ", "");
        
        // Print the timestamp
        System.out.println("Timestamp: " + timestamp);
    }
	

}
