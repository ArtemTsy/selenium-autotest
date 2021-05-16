package com.herokuapp.pages;

import com.herokuapp.constant.URLOption;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@id='username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement errorMessage;

    @Step("Enter username")
    public void setUsername(String username) {
        usernameField.sendKeys(username);
    }

    @Step("Enter password")
    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    @Step("Get error message")
    public String getErrorMessage() {
        return errorMessage.getText();
    }

    @Step("Click sign in button")
    public void clickSingInButton() {
        signInButton.click();
    }

    @Step("Navigate to login page")
    public void navigateToLoginPage() {
        driver.navigate().to(URLOption.LOGIN_PAGE.getUrl());
    }

    @Step("Verify error message")
    public void verifyErrorMessage(String textMessage) {

        Assert.assertTrue(errorMessage.isDisplayed());
        Assert.assertTrue(getErrorMessage().contains(textMessage));
    }
}
