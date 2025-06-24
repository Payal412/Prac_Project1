package com;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class AmazonSearchDropdown {
		
		    WebDriver driver;

		    @BeforeClass
		    public void setUp() {
		    	//Sets up ChromeDriver so Selenium can open and control the browser
		        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
		        driver = new ChromeDriver();
		        driver.manage().window().maximize();
		        driver.get("https://www.amazon.in");
		    }

		    @Test
		    public void printAllDropdownOptions() {
		        // Locate dropdown
		        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));

		        // Use Select class
		        Select select = new Select(dropdown);

		        System.out.println("All Search Categories:");
		        for (WebElement option : select.getOptions()) {
		            System.out.println("- " + option.getText());
		        }
		    }

		    @AfterClass
		    public void tearDown() {
		        driver.quit();
		    }
	}
