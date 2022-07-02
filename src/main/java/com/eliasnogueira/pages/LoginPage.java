package com.eliasnogueira.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.eliasnogueira.config.ConfigurationManager.configuration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()=\"Login with email instead->\"]")
    private WebElement loginWithEmail;

    @FindBy(id = "email")
    private WebElement emailId;

    @FindBy(id = "password")
    private WebElement password;


    public void clickLoginWithEmail(){
        if(loginWithEmail.isEnabled() && loginWithEmail.isDisplayed())
        loginWithEmail.click();
        Assertions.assertEquals(driver.getTitle(), "Login | 100ms Dashboard");
    }

    public void enterCredential(){
        emailId.sendKeys(configuration().email());
        password.sendKeys(configuration().password());


    }
}
