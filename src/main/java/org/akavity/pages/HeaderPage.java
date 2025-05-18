package org.akavity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HeaderPage extends BasePage {

    @FindBy(css = "button[class*='catalog']")
    private WebElement catalogButton;

    @FindBy(css = "div[class*='search_inputs'] input")
    private WebElement searchField;

    @FindBy(css = "div[class*='vertical_information'] a")
    private List<WebElement> productDescriptions;

    @FindBy(css = "button[aria-label='Войти']")
    private WebElement accountButton;

    @FindBy(css = "a[aria-label='История заказов']")
    private WebElement orderButton;

    @FindBy(css = "a[aria-label='Избранные товары']")
    private WebElement favoriteButton;

    @FindBy(css = "a[href='/cart']")
    private WebElement cartButton;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public WebElement scrollableMenuItem(String name) {
        String xpathOfItem = "//div[contains(@class,'swiper__item')]/a[.='" + name + "']";
        return driver.findElement(By.xpath(xpathOfItem));
    }

    public WebElement headerTitle(String title) {
        String xpathOfTitle = "//header/h1[contains(text(),'" + title + "')]";
        return driver.findElement(By.xpath(xpathOfTitle));
    }

    public WebElement getCatalogButton() {
        return catalogButton;
    }

    public WebElement getSearchField() {
        return searchField;
    }

    public List<WebElement> getProductDescriptions() {
        return productDescriptions;
    }

    public WebElement getAccountButton() {
        return accountButton;
    }

    public WebElement getOrderButton() {
        return orderButton;
    }

    public WebElement getFavoriteButton() {
        return favoriteButton;
    }

    public WebElement getCartButton() {
        return cartButton;
    }
}
