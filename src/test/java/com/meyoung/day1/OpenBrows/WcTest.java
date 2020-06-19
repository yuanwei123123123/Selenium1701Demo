package com.meyoung.day1.OpenBrows;

import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class WcTest {

    WebDriver driver;

    @BeforeMethod
    public void openchrome(){
        System.setProperty("webdriver.chrome.driver","D:\\testworkspace\\Selenium\\drivers\\chromedriver.exe");
        driver=new ChromeDriver();
    }

    @Test
    public void test1() throws InterruptedException {
        //打开百度页面
        driver.get("http://www.baidu.com");
        Thread.sleep(3000);
        //定位新闻
        WebElement e= driver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[1]"));
        Thread.sleep(3000);
        //点击新闻按钮
        e.click();
        Thread.sleep(3000);
    }

    //打开百度页面 2. 在搜索文本框输入selenium 3. 点击百度一下按钮
    @Test
    public void test2() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement e= driver.findElement(By.id("kw"));
        e.sendKeys("Libai");
        Thread.sleep(3000);
        e=driver.findElement(By.id("su"));
        e.click();
        Thread.sleep(3000);
    }
    //1. 打开百度首页 2. 在搜索文本框输入selenium 3. 清空搜索输入框
    @Test
    public void test3() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement e= driver.findElement(By.id("kw"));
        e.sendKeys("selemium");
        Thread.sleep(3000);
        e.clear();
        Thread.sleep(3000);
    }

    //1. 打开百度首页 2. 获取右上角所有的文本并输出
    @Test
    public void test4() throws InterruptedException {
        driver.get("http:www.baidu.com");
        List<WebElement>  as=driver.findElements(By.id("s-top-left"));
        for (WebElement e:as
             ) {
            System.out.println(e.getText());
        }
        Thread.sleep(3000);
    }
    //1. 打开百度首页 2. 获取搜索框的TagName
    @Test
    public void test5(){
        driver.get("http://www.baidu.com");
        WebElement e= driver.findElement(By.id("kw"));
        String tagName=e.getTagName();
        System.out.println(tagName);
    }
    //1. 打开百度首页 2. 搜索框输入“webdriver” 3. 获取搜索框的 value 属性值
    @Test
    public void test6(){
        driver.get("http://www.baidu.com");
        WebElement e= driver.findElement(By.id("kw"));
        e.sendKeys("webdriver");;
        System.out.println(e.getAttribute("class"));
    }
    //1. 打开百度首页 2. 获取当前页面的title 3. 校验title值等于“百度一下，你就知道”
    @Test
    public void test7(){
        driver.get("http://www.baidu.com");
        String title= driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"百度一下，你就知道");
    }
    //1. 打开百度主页 2. 截图
    @Test
    public void test8() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement e= driver.findElement(By.xpath("//*[@id=\"s-top-left\"]/a[1]"));
        e.click();
        Thread.sleep(3000);
        File s=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(s,new File("D:\\testing\\webdriver_demo\\1.png"));
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }
    //1. 打开“UI自动化测试”主页 2. 点击Alert按钮 3. 在alert警告框点击确定按
    @Test
    public void test9() throws InterruptedException {
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        WebElement e= driver.findElement(By.className("alert"));
        e.click();
        Thread.sleep(3000);
        Alert alert= driver.switchTo().alert();
        Thread.sleep(3000);
        alert.accept();
    }
    //1. 打开“UI自动化测试”主页 2. 点击Confirm按钮 3. 在Confirm警告框点击确定\取消按钮
    @Test
    public void test10() throws InterruptedException {
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        WebElement element= driver.findElement(By.className("confirm"));
        element.click();
        Thread.sleep(3000);
        Alert alert= driver.switchTo().alert();
        //alert.accept();
        alert.dismiss();
        Thread.sleep(3000);
        alert.accept();
    }
    //1. 打开“UI自动化测试”主页 2. 点击Prompt按钮 3. 在Prompt 弹窗中，输入“这个是Prompt” 4. 点击确定\取消按钮
    @Test
    public void test11() throws InterruptedException {
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        WebElement element=driver.findElement(By.className("prompt"));
        element.click();
        Alert alert= driver.switchTo().alert();
        alert.sendKeys("你到底爱谁");
        Thread.sleep(3000);
        alert.accept();
        Thread.sleep(3000);
        alert.accept();
    }

    //1. 定位iFrame 2. driver控制权交给iFrame 3. 操作iFrame里面的元素 4. driver控制权交回原页面
    @Test
    public void test12() throws InterruptedException {
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        driver.switchTo().frame("aa");
        WebElement element= driver.findElement(By.id("user"));
        element.sendKeys("1111111");
        Thread.sleep(3000);
    }

    /**
     * 下拉框的处理
     三种处理方式： 1. selectByIndex() 根据索引来选取，从0开始
     2. selectByValue() 根据属性value的属性值来选取
     3. selectByVisibleText()根据标签之间的Text值，也就是页面显示的
     */
    @Test
    public void test13() throws InterruptedException {
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        WebElement element= driver.findElement(By.id("moreSelect"));
        Select select= new Select(element);
        select.selectByIndex(3);
        Thread.sleep(3000);
        select.selectByValue("huawei");
        Thread.sleep(3000);
        select.selectByVisibleText("xiaomi");
        Thread.sleep(3000);
    }

    /**
     * 多窗口处理：
     *
     */
    @Test
    public void test14() throws InterruptedException {
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        WebElement element= driver.findElement(By.className("open"));
        element.click();
        String handler=driver.getWindowHandle();
        for (String handles:driver.getWindowHandles()){
            if(handles.equals(handler)){
               continue;
            }
            driver.switchTo().window(handles);
            WebElement e= driver.findElement(By.id("user"));
            e.sendKeys("111112");
            Thread.sleep(3000);
        }
        driver.switchTo().window(handler);
        WebElement e= driver.findElement(By.id("user"));
        e.sendKeys("111112aaa");
        Thread.sleep(3000);
    }
    //在元素上鼠标右击和双击  actions类
    //1.打开百度页面 2.定位百度按钮双击或者右键
    @Test
    public void test15() throws InterruptedException {
       driver.get("http://www.baidu.com");
       WebElement element= driver.findElement(By.id("su"));
       Actions action= new Actions(driver);
       action.contextClick(element).perform();//右键
        Thread.sleep(3000);
        action.doubleClick(element).perform();//双击
        Thread.sleep(3000);
    }

    /**
     * Actions类 鼠标移动到某个元素上
     */
    @Test
    public void test16() throws InterruptedException {
        driver.get("http://www.baidu.com");
        WebElement element= driver.findElement(By.name("tj_briicon"));
        Actions actions= new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(3000);
        WebElement element1= driver.findElement(By.xpath("//*[@id=\"s-top-more\"]/div[1]/a[4]/img"));
        actions.moveToElement(element1).perform();
        Thread.sleep(3000);
        element.click();
        Thread.sleep(3000);
    }

    /**
     * Actions类 把元素拖动到（x,y）
     */
    @Test
    public void test17() throws InterruptedException {
      driver.get("file:///D:/testing/webdriver_demo/selenium_html/dragAndDrop.html");
      WebElement element= driver.findElement(By.id("drag"));
      Actions actions= new Actions(driver);
      actions.dragAndDropBy(element,500,500).perform();
      Thread.sleep(3000);
    }

    /**
     * Actions类 把元素拖动到另一个元素上
     */
    @Test
    public void test18() throws InterruptedException {
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/dragAndDrop.html");
        WebElement element= driver.findElement(By.id("drag"));
        WebElement element1=driver.findElement(By.xpath("/html/body/h1"));
        Actions actions= new Actions(driver);
        actions.clickAndHold(element).moveToElement(element1).release(element1).perform();
        Thread.sleep(3000);
    }

    /**
     * Actions类 下拉框多选
     */
    @Test
    public  void test19() throws InterruptedException {
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        WebElement element= driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        Actions actions= new Actions(driver);
        List<WebElement> ops= element.findElements(By.tagName("option"));
        actions.keyDown(Keys.SHIFT).click(ops.get(1)).click(ops.get(3)).build().perform();
        Thread.sleep(3000);
    }

    /**
     * Robot类 1. 按住某个按键 keyPress() 2. 松开某个按键 keyRelease()
     */
    @Test
    public void test20() throws AWTException, InterruptedException {
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        Robot robot= new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        Thread.sleep(3000);
    }

    /**
     * 上传文件的处理
     思路： 1. 定位上传控件 2. 使用sendkeys()方法，并传入文件路径
     */
    @Test
    public void test21() throws InterruptedException {
        driver.get("file:///D:/testing/webdriver_demo/selenium_html/index.html");
        WebElement element= driver.findElement(By.id("load"));
        element.sendKeys("D:\\testing\\webdriver_demo\\selenium_html\\aa.html");
        Thread.sleep(10000);
    }

    @Test
    public void test22() throws InterruptedException {
        driver.get("http://localhost:8083");
        WebElement element= driver.findElement(By.name("userName"));
        WebElement element1= driver.findElement(By.name("password"));
        element.sendKeys("100012");
        element1.sendKeys("123123");
        WebElement element2= driver.findElement(By.className("loginbtn"));
        element2.click();
        Thread.sleep(3000);
        driver.switchTo().frame("leftFrame");
        //法律法规
        WebElement element3=driver.findElement(By.xpath("//*[@id=\"LAY-system-side-menu\"]/li[1]/a"));
        element3.click();
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        WebElement element4= driver.findElement(By.xpath("//*[@id=\"LAY_app_body\"]/div[2]/iframe"));
        driver.switchTo().frame(element4);
        System.out.println("1111111111111111");
        //新增
        WebElement element5=driver.findElement(By.xpath("//*[@id=\"list-body\"]/div/div/div/div[2]/div[1]/div[1]/div[1]/button"));
        element5.click();
        System.out.println("2222");
        Thread.sleep(3000);
        driver.switchTo().frame("layui-layer-iframe1");
        //调整类型
        driver.findElement(By.className("layui-select-title")).click();
        WebElement element6= driver.findElement(By.xpath("//*[@id=\"imsBasicsLaw.type\"]/div/div/div/dl/dd[2]"));
        element6.click();
        Thread.sleep(3000);
        //法律法规名称
        driver.findElement(By.id("imsBasicsLaw.name_val")).sendKeys("2222");
        Thread.sleep(3000);
        //发布机关
        driver.findElement(By.id("imsBasicsLaw.issusUnit_val")).sendKeys("1111");
        Thread.sleep(3000);
        //发布时间
        driver.findElement(By.id("imsBasicsLaw.issusTime_val")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("laydate-btns-now")).click();
        Thread.sleep(3000);
        //发文字号
        driver.findElement(By.id("imsBasicsLaw.issusNum_val")).sendKeys("1111");
        Thread.sleep(3000);
        //生效日期
        driver.findElement(By.id("imsBasicsLaw.effectiveDate_val")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("laydate-btns-now")).click();
        Thread.sleep(3000);
        //时效性
        driver.findElement(By.xpath("//*[@id=\"imsBasicsLaw.timeliness\"]/div/div/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"imsBasicsLaw.timeliness\"]/div/div/div/dl/dd[2]")).click();
        //效力等级
        driver.findElement(By.xpath("//*[@id=\"imsBasicsLaw.effectiveGrade\"]/div/div/div/div/input")).click();
        driver.findElement(By.xpath("//*[@id=\"imsBasicsLaw.effectiveGrade\"]/div/div/div/dl/dd[2]")).click();
        //备注
        driver.findElement(By.id("imsBasicsLaw.lawComment_val")).sendKeys("111111111");
        Thread.sleep(5000);

        /*driver.switchTo().defaultContent();
        driver.switchTo().frame("layui-layer-iframe4");*/
        //正文附件
        //driver.findElement(By.id("imsBasicsLaw.lawFile_val")).sendKeys("C:\\Users\\10405\\Desktop\\bug\\1.png");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        //直接在下面操作value的值，执行js脚本,在id为search=key的地方把value的值输入“selenium怎么学”
        js.executeScript("document.getElementById(\"imsBasicsLaw.lawFile_val\").setAttribute(\"value\",\"1.png\")");
        Thread.sleep(3000);
        //保存  //*[@id="LAY_app_body"]/div[2]/iframe
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath(" //*[@id=\"LAY_app_body\"]/div[2]/iframe")));
        driver.findElement(By.xpath("//*[@id=\"layui-layer1\"]/div[3]/a[1]")).click();
        Thread.sleep(3000);






    }



















    @AfterMethod
    public void closed(){
        driver.quit();
    }
}
