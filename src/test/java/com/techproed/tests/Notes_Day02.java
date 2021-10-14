package com.techproed.tests;

public class Notes_Day02 {

}

/*
Maven is a Java build and project management tool
Create project to manage the entire automation process
Helps to compile, run and deploy the java applications
Helps to manage the dependencies with pom.xml

//1. Set up the chrome driver
        WebDriverManager.chromedriver().setup();

        //2. Create driver
        WebDriver driver=new ChromeDriver();

        //3. Write your automation script
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
        driver.close();
//2. JUnit is testing framework. Annotations: @Test, @Before, @After, @@BeforeClass @AfterClass, @Before @After
    //@Test: Create a test case. This let us create and run test cases
    //@Before: Runs before each @Test annotation. Used for repeated pre- condition
    //@After: Runs after each @Test annotation. Used for repeated post condition
    //@Ignore: This is used to skip test cases
    Examples in Day02_FirstJUnitClass
//3. 8 selenium locators:
    id, name, className, tagName, linkText, partialLinkText, xpath, css

//4. findElement(driver.findElement(By.id(""));
    locates the elements
    Return type is WebElement
    Return only 1 element. If there are multiple match, then returns the first element
    If there is no matching element, then this throws "No such element exception"

 //5. findElements(By.locator);
     locates the elements
     Return type is <WebElement>
     Return a list even if there ia only 1 element
     If there is no matching element, then this return an empty array

//6. getText();
     returning the text of the web element as a string
//7. click();
    used to click the clickable element
    signIn(), signOut()....

//8. isDisplayed()
     is used to verify if an element is on the page or not
     Return Type is boolean
     Return true if element is in the page
     Return false if element is not on the page
//9. linkText
    generally we use this method from the links
    ex: we are taking the link of address in the page or sign out link...
    WebElement addressesElement = driver.findElement(By.linkText("Addresses"));
//10. partialLinkText
    generally we use this method from the links
    ex: we are taking the link of address in the page or sign out link...
    WebElement signOutElement = driver.findElement(By.partialLinkText("Sign out"));
//   What is different of linkText and partialLinkText
    //linkText -> we must give the entire text with extra spaces and all "Addresses"
    //partialLinkText-> we can give the entire text or part of the text  "dresses" or "Addres"

//11. tagName
        //Links are created by a tag, so we can find all links b finding all elements with "a" tag
        List<WebElement> allLinks =driver.findElements(By.tagName("a"));
        int linkSize = allLinks.size();
        System.out.println("Number of the link is " + linkSize);
//12     getCurrentUrl()
        //Verify the sing out is successful
        boolean isLoggedOut = driver.getCurrentUrl().equals("http://a.testaddressbook.com/sign_in");
        Assert.assertTrue(isLoggedOut);
































*** myjunitproject35_36 is the framework
*** .idea --->>> Belong to intellij. It has project specific information. DO NOT TOUCH
src --->>> source folder. It is used to create the classes and methods, It is used to either create a development
and testing framework.
main --->>> usually used by developers for development
test --->>> usually used by testers for testing
*** pom.xml --->>> This is the most important file in a maven project.
-used to add dependencies. plug-ins, and similar configurations
*** external libraries
This has imported libraries/jar files/plugins/dependencies
 */