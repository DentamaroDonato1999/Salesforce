package com.edenred.qa.salesforce.home.steps;

import com.edenred.qa.salesforce.home.pages.HomePage;
import com.edenred.qa.salesforce.login.USERTYPE;
import com.edenred.qa.salesforce.login.steps.Authenticate;
import net.serenitybdd.annotations.Steps;

public class NavigateToHomePage {

    @Steps
    Authenticate authenticate;
    @Steps
    HomePage homePage;

    public void homePage(USERTYPE usertype){
        authenticate.as(usertype);
        homePage.getHeader().waitUntilTitleAppears();
    }
    public void application(String appName){
        homePage.getHeader().selectApp(appName);
    }
}
