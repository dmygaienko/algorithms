package com.mygaienko.common.algorithms.leetcode.perform_string_shifts;

class Solution {
    public String stringShift(String s, int[][] shifts) {
        var curr = s;
        var length = s.length();

        for (int[] shift : shifts) {
            var dir = shift[0];
            var amount = shift[1] % length;

            if (dir == 0) {
                var shifted = curr.substring(0, amount);
                var root = curr.substring(amount);
                curr = root + shifted;
            } else {
                var pivot = s.length() - amount;
                var shifted = curr.substring(pivot);
                var root = curr.substring(0, pivot);
                curr = shifted + root;
            }
        }

        return curr;
    }
}