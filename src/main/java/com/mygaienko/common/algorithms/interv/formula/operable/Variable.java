package com.mygaienko.common.algorithms.interv.formula.operable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Variable<T> {

    Operand<T> value;

    Operator parentOperator;
    Operator childOperator;

    public Variable(Operand<T> value) {
        this.value = value;
    }

    public void setParentOperator(Operator operator) {
        if (parentOperator != null) {
            parentOperator.attach(operator);
        } else {
            this.parentOperator = operator;
        }
    }

    public void setChildOperator(Operator operator) {
        if (childOperator != null) {
            childOperator.attach(operator);
        } else {
            this.childOperator = operator;
        }
    }
}
