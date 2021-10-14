package com.techproed.tests;

public class Notes_Day04 {
}
/*
DAY04 SUMMARY
1. Implicit wait
    -Is used to  dynamic wait. If driver do not need it will not wait. If driver need it generate
    -It is enough to use ONLY ONCE  in the class
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
2. xpath
    -Xpath is ued to locate/find the element
    -We have multiple ways to write an xpath
    //tag[@attribute ='value']
    //*[.='Hello World']  ==> this is will return all  the Hello World text elements in the page
3. Dynamic element
    The value of attribute can change when refreshing or when we go to the page later again(when logout and login)
    Ex: when I create user account, then  some element; id value change
4. How do you handle dynamic elements?
    By writing dynamic xpath such as contains, start-with, ends-with
 */

