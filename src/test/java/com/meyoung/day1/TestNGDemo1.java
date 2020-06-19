package com.meyoung.day1;

import org.testng.annotations.*;
//通过testNG来管理我们的case
public class TestNGDemo1 {

    @BeforeTest //这是所有test运行，先运行一次
    public void beforeTestCase01(){
        System.out.println("这是BeforeTest注解");
    }

    @BeforeMethod  //这是每个test运行之前，运行一次
    public  void beforeMethod(){
        System.out.println("这是BeforeMethhod注解");
    }

    //执行case顺序，是根据方法名的asike码来执行的，一个字母的比较，例如a的asike码大于t的，所以先执行aestcast1方法
    //一般case要有独立，每个case都不会依赖最好，比如删除操作，现有数据才能删除，就在删除方法里面先添加再删除
    @Test
    public void testCase1(){
        System.out.println("这是@Test注解,case1 ");
    }

    @Test
    public void testCase2(){
        System.out.println("这是@Test注解,case2 ");
    }

    @Test
    public void aestCase1(){
        System.out.println("这是@Test注解,case3 ");
    }

    @AfterMethod //每个test运行之后，运行
    public  void afterMethod(){
        System.out.println("这是afterMethhod注解");
    }

    @AfterTest//所有的test运行之后  运行一次次
    public void afterTest1(){
        System.out.println("这是afterTest注解");
    }

}
