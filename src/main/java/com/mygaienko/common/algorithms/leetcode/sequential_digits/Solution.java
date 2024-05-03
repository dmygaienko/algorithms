package com.mygaienko.common.algorithms.leetcode.sequential_digits;

import java.util.ArrayList;
import java.util.List;

class Solution {

    String digits = "123456789";

    public List<Integer> sequentialDigits(int low, int high) {
        var result = new ArrayList<Integer>();

        var lowLength = String.valueOf(low).length();
        var highLength = String.valueOf(high).length();

        for (int length = lowLength; length <= digits.length() && length <= lowLength + highLength; length++) {
            for (int start = 0; start + length <= digits.length(); start++) {

                var val = Integer.valueOf(digits.substring(start, start + length));
                if (val >= low && val <= high) {
                    result.add(val);
                }
            }
        }
        return result;
    }

}
