package com.herokuapp.pages;

import com.herokuapp.base.TestBase;
import com.herokuapp.props.GlobalProps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HoversPage {

    @FindBy(xpath = "//*[@id='content']/div/div[1]")
    public WebElement user1Avatar;

    @FindBy(xpath = "//*[@id='content']/div/div[2]")
    public WebElement user2Avatar;

    @FindBy(xpath = "//*[@id='content']/div/div[3]")
    public WebElement user3Avatar;


    @Step("Hovering to the user avatar")
    public void hoverOverUserAvatar(WebElement webElement){
        Actions actions = new Actions(TestBase.getDriver());
        actions.moveToElement(webElement).perform();
    }

    @Step("Navigate to hover page")
    public void navigateToHoverPage(){
        TestBase.getDriver().navigate().to(GlobalProps.URL_Hovers);
    }

    @Step("")
    public void verifyUsernameLabel(WebElement webElement, String username) {

        Assert.assertTrue(webElement.isDisplayed());
        Assert.assertTrue(webElement.getText().contains(username));
    }
}
