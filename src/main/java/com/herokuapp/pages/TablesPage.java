package com.herokuapp.pages;

import com.herokuapp.base.TestBase;
import com.herokuapp.constant.SortingOption;
import com.herokuapp.props.GlobalProps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.*;
import java.util.stream.Collectors;

public class TablesPage {

    @FindBy(xpath = "//*[@id='table2']/tbody/tr/td[contains(@class, 'last-name')]")
    private List<WebElement> lastNameElements;

    @FindBy(xpath = "//*[@id='table2']/thead/tr/th[1]")
    private WebElement lastName;


    public void navigateToTablesPage(){
        TestBase.getDriver().navigate().to(GlobalProps.URL_Tables);
    }

    Comparator<String> stringComparatorReversed = Comparator
            .comparing(String::toString).reversed();

    Comparator<String> stringComparator = Comparator
            .comparing(String::toString);


    public void verifySortingTable(SortingOption sortingOption) {
        List<String> sortedLastNameList = null;

        if (SortingOption.REVERSE_ALPHABET == sortingOption){
            sortedLastNameList = lastNameElements.stream()
                    .map(WebElement::getText).sorted(stringComparatorReversed)
                    .collect(Collectors.toList());
        }

        if (SortingOption.ALPHABET == sortingOption){
            sortedLastNameList = lastNameElements.stream()
                    .map(WebElement::getText).sorted(stringComparator)
                    .collect(Collectors.toList());
        }


        List<String> lastNameList = lastNameElements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        for (int i = 0; i < lastNameList.size(); i++){
            Assert.assertEquals(sortedLastNameList.get(i), lastNameList.get(i));
        }
    }

    public void sortingTable(SortingOption sortingOptions) {

        switch (sortingOptions) {
            case ALPHABET:
                if (lastName.getAttribute("className").equals("header")) {
                    lastName.click();
                    break;
                }
                if (lastName.getAttribute("className").equals("header headerSortDown")) {
                    lastName.click();
                    break;
                }
                break;
            case REVERSE_ALPHABET:
                if(lastName.getAttribute("className").equals("header")){
                    lastName.click();
                    lastName.click();
                    break;
                }
                if(lastName.getAttribute("className").equals("header headerSortUp")){
                    lastName.click();
                    break;
                }
                break;
        }

    }
}
