package com.mygaienko.common.algorithms.interv.formula.operable;

public interface Operable {

    static Operable of(Character character) {
        switch (character) {
            case '(':
                return new LeftParenthesis();
            case ')':
                return new RightParenthesis();
            case '*':
                return new Multiply();
            case '/':
                return new Divide();
            case '+':
                return new Plus();
            case '-':
                return new Minus();
            default:
                return getOperand(character);
        }
    }

    static Operand getOperand(Character character) {
        String s = String.valueOf(character);
        return s.matches("\\d+") ? new IntegerOperand(Integer.valueOf(s)) : new StringOperand(s);
    }

}
