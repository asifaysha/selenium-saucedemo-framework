package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driverr) 
	
	{
		this.driver=driverr;//stores driver inside page class now page class can use browser actions 
		
	}
	By Username=By.id("user-name");
	By Password=By.id("password");
	By loginbtn=By.id("login-button");
	By errorMsg=By.cssSelector("h3[data-test='error']");
	
	public void login(String user,String pass) 
	{
		driver.findElement(Username).sendKeys(user);
		driver.findElement(Password).sendKeys(pass);
		driver.findElement(loginbtn).click();
		
	}
	public String getErrorMessage() 
	{
		return driver.findElement(errorMsg).getText();
	}
	

}
