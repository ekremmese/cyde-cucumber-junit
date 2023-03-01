package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage extends BasePage {

    public WebTableLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public  WebElement inputBoxUserName;

    @FindBy(xpath = "//input[@type='password']")
    public  WebElement inputBoxPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public  WebElement loginButton;

    //Login function without credentials
    public  void WebTableLoginFunction(){
        loginButton.click();
    }

    public  void WebTableLoginFunction(String username, String password){
        inputBoxUserName.sendKeys(username);
        inputBoxPassword.sendKeys(password);
        loginButton.click();
    }

    public  void LoginWithConfig(){
        this.inputBoxUserName.sendKeys(ConfigurationReader.getProperty("userName"));
        this.inputBoxPassword.sendKeys(ConfigurationReader.getProperty("password"));
        this.loginButton.click();
    }



}
