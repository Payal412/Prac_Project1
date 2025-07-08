package parameterization_DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {

	WebDriver driver;
	@BeforeClass
	void setup()
	{
		// Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test(dataProvider="dp") // dataProvider is one of the attribute of the test anonotation and it will start with lower case
	
	//How will receive those parameter i will create a String email and pwd, so 2 parameters i can specify
	// Now these 2 parameters will receive the data from the data provider
	//So this perticular 2 parameters will receive email & pwd and it will substitute here and it will do the validation
	
	void testLogin(String email, String pwd) throws InterruptedException
	{
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		
		//Hardcoding the value or data
		//driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("payal28p293@gmail.com");
		//driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("test@123");
		
		//And Instead of hardcoding this data i will just pass it here email & pwd. bcoz these are the local variables
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		// So we are not using any looping statements that is the beauty of the data provider method i.e. is the main advantage of the DP method
		// So here we don't need to do any kind of indexing or anything no index is required no loops are required, just it will return the data
		// from the two dimentional array and in the test method it will read the 1st input and do the everything again take input, then 3rd input and soon
		// And repeat all the steps so this  test method will  repeat multiple times based upon the number of inputs we have passed through data provider 
		// method here even though it is an array concept, we don't need to use any index we don't need to write any f loop so i.e. is a main adv of
		// dataprovider, so DP method will take care of all those things repetation indexing looping all those things will be taken care  by the DP
		
		Thread.sleep(3000);
		//("//h2[normalize-space()='My Account']")
		boolean status = driver.findElement(By.xpath("//*[@id=\"column-right\"]/div/a[4]")).isDisplayed();
		if(status==true)
		{
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
			driver.findElement(By.xpath("//a[@class='btn btn-primary'][normalize-space()='Continue']")).click();
			Assert.assertTrue(true);
		}
		else {
			Assert.fail();
		}
	}
	
	void tearDown()
	{
		driver.close();
	}
	
	// DataProvider is one of the annotation start with upper character
    // Imp point is whenever you create dataProvider() the name attribute must be specified bcoz if you want to refer
    // Suppose this is the test login & from where this is getting the data how this test login() will know which 
    // dataProvider method is providing the data so that is the reason we have to specify here dataProvider = "dp".
	
	@DataProvider(name="dp", indices = {0,3})
	Object[][] loginData()
	{
		// Remember this data provider method is always runing 2 dimentional array only even if you have a 10 columns, 10 inputs still it will return
		// 2 dimentional array, bcoz in 2 dim array we can  create n no. of rows & n no. of colm
		Object data[][] = {
				           // So dataprovider method is passing a diff type of data diff combinations of data and now test method will receive the data
				           // one after another and do the entire process for each and every email ID, the script will be executed multiple times
				             {"abc@gmail.com", "test@123"},
				             {"xyz@gmail.com", "test@02"},
				             {"john@gmail.com", "test@123"},
				             {"payal28p293@gmail.com", "test@123"}
		                  };
		
		return data;
	}
}
