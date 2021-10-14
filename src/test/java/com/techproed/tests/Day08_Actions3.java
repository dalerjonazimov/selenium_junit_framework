package com.techproed.tests;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Day08_Actions3 extends TestBase {
    /*
Create a class: Actions3
Create test method : keysUpDown()
Go to google/amazon
Send iPhone X prices => convert small letter capital vice versa.
Highlight the search box by double clicking
     */

    //NOW THAT WE USED TESTBASE, WE DO NOT USE BEFORE AND AFTER METHOD
//    WebDriver driver;
//    @Before
//    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//    }
    @Test
    public void keysUpDown(){
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();
        WebElement searchBox=  driver.findElement(By.xpath("//input[@name='q']"));
// normal automation   searchBox.sendKeys("iPhone X prices");
        Actions actions = new Actions(driver);
        actions
                .keyDown(searchBox, Keys.SHIFT) //keyDown() is press + Keys.SHIFT to make upperCase
                .sendKeys("iPhone X prices")   //write your searching items
                .keyUp(searchBox,Keys.SHIFT)   //keyUp() is unpress + Keys.SHIFT to make normal
                .sendKeys(" too expensive" + Keys.ENTER)  // here we press ENTER to search without using click button
                .build()                       //build is optionally used to make perform stronger. Without build it works too
                .perform();                   //do action. Must be used
    }
//    @After
//    public void tearDown(){
//        driver.close();
//    }
}
