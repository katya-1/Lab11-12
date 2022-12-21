package com.by.tests;

import com.by.pages.CartPage;
import com.by.pages.CatalogPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CheckCalculateSumOfProductsInCartTest extends CommonConditions {
    @Test
    public void testCalculateSumOfProductInCart() {
        CatalogPage catalogPage = new CatalogPage(driver);
        CartPage cartPage = new CartPage(driver);

        catalogPage.openPage()
                .putFirstProductInCart()
                .clickContinionsShoppingButton()
                .putSecondProductInCart()
                .clickContinionsShoppingButton();
        cartPage.openPage();
        List<Integer> priceOfFirstProduct = cartPage.getPriceProductInCart();
        int resultpriceOfTwoProducts = priceOfFirstProduct.stream().reduce(0, Integer::sum);
        int priceProductsInCart = cartPage.getFinishPrice();

        assertThat(priceProductsInCart, is(resultpriceOfTwoProducts));
    }
}
