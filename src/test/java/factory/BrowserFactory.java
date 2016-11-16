package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dataProvider.ConfigDataProvider;

public class BrowserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getBrowser(String browsername)
	{
		if(browsername.equalsIgnoreCase("firefox"))
		{
			ConfigDataProvider config=new ConfigDataProvider();
			System.setProperty("WebDriver.firefox.driver",DataProviderFactory.getConfig().getfirefoxPath());
		 driver=new FirefoxDriver();
		 
	    }
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}

public static void closeBrowser(WebDriver driver)
{
	driver.close();
	 driver.quit();
}

	
}