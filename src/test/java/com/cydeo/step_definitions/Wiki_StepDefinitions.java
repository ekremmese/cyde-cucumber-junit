package com.cydeo.step_definitions;

import com.cydeo.pages.WikipediaPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wiki_StepDefinitions {

    WikipediaPage wikipediaPage = new WikipediaPage();

    @Given("user is on wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get("https://www.wikipedia.org");
    }
    @When("user type {string}")
    public void user_type(String searchItem) {
        wikipediaPage.searchInputBox.sendKeys(searchItem);
    }
    @When("clicks search button")
    public void clicks_search_button() {
        wikipediaPage.searchButton.click();
    }
    @Then("user sees {string} on wikipedia title")
    public void user_sees_on_wikipedia_title(String searchItem) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(searchItem));
    }

    @Then("user sees {string} on wikipedia main header")
    public void user_sees_on_wikipedia_main_header(String string) {
        String actualHeader = wikipediaPage.mainHeader.getText();
        Assert.assertEquals(string,actualHeader);
    }

    @Then("user sees {string} on wikipedia image header")
    public void user_sees_on_wikipedia_image_header(String string) {
        String actualImageHeader = wikipediaPage.imageHeader.getText();
        Assert.assertEquals(string,actualImageHeader);
    }

}
