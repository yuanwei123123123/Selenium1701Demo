package com.meyoung.day1.OpenBrows;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.Streams;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;

import static java.lang.Thread.*;

/**
 * Created by lenovo on 2016/10/15.文件上传和下载
 */
public class FileTest {
    WebDriver driver;
    FirefoxProfile profile=new FirefoxProfile();
    @Test
    public void download() throws InterruptedException, AWTException {
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        //下载操作,配置响应下载参数
        profile.setPreference("browser.download.dir","D:\\testing");
        profile.setPreference("browser.download.foldList",2);//2表示保存到指定路径，0表示默认路径
        profile.setPreference("browser.download.useDownloadDir",true);
        profile.setPreference("browser.download.manager.showWhenStarting",false);//在开始下载时是否显示下载管理器
        //对所给出文件类型不再弹框进行询问
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/zip,text/plain," +
                "application/vnd.ms-excel,text/csv,text/comma-separated-values,application/octet-stream," +
                "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd." +
                "openxmlformats-officedocument.wordprocessingml.document");
        driver=new FirefoxDriver(profile);
        driver.get("http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%B0%8F%E5%9B%BE%E7%89%87&step_word=&hs=0&pn=6&spn=0&di=28610677040&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&istype=0&ie=utf-8&oe=utf-8&in=&cl=2&lm=-1&st=undefined&cs=4285530%2C402013338&os=680243863%2C305218249&simid=3334851803%2C451413571&adpicid=0&ln=1977&fr=&fmq=1476798824771_R&fm=&ic=undefined&s=undefined&se=&sme=&tab=0&width=&height=&face=undefined&ist=&jit=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fpic30.nipic.com%2F20130615%2F12251844_141425397124_2.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bgtrtv_z%26e3Bv54AzdH3Ffi5oAzdH3FnAzdH3FlAzdH3Fbdmlmnch89u89uju_z%26e3Bip4s&gsm=0&rpstart=0&rpnum=0");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"toolbar\"]/span[7]")).click();
        //快捷键的操作用到Robot类
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
        /*String pic_exist="alert(\\\"download successfully\\\")";
        String pic_not_exist = "alert(\"download unsuccessfully\")";
        if (file.exists()){
            ((JavascriptExecutor) driver).executeScript(pic_exist);
        }else {
            ((JavascriptExecutor) driver).executeScript(pic_not_exist);
        }*/

