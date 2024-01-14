package com.edenred.qa.salesforce.utils;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

@Slf4j
public final class ReportUtils {
    private ReportUtils(){
    }
    public static byte[] takeScreenshot(TakesScreenshot driver) {
        return driver.getScreenshotAs(OutputType.BYTES);
    }

    public static  void attachScreenshot(String name) {
        WebDriver driver = WebDriverRunner.getWebDriver();
        log.debug("Driver instance: {}", driver);
        if ((driver instanceof TakesScreenshot)) {
            byte[] screenshot = takeScreenshot((TakesScreenshot) driver);
            log.debug("Screenshot bytes: {}", screenshot.length);
            Allure.addAttachment(name, "image/png", new ByteArrayInputStream(screenshot), ".png");
        }
    }

    public static void attachMessage(String name, String message){
        Allure.addAttachment(name, message);

    }

}
