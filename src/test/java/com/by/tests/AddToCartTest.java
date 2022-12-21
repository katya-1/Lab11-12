package com.by.tests;

import com.by.pages.CartPage;
import com.by.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.by.conts.TestConstant.PRODUCT_CODE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AddToCartTest extends CommonConditions {
    @Test
    public void testAdditionToCart() {
        ProductPage productPage = new ProductPage(driver);
        CartPage cartPage = new CartPage(driver);

        productPage.openPage()
                .clickAddToCartButton()
                .clickGoToCart();
        String result = cartPage.getProductCode();

        assertThat(result, is(PRODUCT_CODE));
    }
}
