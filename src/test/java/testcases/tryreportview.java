
	package testcases;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.xssf.usermodel.XSSFRow;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
	import Pages.SignupforUserRegisteration;
	import factory.BrowserFactory;
	import factory.DataProviderFactory;
	import junit.framework.Assert;
import utility.Helper;

	public class tryreportview  {
		ExtentReports report;
		ExtentTest logger;
		
		public WebDriver driver=new FirefoxDriver();
		public String baseUrl="http://demo.borland.com/InsuranceWebExtJS";
		String src=("E:\\SeleniumJava\\Scripts\\com.learnautomation.hybrid\\ApplicationTestData\\RegisterInsurance.xlsx");
		XSSFWorkbook wb;
		HomePage home= new HomePage(driver);
		SignupforUserRegisteration usereg1  =new SignupforUserRegisteration(driver);
		
		@BeforeTest
		public void openApplication() throws InterruptedException
		{
			driver.get(baseUrl);
			driver.manage().window().maximize();
			Thread.sleep(3000);
			report = new ExtentReports(System.getProperty("user.dir")+"/Reports/Myownreport.html",true);
			logger=report.startTest("Verify Test Signin");
			logger.log(LogStatus.INFO,"Application is Running");
			
		}
		 	
			@Test(priority=0)
			public void testHomePage()
			{
			logger=report.startTest("testHomePage");
			Assert.assertTrue(true);
			logger.log(LogStatus.PASS,"Assert True");
			HomePage home=PageFactory.initElements(driver, HomePage.class);
			home.clickonsignuplink();
			String title1=home.getApplicationTitle();
			Assert.assertTrue(title1.contains("InsuranceWeb: Sign up"));
			logger.log(LogStatus.PASS,"Signup page loaded");
			
					
		//	SignupforUserRegisteration usereg1=PageFactory.initElements(driver, SignupforUserRegisteration.class);
			
			}
				
			@Test(priority=1)
			public void UserRegisterationDetails() throws Exception, IOException
			{
				logger=report.startTest("UserRegisterationDetails");
				Assert.assertTrue(true);
				logger.log(LogStatus.PASS,"UserRegisteration Page Loaded");
				String sheetName="Sheet1";
				File file = new File(src);
				FileInputStream inputStream = new FileInputStream(file);
				XSSFWorkbook  wb = new XSSFWorkbook(inputStream);
			  Sheet sht = wb.getSheet(sheetName);
			  int rowCount = sht.getLastRowNum()-sht.getFirstRowNum();
			 
			  
		    for (int i = 1; i <rowCount+1; i++)
		    {			 
		    		   Row row = sht.getRow(i);
					     

				usereg1.userregisterationdetails1(row);
				
				String Name=usereg1.getregisterpagetext();
				Assert.assertTrue(Name.contains("Insurance Web: Account Details"));
	 			System.out.println("your page tile is"+Name);
				
	 		
	 		}
	 			 					
			}
			
						
			
			@AfterMethod
			public void teardown(ITestResult result)
			{
				if(result.getStatus()==ITestResult.FAILURE)
				{
				String path=Helper.captureScreenshot(driver, result.getName());
				logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
				}
				report.endTest(logger);
				report.flush();
				
			}
		 	    			
		@AfterTest
		public void closeApplication()
		{
		 driver.close();
		 driver.quit();
		
		}
		
	}



	

