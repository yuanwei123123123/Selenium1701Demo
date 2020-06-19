package com.meyoung.day03;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2016/10/25.
 */
public class ReadCookieTest {
    WebDriver driver;
    @BeforeTest
    public void openfire(){
        System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        driver=new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void ReadCookieFile(){
        try {
            File cookieFile=new File("D:\\testing\\cookie.txt");
            FileReader fileReader=new FileReader(cookieFile);
            BufferedReader br=new BufferedReader(fileReader);
            String line;
            while ((line=br.readLine())!=null) {
                StringTokenizer stringTokenizer=new StringTokenizer(line,";");
                while (stringTokenizer.hasMoreTokens()){
                    String name=stringTokenizer.nextToken();
                    String value=stringTokenizer.nextToken();
                    String domain=stringTokenizer.nextToken();
                    String path=stringTokenizer.nextToken();
                    Date expiry=null;
                    String dt;
                    if(!(dt=stringTokenizer.nextToken()).equals("null")){
                        expiry=new Date(dt);
                    }
                    boolean isSecure=new Boolean(stringTokenizer.nextToken()).booleanValue();
                    Cookie cookie=new Cookie(name,value,domain,path,expiry,isSecure);
                    driver.manage().addCookie(cookie);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver.get("https://www.baidu.com");
    }
}
