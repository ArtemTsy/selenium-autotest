package com.herokuapp.pages;

import com.herokuapp.constant.URLOption;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HoversPage {

    private WebDriver driver;

    public HoversPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='content']/div/div[1]")
    public WebElement user1Avatar;

    @FindBy(xpath = "//*[@id='content']/div/div[2]")
    public WebElement user2Avatar;

    @FindBy(xpath = "//*[@id='content']/div/div[3]")
    public WebElement user3Avatar;


    @Step("Hovering to the user avatar")
    public void hoverOverUserAvatar(WebElement webElement){
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).perform();
    }

    @Step("Navigate to hover page")
    public void navigateToHoverPage(){
        driver.navigate().to(URLOption.HOVERS_PAGE.getUrl());
    }

    @Step("Verify username label is displayed")
    public void verifyUsernameLabel(WebElement webElement, String username) {

        Assert.assertTrue(webElement.getText().contains(username));
    }

    @Step("Verify username label is not displayed")
    public void verifyUsernameLabelIsNotDisplayed(WebElement webElement, String username) {

        Assert.assertFalse(webElement.getText().contains(username));
    }
}
