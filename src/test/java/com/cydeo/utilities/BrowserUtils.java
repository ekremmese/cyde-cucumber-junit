package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    /*
    wait for invisibility
     */

    public static void waitForInvisibilityOf(WebElement webElement){

        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));

    }

}
