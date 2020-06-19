package com.meyoung.day03;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by lenovo on 2016/10/22.
 */
public class DataTest {
    @DataProvider(name = "test1")
    public  Object[][] data(){
        //记得return返回的后面要加引号，必须是Object类
        return new Object[][]{
                {"1","aa"},
                {"2","bb"},
                {"3","cc"}
        };
    }
    @Test(dataProvider = "test1")
    public void testData(String i,String j){
        System.out.print("i="+i+"和j="+j);
        System.out.print("\n");
    }
}
