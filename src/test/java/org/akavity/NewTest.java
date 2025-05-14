package org.akavity;

import org.akavity.driver.DriverManager;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.PopUpsSteps;
import org.openqa.selenium.WebDriver;
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

    @Test
    public void clickHorizontalMenuItem() {
        popUpsSteps.acceptCookie();
        headerSteps.clickScrollableMenuItem("Акции");
        //  WaitUtils.sleep(10000);
    }
}
