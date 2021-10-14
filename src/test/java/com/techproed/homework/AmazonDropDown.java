package com.techproed.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonDropDown {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
      }

     @Test
    public void dropdownTest(){
        //1.
        driver.get("https://www.amazon.com");
        WebElement dropDownBox = driver.findElement(By.id("searchDropdownBox"));
        //2
         Select select = new Select(dropDownBox);
         String firstOption=select.getFirstSelectedOption().getText();
         Assert.assertEquals("All Departments", firstOption);
        //3.
          select.selectByIndex(3);
          String thirdIndex = select.getFirstSelectedOption().getText();
          Assert.assertEquals("Baby",thirdIndex);
        //4
        List<WebElement> allOptions= select.getOptions();
        for (WebElement eachOption: allOptions){
            System.out.println(eachOption.getText());
        }
        //5
        int totalNumberOfOption = allOptions.size();
        System.out.println("Total Number Of Option In The Dropdown: "+ totalNumberOfOption);
        //6.
         List<String> optionApp = new ArrayList<>();
         for (WebElement eachOption: allOptions){
             if(optionApp.contains("Appliances")){
                 System.out.println("True");
             }else{
                 System.out.println("False");
             }

         }
    }
    @After
    public void tearDown(){
        driver.close();
    }
}
