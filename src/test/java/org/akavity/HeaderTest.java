package org.akavity;

import org.akavity.annotations.TestData;
import org.akavity.models.headerTest.AccountData;
import org.akavity.models.headerTest.CatalogData;
import org.akavity.models.headerTest.HorizMenuData;
import org.akavity.models.headerTest.SearchData;
import org.akavity.steps.AccountSteps;
import org.akavity.steps.CatalogStep;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.PopUpsSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HeaderTest extends BaseTest {
    private HeaderSteps headerSteps;
    private PopUpsSteps popUpsSteps;
    private CatalogStep catalogStep;
    private AccountSteps accountSteps;

    @BeforeMethod
    public void initSteps() {
        headerSteps = new HeaderSteps(driver);
        popUpsSteps = new PopUpsSteps(driver);
        catalogStep = new CatalogStep(driver);
        accountSteps = new AccountSteps(driver);
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

    @TestData(jsonFile = "accountData", model = "AccountData", folder = "headerTest")
    @Test(description = "Login to account using password", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void loginToAccount(AccountData accountData) {
        popUpsSteps.acceptCookie();
        headerSteps.clickAccountButton(accountData.getLabelEnter());
        accountSteps.enterTelephone(accountData.getTelephone());
        accountSteps.clickPasswordButton();
        accountSteps.enterPassword(accountData.getPassword());
        accountSteps.clickSubmitButton();

        Assert.assertTrue(headerSteps.isAccountDisplayed(accountData.getLabelName()));
    }
}
