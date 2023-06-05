package com.mygaienko.common.algorithms.leetcode.longest_substring_with_at_least_k_repeating_characters;

class Solution {

    public int longestSubstring(String s, int k) {
        int longestLength = 0;
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            longestLength = findNext(s, i, i + longestLength, longestLength, k, counts, false);

            char iChar = s.charAt(i);
            counts[iChar - 'a']--;
        }

        return longestLength;
    }

    private int findNext(String s, int i, int j, int longestLength, int k, int[] counts, boolean found) {
        if (j >= s.length()) return longestLength;

        char ch = s.charAt(j);

        int count = ++counts[ch - 'a'];

        if (count >= k && (found || isFound(counts, k))) {
            found = true;
            int currentLength = j - i + 1;
            if (currentLength >= longestLength) {
                longestLength = currentLength;
            }
        } else {
            found = false;
        }

        longestLength = findNext(s, i, j + 1, longestLength, k, counts, found);

        if (j <= i + longestLength) return longestLength;

        counts[ch - 'a']--;

        return longestLength;
    }

    private boolean isFound(int[] counts, int k) {
        for (int count : counts) {
            if (count > 0 && count < k) return false;
        }
        return true;
    }

}