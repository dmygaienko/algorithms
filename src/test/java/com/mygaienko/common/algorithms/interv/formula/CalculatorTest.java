package com.mygaienko.common.algorithms.interv.formula;


import org.junit.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testCalculator() {
        Formula formula = calculator.parse("a+b");
        System.out.println(formula);
    }

    @Test
    public void testCalculator0() {
        Formula formula = calculator.parse("a+b*c");
        System.out.println(formula);
    }

    @Test
    public void testCalculator1() {
        Formula formula = calculator.parse("a+(b+c)");
        System.out.println(formula);
    }

    @Test
    public void testCalculator2() {
        Formula formula = calculator.parse("a+(b+c*d)");
        System.out.println(formula);
    }

    @Test
    public void testCalculator3() {
        Formula formula = calculator.parse("a+((b+c)*d)");
        System.out.println(formula);
    }

    @Test
    public void testCalculator4() {
        Formula formula = calculator.parse("a+((b+c+3+7)*d)");
        System.out.println(formula);
    }

    @Test
    public void testCalculator5() {
        Formula formula = calculator.parse("a+((b+c+3+7-a+((b+c+3+7)*d))*d)");
        System.out.println(formula);
    }

    @Test
    public void testCalculator6() {
        Formula formula = calculator.parse("a+((b+c+3+7-a+((b+c+3+7)*d))*d)/(c+3+7)*(d+7)");
        System.out.println(formula);
    }

}