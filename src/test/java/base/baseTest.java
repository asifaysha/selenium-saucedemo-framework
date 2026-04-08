package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

//BaseTest contains reusable setup logic: browser launch,maximize,URL,teardown,waits (avoids duplicate code)
//All test classes will extend this class.
public class baseTest {
	
	public WebDriver driver;
    @BeforeMethod //[Execution flow STEP1: TestNG starts and launches browser in baseTest]
	public void setup() 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		  driver.get("https://www.saucedemo.com/");
		
	}
	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}
}
