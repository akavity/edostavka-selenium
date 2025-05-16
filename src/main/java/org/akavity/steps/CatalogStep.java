package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.CatalogPage;
import org.akavity.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class CatalogStep {
    CatalogPage catalogPage;

    public CatalogStep(WebDriver webDriver) {
        this.catalogPage = new CatalogPage(webDriver);
    }

    @Step
    public void clickMenuItem(String name) {
        log.info("Click catalog menu item");
        catalogPage.getMenuItem(name).click();
    }

    @Step
    public void clickDesktopItem(String name) {
        log.info("Click desktop item");
        catalogPage.getDesktopItem(name).click();
    }

    @Step
    public void hoverMenuItem(String name) {
        log.info("Hover menu item");
        WebElement element = catalogPage.getMenuItem(name);

        Utils.hover(catalogPage.getMenuItem(name));
    }
}
