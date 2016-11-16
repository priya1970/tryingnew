package testcases;




import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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

public class VerifyRegisterationDetailsreport {
	
	ExtentReports report;
	ExtentTest logger;
	
	public WebDriver driver;
	public String baseUrl="http://demo.borland.com/InsuranceWebExtJS";
	String src=("E:\\SeleniumJava\\Scripts\\com.learnautomation.hybrid\\ApplicationTestData\\RegisterInsurance.xlsx");
	//FileInputStream fis=new FileInputStream(src);
	XSSFWorkbook wb;
		HomePage home= new HomePage(driver);
	SignupforUserRegisteration usereg1  =new SignupforUserRegisteration(driver);
	
	
	
	@BeforeTest
	public void setup()
	{
		
		report=new ExtentReports("E:\\SeleniumJava\\Scripts\\com.learnautomation.hybrid\\Reports\\signin.html",true);
	
		logger=report.startTest("Verify Test Signin");
		
	  driver=BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.log(LogStatus.INFO,"Application is running");
		//driver.get(DataProviderFactory.getExcel().getClass());
	}
	
		@Test(priority=0)
		public void testHomePage()
		{
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title=home.getApplicationTitle();
		
		Assert.assertTrue(title.contains("InsuranceWeb: Home"));
		//System.out.println("the pafe info is"+title);
		
		logger.log(LogStatus.PASS,"Home Page loaded successfully and Verified");
		
		home.clickonsignuplink();
		
		//Assert.assertTrue(title.contains("InsuranceWeb: Sign up"));
				
		logger.log(LogStatus.INFO,"Signup page loaded Succesfully");
		}
			
		@Test(priority=1)
		public void UserRegisterationDetails() throws Exception, IOException
		{
			String sheetName="Sheet1";
			File file = new File(src);
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook  wb = new XSSFWorkbook(inputStream);
		  Sheet sht = wb.getSheet(sheetName);
		  int rowCount = sht.getLastRowNum()-sht.getFirstRowNum();
		  System.out.println("Row cont:" + rowCount);
		  
	    for (int i = 1; i < rowCount+1; i++)
	    {			  
				   Row row = sht.getRow(i);
				   

			usereg1.userregisterationdetails1(row); 
			String Actualtext=usereg1.getregisterpagetext();
			Assert.assertTrue(Actualtext.contains("Insurance Web: Account Details"));
			//String exptext="Your user name is "+"InsuranceWeb: Sign up";
	    	//System.out.println(exptext);
 			//usereg1.clicksign();
	  		
		}
						
		}
	@AfterTest
	public void teardown()
	{
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

	
	}

