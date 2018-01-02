package com.epam.tam.demo;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.*;

public class BaseCalculatorTest {

    protected Calculator calculator;

    @BeforeSuite
    public void beforeSutie(){
        System.out.println("Before Suite");
    }

    @BeforeClass
    public  void beforeClass(){
        System.out.println("Before class");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @BeforeGroups(value = {"main"})
    public void beforeGroup(){
        System.out.println("before Group named main");
    }

    @BeforeClass
    public void setUp(){
        System.out.println("before class ");
        calculator = new Calculator();
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("after method");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("after class");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
}
