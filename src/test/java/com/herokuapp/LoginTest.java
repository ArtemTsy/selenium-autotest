package com.herokuapp;

import com.herokuapp.props.LoginProps;
import org.testng.annotations.Test;

public class LoginTest extends ParentTest{


    @Test(priority = 1)
    public void correctLogin(){

        loginPage.navigateToLoginPage();
        loginPage.setUsername(LoginProps.CorrectUsername);
        loginPage.setPassword(LoginProps.CorrectPassword);
        loginPage.clickSingInButton();
        securePage.verifySuccessLogIn();
    }

    @Test(priority = 2)
    public void incorrectUsername(){

        loginPage.navigateToLoginPage();
        loginPage.setUsername(LoginProps.IncorrectUsername);
        loginPage.setPassword(LoginProps.CorrectPassword);
        loginPage.clickSingInButton();
        loginPage.verifyErrorMessage("Your username is invalid");
    }

    @Test(priority = 3)
    public void incorrectPassword(){

        loginPage.navigateToLoginPage();
        loginPage.setUsername(LoginProps.CorrectUsername);
        loginPage.setPassword(LoginProps.IncorrectPassword);
        loginPage.clickSingInButton();
        loginPage.verifyErrorMessage("Your password is invalid!");
    }

}
