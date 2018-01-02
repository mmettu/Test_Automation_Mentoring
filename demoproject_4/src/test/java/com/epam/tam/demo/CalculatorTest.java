package com.epam.tam.demo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseCalculatorTest{

    @Test
    @Parameters({"firstNumber", "secondNumber", "expected"})
    public void sum(long firstNumber, long secondNumber, long expected) {
        long result = calculator.sum(firstNumber, secondNumber);
        Assert.assertEquals(result, expected);
    }

    @Test(groups = {"Negative"})
    public void sumNegative() {
        long result = calculator.sum(1, -2);
        System.out.println("Sum of two numbers is "+result);
        Assert.assertEquals(result, -1);
    }
    
    @Test
    public void division() {
        long result = calculator.div(10, 5);
        System.out.println("Division of 10 with 5 is "+result);
        Assert.assertEquals(result, 2);
    }
    
    @Test(groups = {"Negative"})
    public void divisionNegative() {
        long result = calculator.div(10, -5);
        System.out.println("Division of 10 with -5 is "+result);
        Assert.assertEquals(result, -2);
    }
    @Test(expectedExceptions =NumberFormatException.class)
    public void expectedException() {
    	System.out.println("Handling exception method");
        long result = calculator.div(5, 0);
    }
    
    @Test
    public void multiplication() {
        long result = calculator.mult(10, 5);
        System.out.println("Multiplication of 10 with 5 is "+result);
        Assert.assertEquals(result, 50);
    }
    @Test
    public void power() {
        double result = calculator.pow(2, 3);
        System.out.println("2 power 3 is "+result);
        Assert.assertEquals(result, 8.0);
    }
    @Test(groups = {"Negative"})
    public void powerNegative1() {
        double result = calculator.pow(2, -3);
        System.out.println("2 power 3 is "+result);
        Assert.assertEquals(result, 0.125);
    }
    @Test(groups = {"Negative"})
    public void powerNegative2() {
        double result = calculator.pow(-2, 3);
        System.out.println("2 power 3 is "+result);
        Assert.assertEquals(result, -8.0);
    }
    
    @Test
    public void postiveNumber() {        
          Assert.assertEquals(true, calculator.isPositive(10));
    }
    @Test(groups = {"Negative"})
    public void postiveNumberNegative() { 
    	System.out.println("isPositive should return False");
        Assert.assertEquals(false, calculator.isPositive(-10));
  }
    @Test
    public void negativeNumber() {   
          Assert.assertEquals(true, calculator.isNegative(-10));
    }
    @Test(groups = {"Negative"})
    public void negativeNumberNegative() {   
    		System.out.println("isNagtive should return False");
          Assert.assertEquals(false, calculator.isNegative(10));
    }
    
    @Test(groups = {"wait"})
    public void waitmethod1(){
    	try {
    		System.out.println("In wait methode1 waiting");
			calculator.wait();
			System.out.println("In wait methode waiting done");
		} catch (Exception e) {
			System.out.println(e);
		}
    }
    
    @Test(groups = {"wait"})
    public void waitmethod2(){
    
    		System.out.println("In wait methode2 waiting");
			try {
				calculator.wait(10);
				System.out.println("In wait methode waiting done");
			} catch (Exception e) {
				System.out.println(e);
			}
    }
    
    @Test(groups = {"wait"})
    public void waitmethod3(){
    
    		System.out.println("In wait methode2 waiting");
			try {
				calculator.wait(10,1);
				System.out.println("In wait methode waiting done");
			} catch (Exception e) {
				System.out.println(e);
			}
    }
    
    @Test(groups={"Trig"})
    public void cos1(){
    	double degree=45;
    	try{
    	System.out.println(calculator.cos(degree));
    	}
    	catch (Exception e){
    		System.out.println(e);
    	}
    }
    @Test(groups={"Trig"})
    public void sin1(){
    	double degree=45;
    	try{
    	System.out.println(calculator.sin(degree));
    	}
    	catch (Exception e){
    		System.out.println(e);
    	}
    }
    @Test(groups={"Trig"})
    public void tan(){
    	double degree=45;
    	try{
    	System.out.println(calculator.sin(degree));
    	}
    	catch (Exception e){
    		System.out.println(e);
    	}
    }
    @Test(groups={"Trig"})
    public void cot(){
    	double degree=45;
    	try{
    	System.out.println(calculator.ctg(degree));
    	}
    	catch (Exception e){
    		System.out.println(e);
    	}
    }

    @Test(dataProvider = "numbersProvider")
    public void sumOfNumbers(long firstNumber, long secondNumber, long expected) {
        long result = calculator.sum(firstNumber, secondNumber);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "numbersProvider")
    public Object[][] dataprovider() {
        return new Object[][]{
                {10, 20, 30},
                {-2, -3, -5}
        };
    }

}
