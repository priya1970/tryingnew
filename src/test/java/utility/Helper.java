package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static String captureScreenshot(WebDriver driver,String screenshotname)
	{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	String destination="E:\\SeleniumJava\\Scripts\\com.learnautomation.hybrid\\Screenshots\\"+screenshotname+System.currentTimeMillis()+".png";
	try {
		FileUtils.copyFile(src,new File(destination));
	} catch (IOException e) {
		System.out.println("Failed to capture screenshots"+e.getMessage());
	}
	return destination;
		
	}
	}
	
	

