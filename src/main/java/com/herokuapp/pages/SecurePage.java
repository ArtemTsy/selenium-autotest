package com.herokuapp.pages;

import com.herokuapp.constant.URLOption;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SecurePage {

    private WebDriver driver;

    public SecurePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[contains(text(), 'You logged into a secure area!')]")
    private WebElement successMessage;


    @Step("Verify success login")
    public void verifySuccessLogIn() {

        Assert.assertEquals(driver.getCurrentUrl(), URLOption.SECURE_PAGE.getUrl());
        Assert.assertTrue(successMessage.isDisplayed());
    }
}
