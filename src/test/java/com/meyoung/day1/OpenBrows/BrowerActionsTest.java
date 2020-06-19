package com.meyoung.day1.OpenBrows;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowerActionsTest {

    WebDriver webDriver=null;

    //每个test执行前 执行这个方法，就是打开浏览器
    @BeforeMethod
    public void openChrome(){
        //设置chromedriver 路径
        System.setProperty("webdriver.chrome.driver","D:\\testworkspace\\Selenium\\drivers\\chromedriver.exe");
        // 实例化chromedriver
        webDriver= new ChromeDriver();
    }

    /**
     * 打开chrome浏览器
     * 打开 百度首页
     * 等待5s
     * 关闭浏览器
     */
    @Test
    public  void getTest() throws InterruptedException {

        //打开百度首页
        webDriver.get("https://www.baidu.com");
        //等待五秒
        Thread.sleep(5000);
        //关闭
        webDriver.quit();
    }

    /**
     * 打开chrome浏览器
     * 打开 百度首页
     * 等待3s
     * 后退
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public  void backTest() throws InterruptedException {

        //打开百度首页
        webDriver.get("https://www.baidu.com");
        //等待3秒
        Thread.sleep(3000);
        //浏览器后退
        webDriver.navigate().back();
        //等待3秒
        Thread.sleep(3000);
        //关闭
        webDriver.quit();
    }

    /**
     * 打开chrome浏览器
     * 打开 百度首页
     * 等待3s
     * 后退
     * 等待3s
     * 前进
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public  void frorwardTest() throws InterruptedException {

        //打开百度首页
        webDriver.get("https://www.baidu.com");
        //等待3秒
        Thread.sleep(3000);
        //浏览器后退
        webDriver.navigate().back();
        //等待3秒
        Thread.sleep(3000);
        //浏览器前进
        webDriver.navigate().forward();
        //等待3秒
        Thread.sleep(3000);
        //关闭
        webDriver.quit();
    }

    /**
     * 打开chrome浏览器
     * 打开 百度首页
     * 等待3s
        刷新
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public  void refreshTest() throws InterruptedException {

        //打开百度首页
        webDriver.get("https://www.baidu.com");
        //等待3秒
        Thread.sleep(3000);
        //刷新
        webDriver.navigate().refresh();
        //等待3秒
        Thread.sleep(3000);
        //关闭
        webDriver.quit();
    }

    /**
     * 打开chrome浏览器
     * 设置窗口大小500* 500
     *   * 等待3s
     * 最大化窗口
     * 等待3s
     * 关闭浏览器
     */
    @Test
    public  void winTest() throws InterruptedException {

        //设置窗口大小
        Dimension dimension=new Dimension(300,300);
        webDriver.manage().window().setSize(dimension);
        //等待3秒
        Thread.sleep(3000);
        //窗口最大化
        webDriver.manage().window().maximize();
        //等待3秒
        Thread.sleep(3000);
        //关闭
        webDriver.quit();
    }

    /**
     * 打开chrome浏览器
     * 打开百度首页
     *  获取当前页面url
     *
     * 等待3s
     * 校验当前页面url是不是百度地址
     * 关闭浏览器
     */
    @Test
    public  void getURLTest() throws InterruptedException {

        //打开百度首页
        webDriver.get("https://www.baidu.com");
        String url=webDriver.getCurrentUrl();
        System.out.println("获取的URL是："+url);
        Assert.assertEquals(url,"https://www.baidu.com/");
        /*//关闭 如果上面断言失败 这里就不能关闭了就会耗尽资源，所有要用下面的AfterMethod
        webDriver.quit();*/
    }

    //每个test执行完毕都要关闭，否则会耗尽资源
    @AfterMethod
    public void  closeBrower(){
       webDriver.quit();
    }
}
