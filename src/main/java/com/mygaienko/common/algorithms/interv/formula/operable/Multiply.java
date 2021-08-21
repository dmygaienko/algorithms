package com.mygaienko.common.algorithms.interv.formula.operable;

public class Multiply extends Operator {

    @Override
    public boolean isSameOrGreaterPriority(Operator operator) {
        return operator instanceof Divide || operator instanceof Multiply;
    }

}
