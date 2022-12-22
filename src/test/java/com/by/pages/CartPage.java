package com.by.pages;

import com.by.conts.PageNaming;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    public static final String PATTERN ="[0-9]{4,5}";

    @FindBy(css = "p[class='small']")
    WebElement productSKU;

    @FindBy(css = "div[class='cart-top-delete']")
    WebElement removeButton;

    @FindBy(xpath = "/html/body/section[1]/div/div/div")
    WebElement cartEmpty;

    @FindBy(xpath = "//*[@id=\"sendForm\"]/ul/li[1]/div[2]/div[2]/div[1]/input[3]")
    WebElement addEqualsProductButton;

    @FindBy(css = "div[class = 'h5-regular price-new']")
    List<WebElement> priceProductInCart;

    @FindBy(css = "div[class = 'h5-regular']")
    WebElement finishPriceProductInCart;


    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public CartPage openPage() {
        driver.navigate().to(PageNaming.CART_PAGE);
        return this;
    }

    public Integer getFinishPrice() {
        String res = finishPriceProductInCart.getText().replaceAll(" ", "");
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(res);
        logger.info("calculate sum");
        return matcher.find() ? Integer.parseInt(matcher.group()) : 0;
    }

    public List<Integer> getPriceProductInCart() {
        List<Integer> allPricesInCart = new ArrayList<>();
        for (var i : priceProductInCart) {
            String res = i.getText().replaceAll(" ", "");
            Pattern pattern = Pattern.compile(PATTERN);
            Matcher matcher = pattern.matcher(res);
            allPricesInCart.add(matcher.find() ? Integer.parseInt(matcher.group()) : 0);
        }
        logger.info("get price product");
        return allPricesInCart;
    }

    public CartPage clickRemoveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        removeButton.click();
        logger.info("remove product at cart");
        return this;
    }

    public CartPage clickAddEqualsProductButton() {
        addEqualsProductButton.click();
        logger.info("add product to cart");
        return this;
    }

    public String getProductCode() {
        wait.until(ExpectedConditions.elementToBeClickable(productSKU));
        return productSKU.getText();
    }

    public String getCartEmpty() {
        return cartEmpty.getText();
    }

}
