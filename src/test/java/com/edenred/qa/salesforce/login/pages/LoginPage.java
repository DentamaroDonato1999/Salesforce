package com.edenred.qa.salesforce.login.pages;

import com.edenred.qa.salesforce.pages.WebPage;
import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.annotations.WhenPageOpens;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LoginPage extends WebPage {
    static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    @FindBy(xpath = "//img[@id='logo']")
    WebElementFacade logo;

    @FindBy(css = "#username")
    WebElementFacade usernameField;

    @FindBy(css = "#password")
    WebElementFacade passwordField;

    @FindBy(css = "#Login")
    WebElementFacade loginButton;

    @FindBy(css = "#rememberUn")
    WebElementFacade rememberButton;

    @Override
    @WhenPageOpens
    public void waitUntilTitleAppears() {
        log.debug("Waiting for title to appear");
        logo.waitUntilVisible();
    }

    public void login(UsernameAndPassword credentials) {
        login(credentials.username(), credentials.password());
    }
    public void login(String username, String password){
        typeInto(usernameField, username);
        typeInto(passwordField, password);
        clickOn(loginButton);
    }

    public void rememberMe() {
        if(!rememberButton.isSelected()){
            clickOn(rememberButton);
        }
    }

}
