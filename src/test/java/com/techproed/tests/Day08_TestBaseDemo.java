package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

//Create a class:TestBaseDemo and extend it from TestBase class(Parent)
public class Day08_TestBaseDemo extends TestBase {
//Since I have before after methods in TestBase, we do not use them in here
//This is a TEST CLASS and will have only @Test method


    @Test
    public void test1(){
        driver.get("https://www.google.com");
        driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();
        driver.findElement(By.name("q")).sendKeys("porcelain teapot"+ Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }
    //3)Create a class
    @Test
    public void test2(){
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("porcelain teapot"+Keys.ENTER);
        Assert.assertTrue(driver.getPageSource().contains("porcelain teapot"));
    }



    /*





——————————-
test2 search “porcelain teapot” on amazon
Then verify page contains “porcelain teapot”
     */

}
