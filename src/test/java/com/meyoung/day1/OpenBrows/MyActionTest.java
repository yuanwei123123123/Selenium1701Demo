package com.meyoung.day1.OpenBrows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by lenovo on 2016/10/15.右键，双击，移动，拖拽，Robot
 */
public class MyActionTest {
    WebDriver driver;

    @BeforeTest
    public void openchrome() {
        System.setProperty("webdriver.chrome.driver", "D:\\testing\\webdriver_demo\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Test
    public void RightClickTest() {
        //右击和左键双击操作
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.id("su"));
        //右键操作用到Action类
        Actions actions=new Actions(driver);
        actions.contextClick(element).perform();   //右击哪个元素，如果不传的话默认左上角元素
        actions.doubleClick(element).build().perform();   //左键双击，如果不写build也是可以的
    }
    @Test
    public void moveTest() {
        //鼠标移动操作
        driver.get("http://www.baidu.com");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"head\"]/div/div[4]/div/div[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();
    }
    @Test
    public void dragTest() {
        //鼠标拖拽操作
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        WebElement element = driver.findElement(By.id("drag"));
        Actions actions=new Actions(driver);
        actions.dragAndDropBy(element,500,800).perform();
    }
    @Test
    public void dropTest1() {
        //鼠标拖拽操作
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        WebElement element1 = driver.findElement(By.id("drag"));
        WebElement element2 = driver.findElement(By.linkText("banban"));
        Actions actions=new Actions(driver);
        //按住元素1，然后拖到到元素2，再释放元素1，执行
        actions.clickAndHold(element1).moveToElement(element2).release(element1).perform();
    }
    @Test
    public void robotTest() throws AWTException{
        driver.get("http://www.baidu.com");
        //robot使用,按住ctrl+S键然后释放
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_ALT);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_ALT);
        robot.keyRelease(KeyEvent.VK_S);
    }
}
