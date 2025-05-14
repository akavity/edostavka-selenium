package org.akavity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PopUpsPage extends BasePage {

    @FindBy(css = "div[data-testid='root'] button[class*='black']")
    private WebElement acceptCookieButton;

    public PopUpsPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getAcceptCookieButton() {
        return acceptCookieButton;
    }
}
