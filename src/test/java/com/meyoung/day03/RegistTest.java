package com.meyoung.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/10/22.
 */
public class RegistTest {
    WebDriver driver;
    long time=System.currentTimeMillis();
    @BeforeTest
    public void openfire(){
/*        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver=new FirefoxDriver();*/
        System.setProperty("webdriver.chrome.driver","D:\\testworkspace\\Selenium\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void regist(){
        driver.get("http://mail.163.com");
        driver.switchTo().frame("x-URS-iframe");   //去注册按钮在iframe中，driver转交给iframe控制权
        driver.findElement(By.id("changepage")).click();//点击之后跳转到新的页面，然后需要获取句柄
        String handle1=driver.getWindowHandle();    //获取当前页面的句柄
        for (String handles:driver.getWindowHandles()){
            if (handles.equals(handle1)){
                continue;
            }
            driver.switchTo().window(handles); //把控制权转交给第二个页面
        }
        driver.findElement(By.xpath("//*[@id=\"tabsUl\"]/li[1]/a")).click();
        driver.findElement(By.id("nameIpt")).sendKeys("jun"+time);
        driver.findElement(By.id("mainPwdIpt")).sendKeys("pw654321");
        driver.findElement(By.id("mainCfmPwdIpt")).sendKeys("pw654321");
        driver.findElement(By.id("mainMobileIpt")).sendKeys(String.valueOf(time/100));
        driver.findElement(By.id("vcodeIpt")).sendKeys("abcd");
        driver.findElement(By.id("sendMainAcodeStg")).click();
        driver.findElement(By.id("mainAcodeIpt")).sendKeys("322143");
        driver.findElement(By.className("regForm-item-ct txt-tips")).click();
        driver.findElement(By.id("mainRegA")).click();
        String errorText=driver.findElement(By.xpath("//*[@id=\"m_vcode\"]/span")).getText();
        Assert.assertEquals(errorText,"验证码不正确，请重新填写");
    }
    public static void loginTest(WebDriver driver,String email,String password){
        //封装登陆代码，便于其他地方调用,前面不需要test
        driver.get("http://mail.163.com");
        driver.switchTo().frame("x-URS-iframe");
        driver.findElement(LoginPage.loginName).sendKeys(email);
        driver.findElement(LoginPage.loginPwd).sendKeys(password);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(LoginPage.loginBtn).click();
       /* //对于这种校验问题，采用这种方式不容易出错，其他方式可能出现错误
        Boolean logoutText=driver.findElement(By.xpath(".//*[text()='退出']")).isDisplayed();
        Assert.assertTrue(logoutText);*/

/*        //等待右上角显示退出
        new WebDriverWait(driver,30).until(ExpectedConditions.presenceOfElementLocated(By.linkText("退出")));
        Boolean logout=driver.findElement(By.className("sh0 nui-txt-link")).isDisplayed();
        Assert.assertEquals(logout,"退出");
        String pic_exist="alert(\\\"download successfully\\\")";
        ((JavascriptExecutor) driver).executeScript(pic_exist);*/
    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
