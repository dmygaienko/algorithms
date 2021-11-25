package com.mygaienko.common.algorithms.leetcode.distinct_subsequences_ii;

public class SolutionHint {

    public int distinctSubseqII(String S) {
        int[] dict = new int[26]; // Save 'total' count when a character appears.
        int total = 1; //Empty string, starting at count 1
        for (char c : S.toCharArray()) {
            int combo = total * 2 - dict[c - 'a']; // New - Duplicates
            dict[c - 'a'] = total; // if 'c' ever appears again, it will clash with the current combos.
            total = combo < 0 ? combo + 1000000007 : combo % 1000000007; // mod and fix negative mods
        }
        return total - 1; // Subtract the empty string
    }

//    public int distinctSubseqII(String S) {
//        int n = S.length(), M = (int)1e9 + 7;
//        int[] count = new int[26];
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            int index = S.charAt(i) - 'a';
//            int cur = (1 + sum - count[index] + M) % M;
//            sum = (sum + cur) % M;
//            count[index] = (count[index] + cur) % M;
//        }
//        return sum;
//    }
}

