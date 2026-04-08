package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
		//driver=new ChromeDriver();//this works locally but fails in GitHub actions  linux runners has no visible Ui so  it must run in headless mode
		//driver.manage().window().maximize();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--headless=new");//no UI browser
		options.addArguments("--no-sandbox");// linux permission issue
		options.addArguments("--disable-dev-shm-usage");//memory crash issue
		options.addArguments("--window-size=1920,1080");
		driver=new ChromeDriver(options);
		  driver.get("https://www.saucedemo.com/");
		
	}
	@AfterMethod
	public void teardown() 
	{
		driver.quit();
	}
}
