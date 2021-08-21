package com.mygaienko.common.algorithms.interv.formula;

import java.util.Map;

/**
 * Examples of formula:
 * (a + b) * 20 - c
 * 12 - 5 * 6 / (a - 12 * (b + 5))
 */
public class Calculator {

    public Formula parse(String rawFormula) {
        FormulaProcessor formulaProcessor = new FormulaProcessor(rawFormula);
        return formulaProcessor.parse();
    }

    public long calculate(Formula formula, Map<String, Long> variables) {
        return 0;
    }

}
