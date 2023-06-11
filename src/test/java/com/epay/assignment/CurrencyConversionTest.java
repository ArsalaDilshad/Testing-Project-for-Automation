package com.epay.assignment;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrencyConversionTest {
    private final CurrencyConversion currencyConversion  = new CurrencyConversion();

    @Test(priority =1)
    public void errorMessageValidation() {
        String result = currencyConversion.messageVerification();
        Assert.assertEquals("Please enter a valid amount", result);
    }

    @Test(priority = 2)
    public void verifyCurrencyDropDownValues() {
        String result = currencyConversion.currencyCheckDropDown();
        Assert.assertEquals("INR – ", result);
    }

    @Test(priority =3 )
    public void verifyConversionButtonText() {
        String actualResult = currencyConversion.checkConversionButtonText();
        Assert.assertEquals("Convert", actualResult);
    }
}
