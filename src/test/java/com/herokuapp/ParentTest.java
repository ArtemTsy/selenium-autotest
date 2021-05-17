package com.herokuapp;

import com.herokuapp.base.TestBase;
import com.herokuapp.pages.HoversPage;
import com.herokuapp.pages.LoginPage;
import com.herokuapp.pages.SecurePage;
import com.herokuapp.pages.TablesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class ParentTest {

    private WebDriver driver;
    protected LoginPage loginPage;
    protected SecurePage securePage;
    protected HoversPage hoversPage;
    protected TablesPage tablesPage;

    @BeforeTest
    public void openBrowser() {

        TestBase testBase = new TestBase();
        testBase.initializeWebDriver();
        driver = TestBase.getDriver();

        initPages();
    }

    @AfterTest
    public void closeBrowser(){
        driver.quit();
    }



    public void initPages(){

        loginPage = PageFactory.initElements(driver, LoginPage.class);
        securePage = PageFactory.initElements(driver, SecurePage.class);
        hoversPage = PageFactory.initElements(driver, HoversPage.class);
        tablesPage = PageFactory.initElements(driver, TablesPage.class);
    }

}
