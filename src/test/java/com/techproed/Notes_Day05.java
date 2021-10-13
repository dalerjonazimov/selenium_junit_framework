package com.techproed;

public class Notes_Day05 {
}

/*
DAY05
1. ==CSS==
formula:
a)tag[attribute = 'value']
b)tag#idvalue
c)#idvalue
# means id in cssSelector
driver.findElement(By.cssSelector("input[id='session_email']"));

When there is class:
a) tag.classvalue
b) .classvalue
. means class in cssSelector

==Example==
Using http://a.testaddressbook.com/sign_in page find the locate the email
There are 2 ways:
css: we located by id because it is unique
a.way: input[id='session_email']
b.way: input#session_email
c.way: #session_email


xpath: we located by id because it is unique
//input[@id='session_email']


==WHAT ARE THE DIFFERENCES BETWEEN XPATH AND CSS SELECTOR?==
CSS is a little faster,
Xpath just locating element the DOM(document object Model),cssSelector locates the target without navigation
Xpath is more common. We can write dynamic xpath to locate element
They have different syntax. For example, // is used in xpath but not in css
Css locators usually same across the browsers, so it is more reliable





2.Then click on checkbox1 if box is NOT selected
       //isSelected() is used to check if checkbox or radio button are checked or unchecked
       //returns true if checkbox is already selected. Return false if checkbox is not selected
     if(!checkbox1.isSelected()){
     checkbox1.click();
 */

/*

-------------------------------------------------------------------------------------------
****CheckBox
- isSelected()---> return boolean, check if a box checked or unchecked
- click()  is used to check/unchecked checkboxes

****Radio Button
- isSelected() ---> return boolean, check if a box checked or unchecked
- click()  is used to check/unchecked checkboxes

------------------------------------------------------------------------------------------



====DROPDOWN====
THERE ARE 3 WAYS TO SELECT FROM A DROPDOWN

*****Steps for interaction with dropdown elements
Step 1: Locate the select element dropdown using any locator. Example:
 WebElement selectElement=driver.findElement(By.id(“value of id"));
Step 2: Create Select object and pass the selectElement to that object.Example:
 Select options=new Select(selectElement);
Step 3: We now can handle dropdown using any method. Example:
options.selectByIndex(1); Index starts from 0. This takes an integer as parameter
options.selectByValue(“1”); Pass the value of the option. This takes a string as parameter
options.selectByVisibleText(“Watch”); Pass the text of the option. This takes a string a parameter

METHODS()
METHODS()
selectByIndexText()
selectByValueTest()
selectByVisibleTextTest()
****getOptions() returns all dropdown options as List<WebElement>
List<WebElement> allOptions = select.getOptions();
****getFirstSelectedOption(); returns the first selected option from dropdown
 */
