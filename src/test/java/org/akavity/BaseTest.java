package org.akavity;

import org.akavity.driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.ResourceBundle;

public class BaseTest {
    protected WebDriver driver;
    static ResourceBundle bundle = ResourceBundle.getBundle("test_framework");
    private final String URL = bundle.getString("path_to_url");

    @BeforeMethod
    public void setUp() {
        driver = DriverManager.getDriver();
        driver.get(URL);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
