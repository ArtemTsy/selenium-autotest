package com.herokuapp;

import com.herokuapp.base.TestBase;
import com.herokuapp.pages.HoversPage;
import com.herokuapp.pages.LoginPage;
import com.herokuapp.pages.SecurePage;
import com.herokuapp.pages.TablesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static com.herokuapp.base.TestBase.getDriver;

public class ParentTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected SecurePage securePage;
    protected HoversPage hoversPage;
    protected TablesPage tablesPage;

    @BeforeTest
    public void openBrowser() {

        TestBase testBase = new TestBase();
        testBase.initialize();

        driver = getDriver();

        initPages();
    }

    @AfterTest
    public void closeBrowser(){
        TestBase.driver.quit();
    }



    public void initPages(){

        loginPage = PageFactory.initElements(TestBase.getDriver(), LoginPage.class);
        securePage = PageFactory.initElements(TestBase.getDriver(), SecurePage.class);
        hoversPage = PageFactory.initElements(TestBase.getDriver(), HoversPage.class);
        tablesPage = PageFactory.initElements(TestBase.getDriver(), TablesPage.class);
    }

}
