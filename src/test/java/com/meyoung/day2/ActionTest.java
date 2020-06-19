package com.meyoung.day2;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

public class ActionTest {

    WebDriver webDriver;

    /**
     * 我要点击百度首页的新闻链接
     */
    @BeforeMethod
    public void openChrome(){
        //设置chromedriver 路径
        System.setProperty("webdriver.chrome.driver","D:\\selenium\\Selenium\\drivers\\chromedriver.exe");
        // 实例化chromedriver
        webDriver= new ChromeDriver();
    }

    //我要点击百度首页的新闻链接 那么我打开了新闻页面
    @Test
    public void clickTest(){
        webDriver.get("http://www.baidu.com");
        //定位新闻链接
        WebElement newLink= webDriver.findElement(By.name("tj_trmews"));
        //点击新闻链接
        newLink.click();
        //获取当前页面的url
        String url=webDriver.getCurrentUrl();
        //校验当前页面是不是新闻页面
        Assert.assertEquals(url,"http://news.baidu.com/");
    }

    /**
     * 打开百度首页
     * 输入关键字selenium
     * 点击百度一下进行搜索
     * 检验title是否等于“selenium_百度搜索”
     */
    @Test
    public void sendkeysTest() throws InterruptedException {
        webDriver.get("http://www.baidu.com");
        //定位百度搜索框
        WebElement keys=webDriver.findElement(By.id("kw"));
        //搜索框输入selenium
        keys.sendKeys("selenium");
        //定位百度一下按钮
        WebElement baiduButton= webDriver.findElement(By.id("su"));
        //点击
        baiduButton.click();
        Thread.sleep(3000);
        //获取页面title
        String title=webDriver.getTitle();
        //校验
        Assert.assertEquals(title,"selenium_百度搜索");

    }

    /**
     * 清空定位
     * @throws InterruptedException
     */
    @Test
    public void clear() throws InterruptedException {
        webDriver.get("http://www.baidu.com");
        //定位百度搜索框
        WebElement keys=webDriver.findElement(By.id("kw"));
        //搜索框输入selenium
        keys.sendKeys("selenium");
        Thread.sleep(5000);
        //清空文本框
        keys.clear();
        Thread.sleep(5000);
    }

    /**
     * 打开百度首页
     *获取新闻文本
     *
      */
    @Test
    public void getTextTest() throws InterruptedException {
        webDriver.get("http://www.baidu.com");
        String text1= webDriver.findElement(By.name("tj_trnews")).getText();
        Assert.assertEquals(text1,"新闻");

    }

    /**
     * 打开百度首页
     * 获取文本框的tagname
     * 校验是否为input
     */
    @Test
    public void  getTegNameTest(){
        webDriver.get("http://www.baidu.com");
        String tagName= webDriver.findElement(By.id("kw")).getTagName();
        Assert.assertEquals(tagName,"input");
    }

    /**
     * 打开百度页面
     * 判断按钮显示的文本值为 百度一下
     */
    @Test
    public void  getATest(){
        webDriver.get("http://www.baidu.com");
        String attribute=webDriver.findElement(By.id("su")).getAttribute("value");
        Assert.assertEquals(attribute,"百度一下");
    }

    /**
     * 打开百度首页
     * 判断是否显示百度一下按钮
     */
    @Test
    public void  isDisolagedTest(){
        webDriver.get("http://www.baidu.com");
        Boolean b= webDriver.findElement(By.id("su")).isDisplayed();
        Assert.assertTrue(b);
    }

    /**
     * 打开测试页面
     * 判断Volvo单选框被选中
     */
    @Test
    public void idSelectTest(){
        webDriver.get("file:///c:/selenium_html/index.html");
        WebElement element= webDriver.findElement(By.xpath("//*[@id=\"radio\"]/input[1]"));
        //点击
        element.click();
        //判断是否被选择上
        Boolean b=element.isSelected();
        Assert.assertTrue(b);
    }

    /**
     * 打开测试页面
     * 判断sumbit按钮处于未激活状态
     */
    @Test
    public void isEnableTest(){
        webDriver.get("file:///c:/selenium_html/index.html");
        Boolean b= webDriver.findElement(By.name("buttonhtml")).isEnabled();
        Assert.assertFalse(b);
    }


    /**
     * 打开ui自动化测试 主页
     * 点击alert按钮
     * 在alert警告框点击确定按钮
     */
    @Test
    public void shotTest() throws InterruptedException {
        //打开测试主页
        webDriver.get("file:///c:/selenium_html/index.html");
        //点击alert按钮
        webDriver.findElement(By.xpath(".//*[@id='alert']/input")).click();
        Thread.sleep(3000);
        //选取alert弹框
        Alert alert=webDriver.switchTo().alert();
        //点击警告框的确定按钮
        alert.accept();
    }

    /**
     * 打开百度页面
     * 截图百度首页
     */
    @Test
    public void alertTest(){
        webDriver.get("http://www.baidu.com");
        File file= ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file,new File("D:\\TEST1.PNG"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void closed(){
        webDriver.quit();
    }


}
