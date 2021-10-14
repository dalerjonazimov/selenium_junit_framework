package com.techproed.tests;

public class Notes_Day06 {

}
/*
*****Alerts: JavaScript functions;  that why we cannot click them till we switchTo()
-accept()->Same as clicking OK of an alert.
driver.switchTo().alert().accept();
-dismiss()->Same as clicking Cancel of an alert.
driver.switchTo().alert().dismiss();
-getText()-> To get the alert message of the alert.
driver.switchTo().alert().getText();
-sendKeys("Text")->To send a text into alert textbox
driver.switchTo().alert().sendKeys("Text")

******Iframe
It is like creating page within page
If there is an iframe we must switch to the iframe first
*   -if I do not switch to the iframe, driver will not see the element inside the iframe
*   -If your test case fails, iframe might be one of the reason

How do you understand if the iframe on the page or not?
-Manually: Iframes are created by using iframe tag. //iframe will return the number of the iframe on the page
-Automation:

Write a code that returns the number of iframe on the page
driver.get("https://www.amazon.com");
List<WebElement> iframeElements = driver.findElements(By.xpath("//iframe"));
int iframeSize = iframeElements.size();
System.out.println(iframeSize);



 */
