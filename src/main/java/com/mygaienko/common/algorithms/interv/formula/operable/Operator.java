package com.mygaienko.common.algorithms.interv.formula.operable;

import java.util.ArrayList;
import java.util.List;

public abstract class Operator implements Operable {

    Operand first;
    Operand second;

    List<Operator> attached = new ArrayList<>();

    public void attach(Operator operator) {
        attached.add(operator);
    }

    public Operand getFirst() {
        return first;
    }

    public void setFirst(Operand first) {
        this.first = first;
    }

    public Operand getSecond() {
        return second;
    }

    public void setSecond(Operand second) {
        this.second = second;
    }

    public List<Operator> getAttached() {
        return attached;
    }

    public abstract boolean isSameOrGreaterPriority(Operator operator);
}
