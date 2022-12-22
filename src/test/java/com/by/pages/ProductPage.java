package com.by.pages;

import com.by.conts.PageNaming;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    public static final String PATTERN ="[0-9]{3,4}";

    @FindBy(className = "secondary")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@href='/cart/']")
    WebElement toCartButton;

    @FindBy(css = "span[class='price-new h4-regular']")
    WebElement priceOfProduct;

    public ProductPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public ProductPage
    openPage() {
        driver.navigate().to(PageNaming.PRODUCT_PAGE);
        return this;
    }

    public ProductPage clickGoToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(toCartButton));
        wait.until(ExpectedConditions.elementToBeClickable(toCartButton)).click();
        logger.info("click go to card button");
        return this;
    }

    public ProductPage clickAddToCartButton() {
        addToCartButton.click();
        logger.info("click add to card button");
        return this;
    }

    public Integer getPriceProduct() {
        String res = priceOfProduct.getText().replaceAll(" ", "");
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(res);
        logger.info("get price of product");
        return matcher.find() ? Integer.parseInt(matcher.group()) : 0;
    }

}
