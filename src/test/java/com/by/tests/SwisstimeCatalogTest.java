package com.by.tests;

import com.by.pages.CatalogPage;
import org.testng.annotations.Test;

import static com.by.conts.TestConstant.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SwisstimeCatalogTest extends CommonConditions {
    @Test
    public void testFilterByBrand() {
        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.openPage()
                .clickBrandButton()
                .clickChooseBrandButton();
        String resultBrandProduct = catalogPage.getBrandProduct();

        assertThat(resultBrandProduct, is(BRAND_NAME));
    }

    @Test
    public void testSearchingByName() {
        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.openPage()
                .clickSearchButton()
                .typeTextInInput(DATA_INPUT);
        String resultNameProduct = catalogPage.getCodeOfProduct();

        assertThat(resultNameProduct, is(DATA_INPUT));
    }

    @Test
    public void testContinueShoppingWithHelpButton() {
        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.openPage()
                .putFirstProductInCart()
                .clickContinionsShoppingButton();
        String resultPagePosition = catalogPage.getNamePage();

        assertThat(resultPagePosition, is(PAGE_POSITION));
    }
}
