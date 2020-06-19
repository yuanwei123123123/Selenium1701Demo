package com.meyoung.day1.OpenBrows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementTest {

    WebDriver webDriver;

    //每个test执行前 执行这个方法，就是打开浏览器
    @BeforeMethod
    public void openChrome(){
        //设置chromedriver 路径
        System.setProperty("webdriver.chrome.driver","D:\\testworkspace\\Selenium\\drivers\\chromedriver.exe");
        // 实例化chromedriver
        webDriver= new ChromeDriver();
    }

    /**
     * 打开百度页面
     * 通过id定位搜索文本框
     */
    @Test
    public void byIDTest(){
        webDriver.get("https://www.baidu.com");
        WebElement keyField= webDriver.findElement(By.id("kw"));

    }

    /**
     * 打开百度页面
     * 通过name定位搜索文本框
     */
    @Test
    public void byNameTest(){
        webDriver.get("https://www.baidu.com");
        WebElement keyField= webDriver.findElement(By.name("wd"));

    }

    /**
     * 打开百度页面
     * 通过class定位搜索文本框
     * 必须是a标签里面的文字
     */
    @Test
    public void byClassTest(){
        webDriver.get("https://www.baidu.com");
        WebElement keyField= webDriver.findElement(By.className("s_ipt"));

    }

    /**
     * 打开百度页面
     * 通过linkText定位搜索文本框
     *    * 必须是a标签里面的文字
     */
    @Test
    public void byLinkTextTest(){
        webDriver.get("https://www.baidu.com");
        WebElement keyField= webDriver.findElement(By.linkText("新闻"));

    }

    /**
     * 打开百度页面
     * 通过linkText的部分内容定位搜索文本框
     *  必须是a标签里面的文字
     */
    @Test
    public void bypartialLinkTextTest(){
        webDriver.get("https://www.baidu.com");
        WebElement keyField= webDriver.findElement(By.partialLinkText("新"));

    }

    /**
     * 打开百度页面
     * 通过ltagNmae的部分内容定位搜索文本框
     *
     */
    @Test
    public void byTagName(){
        webDriver.get("https://www.baidu.com");
        List<WebElement> list= webDriver.findElements(By.tagName("input"));
        System.out.println(list.size());
    }

    /**
     * 打开百度页面
     * 通过xpath的定位搜索文本框
     *
     */
    @Test
    public void byXpath(){
        webDriver.get("https://www.baidu.com");
        WebElement webElement= webDriver.findElement(By.xpath("//*[@id=\"su\"]"));
    }

    /**
     * 打开百度页面
     * 通过css的容定位搜索文本框
     *
     */
    @Test
    public void byCss(){
        webDriver.get("https://www.baidu.com");
        WebElement webElement= webDriver.findElement(By.cssSelector("#lg>img"));
    }

    @AfterMethod
    public void colsedBrower(){
        webDriver.quit();
    }


}
