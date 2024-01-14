package com.edenred.qa.salesforce.login.steps;

import com.edenred.qa.salesforce.assertions.WebAssertions;
import com.edenred.qa.salesforce.home.pages.HeaderPage;
import com.edenred.qa.salesforce.home.pages.HomePage;
import com.edenred.qa.salesforce.login.USERTYPE;
import com.edenred.qa.salesforce.login.pages.LoginPage;
import com.google.inject.Inject;
import io.qameta.allure.Allure;
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
    @Inject
    HomePage homePage;
    public void as(USERTYPE usertype){
        startFrom.loginPage();
        String username = testdata.getString("login.%s.username".formatted(usertype));
        String password = testdata.getString("login.%s.password".formatted(usertype));
        Allure.step("authenticating as %s / %s".formatted(username, password));
        loginPage.login(username, password);
    }

    public void homePage(){
        WebAssertions.assertThat(homePage).isLoaded();
    }

}
