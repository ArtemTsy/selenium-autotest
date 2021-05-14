package com.herokuapp;

import com.herokuapp.props.GlobalProps;
import com.herokuapp.props.LoginProps;
import com.herokuapp.props.SecureProps;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends ParentTest{


    @Test(priority = 1)
    public void correctLogin(){

        driver.get(GlobalProps.URL_Login);
        loginPage.setUsername(LoginProps.CorrectUsername);
        loginPage.setPassword(LoginProps.CorrectPassword);
        loginPage.clickSingInButton();
        Assert.assertEquals(securePage.getSuccessMessage(), SecureProps.successMessageLabel);
    }

}
