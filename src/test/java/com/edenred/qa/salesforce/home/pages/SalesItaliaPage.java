package com.edenred.qa.salesforce.home.pages;

import com.codeborne.selenide.SelenideElement;
import com.edenred.qa.salesforce.annotations.PageIdentifier;
import com.edenred.qa.salesforce.pages.WebPage;
import org.openqa.selenium.support.FindBy;

public class SalesItaliaPage extends WebPage {

    @PageIdentifier
    @FindBy(css = ".span[title='Sales Italia']")
    SelenideElement title;

    @FindBy(css = ".button[name='IT_NewAccount']")
    SelenideElement btnNewAccount;

    @FindBy(css = ".a[title='Attività']")
    SelenideElement tabAttivita;

    @FindBy(css = ".a[title='Dashboard']")
    SelenideElement tabDashboard;

    @FindBy(css = ".a[title='Incentivi']")
    SelenideElement tabIncentivi;
    @FindBy(css = ".a[title='Medallia']")
    SelenideElement tabMedallia;

    @FindBy(css = ".a[title='Incentivi Merchant']")
    SelenideElement tabIncentiviMerchant;

    @FindBy(xpath="//span[contains(.,'Lead')]")
    SelenideElement smallTitle;

    @FindBy(css=".a[title='My Leads (new)']")
    SelenideElement tableTitle;

}
