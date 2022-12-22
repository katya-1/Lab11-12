package com.by.tests;

import com.by.pages.CartPage;
import com.by.pages.CatalogPage;
import com.by.pages.ProductPage;
import org.testng.annotations.Test;

import static com.by.conts.TestConstant.BRAND_NAME;
import static com.by.conts.TestConstant.CART_EMPTY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CheckFilterByBrandTest extends CommonConditions {
    @Test
    public void testFilterByBrand() {
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
