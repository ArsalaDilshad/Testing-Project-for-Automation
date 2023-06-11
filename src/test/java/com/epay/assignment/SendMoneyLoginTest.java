package com.epay.assignment;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SendMoneyLoginTest {

    @Test
    public void verifyRegisterButtonEnabled(){
        SendMoneyLogin sendMoneyLogin = new SendMoneyLogin();
        Assert.assertTrue(sendMoneyLogin.registerUser("test_user@hotmail.com", "Password1"));
    }
}
