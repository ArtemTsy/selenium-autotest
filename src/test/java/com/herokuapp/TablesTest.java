package com.herokuapp;

import com.herokuapp.constant.SortingOption;
import org.testng.annotations.Test;

public class TablesTest extends ParentTest {

    @Test(priority = 1)
    public void task5(){

        tablesPage.navigateToTablesPage();
        tablesPage.sortingTable(SortingOption.ALPHABET);
        tablesPage.verifySortingTable(SortingOption.ALPHABET);

        tablesPage.sortingTable(SortingOption.ALPHABET);
        tablesPage.verifySortingTable(SortingOption.REVERSE_ALPHABET);
    }

}
