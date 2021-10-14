package com.techproed.tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day07_IframeExample {

    WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void numberOfIframe(){
       driver.get("https://www.amazon.com");
       List<WebElement> iframeElements = driver.findElements(By.xpath("//iframe"));
       int iframeSize = iframeElements.size();
       System.out.println(iframeSize);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
