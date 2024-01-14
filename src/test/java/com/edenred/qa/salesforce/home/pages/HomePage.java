package com.edenred.qa.salesforce.home.pages;

import com.codeborne.selenide.SelenideElement;
import com.edenred.qa.salesforce.annotations.PageIdentifier;
import com.edenred.qa.salesforce.pages.WebPage;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebPage {
    @PageIdentifier
    @FindBy(xpath = "//div[@role='main']")
    SelenideElement content;
}
