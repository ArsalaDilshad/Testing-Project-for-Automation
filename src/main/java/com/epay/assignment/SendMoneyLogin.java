package com.epay.assignment;

import com.epay.assignment.util.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Send money login class contains methods related to send money application.
 */
public class SendMoneyLogin {

    public static final String URL = "https://www.xe.com/send-money/";

    /**
     * This method enters email and password in the create user form.
     * @param email Contains the email of the user.
     * @param password Contains the password of the user.
     */
    public String registerUser(String email, String password) {
        DriverUtil driverUtil = new DriverUtil();
        try {
            navigationSendMoneyWeb(driverUtil);
            driverUtil.getChromeDriver().findElement(By.xpath("//button[text()='Register']"));
            WebElement signInSendButton = driverUtil.driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@name='Xe vs your Bank | Primary']")));
            signInSendButton.click();
            driverUtil.driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Create your account']")));
            driverUtil.getChromeDriver().findElement(By.id("email")).sendKeys(email);
            driverUtil.getChromeDriver().findElement(By.id("password")).sendKeys(password);
            return driverUtil.getChromeDriver().findElement(By.xpath("//button[text()='Register now']")).getAttribute("innerHTML");
        } finally {
            driverUtil.quitDriver();
        }
    }

    private void navigationSendMoneyWeb(DriverUtil driverUtil) {
        driverUtil.getChromeDriver().get(URL);
        driverUtil.maximizeWindow();
        driverUtil.driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Accept']"))).click();
        driverUtil.driverWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='International Money Transfers - Send Money Online']")));
    }
}
