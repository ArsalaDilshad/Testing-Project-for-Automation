package com.epay.assignment.util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Driver utility class contains all the driver related functionality.
 */
public class DriverUtil {
    private final ChromeDriver chromeDriver = new ChromeDriver();
    public ChromeDriver getChromeDriver(){
        return chromeDriver;
    }

    public WebDriverWait driverWait(){
        return new WebDriverWait(getChromeDriver(), Duration.ofSeconds(60));
    }

    public void quitDriver() {
        getChromeDriver().quit();
    }

    public void maximizeWindow(){
        getChromeDriver().manage().window().maximize();
    }
}
