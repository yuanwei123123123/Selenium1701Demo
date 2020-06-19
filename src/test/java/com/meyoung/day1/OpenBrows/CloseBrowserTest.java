package com.meyoung.day1.OpenBrows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CloseBrowserTest {

    @Test
    public void closedChrome() throws InterruptedException {
        //设置chromedriver 路径
        System.setProperty("webdriver.chrome.driver","D:\\selenium\\Selenium\\drivers\\chromedriver.exe");
       // 实例化chromedriver
        WebDriver webDriver= new ChromeDriver();
        //等待五秒
        Thread.sleep(5000);
        //关闭当前窗口，也许浏览器没关，但是进程driver没有关闭
        webDriver.close();
    }
    @Test
    public void closedChrome1() throws InterruptedException {
        //设置chromedriver 路径
        System.setProperty("webdriver.chrome.driver","D:\\testworkspace\\Selenium\\drivers\\chromedriver.exe");
        // 实例化chromedriver
        WebDriver webDriver= new ChromeDriver();
        //等待五秒
        Thread.sleep(5000);
        //关闭浏览器，完全退出进程，一般用这个
        webDriver.quit();
    }
}
