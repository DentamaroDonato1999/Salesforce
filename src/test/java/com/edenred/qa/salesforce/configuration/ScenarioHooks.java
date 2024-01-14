package com.edenred.qa.salesforce.configuration;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Optional;

import static com.edenred.qa.salesforce.utils.ReportUtils.*;

@Slf4j
public class ScenarioHooks {
    public static final String[] chromeArgs = {
            "remote-allow-origins=*", "test-type", "no-sandbox",
            "ignore-certificate-errors",
            "incognito", "disable-infobars", "disable-gpu", "disable-default-apps",
            "disable-popup-blocking",
            "disable-dev-shm-usage", "disable-extensions",
            "disable-web-security", "disable-translate", "disable-logging"};

    @Before
    public void start(Scenario scenario) {
        attachMessage("Start scenario",scenario.getName());
        if (Configuration.browser.equals("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments(Arrays.asList(chromeArgs));
            Configuration.browserCapabilities = options;
        }

    }

    @BeforeStep
    public void startStep(Scenario scenario) {
        Optional<String> stepName = Allure.getLifecycle().getCurrentTestCaseOrStep();
        stepName.ifPresentOrElse(step ->
                log.debug("Running step :{}", step), () -> log.debug("Step name not found")
        );
    }

    @AfterStep
    public void endStep(Scenario scenario) {
        String stepName = Allure.getLifecycle().getCurrentTestCaseOrStep()
                .orElseThrow(() -> new RuntimeException("Step name not found"));

        log.debug("Finished step :{}", stepName);
    }

    @After
    public void end(Scenario scenario) {
        attachMessage("End Scenario", "%s -> status: %s".formatted(scenario.getName(), scenario.getStatus()));
        attachScreenshot(scenario.getName());
    }

    //Must be the last one called (for @After lowest order goes last)
    @After(order = 0)
    public void cleanUp() {
        Selenide.closeWebDriver();
    }

}