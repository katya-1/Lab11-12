package com.by.pages;

import com.by.conts.PageNaming;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductPage extends AbstractPage {

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
        toCartButton.click();
        return this;
    }

    public ProductPage clickAddToCartButton() {
        addToCartButton.click();
        return this;
    }

    public Integer getPriceProduct() {
        String res = priceOfProduct.getText().replaceAll(" ", "");
        Pattern pattern = Pattern.compile("[0-9]{3,4}");
        Matcher matcher = pattern.matcher(res);
        return matcher.find() ? Integer.parseInt(matcher.group()) : 0;
    }

}
