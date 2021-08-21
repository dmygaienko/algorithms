package com.mygaienko.common.algorithms.interv.formula.operable;

import lombok.Data;

@Data
public class Multiply extends Operator {

    @Override
    public boolean isSameOrGreaterPriority(Operator operator) {
        return operator instanceof Divide || operator instanceof Multiply
                || operator instanceof Minus || operator instanceof Plus;
    }

    @Override
    public String toString() {
        return " * ";
    }

}
