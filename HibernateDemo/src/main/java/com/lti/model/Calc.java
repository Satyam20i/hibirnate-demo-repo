package com.lti.model;

public class Calc {
	public int product(int num1,int num2){
        return num1*num2;
    }
    public boolean isGreater(int num1,int num2){
        if(num1<num2){
            return true;
        }
        return false;
    }
}
