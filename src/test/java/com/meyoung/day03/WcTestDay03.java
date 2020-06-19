package com.meyoung.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WcTestDay03 {
    WebDriver driver;
    @BeforeMethod
    public void open(){
        System.setProperty("webdriver.chrome.driver","D:\\testworkspace\\Selenium\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    //注册
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://mail.163.com/");
        //注册免费邮箱
        driver.findElement(By.xpath("//*[@id=\"normalLoginTab\"]/div[1]/div[2]/a[1]")).click();
        String handles1= driver.getWindowHandle();
        for(String handles:driver.getWindowHandles()){
            if(handles.equals(handles1)){
                continue;
            }
            driver.switchTo().window(handles);
        }
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("chengandqier@163.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("www.1994.com");
        driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("15855147263");
        Thread.sleep(3000);
        //driver.findElement(By.xpath(".//*[text()='同意']")).click();
        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[4]/span")).click();
        Thread.sleep(3000);
        Boolean erweima=driver.findElement(By.xpath(".//*[text()='手机扫描二维码，快速发送短信进行验证']")).isDisplayed();
        Assert.assertTrue(erweima);
        Thread.sleep(3000);

    }

    //登录
    @Test
    public void test2() throws InterruptedException {
        driver.get("https://mail.163.com/");
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"loginDiv\"]/iframe")));
        driver.findElement(LoginPage.loginName).sendKeys("chengandqier");
        driver.findElement(LoginPage.loginPwd).sendKeys("www.1994.com");
        driver.findElement(LoginPage.loginBtn).click();
        Thread.sleep(5000);
        String ename=driver.findElement(By.id("spnUid")).getText();
        System.out.println("ename=="+ename);
        Assert.assertEquals(ename,"chengandqier@163.com");
        Thread.sleep(5000);
    }

    public static void loginTest(WebDriver driver,String email,String password) throws InterruptedException {
        driver.get("https://mail.163.com/");
        Thread.sleep(5000);
        //driver.findElement(By.xpath("//*[@id=\"loginDiv\"]/iframe"));
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"loginDiv\"]/iframe")));
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("dologin")).click();
    }

    //写信
    @Test
    public void test3() throws InterruptedException {
        WcTestDay03.loginTest(driver,"chengandqier","www.1994.com");
        Thread.sleep(5000);

        driver.findElement(By.xpath(".//*[text()='写 信']")).click();
        //driver.findElement(By.xpath("//*[@id=\"dvNavContainer\"]/nav[1]/div[1]/ul[1]/li[2]/span[2]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath(".//*[@aria-label='邮件主题输入框，请输入邮件主题']/input")).sendKeys("爱你一万年");
        driver.findElement(By.xpath(".//*[@aria-label='收件人地址输入框，请输入邮件地址，多人时地址请以分号隔开']")).sendKeys("xiaoqilovetiao@163.com");
       // driver.findElement(By.xpath(".//*[text()='输入对方手机号，就能给他发邮件']")).sendKeys("333333");
        Thread.sleep(5000);
        driver.switchTo().frame(driver.findElement(By.className("APP-editor-iframe")));
        driver.findElement(By.xpath("/html/body/p")).sendKeys("哈哈哈哈哈");
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[text()='发送']")).click();
        Thread.sleep(5000);
        //第一次发送会提示这个，以后都没有
        //driver.findElement(By.xpath("//*[@class=\"nui-simpleForm nui-form\"]/table/tbody/tr/td/div/input")).sendKeys("王成");
        //Thread.sleep(3000);
        //driver.findElement(By.className("nui-msgbox-ft-btns")).click();
        //Thread.sleep(3000);
        Boolean sendText=driver.findElement(By.xpath(".//*[text()='发送成功']")).isDisplayed();
        Assert.assertTrue(sendText);
    }


    @AfterMethod
    public void close(){
        driver.quit();
    }
}
