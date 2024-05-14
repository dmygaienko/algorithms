package com.mygaienko.common.algorithms.leetcode.minimum_number_of_swaps_to_make_the_binary_string_alternating;

class Solution {
    public int minSwaps(String s) {
        var length = s.length();

        var zeroCount = 0;
        var oneCount = 0;

        var zeroEvenCount = 0;
        var zeroOddCount = 0;

        var oneEvenCount = 0;
        var oneOddCount = 0;

        for (int i = 0; i < length; i++) {
            var ch = s.charAt(i);
            var even = i % 2 == 0;

            if (ch == '0') {
                zeroCount++;

                if (even) {
                    zeroEvenCount++;
                } else {
                    zeroOddCount++;
                }

            } else {
                oneCount++;

                if (even) {
                    oneEvenCount++;
                } else {
                    oneOddCount++;
                }
            }
        }

        if (zeroCount == oneCount) {
            if (zeroEvenCount >= oneEvenCount) {
                return length / 2 - zeroEvenCount;
            } else {
                return length / 2 - oneEvenCount;
            }
        } else if (zeroCount == oneCount + 1) { // so that only zeros should be even
            if (zeroEvenCount >= oneEvenCount) {
                return zeroOddCount;
            } else {
                return oneEvenCount;
            }
        } else if (oneCount == zeroCount + 1) { // so that only ones should be even
            if (oneEvenCount >= zeroEvenCount) {
                return oneOddCount;
            } else {
                return zeroEvenCount;
            }
        }

        return -1;
    }

}