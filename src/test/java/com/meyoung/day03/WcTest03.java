package com.meyoung.day03;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WcTest03 {
    //WebDriver driver;
    PhantomJSDriver driver;

    @BeforeMethod
    public void openchrome(){
       /* System.setProperty("webdriver.chrome.driver","D:\\testworkspace\\Selenium\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();*/
        System.setProperty("phantomjs.binary.path","D:\\testworkspace\\Selenium\\drivers\\phantomjs.exe");
         driver= new PhantomJSDriver();
    }

    /**
     * 打开百度页面，执行js，把输入框赋值
     */
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://www.baidu.com");
        //把driver转成javascriptExecutor类型
        JavascriptExecutor js= (JavascriptExecutor) driver;
        //执行js
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"hhhhhhhhhh\")");
        Thread.sleep(5000);

    }

    /**
     * 使用phantomjs
     */
    @Test
    public void test2(){

        driver.get("http://www.baidu.com");
        String title=driver.getTitle();
        Assert.assertEquals(title,"百度一下，你就知道");
    }


    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
