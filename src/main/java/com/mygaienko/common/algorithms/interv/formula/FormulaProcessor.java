package com.mygaienko.common.algorithms.interv.formula;

import com.mygaienko.common.algorithms.interv.formula.operable.*;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

@Data
public class FormulaProcessor {

    final String rawFormula;

    final char[] chars;

    int i = 0;
    int v = 0;

    final Map<String, Formula> tasks = new LinkedHashMap<>();

    public FormulaProcessor(String rawFormula) {
        this.rawFormula = rawFormula;
        chars = rawFormula.toCharArray();
    }

    public Formula parse() {
        return parseFormula(new Formula());
    }

    public Formula parseFormula(Formula formula) {
        Operator prevOperator = null;
        while (i < chars.length) {
            char character = chars[i];
            Operable operable = Operable.of(character);

            if (operable instanceof Operand) {
                formula.setNext(new Variable((Operand) operable));
            } else {
                Operator operator = (Operator) operable;

                if (prevOperator == null || prevOperator.isSameOrGreaterPriority(operator)) {
                    formula.addOperator(operator);
                } else if (formula.isOpenParenthesis() && operator instanceof LeftParenthesis) {
                    return formula;
                } else {
                    // less priority operator
                    Variable<String> replacing = generateNextVariable();
                    Variable replaced = formula.replaceNext(replacing); //
                    Formula newFormula = new Formula(replaced, operator);
                    tasks.put(replacing.getValue().getValue(), parseFormula(newFormula)); //
                }

                prevOperator = operator;
            }
        }
        return formula;
    }

    private Variable<String> generateNextVariable() {
        v += 1;
        return new Variable<>(new StringOperand("V" + v));
    }
}


