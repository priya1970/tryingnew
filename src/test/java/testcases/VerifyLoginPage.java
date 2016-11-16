package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import junit.framework.Assert;

public class VerifyLoginPage {
WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
	  driver=BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());	
	}
	
	@Test
	public void testHomePage() throws Exception
	{
	
	HomePage home=PageFactory.initElements(driver, HomePage.class);
	String title=home.getApplicationTitle();
	Assert.assertTrue(title.contains("InsuranceWeb: Sign up"));
	System.out.println("The homepage"+title);
	Thread.sleep(5000);
	LoginPage login=PageFactory.initElements(driver,LoginPage.class);
	//login.loginApplication(DataProviderFactory.getExcel().getData(0,0,0),DataProviderFactory.getExcel().getData(0,0,1));
	
	}
	
	@AfterMethod
	public void teardown()
	{
		BrowserFactory.closeBrowser(driver);
	}


}
