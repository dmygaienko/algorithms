package com.mygaienko.common.algorithms.leetcode.palindrome_permutation;

import java.util.HashSet;

class SolutionV2 {
    public boolean canPermutePalindrome(String s) {
        var oddSet = new HashSet<Character>();
        for (var ch : s.toCharArray()) {
            if (!oddSet.add(ch)) {
                oddSet.remove(ch);
            }
        }
        return oddSet.size() <= 1;
    }
}
