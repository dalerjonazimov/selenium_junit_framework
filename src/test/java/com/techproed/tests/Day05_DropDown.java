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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

//How many handle dropdown
    /*
    selectByIndex()
    selectByValue()
    selectByVisibleText()

//Go to https://the-internet.herokuapp.com/dropdown
//1.Create method selectByIndexTest and Select and Print Option 1 using index
//2.Create method selectByValueTest Select and Print Option 2 by value
//3.Create method selectByVisibleTextTest Select and Print Option 1 value by visible text
//4.Create method printAllTest Print all dropdown value
//5.Create method printFirstSelectedOptionTest Print first selected option
//6.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 4 elements in the dropdown.

 */

public class Day05_DropDown {


    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

//Go to https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }

//1.Create method selectByIndexTest and Select  using index
    @Test
    public void selectByIndexText() throws InterruptedException {
        //1. locate the dropdown element
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //2. use select object
        Select select = new Select(dropdown);
        //3. use any 3 method to select-index-visibletext (selectByIndexTest)
        Thread.sleep(5000);
        select.selectByIndex(1);
        Thread.sleep(5000);
    }
//2.Create method selectByValueTest Select and Print Option 2 by value
    @Test
    public void selectByValueTest() throws InterruptedException {
        //1. locate the dropdown element
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //2. use select object
        Select select = new Select(dropdown);
        //3. use any 3 method to select-index-visibletext (selectByValueTest)
        Thread.sleep(5000);
        select.selectByValue("2");
    }


//3.Create method selectByVisibleTextTest Select and Print Option 1 value by visible text
    @Test
    public void selectByVisibleTextTest() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select (dropdown);
        select.selectByVisibleText("Option 1");


    }
//4.Create method printAllTest Print all dropdown value
    @Test
    public void printAllTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        //getOptions() returns all dropdown options as List<WebElement>
        List<WebElement> allOption = select.getOptions();
        //Use a loop (for each loop) to get single element
        for(WebElement eachOption: allOption) {
            System.out.println(eachOption.getText());
        }
    }
//5.Create method printFirstSelectedOptionTest Print first selected option
    @Test
    public void printFirstSelectedOptionTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        //getFirstSelectedOption(); returns the first selected option from dropdown
        WebElement firstSelectedOption = select.getFirstSelectedOption();
        System.out.println(firstSelectedOption.getText());

        //Asserting if selected option is Please select an option
        Assert.assertEquals("Please select an option", firstSelectedOption.getText());
    }
//6.Create a method sizeTest. Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 4 elements in the dropdown.
    @Test
    public void sizeTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        List<WebElement> allOptions = select.getOptions();
        int size = allOptions.size();
        Assert.assertEquals("Expected Is Not Equal Actual",3, size);
        //Expected Is Not Equal Actual =will be displayed ONLY IF THE ASSERTION FAILS
    }
    @After
    public void tearDown(){
        driver.close();
    }

}
