package com.edenred.qa.salesforce.home.pages;

import net.serenitybdd.annotations.WhenPageOpens;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class HeaderPage extends PageObject {
    @FindBy(className = "slds-global-header__logo")
    WebElementFacade logo;

    //.slds-global-header
    @FindBy(css = "slds-global-header")
    WebElementFacade globalHeader;

    //.search-button
    @FindBy(css = "search-button")
    WebElementFacade mainSearch;

    //button[contains(.,'Programma di avvio app')]
    @FindBy(xpath = "//button[contains(.,'Programma di avvio app')]")
    WebElementFacade startAppButton;

    @FindBy(xpath = "//input[contains(@placeholder, 'Cerca nelle app')]")
    WebElementFacade appSearch;

    @WhenPageOpens
    public void waitUntilTitleAppears() {
        globalHeader.waitUntilVisible();
    }

    private void openAppMenu() {
        clickOn(startAppButton);
    }

    public void selectApp(String appName) {
        openAppMenu();
        WebElementFacade appElement = findBy("//a[@data-label='{0}']", appName);
        appElement.waitUntilVisible().then().click();
    }
}
