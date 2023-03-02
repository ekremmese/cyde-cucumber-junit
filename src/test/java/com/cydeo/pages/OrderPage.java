package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends BasePage {

    public OrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@name='product']")
    public WebElement productDropdown;

    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement inputQuantity;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement inputName;

    @FindBy(xpath = "//input[@name='street']")
    public WebElement inputStreet;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement inputCity;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement inputState;

    @FindBy(xpath = "//input[@name='zip']")
    public WebElement inputZipCode;

    @FindBy(name = "card")
    public List<WebElement> cardType;

    @FindBy(name = "cardNo")
    public WebElement cardInput;

    @FindBy(name = "cardExp")
    public WebElement cardExpInput;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public WebElement processOrderButton;
    
    








}
