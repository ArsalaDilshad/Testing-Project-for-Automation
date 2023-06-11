package com.epay.assignment;

import com.epay.assignment.util.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Currency conversion class contains methods related to currency conversion application.
 */
public class CurrencyConversion {
    public static final String URL = "https://www.xe.com/currencyconverter/";

    /**
     * This method enters the invalid amount in the Amount field.
     */
    public String messageVerification() {
        DriverUtil driverUtil = new DriverUtil();
        try {
            navigationCurrencyConversionWeb(driverUtil);
            WebElement amount = driverUtil.driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='amount']")));
            driverUtil.getChromeDriver().executeScript("arguments[0].scrollIntoView(false);", amount);
            driverUtil.getChromeDriver().executeScript("arguments[0].click();", amount);
            amount.sendKeys("alphabets");
            return driverUtil.getChromeDriver().findElement(By.xpath("//div[text()='Please enter a valid amount']")).getAttribute("innerHTML");
        } finally {
            driverUtil.quitDriver();
        }
    }

    /**
     * This method is used to select desired currency from the currency from drop down.
     */
    public String currencyCheckDropDown() {
        DriverUtil driverUtil = new DriverUtil();
        try {
            navigationCurrencyConversionWeb(driverUtil);
            WebElement fromCurrency = driverUtil.driverWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='midmarketFromCurrency']")));
            driverUtil.getChromeDriver().executeScript("arguments[0].click();", fromCurrency);
            WebElement signupPopup = driverUtil.driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='yie-overlay-9478e99d-b28e-51e8-99b4-e2cbae34f318']")));
            driverUtil.getChromeDriver().executeScript("arguments[0].style.display='none';", signupPopup);
            fromCurrency.sendKeys("Indian Rupee");
            List<WebElement> dropDownValue = driverUtil.getChromeDriver().findElements(By.xpath("//ul[@id='midmarketFromCurrency-listbox']"));
            for (int i = 0; i<dropDownValue.size(); i++){
                dropDownValue.get(0).click();
            }
            return driverUtil.getChromeDriver().findElement(By.xpath("//div[@id='midmarketFromCurrency-descriptiveText']/span")).getAttribute("innerHTML");
        } finally {
            driverUtil.quitDriver();
        }
    }

    /**
     * This method is used to check the text of currency convert button.
     */
    public String checkConversionButtonText() {
        DriverUtil driverUtil = new DriverUtil();
        try {
            navigationCurrencyConversionWeb(driverUtil);
            return driverUtil.driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Convert']"))).getAttribute("innerHTML");
        } finally {
            driverUtil.quitDriver();
        }
    }

    private void navigationCurrencyConversionWeb(DriverUtil driverUtil) {
        driverUtil.getChromeDriver().get(URL);
        driverUtil.maximizeWindow();
        driverUtil.driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Accept']"))).click();
        ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Xe Currency Converter']"));
    }
}
