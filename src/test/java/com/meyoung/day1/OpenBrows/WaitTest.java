package com.meyoung.day1.OpenBrows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/10/15.三种等待方式
 */
public class WaitTest {
    WebDriver driver;
    @BeforeTest
    public void openchrome() {
        System.setProperty("webdriver.chrome.driver", "D:\\testworkspace\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        //2.全局等待，所有的地方起作用，如果20s之内就正常，那就无需等待，否则会等待20s，然后抛超时异常
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  //后面这个参数是表示20s
    }
    @Test
    public void waitTest(){
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.className("wait")).click();
        //3.显示等待，如果没有满足until后面的值，会等待5s，然后抛超时异常，如果5s之内就正常了，那就无需等待
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.className("red")));
        String text=driver.findElement(By.xpath("//*[@id=\"display\"]/div")).getText();
        System.out.println(text);
    }
}
