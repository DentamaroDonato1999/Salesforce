package com.edenred.qa.salesforce.login.pages;

import com.codeborne.selenide.SelenideElement;
import com.edenred.qa.salesforce.annotations.PageIdentifier;
import com.edenred.qa.salesforce.pages.WebPage;

import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.edenred.qa.salesforce.utils.ReportUtils.attachScreenshot;

public class LoginPage extends WebPage {
    static final Logger log = LoggerFactory.getLogger(LoginPage.class);

    @PageIdentifier
    @FindBy(xpath = "//img[@id='logo']")
    SelenideElement logo;

    @FindBy(css = "#username")
    SelenideElement usernameField;

    @FindBy(css = "#password")
    SelenideElement passwordField;

    @FindBy(css = "#Login")
    SelenideElement loginButton;

    @FindBy(css = "#rememberUn")
    SelenideElement rememberButton;

    public void login(String username, String password){
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.click();
    }

    public void rememberMe() {
        if(!rememberButton.isSelected()){
            rememberButton.click();
        }
    }

}
