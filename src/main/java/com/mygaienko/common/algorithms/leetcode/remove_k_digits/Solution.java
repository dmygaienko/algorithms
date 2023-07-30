package com.mygaienko.common.algorithms.leetcode.remove_k_digits;

import java.util.ArrayDeque;
import java.util.Iterator;

class Solution {

    public String removeKdigits(String num, int k) {
        if (num.length() <= k) return "0";

        ArrayDeque<Integer> monoStack = new ArrayDeque<>();

        for (int i = 0; i < num.length(); i++) {
            int value = getInt(num, i);

            while (!monoStack.isEmpty() && getInt(num, monoStack.peek()) > value && k > 0) {
                monoStack.pop();
                k--;
            }

            monoStack.push(i);
        }

        while (k > 0) {
            monoStack.pop();
            k--;
        }

        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Integer> iterator = monoStack.descendingIterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            int value = getInt(num, i);
            if (stringBuilder.length() == 0 && value == 0) continue;
            stringBuilder.append(value);
        }

        return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
    }

    public int getInt(String num, int i) {
        return Character.getNumericValue(num.charAt(i));
    }

}
