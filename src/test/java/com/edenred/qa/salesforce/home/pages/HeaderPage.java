package com.edenred.qa.salesforce.home.pages;

import com.edenred.qa.salesforce.pages.WebPage;
import net.serenitybdd.annotations.WhenPageOpens;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends WebPage {
    @FindBy(className = "slds-global-header__logo")
    WebElementFacade logo;

    //.slds-global-header
    @FindBy(css = ".slds-global-header")
    WebElementFacade globalHeader;

    //.search-button
    @FindBy(css = ".search-button")
    WebElementFacade mainSearch;

    //button[contains(.,'Programma di avvio app')]
    @FindBy(xpath = "//button[contains(.,'Programma di avvio app')]")
    WebElementFacade startAppButton;

    @FindBy(xpath = "//input[contains(@placeholder, 'Cerca nelle app')]")
    WebElementFacade appSearch;

    @FindBy(xpath = "//ul[@class='slds-global-actions']/..//*[name()='svg'][@data-key='add']")
    WebElementFacade btnGlobalActions;

    @FindBy(xpath = "//ul[@class='slds-global-actions']/..//*[@data-key='trailhead_alt']")
    WebElementFacade btnCentroOrientamento;

    @FindBy(xpath = "//ul[@class='slds-global-actions']/..//*[@data-key='question']")
    WebElementFacade btnHelp;

    @FindBy(xpath = "//ul[@class='slds-global-actions']/..//*[@data-key='setup']")
    WebElementFacade btnSettings;

    @FindBy(xpath = "//ul[@class='slds-global-actions']/..//*[@data-key='notification']")
    WebElementFacade btnNotifiche;

    @FindBy(xpath = "//ul[@class='slds-global-actions']/..//*[@data-key='forceEntityIcon']")
    WebElementFacade btnProfile;
    @Override
    @WhenPageOpens
    public void waitUntilTitleAppears() {
        globalHeader.waitUntilVisible();
    }

    private void openAppMenu() {
        clickOn(startAppButton);
    }

    public void selectApp(String appName) {
        openAppMenu();
        typeInto(appSearch, appName);
        WebElementFacade appElement = findBy("//a[@data-label='{0}']", appName);
        appElement.waitUntilVisible();
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", appElement);
    }
}
