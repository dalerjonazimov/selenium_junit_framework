package com.techproed.tests;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

/*
1.Create a class : RadioButton
2.Complete the following task.
3.Go to https://www.facebook.com/
4.Click on Create an Account button
5.Locate the elements of radio buttons
6.Then click on the radio buttons for your gender if they are not selected
7. Click the submit button
 */
public class Day05_RadioButton {
        WebDriver driver;
        Faker faker = new Faker();

        @Before
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
        @Test
        public void radioButton() {
//       3.Go to https://www.facebook.com/
            driver.get("https://www.facebook.com");
 //      4.Click on Create an Account button
            driver.findElement(By.linkText("Create An Account")).click();
//         Locate the elements of radio buttons USING FAKER METHOD
            driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(faker.name().firstName());
            driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(faker.name().lastName());
            driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(faker.internet().emailAddress());
            driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(faker.internet().password());

//          Locating the month
            WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
            Select select = new Select(month);
            select.selectByVisibleText("May");
//          Locate the day
            WebElement day = driver.findElement(By.xpath("//select[@id='day']"));
            Select dayDropdown = new Select(day);
            dayDropdown.selectByVisibleText("12");
//          Locate the year
            WebElement years = driver.findElement(By.xpath("//select[@id='year']"));
            Select yearDropdown = new Select(years);
            yearDropdown.selectByValue("1994");


 //       5.Locate the elements of radio buttons
            WebElement maleOption = driver.findElement(By.xpath("//input[@type='radio' and @value = '2']"));
 //      6.Then click on the radio buttons for your gender if they are not selected
            if (!maleOption.isSelected()){
                maleOption.click();
            }

//       7. Click the submit button
            driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        }

    @After
    public void tearDown(){
            driver.close();
    }
}

