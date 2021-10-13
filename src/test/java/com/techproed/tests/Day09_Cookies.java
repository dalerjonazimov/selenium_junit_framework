package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import  java.util.Set;

public class Day09_Cookies extends TestBase {

        @Test
        public void handleCookies(){
                //Go to amazon
                driver.get("https://www.amazon.com");
                //1. Find the total number of cookies
                Set <Cookie> allCookies = driver.manage().getCookies();
                int numOfCookies = allCookies.size();
                System.out.println("Number of Cookies =>" + numOfCookies);

                //2. Print all the cookies
                for(Cookie eachCookie: allCookies){
                        System.out.println("Cookie Name=>" + eachCookie.getName());
                        System.out.println("Cookie Values=>" + eachCookie.getValue());
                }
                //3. Get the cookies by their name
                System.out.println("Cookie named i18n-prefs=>"+ driver.manage().getCookieNamed("i18n-prefs"));

                //4. Add new cookie
                  //we created a new cookie
                Cookie myCookie = new Cookie("My First Cookie", "Cookie Brown 2235");
                  //added the cookie
                driver.manage().addCookie(myCookie);

                //getting all cookies
                allCookies = driver.manage().getCookies();
                //printing the total number of cookies
                System.out.println("Number of Cookie=>"+ allCookies.size()); //Number of Cookie=>10


                //5. Delete cookie by name
                driver.manage().deleteCookieNamed("lc-main");
                allCookies = driver.manage().getCookies();
                System.out.println("Number of Cookies=>"+ allCookies.size()); //Number of Cookies=>9

                //6. Delete all of the cookies
                driver.manage().deleteAllCookies();
                allCookies = driver.manage().getCookies();
                System.out.println("Number of Cookies=>"+ allCookies.size()); //Number of Cookies=>0
        }
}
