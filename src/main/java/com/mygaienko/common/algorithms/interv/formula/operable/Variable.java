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
        this.parentOperator = operator;
        if (operator != null) {
            operator.setSecondVariable(this);
        }
    }

    public void setChildOperator(Operator operator) {
        this.childOperator = operator;
        operator.setFirstVariable(this);
    }

    @Override
    public String toString() {
        return value.getValue().toString();
    }
}
