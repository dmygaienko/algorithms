package com.mygaienko.common.algorithms.leetcode.single_row_keyboard;

class Solution {
    public int calculateTime(String keyboard, String word) {
        var chars = new int[26];

        for (int i = 0; i < keyboard.length(); i++) {
            var ch = keyboard.charAt(i);
            chars[ch - 'a'] = i;
        }

        var result = 0;

        var prevIndex = 0;
        for (var ch : word.toCharArray()) {
            var currIndex = chars[ch - 'a'];
            result += Math.abs(currIndex - prevIndex);
            prevIndex = currIndex;
        }
        return result;
    }
}
