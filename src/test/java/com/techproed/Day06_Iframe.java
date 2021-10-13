package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Day06_Iframe {

    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        //Go to https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @Test
    //Create a method: iframeTest
    public void iframeTest() {

        //Verify the Bolded text contains “Editor”
        String actualBoldedText = driver.findElement(By.xpath("//h3")).getText();
        String expectedText = "Editor";
        Assert.assertTrue(actualBoldedText.contains(expectedText));

    //Locate the text box
        //1. Way: Switching to iframe by index, - index start from 0.
            //before we do something first must check if there is iframe. if so then switch
            //driver.switchTo().frame(0);

        /*
        //2. Way: Switching iframe by id/name
            This iframe has an id, then I can pass value of id and switch to the iframe

            <iframe
            id="mce_0_ifr"
            frameborder="0"
            allowtransparency="true"
            title="Rich Text Area.
            Press ALT-0 for help."
            class="tox-edit-area__iframe">
            </iframe>
         */
            //driver.switchTo().frame("mce_0_ifr");
        //3. Way: Switching iframe by WebElement
           //We first locate the iframe element
            WebElement iframeElement = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
            driver.switchTo().frame(iframeElement);






        //NOTE: //p element is inside the iframe.
        //If we do not switch() like above: Result: we will get NoSuchElementException due to frame inside the frame. so we must switch it
        WebElement textBox =  driver.findElement(By.xpath("//p"));
    //Delete the text in the text box    //clear() -> delete the existing text
        textBox.clear();
    //Type “This text box is inside the iframe”
        textBox.sendKeys("This text box is inside the frame");
    //At this point we are still INSIDE THE IFRAME,  we need to go out IFRAME and next step below

    //Verify the text Elemental Selenium text is displayed on the page
        //Elemental Selenium is OUTSIDE OF IFRAME
        //Switch to the parent frame
        driver.switchTo().parentFrame(); // go to parent frame. Az child ba parent guzawtim aknun metonem davomi case kunem

        WebElement elementSelenium = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementSelenium.isDisplayed());

    }
}
