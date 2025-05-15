package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.HeaderPage;
import org.openqa.selenium.WebDriver;

@Log4j2
public class HeaderSteps {
    private HeaderPage headerPage;

    public HeaderSteps(WebDriver driver) {
        headerPage = new HeaderPage(driver);
    }

    @Step("Click the scrollable menu item")
    public void clickScrollableMenuItem(String name) {
        log.info("Click horizontal menu item");
        headerPage.scrollableMenuItem(name).click();
    }

    @Step("Verify title is displayed")
    public boolean verifyTitleIsDisplayed(String title) {
        boolean result = headerPage.headerTitle(title).isDisplayed();
        log.info("Is title displayed: {}", result);
        return result;
    }
}
