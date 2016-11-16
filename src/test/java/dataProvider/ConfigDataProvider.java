package dataProvider;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfigDataProvider {

	
	Properties pro;
	public ConfigDataProvider()
	{
		File src=new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
		  pro=new Properties();
			pro.load(fis);
			
		} catch (Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
	}
	
	public String getApplicationUrl()
	{
		String url=pro.getProperty("url");
		return url;
		
	}
	
	
	
	public String getfirefoxPath()
	{
		String url=pro.getProperty("firefoxPath");
		return url;
		
	}
	
	public void getDriver(String appURL) {
	//	System.out.println(driver);
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get(appURL);
		
	}

	

	
	
	
	}
	
	
	

