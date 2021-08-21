package com.mygaienko.common.algorithms.interv.formula;

import com.mygaienko.common.algorithms.interv.formula.operable.Operator;
import com.mygaienko.common.algorithms.interv.formula.operable.RightParenthesis;
import com.mygaienko.common.algorithms.interv.formula.operable.Variable;
import lombok.Data;

@Data
public class Formula {

    Variable start;
    Variable next;

    Variable calcStart;

    Operator startOperator;

    public Formula(Variable start, Operator startOperator) {
        this.start = start;
        this.startOperator = startOperator;
        addOperator(startOperator);
    }

    public void setNext(Variable next) {
        if (start == null) {
            start = next;
        }
        this.next = next;
    }

    public Variable replaceNext(Variable replacing) {
        Variable prevNext = next;
        prevNext.getParentOperator().setSecondOperand(replacing.getValue());
        this.next = replacing;
        return prevNext;
    }

    public void addOperator(Operator operator) {
        next.setChildOperator(operator);
        operator.setFirstOperand(next.getValue());
    }

    public boolean isOpenParenthesis() {
        return startOperator instanceof RightParenthesis;
    }

}
