package com.meyoung.day1.OpenBrows;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by lenovo on 2016/10/15.
 */
public class FrameTest {
    WebDriver driver;
    @BeforeTest
    public void openchrome() {
        System.setProperty("webdriver.chrome.driver", "D:\\testworkspace\\Selenium\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void iframeTest() throws InterruptedException {
        //iframe窗口的跳转
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.id("user")).sendKeys("this is iframe");
        Thread.sleep(3000);
        //把控制权转交给iframe界面，，id或者属性值为aa的iframe窗口,下面一个方法是没有Id和属性值的情况
        driver.switchTo().frame("aa");
        //点击iframe窗口的Linktext为baidu的按钮
        driver.findElement(By.linkText("baidu")).click();
        //把控制权回到顶部页面
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("this is another iframe");
    }
    @Test
    public void iframeTest1() throws InterruptedException {
        //iframe窗口的跳转，运行整个方法时，由于是testng来执行的脚本，是根据方法名的ASKI值来先后执行的，所以是先运行iframetest
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        driver.findElement(By.id("user")).sendKeys("this is iframe");
        //把控制权转交给iframe界面，如果没有id和属性值，把整个iframe当作一个元素来定位
       WebElement element= driver.findElement(By.xpath("/html/body/div/table/tbody/tr[15]/td[2]/iframe"));
        driver.switchTo().frame(element);
        //点击iframe窗口的Linktext为baidu的按钮
        driver.findElement(By.linkText("baidu")).click();
        //把控制权回到顶部页面,任何界面回到顶部页面都是defaultContent方法，回到另一个页面都是frame方法，只能一级一级的跳
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.findElement(By.id("user")).clear();
        driver.findElement(By.id("user")).sendKeys("this is another iframe");
    }
    @Test
    public void selectTest() throws InterruptedException {
        //下拉框选择,有如下三种方式获取定位，index,value,visibleText
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("moreSelect"));
        Thread.sleep(3000);
        Select select = new Select(element);
        select.selectByIndex(3);
        Thread.sleep(5000);
        //select.selectByValue("xiaomi");       //value值
        //select.selectByVisibleText("huawei");  //文本值
    }

    @Test
    public void WindTest() throws InterruptedException {
        //多窗口的处理
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"open\"]/a")).click();
        //获取第1个页面的句柄
        String handle1 = driver.getWindowHandle();
        //for循环判定是否为第一页面句柄如果不是就控制权转交
        for (String handles : driver.getWindowHandles()) {
            if (handles.equals(handle1)) {
                continue;
            }
            driver.switchTo().window(handles); //将控制权转交给这个页面
            Thread.sleep(3000);
        }
        //下面是采用迭代器的方式实现for循环
/*        Set<String> allHandle=driver.getWindowHandles();
        Iterator iterator=allHandle.iterator();
        for (int i=0;i<allHandle.size();i++){
            String handle=iterator.next().toString();
            if (handle1.equals(handle));
            continue;
            driver.switchTo().window(handle);
        }*/
    }
    @Test
    public void moreSelectTest() throws InterruptedException {
        //下拉框多选
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> list=element.findElements(By.tagName("option"));
        Actions actions=new Actions(driver);
        //按住shift键，点击第二个和第四个来执行
        actions.keyDown(Keys.SHIFT).click(list.get(0)).click(list.get(3)).perform();
        Thread.sleep(3000);
    }
    @Test
    public void upload() throws InterruptedException {
        //文件上传,文件下载在另一个class中
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("load"));
        element.sendKeys("D:\\testing\\baidu.png");
        Thread.sleep(3000);
    }

    @AfterMethod
    public void closed(){
        driver.quit();
    }

}



