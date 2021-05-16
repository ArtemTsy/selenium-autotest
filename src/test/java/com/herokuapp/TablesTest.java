package com.herokuapp;

import com.herokuapp.constant.SortingOption;
import com.herokuapp.listeners.AllureListeners;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners({AllureListeners.class})
public class TablesTest extends ParentTest {

    @Epic("Тесты веб-приложения herokuapp")
    @Feature("Тестирование сортировки таблицы 2 по колонке last name")
    @Description(value = "В этом тесте происходит переход на страницу с таблицами и сортировка таблицы 2 по колонке last name")
    @Story("Тест проверяет сортировку таблицы по возрастанию(позитивный сценарий)")
    @Owner("Цымляков Артем Дмитриевич")
    @Test(priority = 1)
    public void task5SortingTableAscendingPositive(){

        //positive scenarios
        tablesPage.navigateToTablesPage();
        tablesPage.sortingTableByLastName(SortingOption.ALPHABET);
        tablesPage.verifySortingTableByLastName(SortingOption.ALPHABET);
    }

    @Epic("Тесты веб-приложения herokuapp")
    @Feature("Тестирование сортировки таблицы 2 по колонке last name")
    @Description(value = "В этом тесте происходит переход на страницу с таблицами и сортировка таблицы 2 по колонке last name")
    @Story("Тест проверяет сортировку таблицы по возрастанию(негативный сценарий)")
    @Owner("Цымляков Артем Дмитриевич")
    @Test(priority = 2)
    public void task5SortingTableAscendingNegative(){

        //negative scenarios
        tablesPage.navigateToTablesPage();
        tablesPage.sortingTableByLastName(SortingOption.REVERSE_ALPHABET);
        tablesPage.verifySortingTableByLastName(SortingOption.ALPHABET);
    }

    @Epic("Тесты веб-приложения herokuapp")
    @Feature("Тестирование сортировки таблицы 2 по колонке last name")
    @Description(value = "В этом тесте происходит переход на страницу с таблицами и сортировка таблицы 2 по колонке last name")
    @Story("Тест проверяет сортировку таблицы по убыванию(позитивный сценарий)")
    @Owner("Цымляков Артем Дмитриевич")
    @Test(priority = 3)
    public void task5SortingTableDescendingPositive(){

        //positive scenarios
        tablesPage.navigateToTablesPage();
        tablesPage.sortingTableByLastName(SortingOption.REVERSE_ALPHABET);
        tablesPage.verifySortingTableByLastName(SortingOption.REVERSE_ALPHABET);
    }

    @Epic("Тесты веб-приложения herokuapp")
    @Feature("Тестирование сортировки таблицы 2 по колонке last name")
    @Description(value = "В этом тесте происходит переход на страницу с таблицами и сортировка таблицы 2 по колонке last name")
    @Story("Тест проверяет сортировку таблицы по убыванию(негативный сценарий)")
    @Owner("Цымляков Артем Дмитриевич")
    @Test(priority = 2)
    public void task5SortingTableDescendingNegative(){

        //negative scenarios
        tablesPage.navigateToTablesPage();
        tablesPage.sortingTableByLastName(SortingOption.ALPHABET);
        tablesPage.verifySortingTableByLastName(SortingOption.REVERSE_ALPHABET);
    }

    @Epic("Тесты веб-приложения herokuapp")
    @Feature("Тестирование сортировки таблицы 2 по колонке last name")
    @Description(value = "В этом тесте происходит переход на страницу с таблицами и сортировка таблицы 2 по колонке first name")
    @Story("Тест проверяет вариант сортировки, когда таблица упорядочена по колонке, отличающейся от last name(позитивный сценарий)")
    @Owner("Цымляков Артем Дмитриевич")
    @Test(priority = 3)
    public void task5SortingTablePositive(){

        //positive scenarios
        tablesPage.navigateToTablesPage();
        tablesPage.sortingTableByFirstName(SortingOption.ALPHABET);
        tablesPage.verifySortingTableByLastName(SortingOption.NOT_SORTING);
    }

    @Epic("Тесты веб-приложения herokuapp")
    @Feature("Тестирование сортировки таблицы 2 по колонке last name")
    @Description(value = "В этом тесте происходит переход на страницу с таблицами и сортировка таблицы 2 по колонке first name")
    @Story("Тест проверяет вариант сортировки, когда таблица упорядочена по колонке, отличающейся от last name(негативный сценарий)")
    @Owner("Цымляков Артем Дмитриевич")
    @Test(priority = 3)
    public void task5SortingTableNegative(){

        //negative scenarios
        tablesPage.navigateToTablesPage();
        tablesPage.sortingTableByLastName(SortingOption.REVERSE_ALPHABET);
        tablesPage.verifySortingTableByLastName(SortingOption.NOT_SORTING);
    }


}
