package com.by.tests;

import com.by.pages.CatalogPage;
import org.testng.annotations.Test;

import static com.by.conts.TestConstant.BRAND_NAME;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CheckFilterByBrandTest extends CommonConditions {
    @Test
    public void testFilterByBrand() {
        CatalogPage catalogPage = new CatalogPage(driver);

        catalogPage.openPage()
                .clickBrandButton()
                .clickChooseBrandButton();
        String resultBrandProduct = catalogPage.getBrandProduct();

        assertThat(resultBrandProduct, is(BRAND_NAME));
    }
}
