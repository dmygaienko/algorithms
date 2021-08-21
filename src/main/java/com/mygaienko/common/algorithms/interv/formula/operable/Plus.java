package com.mygaienko.common.algorithms.interv.formula.operable;

public class Plus extends Operator {

    @Override
    public boolean isSameOrGreaterPriority(Operator operator) {
        return operator instanceof Minus || operator instanceof Plus;
    }

}


