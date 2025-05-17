package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.HeaderPage;
import org.akavity.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class HeaderSteps {
    private HeaderPage headerPage;

    public HeaderSteps(WebDriver webDriver) {
        headerPage = new HeaderPage(webDriver);
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

    @Step
    public void clickCatalogButton() {
        log.info("CLick catalog button");
        headerPage.getCatalogButton().click();
    }

    @Step
    public void performSearchWithText(String text) {
        log.info("Enter text into search: {}", text);
        WebElement element = headerPage.getSearchField();
        element.click();
        element.sendKeys(text);
        element.submit();
    }

    @Step
    public boolean doProductDescriptionsContainText(String text, int limit) {
        Utils.sleep(2000);
        return headerPage.getProductDescriptions()
                .stream()
                .limit(limit)
                .map(x -> {
                    String label = x.getDomAttribute("aria-label");
                    log.info("Text: {}", label);
                    return label != null ? label.toLowerCase() : "";
                })
                .allMatch(t -> t.contains(text.toLowerCase()));
    }
}
