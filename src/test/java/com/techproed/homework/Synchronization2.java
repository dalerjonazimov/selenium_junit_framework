package com.techproed.homework;

import com.techproed.utilities.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Synchronization2 extends TestBase {

        //1. Create a class:Synchronization2. Create a method: isEnabled
    @Test
    public void isEnabled(){

        //2. Go to https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //3. Click enable Button
        driver.findElement(By.xpath("//button[.='Enable']")).click();

        //4. And verify the message is equal to “It's enabled!”
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement enableMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertTrue(enableMessage.getText().equals("It's enabled!"));

        //5. And verify the textbox is enabled (I can type in the box)
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("I can type in the box");
        Assert.assertTrue(enableMessage.isEnabled());

        //6. Click the Disable button
        driver.findElement(By.xpath("//button[.='Disable']")).click();

        //6. And verify the message is equal to “It's disabled!”
        WebElement disableMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id='message']")));
        Assert.assertEquals("It's disabled!", disableMessage.getText());

        //6. And verify the textbox is disabled (I cannot type in the box)
        WebElement cannotType = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertTrue(cannotType.isDisplayed());

    }

}
