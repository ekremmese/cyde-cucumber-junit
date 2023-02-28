package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleStepDefinitions {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

    @When("user is on Google search page")
    public void user_is_on_google_search_page() {

        Driver.getDriver().get("https://www.google.com");

    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {

        //Assert.assertTrue(Driver.getDriver().getTitle().contains("Google"));
        Assert.assertEquals("Google", Driver.getDriver().getTitle());

    }

    @When("user type apple and clicks enter")
    public void userTypeAppleAndClicksEnter() {

        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
    }

    @Then("user sees apple in the google title")
    public void userSeesAppleInTheGoogleTitle() {
        String expectedTitle = "apple - Google'da Ara";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }
}

//TC#1: Google Search Functionality Title Verification
//1. User is on Google search page
//2. User types apple in the google search box and clicks enter
//3. User sees Steve Jobs is in the google title
//Note: Follow POM