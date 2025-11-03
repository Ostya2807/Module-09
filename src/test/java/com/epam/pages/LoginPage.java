package com.epam.pages;

import com.epam.models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    private WebDriver driver;
    @FindBy(id = "user-name")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(css = ".error-message-container")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void login(User user) {
        waitForElementToBeVisible(usernameField);
        waitForElementToBeVisible(passwordField);
        usernameField.clear();
        usernameField.sendKeys(user.getUsername());
        passwordField.clear();
        passwordField.sendKeys(user.getPassword());
        loginButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
