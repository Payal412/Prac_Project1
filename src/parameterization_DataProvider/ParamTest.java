package parameterization_DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamTest {

	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	void setup(String nameofbrowser) throws InterruptedException
	{
		if(nameofbrowser.equals("chrome"))
		{
			// Set up WebDriver
	        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		if(nameofbrowser.equals("edge"))
		{
			// Set up WebDriver
	        System.setProperty("webdriver.edge.driver", "E:\\edgedriver_win32\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	
	@Test(priority=1)
	void testLogo()
	{
		boolean status =  driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
	}
	
	@Test(priority=2)
	void testTitle()
	{
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	
	@Test(priority=3)
	void testURL()
	{
		Assert.assertEquals(driver.getCurrentUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@AfterClass()
	void tearDown()
	{
		driver.close();
	}
}
