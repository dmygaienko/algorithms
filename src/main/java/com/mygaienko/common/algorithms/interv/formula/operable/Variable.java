package com.mygaienko.common.algorithms.interv.formula.operable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Variable<T> {

    Operand<T> value;

    Operator parent;
    Operator child;

    public Variable(Operand<T> value) {
        this.value = value;
    }

    public void setParent(Operator operator) {
        if (parent != null) {
            parent.attach(operator);
        } else {
            this.parent = operator;
        }
    }

    public void setChild(Operator operator) {
        if (child != null) {
            child.attach(operator);
        } else {
            this.child = operator;
        }
    }
}
