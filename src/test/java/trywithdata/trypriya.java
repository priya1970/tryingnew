package trywithdata;


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
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.AfterTest;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.Test;
	import org.apache.poi.ss.usermodel.Sheet;
	import Pages.HomePage;
	import Pages.LoginPage;
	import Pages.SignupforUserRegisteration;
import dataProvider.ExcelDataProvider;
//import Utility.Sheet;
	//import Pages.SignupforUserRegisteration;
	import factory.BrowserFactory;
	import factory.DataProviderFactory;
	import junit.framework.Assert;

	public class trypriya {
		
		public WebDriver driver=new FirefoxDriver();
		
		//public String baseUrl="http://demo.borland.com/InsuranceWebExtJS";
			
		String src=("E:\\SeleniumJava\\Scripts\\com.learnautomation.hybrid\\ApplicationTestData\\RegisterInsurance.xlsx");
		
		XSSFWorkbook wb;
			HomePage home= new HomePage(driver);
		SignupforUserRegisteration usereg1  =new SignupforUserRegisteration(driver);

		
		@BeforeTest
		public void setup()
		{
		  driver=BrowserFactory.getBrowser("firefox");
			driver.get(DataProviderFactory.getConfig().getApplicationUrl());
			
		}
		 	
			@Test(priority=0)
			public void testHomePage()
			{
			
			HomePage home=PageFactory.initElements(driver, HomePage.class);
			home.clickonsignuplink();
			String title1=home.getApplicationTitle();
			Assert.assertTrue(title1.contains("InsuranceWeb: Sign up"));
					
			SignupforUserRegisteration usereg1=PageFactory.initElements(driver, SignupforUserRegisteration.class);
			
			}
				
			@Test(priority=1)
			public void UserRegisterationDetails() throws Exception, IOException
			{
				//DataProviderFactory excel1=new DataProviderFactory();
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
	 		
		    wb.close();
		       inputStream.close(); 
		      
		 				
			}
						
		 	    			
		@AfterTest
		public void closeApplication()
		{
		// driver.close();
		 driver.quit();
		
		}
		
	}


	
	
	
	

