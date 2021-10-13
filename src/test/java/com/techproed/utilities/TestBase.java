package com.techproed.utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
//Making TestBase abstract because we do not want to create an object of TestBase class
//We want to use the objects or methods in this class by extending it

    protected WebDriver driver;
    Faker faker = new Faker();
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); //This is must be used
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS); //for page load, optional.
    }

   // @After
    //public void tearDown(){
        //driver.close();
   // }
}
