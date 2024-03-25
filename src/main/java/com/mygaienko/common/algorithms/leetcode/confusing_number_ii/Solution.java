package com.mygaienko.common.algorithms.leetcode.confusing_number_ii;

class Solution {

    int[] digits = new int[]{0, 1, 6, 8, 9};

    public int confusingNumberII(int n) {
        return confusingNumber(n, 1) + confusingNumber(n, 6) + confusingNumber(n, 8) + confusingNumber(n, 9);
    }

    private int confusingNumber(int n, long curr) {
        var count = 0;
        if (curr > n) {
            return count;
        }
        var rotated = rotate(curr);

        if (curr != rotated) {
            count++;
        }

        for (var digit : digits) {
            var next = curr * 10 + digit;
            count += confusingNumber(n, next);
        }

        return count;
    }

    public long rotate(long n) {
        var answer = 0L;
        while (n > 0) {
            int digit = (int) n % 10;
            answer = answer * 10 + rotateDigit(digit);
            n = n / 10;
        }
        return answer;
    }

    private int rotateDigit(int digit) {
        if (digit == 6) {
            return 9;
        } else if (digit == 9) {
            return 6;
        }
        return digit;
    }

}
