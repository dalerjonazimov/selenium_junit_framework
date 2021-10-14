package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day09_Synchronization1 extends TestBase {

    @Test
    public void synchronization1(){
        //1.Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //2.click on remove button
        driver.findElement(By.xpath("//button[.='Remove']")).click();

        //3.And verify the message is equal to "It's gone!"
//        WebElement goneElement = driver.findElement(By.xpath("//p[@id='message']"));
                    //1.Way of assertion
        //Assert.assertEquals("It's gone!", goneElement);
                    //2.Way of assertion
//       Assert.assertTrue(goneElement.getText().equals("It's gone!"));

        //IN TEST BASE (PARENT) WE HAVE IMPLICIT WAIT 15 SECOND. AND WHILE WE DO IT 1 SECOND TESTCASE FAILS
        //BECAUSE WEBPAGE IS WORKING SLOW THEN DRIVER. FOR THAT REASON WE SHOULD SYNCHRONIZE IT BY USING WAIT METHOD
        //1. WE CAN CHANGE THE IMPLICIT WAIT FROM 1 TO 15 BUT SOMETIMES 15 SECONDS DOES NOT WORK TOO
        //2. FOR THAT REASON NOW WE USE EXPLICIT WAIT(FOR ELEMENT):
             //Step1: Create WebDriverWait object
        WebDriverWait wait = new WebDriverWait(driver, 15);
            //Step2: Use wait object to wait for element
         /*Explicit wait does the following
            * 1. Wait for By.xpath("//p[@id='message']")
            * 2. If the xpath found in 10 seconds, then it is returned as WEBELEMENT
            * 3. If the element cannot be found in 10 second, step will fail
          */
       WebElement goneElement= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
       Assert.assertTrue(goneElement.getText().equals("It's gone!"));


        //4.Then click an Add Button
         driver.findElement(By.xpath("//button[.='Add']")).click();

        //5.Verify the message is equal to "It's back!" By using explicit wait
                //Step1: Create WebDriverWait object. Do not need to write again because we already created object in first request
        //WebDriverWait wait2 = new WebDriverWait(driver, 15);
                //Step2: Use wait object to wait for element
        WebElement comeBackElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(comeBackElement.getText().equals("It's back!"));




    }

}
