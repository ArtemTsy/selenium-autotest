package com.herokuapp.pages;

import com.herokuapp.base.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage {

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
    public void getErrorMessage() {
        errorMessage.getText();
    }

    @Step("Click sign in button")
    public void clickSingInButton() {
        signInButton.click();
    }

    public void verifyElementPresent(String text) {
        Assert.assertTrue(TestBase.getDriver().findElement(By.linkText(text)).isDisplayed(), text + " is present");
    }
}
