package com.by.pages;

import com.by.conts.PageNaming;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartPage extends AbstractPage {

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

    public CartPage clickRemoveButton() {
        wait.until(ExpectedConditions.elementToBeClickable(removeButton));
        removeButton.click();
        return this;
    }

    public String getProductCode() {
        return productSKU.getText();
    }

    public String getCartEmpty() {
        return cartEmpty.getText();
    }

    public Integer getFinishPrice() {
        String res = finishPriceProductInCart.getText().replaceAll(" ", "");
        Pattern pattern = Pattern.compile("[0-9]{4,5}");
        Matcher matcher = pattern.matcher(res);
        return matcher.find() ? Integer.parseInt(matcher.group()) : 0;
    }

    public CartPage clickAddEqualsProductButton() {
        addEqualsProductButton.click();
        return this;
    }

    public List<Integer> getPriceProductInCart() {
        List<Integer> allPricesInCart = new ArrayList<>();
        for (var i : priceProductInCart) {
            String res = i.getText().replaceAll(" ", "");
            Pattern pattern = Pattern.compile("[0-9]{4,5}");
            Matcher matcher = pattern.matcher(res);
            allPricesInCart.add(matcher.find() ? Integer.parseInt(matcher.group()) : 0);
        }
        return allPricesInCart;
    }
}
