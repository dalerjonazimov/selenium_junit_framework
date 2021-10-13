package com.techproed;

public class Notes_Day09 {
}

/*
BASIC AUTHENTICATION
Auth are used for security reason
One way to auth is to use below syntax:
https://username:password@URL
****************************************
Example:

//  https://username:password@URL
//  username: admin
//  password: admin
//  url: the-internet.herokuapp.com/basic_auth
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

//Writing  asserting to check if the page has Congratulations!
       boolean isDisplayed =  driver.findElement(By.xpath("//*[contains(text(),'Congratulations!')]")).isDisplayed();
       Assert.assertTrue(isDisplayed);
**********************************************

HANDLING COOKIES IN SELENIUM
What is cookies?
    The temporary data that is created by the browser
    Cookies are stored in our computer as we visit the websites
We can automate handling cookies:
    Find the cookies
    Add new cookies
    Delete cookies
 */