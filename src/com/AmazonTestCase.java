package com;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonTestCase {

	WebDriver driver;

    @BeforeClass
    public void setup() throws Exception {
    	// Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        Thread.sleep(20000); // Wait manually for CAPTCHA
    }

    @Test(priority = 1)
    public void selectCountry() throws Exception {
        driver.findElement(By.id("nav-global-location-popover-link")).click();
        Thread.sleep(2000);

        WebElement dropdownButton = driver.findElement(By.xpath("//*[@class='a-button-dropdown a-button a-button-span12']"));
        dropdownButton.click();

        WebElement dropdownOption = driver.findElement(By.xpath("//a[text()='India']"));
        dropdownOption.click();
        Thread.sleep(2000);

        driver.findElement(By.name("glowDoneButton")).click();
    }

    @Test(priority = 2)
    public void searchProduct() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(By.id("searchDropdownBox"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Arts & Crafts");
        
        Thread.sleep(1000); // wait for dropdown selection

        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("paint kit");
        searchBox.sendKeys(Keys.ENTER);

        Thread.sleep(3000); // wait for search results to load
    }
}
