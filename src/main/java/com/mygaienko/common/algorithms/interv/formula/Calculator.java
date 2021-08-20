package com.mygaienko.common.algorithms.interv.formula;

import com.mygaienko.common.algorithms.interv.formula.operable.Operable;
import com.mygaienko.common.algorithms.interv.formula.operable.Operand;
import com.mygaienko.common.algorithms.interv.formula.operable.Operator;
import com.mygaienko.common.algorithms.interv.formula.operable.Variable;
import lombok.Value;

import java.util.Map;

/**
 * Examples of formula:
 * (a + b) * 20 - c
 * 12 - 5 * 6 / (a - 12 * (b + 5))
 */
public class Calculator {

    public Formula parse(String rawFormula) {
        Formula formula = new Formula();

        char[] chars = rawFormula.toCharArray();
        int i = 0;

        while (i < chars.length) {
            ParsedVariable parsedVariable = parseVariable(chars, i, new Variable());
            setChild(formula, parsedVariable);

            formula.setNext(parsedVariable.getVariable());
            i = parsedVariable.getI();
        }

        return formula;
    }

    private void setChild(Formula formula, ParsedVariable parsedVariable) {
        if (formula.getNext() != null && parsedVariable.getVariable().getParent() != null) {
            formula.getNext().setChild(parsedVariable.getVariable().getParent());
        }
    }

    public ParsedVariable parseVariable(char[] chars, int i, Variable variable) {
        char character = chars[i];
        Operable operable = Operable.of(character);

        if (operable instanceof Operand) {
            variable.setValue((Operand) operable);
        } else {
            ++i;
            variable.setParent((Operator) operable);
            if (i < chars.length) {
                return parseVariable(chars, i, variable);
            }
        }
        return new ParsedVariable(++i, variable);
    }

    public long calculate(Formula formula, Map<String, Long> variables) {
        return 0;
    }

    @Value
    static class ParsedVariable <T> {
        final int i;
        final Variable<T> variable;
    }

}
