package com.meyoung.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/10/22.调用另一个类下面的方法，实现登陆，然后实现发邮件
 */
public class SendEmail {
    WebDriver driver;
    @BeforeTest
    public void openfire(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void sendTest( ){
        //调用另一个类的静态方法，实现登陆操作
       RegistTest.loginTest(driver, "zhoujun_boyan", "zhoujun123");
        //定位“写信”,对于无法找到定位的一般用xpath,注意xpath格式
        driver.findElement(By.xpath(".//*[@id='dvNavTop']/ul/li[2]/span[2]")).click();
        driver.findElement(By.xpath(".//*[@aria-label='收件人地址输入框，请输入邮件地址，多人时地址请以分号隔开']")).sendKeys("794516619@qq.com");
        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("我的第一个主题XX");
        driver.findElement(By.xpath(".//*[@title='一次可发送2000张照片，600首MP3，一部高清电影']/input")).sendKeys("C:\\Users\\lenovo\\Desktop\\云层天资\\资料\\webdriver基础教程.pdf");
        //发现输入内容框是一个iframe，做控制权转交
        WebElement element=driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(element);
        //xpath直接是/html/body
        driver.findElement(By.xpath("/html/body")).sendKeys("这是我的内容xx");
        //跳出iframe
        driver.switchTo().defaultContent();
        //xpath的语法，text的文本值为发送的标签,获取页面上的第一个发送按钮
        driver.findElements(By.xpath(".//*[text()='发送']")).get(0).click();
        //对于这种校验问题，采用这种方式不容易出错，其他方式可能出现错误
        Boolean sendText=driver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(sendText);
    }

}
