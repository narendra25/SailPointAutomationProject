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


	import java.util.*;

	class GFG 
	{
		static String removeDuplicate(char str[], int n)
		{
			// Used as index in the modified string
			int index = 0;

			// Traverse through all characters
			for (int i = 0; i < n; i++)
			{

				// Check if str[i] is present before it 
				int j;
				for (j = 0; j < i; j++) 
				{
					if (str[i] == str[j])
					{
						break;
					}
				}

				// If not present, then add it to
				// result.
				if (j == i) 
				{
					str[index++] = str[i];
				}
			}
			return String.valueOf(Arrays.copyOf(str, index));
		}

		// Driver code
		public static void main(String[] args)
		{
			char str[] = "geeksforgeeks".toCharArray();
			int n = str.length;
			System.out.println(removeDuplicate(str, n));
		}
	}
	
	// This code is contributed by Rajput-Ji


