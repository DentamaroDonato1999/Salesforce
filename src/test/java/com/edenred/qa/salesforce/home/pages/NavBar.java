package com.edenred.qa.salesforce.home.pages;

import com.codeborne.selenide.*;
import com.edenred.qa.salesforce.annotations.PageIdentifier;
import com.edenred.qa.salesforce.pages.WebPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static com.codeborne.selenide.ClickOptions.usingJavaScript;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

@Slf4j
public class NavBar extends WebPage {
    @PageIdentifier
    @FindBy(xpath = "//button[contains(.,'Programma di avvio app')]")
    SelenideElement startAppButton;

    @FindBy(xpath = "//input[contains(@placeholder, 'Cerca nelle app')]")
    SelenideElement appSearch;
    @FindBy(xpath = "//div[@class='appName slds-context-bar__label-action slds-context-bar__app-name']/span")
    private SelenideElement appTitle;

    @FindBy(xpath = "//button[@aria-label='Mostra menu di navigazione']")
    private SelenideElement navMenuButton;

    @FindBy(xpath = "//div[@data-message-id='loginAsSystemMessage']")
    private SelenideElement topGrayInfoBar;

    @FindBy(xpath = "//ul[@aria-label='Menu di navigazione']")
    private SelenideElement navMenu;

    private void openAppMenu() {
        startAppButton.click();
    }

    public void selectApp(String appName) {
        openAppMenu();
        appSearch.setValue(appName);
        SelenideElement appElement = $(By.xpath("//a[@data-label='%s']".formatted(appName)));
        appElement.shouldBe(visible);
        appElement.click(usingJavaScript());
    }

    public String getAppTitle() {
        return appTitle.getText();
    }

    public void openPage(String menuItem) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        log.debug("trying to open {}", menuItem);
        topGrayInfoBar.shouldBe(visible);
        log.debug("top bar is visible");
        navMenuButton.shouldBe(enabled);
        log.debug("navMenuButton is enabled: clicking...");
        //Wait 2 seconds to give time to the navButton to be ready
        Selenide.sleep(Duration.ofSeconds(2).toMillis());
        navMenuButton.click();
        navMenu.shouldBe(visible);
        String xpath = "//li//a[@data-label='%s']".formatted(menuItem);
        log.debug("Menu is visible: looking for {} at {}", menuItem, xpath);
        SelenideElement itemElement = $(By.xpath(xpath));
        itemElement.scrollIntoView(true).shouldBe(visible).click();
    }



}
