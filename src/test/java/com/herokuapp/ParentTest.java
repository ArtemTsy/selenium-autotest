package com.herokuapp;

import com.herokuapp.base.TestBase;
import com.herokuapp.pages.LoginPage;
import com.herokuapp.pages.SecurePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static com.herokuapp.base.TestBase.getDriver;

public class ParentTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected SecurePage securePage;

    @BeforeTest
    public void openBrowser() {

        TestBase testBase = new TestBase();
        testBase.initialize();

        driver = getDriver();

        getPages();
    }

    @AfterTest
    public void closeBrowser(){
        TestBase.driver.quit();
    }

    public void getPages(){
        loginPage = PageFactory.initElements(TestBase.getDriver(), LoginPage.class);
        securePage = PageFactory.initElements(TestBase.getDriver(), SecurePage.class);
    }

}
