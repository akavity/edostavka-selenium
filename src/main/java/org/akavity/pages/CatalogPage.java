package org.akavity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CatalogPage extends BasePage {

    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getMenuItem(String name) {
        String xpathOfItem = "//li[@role='menuitem']//span[contains(text(),'" + name + "')]";
        return driver.findElement(By.xpath(xpathOfItem));
    }

    public WebElement getDesktopItem(String name) {
        String xpathOfItem = "//ul[contains(@class,'desktop_subcategory')]/li/a[contains(text(),'" + name + "')]";
        return driver.findElement(By.xpath(xpathOfItem));
    }
}
