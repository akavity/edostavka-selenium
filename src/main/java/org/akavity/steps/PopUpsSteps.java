package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.PopUpsPage;
import org.openqa.selenium.WebDriver;

@Log4j2
public class PopUpsSteps {
    PopUpsPage popUpsPage;

    public PopUpsSteps(WebDriver driver) {
        popUpsPage = new PopUpsPage(driver);
    }

    @Step
    public void acceptCookie() {
        log.info("Click button \"Accept cookie\"");
        popUpsPage.getAcceptCookieButton().click();
    }
}
