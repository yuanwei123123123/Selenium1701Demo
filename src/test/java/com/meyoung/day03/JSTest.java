package com.meyoung.day03;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by lenovo on 2016/10/22.
 */
public class JSTest {
    WebDriver driver;
    @Test
    public void openfire() throws InterruptedException {
       /* System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver=new FirefoxDriver();*/
        System.setProperty("webdriver.chrome.driver","D:\\testworkspace\\Selenium\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.baidu.com");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        //直接在下面操作value的值，执行js脚本,在id为search=key的地方把value的值输入“selenium怎么学”
        js.executeScript("document.getElementById(\"kw\").setAttribute(\"value\",\"selenium怎么学\")");
       Thread.sleep(5000);
        driver.quit();
    }
}
