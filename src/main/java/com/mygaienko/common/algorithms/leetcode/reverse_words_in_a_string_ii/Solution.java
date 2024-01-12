package com.mygaienko.common.algorithms.leetcode.reverse_words_in_a_string_ii;

class Solution {

    public void reverseWords(char[] s) {
        //swap chars in sentence
        swap(s, 0, s.length - 1);

        //swap chars in word
        for (int i = 0; i < s.length; i++) {
            int j = i;
            while (j < s.length && s[j] != ' ') {
                j++;
            }

            swap(s, i, j - 1);
            i = j;
        }
    }

    private void swap(char[] s, int left, int right) {
        var N = s.length;
        while (left < right && left < N && left >= 0 && right < N && right >= 0) {
            var temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}