package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
//import org.apache.poi.ss.formula.functions.Rows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignupforUserRegisteration
{
	
	
	WebDriver driver;
	
	String src="E:\\SeleniumJava\\Scripts\\com.learnautomation.hybrid\\ApplicationTestData\\RegisterInsurance.xlsx";
	//File src=new File("./ApplicationTestData/RegisterInsurance.xlsx");
	//FileInputStream fis=new FileInputStream(src);
	XSSFWorkbook wb;
	
	@FindBy(name="signup:fname")WebElement firstnametxt;
	@FindBy(name="signup:lname") WebElement lastnametxt;
	@FindBy(name="BirthDate") WebElement birthdatetxt;
	@FindBy(name="signup:email")WebElement emailAddresstxt;
	@FindBy(name="signup:street")WebElement mailingAddresstxt;
	@FindBy(name="signup:city")	WebElement citytxt;
	@FindBy(name="signup:state")WebElement statetxt;
	@FindBy(name="signup:zip")WebElement postalCodetxt;
	@FindBy(name="signup:password")WebElement passwordtxt;
	@FindBy(xpath=".//*[@id='signup:signup']")WebElement Signup;
	@FindBy(name="signup:continue")	WebElement continuebtn;
	@FindBy(xpath=".//*[@id='home']/a")WebElement Homelink;
//	@FindBy(xpath=".//*[@id='content-main']")WebElement Body;
	@FindBy(id="logout-form:logout")WebElement signoff;
	@FindBy(id="login-form:signup")WebElement signonlink;
	
	public SignupforUserRegisteration(WebDriver driver)

	{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	
	
public  void userregisterationdetails1 (Row row) throws InterruptedException, IOException
{
	
	
	
	firstnametxt.sendKeys(row.getCell(0).getStringCellValue());
	lastnametxt.sendKeys(row.getCell(1).getStringCellValue());
	birthdatetxt.sendKeys(row.getCell(2).getStringCellValue());
	emailAddresstxt.sendKeys(row.getCell(3).getStringCellValue());
	mailingAddresstxt.sendKeys(row.getCell(4).getStringCellValue());
	citytxt.sendKeys(row.getCell(5).getStringCellValue());
	statetxt.sendKeys(row.getCell(6).getStringCellValue());
	postalCodetxt.sendKeys(row.getCell(7).toString());
	passwordtxt.sendKeys(row.getCell(8).toString());
	//WebDriverWait wait2 = new WebDriverWait(driver,30);	
	//wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='signup:signup']")));
 	Signup.click();
	continuebtn.click();
	
	WebDriverWait wait3 = new WebDriverWait(driver,30);	
	wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='home']/a")));
 	
	Homelink.click();
	WebDriverWait wait4 = new WebDriverWait(driver,30);	
	wait4.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout-form:logout")));
 	
	signoff.click();
	Thread.sleep(7000);
	
	signonlink.click();
	
}



public String getregisterpagetext()
{   
	String title="Insurance Web: Account Details";
	
	Assert.assertTrue(title.contains(("Insurance Web: Account Details")));
 	//System.out.println( " the actual value:"+title);
return title;
}
	

}


