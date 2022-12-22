package com.by.pages;

import com.by.conts.PageNaming;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CatalogPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(css = ".search")
    WebElement searchButton;

    @FindBy(id = "title-search-input")
    WebElement inputLine;

    @FindBy(css = ".st-card__model")
    WebElement nameProduct;

    @FindBy(css = ".st-card__modelwe")
    WebElement wrongEl;

    @FindBy(xpath = "//a[@href='/catalog/tissot/muzhskie/t_sport/seastar_1000_automatic/t1204071104103/']")
    WebElement firstProduct;

    @FindBy(xpath = "//a[@href='/catalog/tissot/muzhskie/t_classic/tissot-gentleman-automatic/t1274104408100/']")
    WebElement secondProduct;

    @FindBy(css = "a[class = 'st-button st-button_inverse']")
    List<WebElement> addPutProductButton;

    @FindBy(xpath = "//*[@id=\"card\"]/div[1]/div/div[3]/div[2]/a")
    WebElement continionsSpoppingButton;

    @FindBy(xpath = "//*[@id=\"brand\"]/label")
    WebElement filterByBrandButton;

    @FindBy(xpath = "//*[@id=\"brand_ddl\"]/label[3]")
    WebElement chooseBrandButton;

    @FindBy(css = "div[class = 'st-card__brand']")
    WebElement nameBrandProduct;

    @FindBy(css = "span[class='small breadcrumbs-item__current']")
    WebElement namePage;

    public CatalogPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    public CatalogPage openPage() {
        driver.navigate().to(PageNaming.CATALOG_PAGE);
        return this;
    }

    public String getCodeOfProduct() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(wrongEl));
        } catch (TimeoutException e) {
            logger.info("get product code");
            return nameProduct.getText();
        }
        return "";
    }

    public CatalogPage putFirstProductInCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,390)", "");
        Actions actions = new Actions(driver);
        actions.moveToElement(firstProduct).perform();
        addPutProductButton.get(0).click();
        logger.info("hover and click on the product card");
        return this;
    }

    public CatalogPage putSecondProductInCart() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,390)", "");
        Actions actions = new Actions(driver);
        actions.moveToElement(secondProduct).perform();
        addPutProductButton.get(1).click();
        logger.info("hover and click on the product card");
        return this;
    }

    public CatalogPage clickSearchButton() {
        searchButton.click();
        logger.info("click search button");
        return this;
    }

    public CatalogPage clickBrandButton() {
        wait.until(ExpectedConditions.elementToBeClickable(filterByBrandButton)).click();
        logger.info("click filter button");
        return this;
    }

    public CatalogPage clickChooseBrandButton() {
        wait.until(ExpectedConditions.elementToBeClickable(chooseBrandButton)).click();
        logger.info("click brand button");
        return this;
    }

    public CatalogPage clickContinionsShoppingButton() {
        wait.until(ExpectedConditions.elementToBeClickable(continionsSpoppingButton)).click();
        logger.info("click continion button");
        return this;
    }

    public String getBrandProduct() {
        return nameBrandProduct.getText();
    }

    public CatalogPage typeTextInInput(String keys) {
        inputLine.sendKeys(keys);
        return this;
    }

    public String getNamePage() {
        return namePage.getText();
    }

}

