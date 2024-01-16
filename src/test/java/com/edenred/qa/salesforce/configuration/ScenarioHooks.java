package com.edenred.qa.salesforce.configuration;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.*;
import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.AbstractDriverOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.edenred.qa.salesforce.utils.ReportUtils.attachMessage;
import static com.edenred.qa.salesforce.utils.ReportUtils.attachScreenshot;

@Slf4j
public class ScenarioHooks {
    public static final String[] chromeArgs = {
            "remote-allow-origins=*", "test-type", //"no-sandbox",
            "ignore-certificate-errors",
            "incognito", "disable-infobars", "disable-gpu", "disable-default-apps",
            "disable-popup-blocking", "--disable-geolocation",
            "disable-dev-shm-usage", "disable-extensions", "--enable-strict-powerful-feature-restrictions",
            "disable-web-security", "disable-translate", "disable-logging"};

    public static final String SAUCE_URL = "https://ondemand.eu-central-1.saucelabs.com:443/wd/hub";
    public static String environment = System.getProperty("profile");
    public static final String SAUCE_ENV_PROPERTY = "saucelabs";


    @SneakyThrows
    @Before
    public void start(Scenario scenario) {
        attachMessage("Start scenario", scenario.getName());
        if (Configuration.browser.equals("chrome")) {
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.addArguments(Arrays.asList(chromeArgs));
            if (SAUCE_ENV_PROPERTY.equalsIgnoreCase(environment)) {
                appendSauceOptions(browserOptions);
                WebDriver driver = new RemoteWebDriver(new URL(SAUCE_URL), browserOptions);
                WebDriverRunner.setWebDriver(driver);
            } else {
                Configuration.browserCapabilities = browserOptions;
            }
        }
    }

    private <T extends AbstractDriverOptions<T>> void appendSauceOptions(T browserOptions) {
        String username = System.getProperty("sauce.username");
        String accessKey = System.getProperty("sauce.accessKey");
        String buildId = System.getProperty("sauce.build");
        String testName = "Salesforce Test Automation";
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", username);
        sauceOptions.put("accessKey", accessKey);
        sauceOptions.put("build", buildId);
        sauceOptions.put("name", testName);
        sauceOptions.put("screenResolution", "1920x1080");
        sauceOptions.put("maxDuration", Duration.ofMinutes(60).toSeconds());
        sauceOptions.put("timeZone", "Rome");
        sauceOptions.put("extendedDebugging", true);
        sauceOptions.put("capturePerformance", true);
        browserOptions.setCapability("sauce:options", sauceOptions);
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