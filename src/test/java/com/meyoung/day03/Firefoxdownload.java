package com.meyoung.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Firefoxdownload {
    //火狐下载文件
    @Test
    public void test23() throws InterruptedException, AWTException {
        System.setProperty("ebdriver.gecko.driver","D:\\testworkspace\\Selenium\\drivers\\geckodriver.exe");
        FirefoxProfile firefoxProfile= new FirefoxProfile();
        //设置火狐的默认下载文件夹，0表示桌面，1表示我的下载，2表示自定义文件夹
        firefoxProfile.setPreference("browser.download,folderList","2");
        //设置自定义文件夹位置
        firefoxProfile.setPreference("browser.download.dir","d:\\soft");
        //打开一个预先配置的火狐
        WebDriver driver= new FirefoxDriver(firefoxProfile);
        Thread.sleep(10000);
        driver.get("https://www.editplus.com/download.html");
        driver.findElement(By.xpath("/html/body/div[1]/div[4]/div[2]/div[2]/a")).click();
        Thread.sleep(10000);
        Robot robot= new Robot();
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(10000);
        driver.quit();

    }


}
