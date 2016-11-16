package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
	public HomePage(WebDriver ldriver)
	{
		this.driver=ldriver;
		
	}
	@FindBy(id="login-form:signup")WebElement signonlink;

	public void Home(WebDriver driver){
		this.driver = driver;
		//This initElements method will create  all WebElements
		PageFactory.initElements(driver, this);
	}

  
public void clickonsignuplink()
{
	signonlink.click();
	System.out.println("after signup link method");
}

public String getApplicationTitle()
{
return driver.getTitle();
}




}