package com.mygaienko.common.algorithms.interv.formula.operable;

import lombok.Data;

@Data
public class RightParenthesis extends Operator {

    @Override
    public boolean isSameOrGreaterPriority(Operator operator) {
        return false;
    }

}
