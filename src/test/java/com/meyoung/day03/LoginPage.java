package com.meyoung.day03;

import org.openqa.selenium.By;

/**
 * Created by lenovo on 2016/10/26.
 */
public class LoginPage {
    //PO思想实现，当页面元素id或者位置发生变化时，只改这一个地方即可。别的地方调用直接是LoginPage.loginName即可
    public static By loginName=By.name("email");
    public static By loginPwd=By.name("password");
    public static By loginBtn=By.id("dologin");
}
