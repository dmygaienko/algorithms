package com.mygaienko.common.algorithms.leetcode.find_k_length_substrings_with_no_repeated_characters;

class SolutionV2 {

    // iterate over string
    // use two iterators keeping distance between them equal to k
    // add char count on each step, if count > 1 than skip
    // if less than increment count of result
    public int numKLenSubstrNoRepeats(String s, int k) {
        var charCount = new int[26];
        var result = 0;

        var left = 0;
        var right = 0;

        while (right < s.length()) {
            var next = s.charAt(right);

            charCount[next - 'a']++;

            while (charCount[next - 'a'] > 1) {
                charCount[s.charAt(left) - 'a']--;
                left++;
            }

            if (right - left + 1 == k) {
                result++;

                charCount[s.charAt(left) - 'a']--;
                left++;
            }

            right++;
        }

        return result;
    }
}