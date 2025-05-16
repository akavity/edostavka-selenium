package org.akavity.utils;

import org.akavity.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    public static void waitForVisibility(WebElement webElement) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForVisibility(WebElement webElement, int seconds) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOf(webElement));
    }

    public static void waitForClickable(WebElement webElement) {
        new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void hover(WebElement element) {
        Actions builder = new Actions(DriverManager.getDriver());
        builder.moveToElement(element).build().perform();
    }
}
