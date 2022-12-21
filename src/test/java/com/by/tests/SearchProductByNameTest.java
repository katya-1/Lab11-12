package com.by.tests;

import com.by.pages.CatalogPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.by.conts.TestConstant.DATA_INPUT;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchProductByNameTest extends CommonConditions {

    @Test
    public void testSearchingByName() {
        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.openPage()
                .clickSearchButton()
                .typeTextInInput(DATA_INPUT);
        String resultNameProduct = catalogPage.getCodeOfProduct();

        assertThat(resultNameProduct, is(DATA_INPUT));
    }

}

