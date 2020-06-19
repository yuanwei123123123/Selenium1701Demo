package com.meyoung.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

//通过testNG来做校验
public class TestNGDemo02 {

    //校验 a==a
    //比如：根据用户名密码登录成功后，打开页面，点击一个数据删除，那么我删除成功,这是2个case，最好不要放在一起
    //假如登录失败，你的删除case就不会执行，Assert后面不要跟其他操作，防止下面的操作不被执行，可以跟登录成功后显示什么字段
    @Test
    public void assertEqualTest(){
        String a="asdas";
        String b="31ds";
        System.out.println("登录");
        Assert.assertEquals(a,b,"校验登录成功");
        Assert.assertEquals(a,b,"用户名是否OK");//这可以跟后面

        System.out.println("操作打开页面删除");
        Assert.assertEquals(a,b,"删除成功");//上面校验报错，这里都不会执行的，要在写一个case：assertEqualTest1
    }

    @Test
    public void assertEqualTest1(){
        String a="asdas";
        String b="31ds";
        System.out.println("登录");
       //这里就不要校验登录，直接校验删除

        System.out.println("操作打开页面删除");
        Assert.assertEquals(a,b,"删除成功");//上面校验报错，这里都不会执行的，要在写一个case
    }

    //校验不等
    @Test
    public  void assertNotEquallTest(){
        int a=1;
        int b=2;
        Assert.assertNotEquals(a,b);
    }

    //校验为空
    @Test
    public void assertNullTest(){
        String a=null;
        Assert.assertNull(a);
    }

    //校验不为空
    @Test
    public void assertNotNullTest(){
        String a="aa";
        Assert.assertNotNull(a);
    }

    @Test
    public  void  a(){
        Boolean a=false;
        Assert.assertFalse(a);//判断是不是为false
    }

}
