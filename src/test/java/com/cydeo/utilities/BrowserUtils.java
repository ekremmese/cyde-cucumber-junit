package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    /*
   This method will accept int (int seconds) and execute Thread.sleep for given duration
    */
    public static void sleep(int second){
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e){

        }
    }

    /*
This method accepts 3 arguments
• Return type: void
• Arg1: WebDriver
• Arg2: String expectedInUrl : for verify if the url contains given String
-If condition matches, will break loop
• Arg3: String expectedTitle to be compared against actualTitle
     */

    public static void switchWindowAndVerify( String expectedInUrl, String expectedTitle){

        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();


        for (String each : allWindowsHandles) {

            Driver.getDriver().switchTo().window(each);

            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().equals(expectedInUrl)) {
                break;
            }

        }

        //5. Assert: Title contains "expectedInTitle"
        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = expectedTitle;

        Assert.assertTrue(actualTitle.contains(expectedInTitle));

    }
    /*
    This method accepts a String "expectedTitle"
 and Asserts if it is true      */
    public static void verifyTitle( String expectedTitle){
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    /**
    This method will verify if the current URL contains expected value
     */
    public static void verifyURLContains(String expectedInURL){
        String actualTitle = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualTitle.contains(expectedInURL));
    }


    /**
    wait for invisibility
     */

    public static void waitForInvisibilityOf(WebElement webElement){

        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));

    }

    /**
     * This method will accept a dropdown as a WebElement
     * and return all the options' text in a List of String
     * @param dropdownElement
     * @return List<String> actualOptionsAsString
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){

        Select monthDropDown = new Select(dropdownElement);

        //All month options as web element list
        List<WebElement> actualOptionsAsWebElement = monthDropDown.getOptions();

        //All month options as a string list
        List<String> actualOptionsAsString = new ArrayList<>();

        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }

        return actualOptionsAsString;

    }

}
