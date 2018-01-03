package com.epam.tam.apitest.test;

import com.epam.tam.apitest.model.MyPojo;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RestAssuredDemo {

    Response response = null;
    @BeforeClass
    public void initTest(){
        RestAssured.baseURI = "http://jsonplaceholder.typicode.com";
        RequestSpecification httpRequest = RestAssured.given();
        response = httpRequest.request(Method.GET, "/users");
    }

    @Test (priority=0)
    public void checkStatusCode(){
    	System.out.println("Ststus Code is "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test (priority=1)
    public void checkResponseHeader(){
        String valueOfContentTypeHeader = response.getHeader("content-type");
        System.out.println("Char set is "+valueOfContentTypeHeader);        
        Assert.assertEquals(valueOfContentTypeHeader,"application/json; charset=utf-8");
    }

    @Test(priority=2)
    public void checkNumberOfObjects(){
        MyPojo[] posts = response.as(MyPojo[].class);
        Assert.assertEquals(posts.length , 10);
    }

    @Test(priority=3)
    public void printObjects(){
        MyPojo[] posts = response.as(MyPojo[].class);
        for (MyPojo post: posts) {
            System.out.println(post);
        }
    }
}
