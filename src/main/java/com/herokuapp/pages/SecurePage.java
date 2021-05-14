package com.herokuapp.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurePage {

    @FindBy(xpath = "//div[@id='flash']")
    private WebElement successMessage;

    public String getSuccessMessage() {
        return successMessage.getText();
    }



}
