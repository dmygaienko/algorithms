package com.mygaienko.common.algorithms.interv.formula.operable;

public abstract class Operator implements Operable {

    Variable firstVariable;
    Variable secondVariable;

    public Variable getFirstVariable() {
        return firstVariable;
    }

    public void setFirstVariable(Variable firstVariable) {
        this.firstVariable = firstVariable;
    }

    public Variable getSecondVariable() {
        return secondVariable;
    }

    public void setSecondVariable(Variable secondVariable) {
        this.secondVariable = secondVariable;
    }

    public abstract boolean isSameOrGreaterPriority(Operator operator);
}
