package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

	@Test
	public void loginTest() {
		
		// Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//Create Object of LoginPage
		LoginPage login = new LoginPage(driver);
		
		//Call methods
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickLogin();
		
		driver.quit();
	}
}
