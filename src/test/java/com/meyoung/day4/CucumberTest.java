package com.meyoung.day4;


import automator.day3.LoginPage;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.lift.find.InputFinder;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/11/3.
 */
public class CucumberTest {
   public static WebDriver driver;
    @假如("^我打开\"(.*?)\"网站$")
    public void openfire(String url){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver=new FirefoxDriver();
        driver.get(url);
    }
    @当("^我用\"(.*?)\"账号,用\"(.*?)\"密码$")
    public void input(String email,String password){
        Input_Step step=new Input_Step();
        step.input_PO(email,password);
    }
    @当("^点击登录按钮$")
    public void login(){
        driver.findElement(LoginPage.loginBtn).click();
    }
    @那么("^登录成功$")
    public void success(){
        Assert.assertTrue(true);
    }

}
