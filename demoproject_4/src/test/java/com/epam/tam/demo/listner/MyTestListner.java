package com.epam.tam.demo.listner;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class MyTestListner implements IInvokedMethodListener{

    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        System.out.println("method started :" + iInvokedMethod.getTestMethod().getMethodName());
    }

    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        System.out.println("mehtod finished :" + iTestResult.getStatus());
    }
}
