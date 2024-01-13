package com.edenred.qa.salesforce.login.steps;

import com.edenred.qa.salesforce.home.pages.HeaderPage;
import com.edenred.qa.salesforce.home.pages.HomePage;
import com.edenred.qa.salesforce.login.USERTYPE;
import com.edenred.qa.salesforce.login.pages.LoginPage;
import com.google.inject.Inject;
import io.qameta.allure.Step;
import org.openqa.selenium.UsernameAndPassword;

import java.util.ResourceBundle;


public class Authenticate {
    final static ResourceBundle testdata = ResourceBundle.getBundle("testdata");

    @Inject
    LoginPage loginPage;
    @Inject
    StartFrom startFrom;

    @Inject
    HeaderPage headerPage;

    @Step
    public void as(USERTYPE usertype){
        startFrom.loginPage();
        UsernameAndPassword credentials = new UsernameAndPassword(
                testdata.getString("login.%s.username".formatted(usertype)),
                testdata.getString("login.%s.password".formatted(usertype)));
        loginPage.login(credentials);
    }

    @Step("verify Home Page")
    public void verify(){
        headerPage.isLoaded();
    }

}
