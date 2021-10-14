package com.techproed.tests;

public class Notes_Day03 {
}

/*

Summary of Day03
1. Locators : Used to find elements from the websites
    id, name, className, tagName, linkText, partialLinkText, xpath, cssSelector
2. In which order, do you use locators?
    1. id = because there should be, it is UNIQUE id. If there is no id
    2. name = if there is unique name. ex: class ='btn-btnprimary'. I do not prefer to use class because it usually not unique
    3. tag = I do not use tag there are not generally unique
    4. link = if the element is a link, then I prefer to use linkText or partialLinkText
    5. xpath = I also prefer to use for locations elements. I am good at writing dynamic xpath
                for the elements. I can write xpath for any elements on the page. safer, not easily change
                issue is= we do not have to use indexes. Even though xpath is a little slower, it is safer to use
3. findElement(By.locator ("value"))=> return single elements.(when multiple match, returns the first element)
                                    If there is no match, then throws nosuchelementexception
   findElements(By.locator("value"))=> return multiple elements. Return type is List<WebElement>,
            if there is no match, returns empty List. Do not throw exception


*/
/*=========XPATH=======
4. Xpath: There are 2 xpath - absolute and relative
        Absolute xpath: Navigating from the first parent to the targeted element 1 by 1. /is used
        Relative xpath: Navigating the elements using relative path. No need to go from parent to child 1 by 1. // is used
        //tag[@attribute='value of that value']
        There are multiple ways to write xpath

           ex:
        <h2 class="mb-4">Welcome To Our Hotel</h2> ==element
        (//h2)[10] =>it is how you search by using tag+index --not recommended because is not good

    **  //tagName[.='text name']  ==> KNOW THIS SYNTAX, IT'S ENOUGH TO LOCATE ELEMENT USING XPATH==
        //tag[.='text'] just change it according element like below
        //hr[.='Welcome To Our Hotel'] => this combination can be used to locate the text on the page
                                       => We have to pass complete text inside
    **  //*[.='text name']  ==> * means Any it same almost same syntax as above //tag[.='text']
        //*[.='Welcome To Our Hotel'] ==> the only different with 1 syntax is if there is
                                  same 'Welcome To Our Hotel' it shows all of them

    **  //*[(text()='Welcome To Our Hotel')] ==> same with above syntax
        //*[(text()='Welcome To Our Hotel')]

    ** //*[contains(text(), 'PIECE OF TEXT')]
       //*[contains(text(), 'Welcome To')]

    ** //tag[contains(@attribute, 'value')]
       (//input[contains(@id, 'UserName')])


            this is used to locate especially DYNAMIC ELEMENTS(the element's id, class.. can change when the page refreshes-Facebook example)
            We use TAG, ATTRIBUTE, VALUE OF THAT ATTRIBUTE
            We can use this xpath to locate any element
    **  Handling the DYNAMIC ELEMENTS
        //tag[contains(@attribute,'value')]
        //input[contains(@id, 'u_2_b2')] so to locate always and handle it use
        (//input[contains(@id,'u_')])[1] because value u_ stays same after refreshing the page.(facebook)

        //tag[starts-with(@attribute,'value')] ==> (//input[starts-with(@id, 'u_')])[1] Returns the first input whose id start with u

        //tag[ends-with(@attribute, 'value')] ==> //input[ends-with(@id,'P7')] Returns the input elements who ends with P7

        //*[starts-with(@attribute, 'value')] ==> (//input[stats-with(@id, 'u_')])[1] return any tag whose id start with u_

        //*[contains(@attribute, 'value')]==> //*[contains(@id, 'u_')] returns ANY tag whose ID CONTAINS u_.
         THIS IS MOST GENERIC XPATH FOR LOCATING DYNAMIC ELEMENTS
         Note that Dynamic elements are not common, we can rarely see dynamic elements on the pages
 */














