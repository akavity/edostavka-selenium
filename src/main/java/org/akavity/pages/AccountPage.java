package org.akavity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {
    @FindBy(css = "input[id='tel']")
    private WebElement telephoneField;

    @FindBy(css = "button[class*='login_enter_button']")
    private WebElement passwordButton;

    @FindBy(css = "input[id='current-password']")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getTelephoneField() {
        return telephoneField;
    }

    public WebElement getPasswordButton() {
        return passwordButton;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }
}
