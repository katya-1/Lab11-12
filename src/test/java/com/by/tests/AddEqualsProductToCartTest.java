package com.by.tests;

import com.by.pages.CartPage;
import com.by.pages.ProductPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AddEqualsProductToCartTest extends CommonConditions {
    @Test
    public void testAdditionTwoEqualsProductToCart() {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        productPage.openPage();
        int priceOfOneProduct = productPage.getPriceProduct();
        int resultpriceOfOneProduct = priceOfOneProduct * 2;
        productPage.clickAddToCartButton()
                .clickGoToCart();
        cartPage.openPage()
                .clickAddEqualsProductButton();
        List<Integer> priceProductInCart = cartPage.getPriceProductInCart();

        assertThat(priceProductInCart.get(0), is(resultpriceOfOneProduct));
    }
}
