package com.meyoung.day4;

import automator.day3.LoginPage;

import static automator.day4.CucumberTest.driver;
import static com.meyoung.day4.CucumberTest.driver;

/**
 * Created by lenovo on 2016/11/4.
 */
public class Input_Step{
    public void input_PO(String email,String password){
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(LoginPage.loginName).sendKeys(email);
        driver.findElement(LoginPage.loginPwd).sendKeys(password);
    }
}
