package com.meyoung.day03;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/10/25.
 */
public class CookieTest {
    WebDriver driver;
    @BeforeTest
    public void openfire(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void CookieFile(){
        driver.get("http://www.baidu.com");
        driver.findElement(By.xpath(".//*[@id='u1']/a[7]")).click();
        driver.findElement(By.xpath(".//*[@id='TANGRAM__PSP_8__userName']")).sendKeys("apple周俊123");
        driver.findElement(By.xpath(".//*[@id='TANGRAM__PSP_8__password']")).sendKeys("jun15200506121");
        Boolean sel=driver.findElement(By.xpath(".//*[@id='TANGRAM__PSP_8__memberPass']")).isSelected();
        if(!sel){
            driver.findElement(By.xpath(".//*[@id='TANGRAM__PSP_8__memberPass']")).click();
        }else{
            driver.findElement(By.xpath(".//*[@id='TANGRAM__PSP_8__submit']")).click();
        }
        //文件操作,先清空后将cookie写入文件
        File cookieFile=new File("D:\\testing\\cookie.txt");
        try {
            cookieFile.delete();
            cookieFile.createNewFile();
            FileWriter fileWriter=new FileWriter(cookieFile);
            BufferedWriter bw=new BufferedWriter(fileWriter);
            for(Cookie cookie:driver.manage().getCookies()){
                bw.write((cookie.getName()+";"+cookie.getValue()+";"+cookie.getDomain()+";"+cookie.getPath()+";"+cookie.getExpiry()+";"+cookie.isSecure()));
                bw.newLine();
            }
            bw.flush();
            bw.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
