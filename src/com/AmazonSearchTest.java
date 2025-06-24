package com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonSearchTest {

	    WebDriver driver;

	    @BeforeClass
		public void setup() {
			//Sets up ChromeDriver so Selenium can open and control the browser
	        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
			//Opens the Amazon India website in the browser
			driver.get("https://www.amazon.in/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}

		@Test(priority = 1)
		public void searchLaptopInElectronics() {
			// Select "Electronics" from dropdown, Selects the "Electronics" category from the dropdown list
			Select categoryDropdown = new Select(driver.findElement(By.id("searchDropdownBox")));
			categoryDropdown.selectByVisibleText("Electronics");

			//Types "laptop" in the search box and presses Enter
			WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
			searchBox.sendKeys("laptop");
			driver.findElement(By.id("nav-search-submit-button")).click();
		}
		
	    @Test(priority = 2)
	    public void applyHPBrandFilter() throws InterruptedException {
	        Thread.sleep(3000); // Wait for filters to load

	        // Click on HP brand filter
	        WebElement hpBrand = driver.findElement(By.xpath("//span[text()='HP']"));
	        hpBrand.click();
	    }

	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
}
