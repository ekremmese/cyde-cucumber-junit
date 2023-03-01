package com.cydeo.step_definitions;

import com.cydeo.pages.DataTablePage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class DataTable_StepDefinitions {

    DataTablePage dataTablePage = new DataTablePage();

    @Then("user should see fruits I like")
    public void user_should_see_fruits_i_like(List<String> fruits) {
        System.out.println(fruits);
    }
    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }

    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> monthTable) {

        Select monthDropDown = new Select(dataTablePage.dropDown);

        List<WebElement> actualOptionsAsWebElement = monthDropDown.getOptions();

        List<String> actualMonthTable = new ArrayList<>();

        for (WebElement webElement : actualOptionsAsWebElement) {
            actualMonthTable.add(webElement.getText());
        }

        Assert.assertEquals(monthTable,actualMonthTable);
        //Assert will check the size of the lists first. If it is matching it will check content 1 by 1


    }


}
