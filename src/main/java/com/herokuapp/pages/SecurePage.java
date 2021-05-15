package com.herokuapp.pages;

import com.herokuapp.props.GlobalProps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.lang.reflect.Parameter;

import static com.herokuapp.base.TestBase.driver;

public class SecurePage {

    @FindBy(xpath = "//div[contains(text(), 'You logged into a secure area!')]")
    private WebElement successMessage;


    @Step("Verify success login")
    public void verifySuccessLogIn() {

        Assert.assertEquals(driver.getCurrentUrl(), GlobalProps.URL_Secure);
        Assert.assertTrue(successMessage.isDisplayed());
    }
}
