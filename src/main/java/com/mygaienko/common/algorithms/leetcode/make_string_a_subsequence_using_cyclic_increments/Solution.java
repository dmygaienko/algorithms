package com.mygaienko.common.algorithms.leetcode.make_string_a_subsequence_using_cyclic_increments;

class Solution {

    public boolean canMakeSubsequence(String str1, String str2) {

        for (int i = 0, j = 0; i < str1.length() && j < str2.length(); i++) {
            char charOne = str1.charAt(i);
            char charTwo = str2.charAt(j);

            if (charOne == charTwo || nextChar(charOne) == charTwo) {
                j++;
                if (j == str2.length()) return true;
            }
        }

        return false;
    }

    private char nextChar(char charOne) {
        var charIndex = charOne - 'a';
        if (charIndex == 25) return 'a';
        return (char) (charIndex + 1 + 'a');
    }

}