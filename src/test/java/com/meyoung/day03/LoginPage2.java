package com.meyoung.day03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/10/30.加强版的PO
 */
public class LoginPage2 {
    WebDriver driver;
    @FindBy(how= How.NAME,name="email")
    WebElement loginName;
    @FindBy(how= How.NAME,name="password")
    WebElement loginPwd;
    @FindBy(how= How.ID,id="dologin")
    WebElement loginBtn;

    public LoginPage2(WebDriver driver){
        this.driver=driver;
    }
    public void login(String userName,String PassWord){
        loginName.sendKeys(userName);
        loginPwd.sendKeys(PassWord);
        loginBtn.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }
}
