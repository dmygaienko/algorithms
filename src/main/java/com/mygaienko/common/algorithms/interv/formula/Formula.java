package com.mygaienko.common.algorithms.interv.formula;

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
}
