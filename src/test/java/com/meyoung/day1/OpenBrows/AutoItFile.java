package com.meyoung.day1.OpenBrows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by lenovo on 2016/10/20.
 */
public class AutoItFile {
    WebDriver driver;
    @Test
    public void upload(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.id("load")).click();
    }
}
