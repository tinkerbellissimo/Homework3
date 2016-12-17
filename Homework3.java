package com.tinkerbellissimo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



/**
 * Created by tinkerbellissimo on 12/15/16.
 */
public class Homework3 {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "/Users/tinkerbellissimo/Downloads/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void Homework1() throws InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath(".//*[@id='sidebar']/div[2]/a[1]/i")).click();
        driver.findElement(By.xpath(".//*[@id='box-campaigns']/div/ul/li/a[1]/div[1]/img")).click();
        Select dropdown = new Select(driver.findElement(By.cssSelector(".options>select")));
        dropdown.selectByIndex(1);
        driver.findElement(By.cssSelector(".quantity>button")).click();
        Thread.sleep(2000L);
        driver.findElement(By.xpath(".//*[@id='cart']/a[3]")).click();
        driver.findElement(By.cssSelector(".comments>textarea")).sendKeys("End of test:)");
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}