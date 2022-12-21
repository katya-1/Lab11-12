package com.by.tests;

import com.by.pages.CartPage;
import com.by.pages.CatalogPage;
import org.testng.annotations.Test;

import java.util.List;

import static com.by.conts.TestConstant.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ContinueShoppingTest extends CommonConditions {
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
