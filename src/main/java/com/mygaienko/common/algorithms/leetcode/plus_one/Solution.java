package com.mygaienko.common.algorithms.leetcode.plus_one;

class Solution {

    public int[] plusOne(int[] digits) {
        int N = digits.length;

        int[] result = new int[N+1];

        int rest = 0;
        for (int i = N - 1; i >= 0; i--) {
            int digit = digits[i];

            if (i == N - 1) {
                if (digit == 9) {
                    result[i + 1] = 0;
                    rest = 1;
                } else {
                    result[i + 1] = digits[i] + 1;
                }
            } else {
                if (rest != 0) {
                    if (digit == 9) {
                        result[i + 1] = 0;
                        rest = 1;
                    } else {
                        result[i + 1] = digits[i] + rest;
                        rest = 0;
                    }
                } else {
                    result[i + 1] = digits[i];
                }
            }
        }

        if (rest == 1) {
            result[0] = 1;
        }

        if (result[0] == 0) {
            result = shift(result);
        }

        return result;
    }

    private int[] shift(int[] from) {
        int[] to = new int[from.length-1];

        for (int i = 1; i < from.length; i++) {
            to[i-1] = from[i];
        }

        return to;
    }

}
