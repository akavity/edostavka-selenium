package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.driver.DriverManager;
import org.akavity.models.headerTest.HorizMenuData;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.PopUpsSteps;
import org.akavity.utils.JsonReader;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NewTest extends BaseTest {
    protected WebDriver driver;
    private HeaderSteps headerSteps;
    private PopUpsSteps popUpsSteps;

    @BeforeClass
    private void startPage() {
        driver = DriverManager.getDriver();
        headerSteps = new HeaderSteps(driver);
        popUpsSteps = new PopUpsSteps(driver);
    }

    @TestData(jsonFile = "horizMenuData", model = "HorizMenuData", folder = "headerTest")
    @Test(description = "Horizontal menu navigation", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void clickHorizontalMenuItem(HorizMenuData horizMenuData) {
        popUpsSteps.acceptCookie();
        headerSteps.clickScrollableMenuItem(horizMenuData.getMenuItem());

        Assert.assertTrue(headerSteps.verifyTitleIsDisplayed(horizMenuData.getTitle()));
    }
}
