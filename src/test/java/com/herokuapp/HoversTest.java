package com.herokuapp;

import io.qameta.allure.*;
import org.testng.annotations.Test;

public class HoversTest extends ParentTest {

    @Epic("Тесты веб-приложения herokuapp")
    @Feature("Тестирование страницы с аватарами")
    @Description(value = "В этом тесте происходит переход на страницу с аватарами и наведение курсора на аватар 1")
    @Story("Тест проверяет отображение лейбла с именем пользователя 1 при наведении курсора на аватар")
    @Owner("Цымляков Артем Дмитриевич")
    @Test(priority = 1)
    public void task4DisplayingUsername1() {

        hoversPage.navigateToHoverPage();
        hoversPage.verifyUsernameLabelIsNotDisplayed(hoversPage.user1Avatar, "user1");
        hoversPage.hoverOverUserAvatar(hoversPage.user1Avatar);
        hoversPage.verifyUsernameLabel(hoversPage.user1Avatar, "user1");
    }

    @Epic("Тесты веб-приложения herokuapp")
    @Feature("Тестирование страницы с аватарами")
    @Description(value = "В этом тесте происходит переход на страницу с аватарами и наведение курсора на аватар 2")
    @Story("Тест проверяет отображение лейбла с именем пользователя 2 при наведении курсора на аватар")
    @Owner("Цымляков Артем Дмитриевич")
    @Test(priority = 2)
    public void task4DisplayingUsername2() {

        hoversPage.navigateToHoverPage();
        hoversPage.verifyUsernameLabelIsNotDisplayed(hoversPage.user2Avatar, "user2");
        hoversPage.hoverOverUserAvatar(hoversPage.user2Avatar);
        hoversPage.verifyUsernameLabel(hoversPage.user2Avatar, "user2");
    }

    @Epic("Тесты веб-приложения herokuapp")
    @Feature("Тестирование страницы с аватарами")
    @Description(value = "В этом тесте происходит переход на страницу с аватарами и наведение курсора на аватар 3")
    @Story("Тест проверяет отображение лейбла с именем пользователя 3 при наведении курсора на аватар")
    @Owner("Цымляков Артем Дмитриевич")
    @Test(priority = 3)
    public void task4DisplayingUsername3() {

        hoversPage.navigateToHoverPage();
        hoversPage.verifyUsernameLabelIsNotDisplayed(hoversPage.user3Avatar, "user3");
        hoversPage.hoverOverUserAvatar(hoversPage.user3Avatar);
        hoversPage.verifyUsernameLabel(hoversPage.user3Avatar, "user3");
    }
}
