package org.akavity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends BasePage {

    @FindBy(css = "button[class*='catalog']")
    private WebElement catalogButton;

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
}
