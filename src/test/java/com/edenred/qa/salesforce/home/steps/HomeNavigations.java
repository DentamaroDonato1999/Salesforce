package com.edenred.qa.salesforce.home.steps;

import com.edenred.qa.salesforce.assertions.WebAssertions;
import com.edenred.qa.salesforce.home.pages.NavBar;
import com.google.inject.Inject;
import io.qameta.allure.Step;

public class HomeNavigations {
    @Inject
    NavBar navBar;
    @Inject
    HomeNavigations home;

    public void openApp(String appName){
        navBar.selectApp(appName);
        WebAssertions.assertThat(navBar.getAppTitle()).isEqualTo(appName);
    }
}
