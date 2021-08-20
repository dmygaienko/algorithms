package com.mygaienko.common.algorithms.interv.formula.operable;

import lombok.Value;

@Value
public class IntegerOperand implements Operand<Integer> {

    final Integer value;

    static IntegerOperand of(Integer i) {
        return new IntegerOperand(i);
    }


}
