package com.mygaienko.common.algorithms.leetcode.palindrome_permutation;

class Solution {
    public boolean canPermutePalindrome(String s) {
        var charCounts = new int[26];

        for (var ch : s.toCharArray()) {
            charCounts[ch - 'a']++;
        }

        var odd = 0;
        for (var charCount : charCounts) {
            if (charCount % 2 > 0) {
                odd++;

                if (odd > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}
