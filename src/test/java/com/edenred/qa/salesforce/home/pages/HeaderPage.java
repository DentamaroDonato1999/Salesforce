package com.edenred.qa.salesforce.home.pages;

import com.codeborne.selenide.SelenideElement;
import com.edenred.qa.salesforce.annotations.PageIdentifier;
import com.edenred.qa.salesforce.pages.WebPage;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends WebPage {
    @PageIdentifier
    @FindBy(className = "slds-global-header__logo")
    SelenideElement logo;

    @FindBy(css = ".slds-global-header")
    SelenideElement globalHeader;

    @FindBy(css = ".search-button")
    SelenideElement mainSearch;

    @FindBy(xpath = "//ul[@class='slds-global-actions']/..//*[name()='svg'][@data-key='add']")
    SelenideElement btnGlobalActions;

    @FindBy(xpath = "//ul[@class='slds-global-actions']/..//*[@data-key='trailhead_alt']")
    SelenideElement btnCentroOrientamento;

    @FindBy(xpath = "//ul[@class='slds-global-actions']/..//*[@data-key='question']")
    SelenideElement btnHelp;

    @FindBy(xpath = "//ul[@class='slds-global-actions']/..//*[@data-key='setup']")
    SelenideElement btnSettings;

    @FindBy(xpath = "//ul[@class='slds-global-actions']/..//*[@data-key='notification']")
    SelenideElement btnNotifiche;

    @FindBy(xpath = "//ul[@class='slds-global-actions']/..//*[@data-key='forceEntityIcon']")
    SelenideElement btnProfile;


}
