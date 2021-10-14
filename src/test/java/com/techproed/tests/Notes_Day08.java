package com.techproed.tests;

public class Notes_Day08 {

}

/*
================================================================================
IF YOU SEE COOKIES THEN ADD THIS LINE
driver.findElement(By.xpath("//*[@id='L2AGLb']")).click();
===================================================================================
file-new-project from version control  === its to clone from github
https://github.com/B-35-36/junit-framework

=================================================================================
 Actions actions = new Actions(driver);
 actions
       .keyDown(searchBox, Keys.SHIFT) //keyDown() is press + Keys.SHIFT to make upperCase
       .sendKeys("iPhone X prices")   //write your searching items
       .keyUp(searchBox,Keys.SHIFT)   //keyUp() is unpress + Keys.SHIFT to make normal
       .build()                       //build is optionally used to make perform stronger. Without build it works too
        .perform();                   //do action. Must be used


=======================================================================================

//PAGE_DOWN=> scroll down the page
actions.sendKeys(Keys.PAGE_DOWN).perform();
//ARROW_DOWN=> scroll down the page less than PAGE_DOWN
actions.sendKeys(Keys.ARROW_DOWN).perform();
//PAGE_UP=> scroll up the page
actions.sendKeys(Keys.PAGE_UP).perform();
//ARROW_UP=>scroll ip the page
actions.sendKeys(Keys.ARROW_UP).perform();
========================================================================================
===SUMMARY OF DAY08====
SYNCHRONIZATION
There is driver and browser and work together: if driver is very fast and page(browser) is very slow, then
page will not load  elements. Then test case will fail. What we do in this case? Wr use below dynamic waits

==There are 3 WAITS in Selenium==
    =Implicit Wait //driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    =Explicit Wait //1) WebDriverWait wait = new WebDriverWait(driver,15); 2) WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(LOCATOR OF ELEMENT))
    =Fluent wait- this is similar to explicit wait

What is difference between implicit and explicit wait?
    Implicit: global wait: It will apply the driver whenever driver is used
    Explicit: local wait, it applies only for specific element. When should I use explicit wait? Used under an expected condition
                We must create a WebDriverWait object.
Similarity between implicit and explicit wait?
    All these waits are dynamic waits, IT will not put unnecessary wait. Bot are selenium waits
Fluent Wait:
    Similar to explicit wait. We can give polling time. We can ignore the exceptions with fluent wait
            Wait wait = new FluentWait(WebDriver reference)
            .withTimeout(5, SECONDS)  it means wait 5 second for the element
            .pollingEvery(1, SECONDS)  check for the element every 1 second
            .ignoring(Exception.class)  We can add ignore exception with fluent wait
    Specify polling time

==TestBase==
This is used for pre and post conditions. We have Before and After method. We use TestBase by extending it.
==Files==
    Upload a file
    Download a file
    Check if a file exists- with the help of JAVA
==Actions==
    Hover OVer-Move over to an elements
        actions.moveToElement(element).perform()
    Scroll Up or Down
        ARROW_UP, PAGE_UP
        ARROW_DOWN, PAGE_DOWN




 */