package com.mygaienko.common.algorithms.interv.formula;

import com.mygaienko.common.algorithms.interv.formula.operable.Operator;
import com.mygaienko.common.algorithms.interv.formula.operable.StringOperand;
import com.mygaienko.common.algorithms.interv.formula.operable.Variable;
import lombok.Data;

@Data
public class Formula {

    Variable start;
    Variable next;

    Variable calcStart;

    public void setNext(Variable next) {
        if (start == null) {
            start = next;
        }
        this.next = next;
    }

    public Variable replaceNext(Variable replacing) {
        Variable prevNext = next;
        prevNext.getParent().setSecond(replacing.getValue());
        this.next = replacing;
        return prevNext;
    }

    public void addOperator(Operator operator) {
        next.setChild(operator);
        operator.setFirst(next.getValue());
    }

}
