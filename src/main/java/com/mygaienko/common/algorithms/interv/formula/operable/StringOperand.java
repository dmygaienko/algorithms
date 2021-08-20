package com.mygaienko.common.algorithms.interv.formula.operable;

import lombok.Value;

@Value
public class StringOperand implements Operand<String> {

    final String value;

    static StringOperand of(String i) {
        return new StringOperand(i);
    }


}
