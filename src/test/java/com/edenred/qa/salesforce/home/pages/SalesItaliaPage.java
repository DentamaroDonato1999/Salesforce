package com.edenred.qa.salesforce.home.pages;

import com.edenred.qa.salesforce.pages.WebPage;
import net.serenitybdd.annotations.WhenPageOpens;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SalesItaliaPage extends WebPage {

    @FindBy(css = ".span[title='Sales Italia']")
    WebElementFacade title;

    @FindBy(css = ".button[name='IT_NewAccount']")
    WebElementFacade btnNewAccount;

    @FindBy(css = ".a[title='Attività']")
    WebElementFacade tabAttivita;

    @FindBy(css = ".a[title='Dashboard']")
    WebElementFacade tabDashboard;

    @FindBy(css = ".a[title='Incentivi']")
    WebElementFacade tabIncentivi;
    @FindBy(css = ".a[title='Medallia']")
    WebElementFacade tabMedallia;

    @FindBy(css = ".a[title='Incentivi Merchant']")
    WebElementFacade tabIncentiviMerchant;

    @FindBy(xpath="//span[contains(.,'Lead')]")
    WebElementFacade smallTitle;

    @FindBy(css=".a[title='My Leads (new)']")
    WebElementFacade tableTitle;

    @Override
    @WhenPageOpens
    public void waitUntilTitleAppears() {
        title.waitUntilVisible();
    }
}
