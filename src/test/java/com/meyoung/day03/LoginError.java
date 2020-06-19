package com.meyoung.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/10/23.采用数据驱动DataProvider实现不同方式登陆
 */
public class LoginError {
    WebDriver driver;
    @BeforeTest
    public void openfire(){
       /* System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver=new FirefoxDriver();*/
        System.setProperty("webdriver.chrome.driver","D:\\testing\\webdriver_demo\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }
    @DataProvider (name="loginusers")
    public Object[][] date(){
        return new Object[][]{
                {"zhoujun_boyan","zhoujun123"},
                {"zhoujun_boyan","zhoujun123456"},
                {"zhoujun_boyan"," "},
                {" ","zhoujun123"},
                {"zhoujun_boyan","zhoujun123"}
        };
    }
    @Test(dataProvider = "loginusers")
    public void loginError(String email,String password) throws InterruptedException {
        RegistTest.loginTest(driver, email, password);
       /*  Boolean code=driver.findElement(By.className("checkcode_tlt")).isDisplayed();
       if (code){
            //输入验证码，else
        }else{
            String errorText=driver.findElement(By.xpath("/*//*[@id=\"nerror\"]/div[2]")).getText();
            Assert.assertEquals(errorText,"帐号或密码错误");
        }*/
        //等待右上角显示退出

/*
     Boolean logout=driver.findElement(By.className("sh0 nui-txt-link")).isDisplayed();
        Assert.assertEquals(logout,"退出");
    String pic_exist="alert(\\\"download successfully\\\")";
        ((JavascriptExecutor) driver).executeScript(pic_exist);*/
    }
}
