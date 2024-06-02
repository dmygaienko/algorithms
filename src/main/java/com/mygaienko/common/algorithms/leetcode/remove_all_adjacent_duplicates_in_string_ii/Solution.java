package com.mygaienko.common.algorithms.leetcode.remove_all_adjacent_duplicates_in_string_ii;

import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;

class Solution {

    // add char to stack with count of duplicates
    // then on removing duplicates check whether new duplicates appears, and count their new sum
    public String removeDuplicates(String s, int k) {
        var stack = new LinkedList<Pair<Character, Integer>>();
        var duplicates = 1;

        for (var ch : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek().getKey() != ch) {
                duplicates = 1;
            } else {
                duplicates++;
            }
            stack.push(Pair.of(ch, duplicates));

            if (duplicates == k) {
                while (duplicates > 0) {
                    stack.pop();
                    duplicates--;
                }

                if (!stack.isEmpty()) {
                    duplicates = stack.peek().getValue();
                }
            }
        }

        var sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast().getKey());
        }

        return sb.toString();
    }
}
