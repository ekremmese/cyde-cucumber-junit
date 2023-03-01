package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class webTableLogin_StepDefinitions {

    WebTableLoginPage webTableLoginPage = new WebTableLoginPage();

    @Given("user is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        String url = ConfigurationReader.getProperty("webTableUrl");
        Driver.getDriver().get(url);
    }

    @When("user enters username {string}")
    public void user_enters_username(String string) {
        webTableLoginPage.inputBoxUserName.sendKeys(string);
    }

    @When("user enters password {string}")
    public void user_enters_password(String string) {
        webTableLoginPage.inputBoxPassword.sendKeys(string);
    }

    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webTableLoginPage.loginButton.click();
    }

    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {

        BrowserUtils.verifyURLContains("orders");
    }

    @When("user enters username {string} password {string} and logins")
    public void user_enters_username_password_and_logins(String string, String string2) {
        webTableLoginPage.WebTableLoginFunction(string,string2);
    }

    @When("User enters below credentials")
    public void user_enters_below_credentials(Map<String,String> credentials) {

       // webTableLoginPage.inputBoxUserName.sendKeys(credentials.get("username"));
        //webTableLoginPage.inputBoxPassword.sendKeys(credentials.get("password"));
        //webTableLoginPage.loginButton.click();

        webTableLoginPage.WebTableLoginFunction(credentials.get("username"),credentials.get("password"));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("orders"));

    }

}
