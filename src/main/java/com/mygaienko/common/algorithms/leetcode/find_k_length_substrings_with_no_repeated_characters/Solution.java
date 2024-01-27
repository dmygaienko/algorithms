package com.mygaienko.common.algorithms.leetcode.find_k_length_substrings_with_no_repeated_characters;

class Solution {

    // iterate over string
    // use two iterators keeping distance between them equal to k
    // add char count on each step, if count > 1 than skip
    // if less than increment count of result
    public int numKLenSubstrNoRepeats(String s, int k) {
        var charCount = new int[26];
        var result = 0;

        var left = 0;
        var right = 0;

        var uniqueCount = 0;
        while (right < s.length()) {
            var nextCh = s.charAt(right);
            var nextI = nextCh - 'a';
            charCount[nextI]++;
            if (charCount[nextI] == 1) {
                uniqueCount++;
            } else if (charCount[nextI] == 2) {
                uniqueCount--;
            }

            if (right - left + 1 > k) {
                var leftCh = s.charAt(left);
                var leftI = leftCh - 'a';
                charCount[leftI]--;
                if (charCount[leftI] == 1) {
                    uniqueCount++;
                } else if (charCount[leftI] == 0) {
                    uniqueCount--;
                }
                left++;
            }

            if (uniqueCount == k) {
                result++;
            }
            right++;
        }

        return result;
    }
}