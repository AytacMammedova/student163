package com.matrix.java163Spring.service.impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorServiceImplTest {
    @Mock
    private CalculatorServiceImpl calculatorService;
    @BeforeEach
    void setUp(){calculatorService=new CalculatorServiceImpl();}
    @AfterEach
    void tearDown(){calculatorService=null;}

    @Test
    public void getPositiveAAndPositiveBThenSum() {
        double result= calculatorService.sum(1,2);
        assertThat(result).isEqualTo(3);

    }
    @Test
    public void getNegativeAAndNegativeBThenSum(){
        double result=calculatorService.sum(-1,-2);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void getPositiveAAndPositiveBThenSubtraction(){
        double result=calculatorService.subtraction(5,3);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void getNegativeAAndNegativeBThenSubtraction(){
        double result=calculatorService.subtraction(-1,-5);
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void getZeroAAndZeroBThenMultiplication(){
        double result=calculatorService.multiplication(0,0);
        assertThat(result).isEqualTo(1);
    }
    @Test
    public void getNonZeroAAndNonZeroBMultiplication(){
        double result=calculatorService.multiplication(3,4);
        assertThat(result).isEqualTo(12);

    }
    @Test
    public void getNonZeroAAndZeroBThenException(){
        assertThatThrownBy(()->calculatorService.divide(5,0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Cannot be divided by 0");

    }
    @Test
    public void getNonZeroAAndNonZeroBThenDivide(){
        double result=calculatorService.divide(15,5);
        assertThat(result).isEqualTo(3);
    }
}