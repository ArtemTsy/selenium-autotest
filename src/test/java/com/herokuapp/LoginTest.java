package com.herokuapp;


import com.herokuapp.helpers.LoginProps;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class LoginTest extends ParentTest{

    @Epic("Тесты веб-приложения herokuapp")
    @Feature("Тестирование входа в приложение")
    @Description(value = "В этом тесте происходит переход на страницу логина и вход в приложение с корректными значениями полей")
    @Story("Тест проверяет вход в приложение с корректными данными")
    @Owner("Цымляков Артем Дмитриевич")
    @Test(priority = 1)
    public void task1CorrectLogin(){

        loginPage.navigateToLoginPage();
        loginPage.setUsername(LoginProps.CorrectUsername);
        loginPage.setPassword(LoginProps.CorrectPassword);
        loginPage.clickSingInButton();
        securePage.verifySuccessLogIn();
    }

    @Epic("Тесты веб-приложения herokuapp")
    @Feature("Тестирование входа в приложение")
    @Description(value = "В этом тесте происходит переход на страницу логина и вход в приложение с некоректным логином")
    @Story("Тест проверяет вход в приложение с некорректным логином")
    @Owner("Цымляков Артем Дмитриевич")
    @Test(priority = 2)
    public void task2IncorrectUsername(){

        loginPage.navigateToLoginPage();
        loginPage.setUsername(LoginProps.IncorrectUsername);
        loginPage.setPassword(LoginProps.CorrectPassword);
        loginPage.clickSingInButton();
        loginPage.verifyErrorMessage("Your username is invalid");
    }

    @Epic("Тесты веб-приложения herokuapp")
    @Feature("Тестирование входа в приложение")
    @Description(value = "В этом тесте происходит переход на страницу логина и вход в приложение с некоректным паролем")
    @Story("Тест проверяет вход в приложение с некорректным паролем")
    @Owner("Цымляков Артем Дмитриевич")
    @Test(priority = 3)
    public void task3IncorrectPassword(){

        loginPage.navigateToLoginPage();
        loginPage.setUsername(LoginProps.CorrectUsername);
        loginPage.setPassword(LoginProps.IncorrectPassword);
        loginPage.clickSingInButton();
        loginPage.verifyErrorMessage("Your password is invalid!");
    }

}
