package com.techproed.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

//1. Create a class AccoutCreationTest
public class AccoutCreationTest {

    WebDriver driver;
    Faker faker = new Faker();
     @Before
    public  void setUp(){
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
         driver.manage().window().maximize();
     }
     @Test
    public void accountTest(){
    //2. Go to http://automationpractice.com/index.php
    driver.get("http://automationpractice.com/index.php");
    //3. Click on sign in link
    driver.findElement(By.xpath("//a[@class='login']")).click();
    //4.Send your email and click on create an account button
    driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(faker.internet().emailAddress());
    driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

    //5.Verify the Text : CREATE AN ACCOUNT
         WebElement verifyCreateAnAccount = driver.findElement(By.xpath("//h1[@class='page-heading']"));
         Assert.assertTrue(verifyCreateAnAccount.isDisplayed());
    //6. Verify the Text : YOUR PERSONAL INFORMATION
        WebElement verifyYourPersonalInformation = driver.findElement(By.xpath("(//h3[@class='page-subheading'])[1]"));
        Assert.assertTrue(verifyYourPersonalInformation.isDisplayed());
    //7. Verify the Text : Title
        WebElement verifyTitle = driver.findElement(By.xpath("//label[.='Title']"));
        Assert.assertTrue(verifyTitle.isDisplayed());
    //8. Select your title
        WebElement genderSelection = driver.findElement(By.xpath("//input[@id='id_gender1']"));
        if(!genderSelection.isSelected()){
            genderSelection.click();
        }
    //9. Enter your first name
        driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys("Dalerjon");
    //10. Enter your last name
        driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys("Azimov");
    //11. Enter your email- it has been already written, if there is not then we can use faker
        //driver.findElement(By.xpath("//input[@id='email']")).sendKeys(faker.internet().emailAddress());
    //12. Enter your password
       driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("123456@Ad");
    //13. ENTER DATE OF BIRTH
        WebElement day = driver.findElement(By.xpath("//select[@id='days']"));
        Select select = new Select(day);
        select.selectByValue("12");
        WebElement months = driver.findElement(By.xpath("//select[@id='months']"));
        Select monthDropdown = new Select(months);
        monthDropdown.selectByIndex(5);
        WebElement years = driver.findElement(By.xpath("//select[@id='years']"));
        Select yearDropdown = new Select(years);
        yearDropdown.selectByValue("1994");
    //14. Click on Sign up for our newsletter!
        WebElement clickOption = driver.findElement(By.xpath("//input[@id='newsletter']"));
        if(!clickOption.isSelected()){
            clickOption.click();
        }

    //15. Enter your first name
         //driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Dalerjon");

    //16. Enter your last name
         //driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Azimov");
    //   17. Enter your company
         driver.findElement(By.xpath("//input[@id='company']")).sendKeys(faker.company().name());
    //    18. Enter your Address
         driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(faker.address().fullAddress());
    //    19. Enter your City
         driver.findElement(By.xpath("//input[@id='city']")).sendKeys(faker.address().city());


    //20. SELECT STATE
         WebElement state = driver.findElement(By.xpath("//select[@id='id_state']"));
         Select stateDropdown = new Select(state);
         stateDropdown.selectByVisibleText("Alaska");
    //21. Enter Postal Code
         driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(faker.number().digits(5));

    //22.SELECT COUNTRY
         WebElement country = driver.findElement(By.xpath("//select[@id='id_country']"));
         Select countryDropdown = new Select(country);
         countryDropdown.getFirstSelectedOption();
    //23. Enter additional information
         driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys(faker.letterify("my first automation test").toUpperCase());
    //24. Enter home phone
         //driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(faker.phoneNumber().phoneNumber());
    //25. Enter mobile phone
         driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(faker.phoneNumber().cellPhone());
    //26. Enter reference name
         driver.findElement(By.xpath("//input[@id='alias']")).sendKeys("TechProEd");
    //27. Click Register
         driver.findElement(By.xpath("//button[@id='submitAccount']")).click();
    // 20. Then verify MY ACCOUNT is displayed on the home page-SEE BELOW IMAGE
         WebElement verifyMyAccount = driver.findElement(By.xpath("//h1[@class='page-heading']"));
         Assert.assertTrue("Well Done",verifyMyAccount.isDisplayed());

     }
     @After
    public void tearDown(){
         driver.close();
     }


}
