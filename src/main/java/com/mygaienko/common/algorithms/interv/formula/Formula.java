package com.mygaienko.common.algorithms.interv.formula;

import com.mygaienko.common.algorithms.interv.formula.operable.LeftParenthesis;
import com.mygaienko.common.algorithms.interv.formula.operable.Operator;
import com.mygaienko.common.algorithms.interv.formula.operable.Variable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
public class Formula {

    Variable start;
    Variable next;

    Operator startOperator;

    Map<String, Formula> tasks = null;

    public Formula(Map<String, Formula> tasks) {
       this.tasks = tasks;
    }

    public Formula(Variable start, Operator startOperator) {
        this.start = start;
        this.next = start;
        this.startOperator = startOperator;
        addOperator(startOperator);
    }

    public Formula(Operator operator) {
        startOperator = operator;
    }

    public void setNext(Variable next) {
        if (start == null) {
            start = next;
        }
        Variable prevNext = this.next;
        this.next = next;
        if (prevNext != null) {
            next.setParentOperator(prevNext.getChildOperator());
        }
    }

    public Variable replaceNext(Variable replacing) {
        Variable prevNext = next;
        prevNext.getParentOperator().setSecondVariable(replacing);
        replacing.setParentOperator(prevNext.getParentOperator());
        prevNext.setParentOperator(null);
        this.next = replacing;
        return prevNext;
    }

    public void addOperator(Operator operator) {
        next.setChildOperator(operator);
    }

    public boolean isOpenParenthesis() {
        return startOperator instanceof LeftParenthesis;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        Variable nextToString = start;
        while (nextToString != null) {
            stringBuilder.append(" ");
            stringBuilder.append(nextToString);
            stringBuilder.append(" ");
            Operator childOperator = nextToString.getChildOperator();
            if (childOperator != null) {
                stringBuilder.append(childOperator);
                nextToString = childOperator.getSecondVariable();
            } else {
                nextToString = null;
            }
        }
        stringBuilder.append("\n");

        if (tasks != null) {
            stringBuilder.append(tasks);
        }

        return  stringBuilder.toString();
    }

}
