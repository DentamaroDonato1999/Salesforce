package com.edenred.qa.salesforce.home.pages;

import com.codeborne.selenide.SelenideElement;
import com.edenred.qa.salesforce.annotations.PageIdentifier;
import com.edenred.qa.salesforce.pages.WebPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HeaderPage extends WebPage {
    @FindBy(className = "slds-global-header__logo")
    SelenideElement logo;

    @PageIdentifier
    @FindBy(css = ".slds-global-header")
    SelenideElement globalHeader;

    @FindBy(css = ".search-button")
    SelenideElement mainSearch;

    @FindBy(xpath = "//button[contains(.,'Programma di avvio app')]")
    SelenideElement startAppButton;

    @FindBy(xpath = "//input[contains(@placeholder, 'Cerca nelle app')]")
    SelenideElement appSearch;

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

    private void openAppMenu() {
         startAppButton.click();
    }

    public void selectApp(String appName) {
        openAppMenu();
        appSearch.type(appName);
        SelenideElement appElement = $(By.xpath("//a[@data-label='%s']".formatted(appName)));
        appElement.shouldBe(visible);
        appElement.click(usingJavaScript());
    }
}
