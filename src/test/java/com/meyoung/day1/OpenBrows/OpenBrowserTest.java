package com.meyoung.day1.OpenBrows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class OpenBrowserTest {

    @Test
    public void openFF(){
        //启动火狐浏览器  直接new 必须要默认安装在这里才可以 C:\Program Files\Mozilla Firefox
        WebDriver webDriver= new FirefoxDriver();
    }

    //如果本地火狐的版本是48以上，就要下载火狐的driver，然后跟谷歌一样操作的
    @Test
    public void openFF2(){
        //假如火狐不是默认安装的,就要设置安装路径
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriver webDriver= new FirefoxDriver();
    }

    //谷歌
    @Test
    public void openChrome(){
        //设置driver的路径
        System.setProperty("webdriver.chrome.driver","D:\\selenium\\Selenium\\drivers\\chromedriver.exe");
        WebDriver webDriver= new ChromeDriver();
    }

    //ie的driver也要下载的
    @Test
    public void openIE(){
        //设置driver的路径
        System.setProperty("webdriver.ie.driver","D:\\selenium\\Selenium\\drivers\\IEDriverServer.exe");
        WebDriver webDriver= new InternetExplorerDriver();
    }
    //以上打开的浏览器都空的全新的浏览器，没有带cookie的
}
