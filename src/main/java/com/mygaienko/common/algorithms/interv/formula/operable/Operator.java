package com.mygaienko.common.algorithms.interv.formula.operable;

import java.util.ArrayList;
import java.util.List;

public abstract class Operator implements Operable {

    Operand firstOperand;
    Operand secondOperand;

    List<Operator> attached = new ArrayList<>();

    public void attach(Operator operator) {
        attached.add(operator);
    }

    public Operand getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(Operand firstOperand) {
        this.firstOperand = firstOperand;
    }

    public Operand getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(Operand secondOperand) {
        this.secondOperand = secondOperand;
    }

    public List<Operator> getAttached() {
        return attached;
    }

    public abstract boolean isSameOrGreaterPriority(Operator operator);
}
