package com.mygaienko.common.algorithms.interv.formula;


import com.mygaienko.common.algorithms.interv.formula.operable.*;
import org.junit.Test;

import java.util.LinkedHashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void testCalculator() {
        Formula expected = new Formula(new LinkedHashMap<>());
        Plus plus = new Plus();
        Variable a = new Variable(new StringOperand("a"));
        a.setChildOperator(plus);
        Variable b = new Variable(new StringOperand("b"));
        b.setParentOperator(plus);
        expected.setNext(a);
        expected.setNext(b);

        Formula actual = calculator.parse("a+b");
        assertThat(actual, equalTo(expected));
        System.out.println(actual);
    }

    @Test
    public void testCalculator0() {
        LinkedHashMap<String, Formula> tasks = new LinkedHashMap<>();
        Formula expected = new Formula(tasks);
        Plus plus = new Plus();
        Variable a = new Variable(new StringOperand("a"));
        a.setChildOperator(plus);
        Variable v1 = new Variable(new StringOperand("V1"));
        v1.setParentOperator(plus);
        expected.setNext(a);
        expected.setNext(v1);

        Formula v1F = new Formula();
        Multiply multiply = new Multiply();
        Variable b = new Variable(new StringOperand("b"));
        b.setChildOperator(multiply);
        Variable c = new Variable(new StringOperand("c"));
        c.setParentOperator(multiply);
        v1F.setNext(b);
        v1F.setNext(c);
        v1F.setStartOperator(multiply);

        tasks.put("V1", v1F);

        Formula actual = calculator.parse("a+b*c");
        assertThat(actual, equalTo(expected));
        System.out.println(actual);
    }

    @Test
    public void testCalculator00() {
        Formula expected = new Formula(new LinkedHashMap<>());

        Multiply multiply = new Multiply();
        Variable a = new Variable(new StringOperand("a"));
        a.setChildOperator(multiply);
        Variable b = new Variable(new StringOperand("b"));
        b.setParentOperator(multiply);

        Plus plus = new Plus();
        b.setChildOperator(plus);
        Variable c = new Variable(new StringOperand("c"));
        c.setParentOperator(plus);
        expected.setNext(a);
        expected.setNext(b);
        expected.setNext(c);

        Formula actual = calculator.parse("a*b+c");
        assertThat(actual, equalTo(expected));
        System.out.println(actual);
    }

    @Test
    public void testCalculator1() {
        LinkedHashMap<String, Formula> tasks = new LinkedHashMap<>();
        Formula expected = new Formula(tasks);
        Plus plus = new Plus();
        Variable a = new Variable(new StringOperand("a"));
        a.setChildOperator(plus);
        Variable v1 = new Variable(new StringOperand("V1"));
        v1.setParentOperator(plus);
        expected.setNext(a);
        expected.setNext(v1);

        Formula v1F = new Formula();
        Plus plus2 = new Plus();
        Variable b = new Variable(new StringOperand("b"));
        b.setChildOperator(plus2);
        Variable c = new Variable(new StringOperand("c"));
        c.setParentOperator(plus2);
        v1F.setNext(b);
        v1F.setNext(c);
        v1F.setStartOperator(new LeftParenthesis());

        tasks.put("V1", v1F);

        Formula actual = calculator.parse("a+(b+c)");
        assertThat(actual, equalTo(expected));
        System.out.println(actual);
    }

    @Test
    public void testCalculator11() {
        LinkedHashMap<String, Formula> tasks = new LinkedHashMap<>();
        Formula expected = new Formula(tasks);
        Plus plus = new Plus();
        Variable a = new Variable(new StringOperand("a"));
        a.setChildOperator(plus);
        Variable v1 = new Variable(new StringOperand("V1"));
        v1.setParentOperator(plus);
        expected.setNext(a);
        expected.setNext(v1);

        Formula v1F = new Formula();
        Multiply plus2 = new Multiply();
        Variable b = new Variable(new StringOperand("b"));
        b.setChildOperator(plus2);
        Variable c = new Variable(new StringOperand("c"));
        c.setParentOperator(plus2);
        v1F.setNext(b);
        v1F.setNext(c);
        v1F.setStartOperator(plus2);

        tasks.put("V1", v1F);

        Formula formula = calculator.parse("a+(b+c+d)");
        System.out.println(formula);
    }

    @Test
    public void testCalculator111() {
        Formula formula = calculator.parse("a+(b+c+d+(e+f))");
        System.out.println(formula);
    }

    @Test
    public void testCalculator2() {
        Formula formula = calculator.parse("a+(b+c*d)");
        System.out.println(formula);
    }

    @Test
    public void testCalculator3() {
        Formula formula = calculator.parse("a+(b+c)*d");
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