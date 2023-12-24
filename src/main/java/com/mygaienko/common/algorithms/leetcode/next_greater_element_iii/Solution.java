package com.mygaienko.common.algorithms.leetcode.next_greater_element_iii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {

    public int nextGreaterElement(int n) {
        var decimals = toDecimals(n);

        for (int i = 1; i < decimals.length; i++) {
            int prev = decimals[i - 1];
            int curr = decimals[i];
            if (prev > curr) {

                //find least great value more than curr
                int leastGreater = Integer.MAX_VALUE;
                int leastGreaterIndex = -1;
                int j = 0;
                for (; j < i; j++) {
                    if (decimals[j] > curr && decimals[j] < leastGreater) {
                        leastGreater = decimals[j];
                        leastGreaterIndex = j;
                    }
                }

                decimals[i] = leastGreater;
                decimals[leastGreaterIndex] = curr;

                Arrays.sort(decimals, 0, i, Collections.reverseOrder());
                return toInt(decimals);
            }
        }

        return -1;
    }

    private int toInt(Integer[] decimals) {
        var result = 0L;
        for (int i = 0; i < decimals.length; i++) {
            result += decimals[i] * Math.pow(10, i);
        }
        return result <= Integer.MAX_VALUE ? (int) result : -1;
    }

    public Integer[] toDecimals(int n) {
        var result = new ArrayList<Integer>();
        var val = n;
        while (val > 0) {
            result.add(val % 10);
            val = val / 10;
        }
        return result.toArray(new Integer[0]);
    }

}