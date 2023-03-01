package com.cydeo.step_definitions;

/*
    In the class we will be able to pass pre & post conditions to eah scenario and each step
     */

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.swing.*;

public class Hooks {

    //import from io.cucumber.java not from Junit
    //@Before
    public void setupScenario() {
        System.out.println("---------Before Scenario is working-----------");    }

    //@Before ("@login")
    public void setupScenarioForLogins() {
        System.out.println("=====Setting up browser using Cucumber @Before");
    }

    //@Before ("@db")
    public void setupForDatabaseScenarios() {
        System.out.println("=====Setting up browser using Cucumber @Before");
    }

    @After
    public void tearDownScenario(Scenario scenario) {

        //scenario.isFailed()-> if scenario fails this method will return TRUE boolean value
        if (scenario.isFailed()) {
            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        }

        Driver.getDriver().close();
        //System.out.println("=====Closing browser using cucumber @After");
        //System.out.println("=====Scenario ended/ Take screenshot is failed!");
    }

    //@BeforeStep
    public void setupStep() {
        System.out.println("-------------------applying setup using @BeforeStep");
    }

    //@AfterStep
    public void afterStep() {
        System.out.println("-------------------->applying teardown using @AfterSetup");
    }


}
