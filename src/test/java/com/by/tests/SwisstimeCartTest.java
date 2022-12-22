package com.by.tests;

import com.by.pages.CartPage;
import com.by.pages.CatalogPage;
import com.by.pages.ProductPage;
import org.testng.annotations.Test;

import java.util.List;

import static com.by.conts.TestConstant.CART_EMPTY;
import static com.by.conts.TestConstant.PRODUCT_CODE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SwisstimeCartTest extends CommonConditions {

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
