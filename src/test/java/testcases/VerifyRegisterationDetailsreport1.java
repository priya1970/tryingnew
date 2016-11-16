package testcases;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.poi.ss.usermodel.Sheet;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignupforUserRegisteration;
//import Utility.Sheet;
//import Pages.SignupforUserRegisteration;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import junit.framework.Assert;
import utility.Helper;

public class VerifyRegisterationDetailsreport1 {
	
	ExtentReports report;
	ExtentTest logger;
	
	public WebDriver driver=new FirefoxDriver();
	public String baseUrl="http://demo.borland.com/InsuranceWebExtJS";
	String src=("E:\\SeleniumJava\\Scripts\\com.learnautomation.hybrid\\ApplicationTestData\\RegisterInsurance.xlsx");
	//FileInputStream fis=new FileInputStream(src);
	XSSFWorkbook wb;
		HomePage home= new HomePage(driver);
	SignupforUserRegisteration usereg1  =new SignupforUserRegisteration(driver);
	
	
	
	@BeforeMethod
	public void openApplication() throws InterruptedException 
	{
		driver.get(baseUrl);
		Thread.sleep(3000);
		report=new ExtentReports("E:\\SeleniumJava\\Scripts\\com.learnautomation.hybrid\\Reports\\testing.html",true);
		
	
		logger=report.startTest("Verify Test Signin");
		report.addSystemInfo("HostName","Priya")
		 .addSystemInfo("Environment","QA")
		 .addSystemInfo("User Name","Priya Murali");
		report.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
	 // driver=BrowserFactory.getBrowser("firefox");
		//driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.log(LogStatus.INFO,"Application is running");
		//driver.get(DataProviderFactory.getExcel().getClass());
	}
	
		@Test(priority=0)
		public void testHomePage()
		{
			logger = report.startTest("testHomePage");
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS,"Assert Pass");
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title=home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("InsuranceWeb: Home"));
		//System.out.println("the pafe info is"+title);
		
		logger.log(LogStatus.PASS,"Home Page loaded successfully and Verified");
		
		home.clickonsignuplink();
		
		Assert.assertTrue(title.contains("InsuranceWeb: Home"));
		logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver,"validation4")));				
		logger.log(LogStatus.PASS,"Signup page loaded Succesfully");
		}
			
		@Test(priority=1)
		public void UserRegisterationDetails() throws Exception, IOException
		{
			
			logger = report.startTest("UserRegisterationDetails");
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS,"Assert Pass");
			logger=report.startTest("UserRegisterationDetails");
			String sheetName="Sheet1";
			File file = new File(src);
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook  wb = new XSSFWorkbook(inputStream);
		  Sheet sht = wb.getSheet(sheetName);
		  int rowCount = sht.getLastRowNum()-sht.getFirstRowNum();
		  System.out.println("Row cont:" + rowCount);
		  
		 // logger.log(LogStatus.PASS, "UserRegisteration page loaded Succesfully");
		  
	    for (int i = 1; i < rowCount+1; i++)
	    {			  
				   Row row = sht.getRow(i);
				   

			usereg1.userregisterationdetails1(row); 
			String Actualtext=usereg1.getregisterpagetext();
			Assert.assertTrue(Actualtext.contains("Insurance Web: Account Details"));
			//String exptext="Your user name is "+"Create A New Account";
	    	//System.out.println(exptext);
 			//usereg1.clicksign();
 			logger.log(LogStatus.PASS,"Signup page loaded Succesfully");
		}
						
		}
	@AfterMethod
	public void teardown(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
		String path=Helper.captureScreenshot(driver, result.getName());
		logger.log(LogStatus.FAIL,logger.addScreenCapture(path));
		}
		
		report.endTest(logger);
			
		report.flush();
		
		driver.get("E:\\SeleniumJava\\Scripts\\com.learnautomation.hybrid\\Reports\\testing.html");

	}
	
	@AfterTest
	public void closeApplication()
	{
	 driver.close();
	 driver.quit();
	
	}
	
	
	}

