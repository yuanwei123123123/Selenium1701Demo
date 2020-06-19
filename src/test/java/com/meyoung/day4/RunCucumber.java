package com.meyoung.day4;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

/**
 * Created by lenovo on 2016/11/6.用于触发feature文件
 */
@CucumberOptions(
        features = "src/test/rescources",
        format = {"pretty","html:target/site/cucumber-pretty",
                "return:target/return.txt",
                "json:target/cucumber.json"},
        tags = {"@unAutomation"},
        glue = {"automator.day4"})
public class RunCucumber{
}
