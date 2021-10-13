package com.techproed;

import com.github.javafaker.Faker;
import com.sun.source.tree.AssertTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Day07_WindowHandle {
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
    public void windowHandle() throws InterruptedException {
     //1. Given user on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");
     //2. Then user verifies the text: "Opening a new window"
        WebElement window1heading= driver.findElement(By.xpath("//h3[.='Opening a new window']"));
        //Assert.assertTrue(window1heading.isDisplayed());//1 way
        Assert.assertEquals("Opening a new window", window1heading.getText()); //2.way
     //3. Then user verifies the title of the page is "The Internet"
        String window1Title = driver.getTitle();
        Assert.assertEquals("The Internet", window1Title);
    //4. When user clicks on the "Click Here" link
        driver.findElement(By.linkText("Click Here")).click();

        //DRIVER IS STILL ON THE WINDOW1, GET THE WINDOW 1 HANDLE


    //5. Switch the window to window2
        //GET THE WINDOW 1 HANDLE
        //1. Get the WINDOW 1 handle
        String window1Handle= driver.getWindowHandle();

        //2. Get all WINDOW Handles
        Set<String> allWindowHandles = driver.getWindowHandles();
        //allWindowHandle has window1 and window2(THis is the one I want to switch)

        //3. SO WE SWITCH WINDOW1 TO WINDOW2 using WindowHandles()
        for(String eachWindowHandle:allWindowHandles){
            if(!eachWindowHandle.equals(window1Handle)){
                driver.switchTo().window(eachWindowHandle);
                break;
            }
        }

        //DRIVER IS NOT IN WINDOW2
        //DRIVER CAN SEE ALL ELEMENTS ON WINDOW2
        //BUT DRIVER CANNOT SEE WINDOW1 ELEMENTS NOW

    //6. Then user verifies the new window title is "New Window"

         String window2title =driver.getTitle();
         Assert.assertEquals("New Window", window2title);

    //7. Then user verifies the text: "New Window"
        Assert.assertEquals("New Window", driver.findElement(By.xpath("//h3[.='New Window']")).getText());

// GETTING WINDOW 2 HANDLE. SINCE DRIVER IS ON WINDOW2, THIS RETURNS WINDOW2 HANDLE
        String window2Handle= driver.getWindowHandle();

    //8. When user goes back to the previous window and then verifies the title: "The Internet"
        driver.switchTo().window(window1Handle);
        Assert.assertTrue(driver.getTitle().equals("The Internet"));
        //DRIVER IS ON BACK WINDOW1

        Thread.sleep(5000);
    //go back to window2
        driver.switchTo().window(window2Handle);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
