package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
/*
Go to https://the-internet.herokuapp.com/javascript_alerts
Create a class: AlertTest
Create setUp method
Create 3 test methods:
acceptAlert() => click on the first alert, verify the text “I am a JS Alert” , click OK , and Verify “You successfuly clicked an alert”
dismissAlert()=> click on the second alert, verify text "I am a JS Confirm”, click cancel, and Verify “You clicked: Cancel”
sendKeysAlert()=> click on the third alert, verify text “I am a JS prompt”, type “Hello Word”, click OK, and Verify “You entered: Hello Word”
 */

public class Day06_Alert {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void acceptAlert(){
     //   click on the first alert,
        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
     //   the text “I am a JS Alert”
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals("I am a JS Alert", alertText);
     //   click OK
        driver.switchTo().alert().accept();
     //   and Verify “You successfully clicked an alert”
        String result = driver.findElement(By.id("result")).getText();
        Assert.assertEquals("You successfully clicked an alert",result );


    }

    @Test
    public void dismissAlert (){
    //click on the second alert,
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
    // verify text "I am a JS Confirm”,
        Assert.assertEquals("Text does not match","I am a JS Confirm",driver.switchTo().alert().getText());
    // click cancel,
        driver.switchTo().alert().dismiss();
    // Verify “You clicked: Cancel”
        Assert.assertEquals("Result does not match","You clicked: Cancel",driver.findElement(By.xpath("//p[@id='result']")).getText());

    }

    @Test
    public void sendKeys(){
    //click on the third alert
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
    //verify text “I am a JS prompt”,
       String actual= driver.switchTo().alert().getText();
       String expected = "I am a JS prompt";
       Assert.assertEquals(expected, actual);
    //type “Hello World”,
        driver.switchTo().alert().sendKeys("Hello World");
    //click OK, and
        driver.switchTo().alert().accept();
    //Verify “You entered: Hello Word”
        Assert.assertEquals("You entered: Hello World", driver.findElement(By.xpath("//p[@id='result']")).getText());

    }
    @After
    public void tearDown(){
        driver.close();
    }
}

