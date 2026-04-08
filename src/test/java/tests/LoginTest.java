package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.baseTest;
import pages.LoginPage;

public class LoginTest extends baseTest{
	
@Test //[Execution flow STEP2: Test enters ]
	public void invalidLoginTest() 
	{
		
		LoginPage login=new LoginPage(driver); //it is constructor (it runs automatically when object is created)call driver from baseTest is passed here.[Execution flow STEP3: creates page object]
		login.login("wrong_user", "wrong_pass");//[Execution flow STEP4:calls method]
		String actualError=login.getErrorMessage();//[Execution flow STEP5:calls method]
		String expectedError="Epic sadface: Username and password do not match any user in this service";
		Assert.assertEquals(actualError, expectedError);
	}
@Test
	public void ValidLoginTest() 
	{
		LoginPage login=new LoginPage(driver);
		login.login("standard_user", "secret_sauce");
		String actualUrl=driver.getCurrentUrl();
		String expectedUrl="https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actualUrl,expectedUrl,"Valid Login Failed");
		
	}
	@Test
	public void LockeduserTest() 
	{
		LoginPage login=new LoginPage(driver);
		login.login("locked_out_user", "secret_sauce");
	String actualError=	login.getErrorMessage();
	String ExpectedError="Epic sadface: Sorry, this user has been locked out.";
	Assert.assertEquals(actualError, ExpectedError,"Locked user validation failed");
	}
}