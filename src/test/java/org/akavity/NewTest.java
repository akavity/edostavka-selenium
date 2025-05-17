package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.headerTest.CatalogData;
import org.akavity.models.headerTest.HorizMenuData;
import org.akavity.models.headerTest.SearchData;
import org.akavity.steps.CatalogStep;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.PopUpsSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest extends BaseTest {
    private HeaderSteps headerSteps;
    private PopUpsSteps popUpsSteps;
    private CatalogStep catalogStep;

    @BeforeMethod
    public void initSteps() {
        headerSteps = new HeaderSteps(driver);
        popUpsSteps = new PopUpsSteps(driver);
        catalogStep = new CatalogStep(driver);
    }

    @TestData(jsonFile = "horizMenuData", model = "HorizMenuData", folder = "headerTest")
    @Test(description = "Horizontal menu navigation", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void horizontalMenuNavigation(HorizMenuData horizMenuData) {
        popUpsSteps.acceptCookie();
        headerSteps.clickScrollableMenuItem(horizMenuData.getMenuItem());

        Assert.assertTrue(headerSteps.verifyTitleIsDisplayed(horizMenuData.getTitle()));
    }

    @TestData(jsonFile = "catalogData", model = "CatalogData", folder = "headerTest")
    @Test(description = "Catalog navigation", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void catalogNavigation(CatalogData catalogData) {
        popUpsSteps.acceptCookie();
        headerSteps.clickCatalogButton();
        catalogStep.hoverMenuItem(catalogData.getMenuItem());
        catalogStep.clickDesktopItem(catalogData.getDesktopItem());

        Assert.assertTrue(headerSteps.verifyTitleIsDisplayed(catalogData.getTitle()));
    }

    @TestData(jsonFile = "searchData", model = "SearchData", folder = "headerTest")
    @Test(description = "Search for a product using search", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void searchForProduct(SearchData searchData) {
        popUpsSteps.acceptCookie();
        headerSteps.performSearchWithText(searchData.getText());

        Assert.assertTrue(headerSteps.doProductDescriptionsContainText(searchData.getText(), searchData.getLimit()));
    }
}
