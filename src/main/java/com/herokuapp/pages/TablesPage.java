package com.herokuapp.pages;

import com.herokuapp.constant.SortingOption;
import com.herokuapp.constant.URLOption;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class TablesPage {

    private WebDriver driver;

    public TablesPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@id='table2']/tbody/tr/td[contains(@class, 'last-name')]")
    private List<WebElement> lastNameElements;

    @FindBy(xpath = "//*[@id='table2']/thead/tr/th[1]")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id='table2']/thead/tr/th[2]")
    private WebElement firstName;

    @Step("Navigate to tables page")
    public void navigateToTablesPage() {
        driver.navigate().to(URLOption.TABLES_PAGE.getUrl());
    }

    @Step("Verify table sorting with {sortingOption}")
    public void verifySortingTableByLastName(SortingOption sortingOption) {

        Comparator<String> stringComparatorReversed = Comparator
                .comparing(String::toString).reversed();

        Comparator<String> stringComparator = Comparator
                .comparing(String::toString);

        List<String> expectedList = null;

        List<String> actualList = lastNameElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        switch (sortingOption) {
            case DESCENDING:
                expectedList = lastNameElements.stream()
                        .map(WebElement::getText).sorted(stringComparatorReversed)
                        .collect(Collectors.toList());
                Assert.assertEquals(actualList, expectedList);
                break;

            case ASCENDING:
                expectedList = lastNameElements.stream()
                        .map(WebElement::getText).sorted(stringComparator)
                        .collect(Collectors.toList());
                Assert.assertEquals(actualList, expectedList);
                break;

            case NOT_SORTING:
                Assert.assertNotEquals(lastNameElements.stream()
                        .map(WebElement::getText).sorted(stringComparator)
                        .collect(Collectors.toList()), actualList, "Tables sorted ascending by last name");
                Assert.assertNotEquals(lastNameElements.stream()
                        .map(WebElement::getText).sorted(stringComparatorReversed)
                        .collect(Collectors.toList()), actualList, "Tables sorted descending by last name");
                break;
        }
    }

    @Step("Sorting table by first name column with {sortingOption}")
    public void sortingTableByFirstName(SortingOption sortingOption) {

        if (sortingOption == SortingOption.ASCENDING) {
            if (firstName.getAttribute("className").equals("header")) {
                firstName.click();
                return;
            }
            if (firstName.getAttribute("className").equals("header headerSortUp")) {
                firstName.click();
            }
        }
    }

    @Step("Sorting table by last name column with {sortingOption}")
    public void sortingTableByLastName(SortingOption sortingOption) {

        switch (sortingOption) {
            case ASCENDING:
                if (lastName.getAttribute("className").equals("header")) {
                    lastName.click();
                    break;
                }
                if (lastName.getAttribute("className").equals("header headerSortUp")) {
                    lastName.click();
                    break;
                }
                break;
            case DESCENDING:
                if (lastName.getAttribute("className").equals("header")) {
                    lastName.click();
                    lastName.click();
                    break;
                }
                if (lastName.getAttribute("className").equals("header headerSortDown")) {
                    lastName.click();
                    break;
                }
                break;
        }

    }
}
