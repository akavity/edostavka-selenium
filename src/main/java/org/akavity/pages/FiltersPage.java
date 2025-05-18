package org.akavity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FiltersPage extends BasePage {

    @FindBy(css = "input[placeholder*='От']")
    private WebElement minPriceField;

    @FindBy(css = "input[placeholder*='До']")
    private WebElement maxPriceField;

    @FindBy(xpath = "//span[contains(text(),'Бренд')]/../..//button")
    private WebElement allBrandsButton;

    @FindBy(xpath = "//span[contains(text(),'Страна')]/../..//button")
    private WebElement allCountriesButton;

    @FindBy(css = "button[class*='filter_clear']")
    private WebElement filterClearButton;

    public FiltersPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getCategoriesItem(String name) {
        return driver.findElement(By.xpath("//div[contains(@class,'categories_c')]//a[contains(text(),'" + name + "')]"));
    }

    public WebElement getPromotionRadio(String name) {
        return driver.findElement(By.xpath("//span[@class='radio__title' and contains(text(),'" + name + "')]"));
    }

    public WebElement getBrandCheckbox(String name) {
        return driver.findElement(By.xpath("//span[contains(text(),'Бренд')]/../.." +
                "//span[@class='checkbox__title' and contains(text(),'" + name + "')]"));
    }

    public WebElement getCountryCheckbox(String name) {
        return driver.findElement(By.xpath("//span[contains(text(),'Страна')]/../.." +
                "//span[@class='checkbox__title' and contains(text(),'" + name + "')]"));
    }

    public WebElement getMinPriceField() {
        return minPriceField;
    }

    public WebElement getMaxPriceField() {
        return maxPriceField;
    }

    public WebElement getAllBrandsButton() {
        return allBrandsButton;
    }

    public WebElement getAllCountriesButton() {
        return allCountriesButton;
    }

    public WebElement getFilterClearButton() {
        return filterClearButton;
    }
}
