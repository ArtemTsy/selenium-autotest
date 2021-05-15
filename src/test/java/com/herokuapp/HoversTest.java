package com.herokuapp;

import com.herokuapp.props.GlobalProps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HoversTest extends ParentTest {

    @Test(priority = 1)
    public void task4() {

        hoversPage.navigateToHoverPage();
        hoversPage.hoverOverUserAvatar(hoversPage.user1Avatar);
        hoversPage.verifyUsernameLabel(hoversPage.user1Avatar, "user1");

        hoversPage.hoverOverUserAvatar(hoversPage.user2Avatar);
        hoversPage.verifyUsernameLabel(hoversPage.user2Avatar, "user2");

        hoversPage.hoverOverUserAvatar(hoversPage.user3Avatar);
        hoversPage.verifyUsernameLabel(hoversPage.user3Avatar, "user3");
    }

}
