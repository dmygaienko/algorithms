package com.mygaienko.common.algorithms.leetcode.remove_duplicate_letters;

import java.util.*;

@SuppressWarnings("Duplicates")
class Solution {

    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            charCounts.compute(ch, (k, v) -> v == null ? 1 : v + 1);
        }

        BitSet bitSet = new BitSet(26);

        ArrayDeque<Character> monoStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int chIndex = getIndex(ch);

            while (!monoStack.isEmpty() && monoStack.peek() >= ch
                    && charCounts.get(monoStack.peek()) > 0 && !bitSet.get(chIndex)) {
                Character pop = monoStack.pop();
                bitSet.clear(getIndex(pop));
            }

            if (!bitSet.get(chIndex)) {
                monoStack.push(ch);
                bitSet.set(chIndex);
            }

            charCounts.compute(ch, (k, v) -> v - 1);
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Character> iterator = monoStack.descendingIterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
        }
        return sb.toString();
    }

    private int getIndex(char ch) {
        return ch - 'a';
    }

}
