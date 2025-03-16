package com.matrix.java163Spring.service.impl;

import com.matrix.java163Spring.service.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double sum(int a, int b) {
        double result=0;
        if(a>=0 || b>=0){
            result=a+b;
        }
        return result;
    }

    @Override
    public double subtraction(int a, int b) {
        double result=0;
        if(a>0 && b>0){
            result=a-b;
        }
        return result;
    }

    @Override
    public double multiplication(int a, int b) {
        double result=1;
        if(a!=0 || b!=0){
            result=a*b;
        }
        return result;
    }

    @Override
    public double divide(int a, int b) {
        double result = 0;
        if (b != 0) {
            result = a/b;
        } else{
            throw new ArithmeticException("Cannot be divided by 0");
        }
        return result;
    }
}
