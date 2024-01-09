package com.mygaienko.common.algorithms.leetcode.palindrome_permutation_ii;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> generatePalindromes(String s) {
        var result = new ArrayList<String>();

        var counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
        }

        var seenNotPair = false;
        Character midChar = null;
        for (int i = 0; i < counter.length; i++) {
            var count = counter[i];
            if (count % 2 != 0) {
                if (seenNotPair) return result;
                seenNotPair = true;
                midChar = (char) (i + 'a');
            }
        }

        backtrack(counter, midChar, s.length(), new StringBuilder(), result);
        return result;
    }

    void backtrack(int[] counter, Character midChar, int target, StringBuilder current, List<String> result) {
        if (current.length() * 2 == target) {
            result.add(current.toString() + new StringBuilder(current).reverse().toString());
            return;
        } else if (current.length() * 2 + 1 == target) {
            result.add(current.toString() + midChar + new StringBuilder(current).reverse().toString());
            return;
        }

        for (int i = 0; i < counter.length; i++) {
            var ch = (char) (i + 'a');
            var count = counter[i];
            if (count <= 1) continue;

            current.append(ch);
            counter[i] = count - 2;

            backtrack(counter, midChar, target, current, result);

            current.deleteCharAt(current.length() - 1);
            counter[i] = count;
        }
    }

}
