package com.by.tests;

import com.by.pages.CartPage;
import com.by.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static com.by.conts.TestConstant.*;

public class CheckRemoveProductTest extends CommonConditions {
    @Test
    public void testRemovingProductFromCart() {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        productPage.openPage()
                .clickAddToCartButton()
                .clickGoToCart();
        cartPage.openPage()
                .clickRemoveButton();
        String resultEmptyCart = cartPage.getCartEmpty();

        assertThat(resultEmptyCart, is(CART_EMPTY));
    }
}
