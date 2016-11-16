package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
@FindBy(id="login-form:email")WebElement username;
@FindBy(id="login-form:password")WebElement password;
@FindBy(id="login-form:login")WebElement login;	
	
public void loginApplication(String user,String pass)
{
	username.sendKeys(user);
	password.sendKeys(pass);
	login.click();
	
}
}

