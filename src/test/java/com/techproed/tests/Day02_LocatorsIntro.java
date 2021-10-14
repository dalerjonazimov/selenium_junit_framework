package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Day02_LocatorsIntro {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){
//        driver.close();
    }
    @Test
    public void locators(){
        driver.get("http://a.testaddressbook.com/sign_in");
        //1. Way
//        driver
//                .findElement(By.id("session_email")) //Locating the element by id
//                .sendKeys("testtechproed@gmail.com"); //typing in the element
        //2. Way better;  RETURN TYPE OF findElement is WebElement
        //Email Element
        WebElement emailBox= driver.findElement(By.id("session_email"));
        emailBox.sendKeys("testtechproed@gmail.com");

        //Password Element:
        driver.findElement(By.name("session[password]")).sendKeys("Test1234!");

        //Sign In Element:
        driver.findElement(By.name("commit")).click();

//        Then verify that the expected user id (email)
        WebElement userId = driver.findElement(By.className("navbar-text"));
        System.out.println(userId);//[[ChromeDriver: chrome on WINDOWS (cc8e043009d1b630a7c85e69b85bb9c6)] -> class name: navbar-text]
//          getText(); return the test of the WebElement. Return type is a String
        String userIdText = userId.getText();
        System.out.println(userIdText); //testtechproed@gmail.com

           //OR
//       String userIdText = driver.findElement(By.className("navbar-text")).getText();

        String expectedUserId = "testtechproed@gmail.com";
        Assert.assertEquals(expectedUserId, userIdText);




//        Verify the Addresses and Sign Out texts are displayed
            //The text of Addresses link is Addresses
         WebElement addressesElement = driver.findElement(By.linkText("Addresses"));
    //        isDisplayed()
    //        is used to verify if an element is on the page or not
    //        Return Type is boolean
    //        Return true if element is in the page
    //        Return false if element is not on the page
        Assert.assertTrue(addressesElement.isDisplayed());

        WebElement signOutElement = driver.findElement(By.partialLinkText("Sign out"));
        Assert.assertTrue(signOutElement.isDisplayed());
        //   What is different of linkText and partialLinkText
        //linkText -> we must give the entire text with extra spaces and all "Addresses"
        //partialLinkText-> we can give the entire text or part of the text  "dresses" or "Addres"

//        Find the number of total link on the page
        //Links are created by a tag, so we can find all links b finding all elements with "a" tag
        List<WebElement> allLinks =driver.findElements(By.tagName("a"));
        int linkSize = allLinks.size();
        System.out.println("Number of the link is " + linkSize);

//        Sign out from the page
        driver.findElement(By.linkText("Sign out")).click();

        //Verify the sing out is successful
        boolean isLoggedOut = driver.getCurrentUrl().equals("http://a.testaddressbook.com/sign_in");
        Assert.assertTrue(isLoggedOut);






    }
}
