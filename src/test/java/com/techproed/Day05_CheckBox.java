package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
/*
1.Create a class : CheckBox
2.Create test method and complete the following task
3.Go to https://the-internet.herokuapp.com/checkboxes
4.Locate the elements of checkboxes
5.Then click on checkbox1 if box is not selected
6.Then click on checkbox2 if box is not selected
7.Then verify that checkbox1 and checkbox2 are checked.
 */

//1.Create a class : CheckBox
public class Day05_CheckBox {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

   }
// Create test method and complete the following task
   @Test
    public void checkbox(){
//  Go to https://the-internet.herokuapp.com/checkboxes
    driver.get("https://the-internet.herokuapp.com//checkboxes");
//  Locate the elements of checkboxes
    WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type =\"checkbox\"])[1]"));
    WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type =\"checkbox\"])[2]"));
//  5.Then click on checkbox1 if box is NOT selected
       //isSelected() is used to check if checkbox or radio button are checked or unchecked
       //returns true if checkbox is already selected. Return false if checkbox is not selected
       if(!checkbox1.isSelected()){
           checkbox1.click();
       }
//  6.Then click on checkbox2 if box is NOT selected
        if(!checkbox2.isSelected()){
            checkbox2.click();
        }

//  7.Then verify that checkbox1 and checkbox2 are checked.
       Assert.assertTrue(checkbox1.isSelected());
       Assert.assertTrue(checkbox2.isSelected());

    }
    @After
    public void tearDown(){
        driver.close();
    }
}

