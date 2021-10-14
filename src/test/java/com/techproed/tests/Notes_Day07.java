package com.techproed.tests;

public class Notes_Day07 {
}

/*
Summary of Day07

===Iframe===
Created by using iframe tag. Page within a page.
How to handle Iframe? We handle iframe by switching: there are 3 ways:
-index
-id/class
-WebElement
Formula: driver.switchTo().frame(3 options);

===Alerts===
Alerts are JS pop-ups. We must accept or cancel alerts to continue testing.
How to handle Alerts?
-accept() -clicking ok
-dismiss() - clicking Cancel
-getText()- getting text on alert (NOT MANDATORY)
-sendKeys() - used to typing the box (NOT MANDATORY)
Formula: driver.switchTo().alert().4 OPTIONS

===Multiple Tabs/Windows===
Some pages opens new windows(not same windows). Then we see 2 windows
-getWindowHandle() : return the unique identifier of the page as a String
-getWindowHandles() : return all window identifiers as  Set<String>
driver.switchTo().window(driver.WINDOW HANDLE YOU WANT TO SWITCH TO);


===Actions Class===
Actions is used for mouse-keyboards actions.  -hoverOver, right click, double click, drag and drop, press shift, alt, ctrl
Steps to use Action Class
1. Create an action object
    Actions actions = new Actions(driver)
2. Locate the elements on the page using any locator
3. actions.OPTIONS.perform()


==Window Handle==
driver.getWindowHandle();=> return the existing window
driver.getWindowHandles();=> return all windows

Note that we can not switch the specific window using index
Logic: Change the window if driver is not window1

if driver is not on window1:   if(!eachWindowHandle.equals(window1Handle))
Then switch the other window: driver.switchTo().window(eachWindowHandle);

 */