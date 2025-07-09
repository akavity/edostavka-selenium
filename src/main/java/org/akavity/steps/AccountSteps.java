package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.AccountPage;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AccountSteps {
    AccountPage accountPage;

    public AccountSteps(WebDriver webDriver) {
        this.accountPage = new AccountPage(webDriver);
    }

    @Step
    public void enterTelephone(String tel) {
        log.info("Enter telephone number");
        accountPage.getTelephoneField().sendKeys(tel);
    }

    @Step
    public void clickPasswordButton() {
        log.info("Click password button");
        accountPage.getPasswordButton().click();
    }

    @Step
    public void enterPassword(String pas) {
        log.info("Enter password");
        accountPage.getPasswordField().sendKeys(pas);
    }

    @Step
    public void clickSubmitButton() {
        log.info("Click submit button");
        accountPage.getSubmitButton().click();
    }
}
