package com.QA.Application.TestBase;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.QA.Application.Utilities.ReUsableMethods;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ApplicationReusableMethods.ApplicationReusableMethods;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
public class TestBase {
	public static Properties properties;
	public static org.openqa.selenium.WebDriver driver;
	public static ReUsableMethods webdriver = new ReUsableMethods();
	public static ApplicationReusableMethods Application=new ApplicationReusableMethods();
	public static Date date = new Date();
	public static SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	public static String dt = formatter.format(date);
	public static FileReader fileReader;
	public static ExtentHtmlReporter spark;
	public static ExtentTest test;
	public static ExtentReports extent;
	public static String reportDestination = "./reports/Reports__"+ dt+"/report_" + dt + ".html";
	public static String FolderName;
	public static String TestDescription;
	public static String ImageName;
	public static String LogDescription;  
	public static By PassLocator;
	public static String EnterText;
	protected static final Logger LOG = (Logger) LogManager.getLogger(TestBase.class);
	public static String IdentityMappingName;
	public static File file=new File(reportDestination);
	
	
	static String Concatnate=".";
	
	
	@BeforeSuite(alwaysRun = true)
	public void generateReports() throws Exception
	{
		propertiesLoad();
		extentReportSpark();
	}
	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		openBrowser();
		openURL("URL");

	}
	@AfterClass
	public void tearDown()  {
		driver.quit();
		
	}
	@AfterSuite(alwaysRun = true)
	public void closeReport() throws IOException
	{
		extent.flush();
		
		
		//This Below Code is Opening The Reports after test is complted
		Desktop.getDesktop().browse(file.toURI());
		
	}
	
	//CREATING EXTENT TEST REPORT
	public static void CreateExtentTest(String Url,String TestCase,String Category,String Author) {
		test = extent.createTest(Url,TestCase).assignCategory(Category).assignAuthor(Author);
	}
	
	//Take Screen Shot
		public static void TakeScreenshot(String TestDescription,String FolderName,String ImageName) throws IOException {
			String ScreenshotName=Concatnate+ReUsableMethods.CaptureScreenShot(FolderName,ImageName);
			ScreenCapture(TestDescription,ScreenshotName);

		}
		public static Object ScreenCapture(String LogDetails,String ImagePath) throws IOException {
			test.log(Status.PASS,LogDetails,MediaEntityBuilder.createScreenCaptureFromPath(ImagePath).build());
			return test;

		}
		//ExtentTest Information 
		public static void TestPass(String TextDescription) {
			test.pass(TextDescription);
		}
		public static void TestFail(String TextDescription) {
			test.fail(TextDescription);
		}
		public static void TestInfo(String TextDescription) {
			test.info(TextDescription);
		}
		//Logger Information 
		public static void LogInFo(String LogDescription) {
			LOG.info(LogDescription);
		}
		public static void LogWarn(String LogDescription) {
			LOG.warn(LogDescription);
		}
		public static void LogDeBug(String LogDescription) {
			LOG.debug(LogDescription);
		}
		public static void LogTrace(String LogDescription) {
			LOG.trace(LogDescription);
		}

	public void extentReportSpark() {
		
		spark= new ExtentHtmlReporter(file);
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("OS", System.getProperty("os.name"));
		extent.setSystemInfo("Browser Name", properties.getProperty("BrowserName"));
		extent.setSystemInfo("Environment", properties.getProperty("Environment"));
		extent.setSystemInfo("Base URL", properties.getProperty("URL"));
		extent.setSystemInfo("User Name", properties.getProperty("UserName"));
		extent.setSystemInfo("User Email", properties.getProperty("UserEmail"));
		spark.config().setDocumentTitle("Sample Automation Testing Report");
		spark.config().setReportName("Sample Automation Test Suite");
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		String css = ".r-img {width: 75%;}";
	    spark.config().setCSS(css);
	}

	public void propertiesLoad() throws IOException {

		try {
			properties = new Properties();
			String filePath=System.getProperty("user.dir");
			System.out.println(filePath);

			FileInputStream file=new FileInputStream(filePath+"/src/main/java/com/QA/Application/Configuration/config.properties");
			properties.load(file);
		} catch (FileNotFoundException ex) {
			test.info("*************************************************");
			test.info("Property file you are looking for does not exist.");
			test.info("*************************************************");

		} catch (IOException e) {
			System.out.println("io exception");
		}
	}

	public static void openURL(String url) {

		try {
			driver.get(properties.getProperty(url));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			test.log(Status.INFO,"URL is does not exist");

		}

	}

	public void openBrowser() {

		if (properties.getProperty("BrowserName").equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setHeadless(false);
			options.addArguments("start-maximized"); // open Browser in maximized mode
			options.addArguments("disable-infobars"); // disabling infobars
			options.addArguments("--disable-extensions"); // disabling extensions
			options.addArguments("--disable-gpu"); // applicable to Windows os only
			options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
			options.addArguments("--no-sandbox"); // Bypass OS security model
			options.addArguments("--disable-in-process-stack-traces");
			options.addArguments("--disable-logging");
			options.addArguments("--log-level=3");
			options.addArguments("--remote-allow-origins=*");
			options.setExperimentalOption("detach", true);
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\na21279\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
			driver = new ChromeDriver(options);
			//driver=new ChromeDriver();
			//System.setProperty("webdriver.chrome.logfile", "./logs/chromeLogs.txt");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} else if (properties.getProperty("BrowserName").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			//System.setProperty("webdriver.edge.driver","C:\\Users\\na21279\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
			//System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "./logs/FirefoxLogs.txt");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} else {
			driver = new SafariDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}
	}
