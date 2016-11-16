package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import factory.BrowserFactory;
import factory.DataProviderFactory;
import junit.framework.Assert;

public class VerifyHomePage {
	WebDriver driver;
	
	@BeforeMethod
	public void setup()
	{
	  driver=BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());	
	}
	
	@Test
	public void testHomePage()
	{
	
	HomePage home=PageFactory.initElements(driver, HomePage.class);
	String title=home.getApplicationTitle();
	Assert.assertTrue(title.contains("InsuranceWeb: Sign up"));
	
	System.out.println("My Application title is "+title);
	//BrowserFactory.closeBrowser(driver);
		
	}
	
	@AfterMethod
	public void teardown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}

	



