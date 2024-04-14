package com.mygaienko.common.algorithms.leetcode.confusing_number;

import java.util.Set;
import java.util.ArrayDeque;

class Solution {
    Set<Integer> notValid = Set.of(2, 3, 4, 5, 7);

    public boolean confusingNumber(int n) {
        var stack = new ArrayDeque<Integer>();

        var curr = n;
        while (curr > 0) {
            var val = curr % 10;
            curr = curr / 10;
            if (notValid.contains(val)) {
                return false;
            }
            stack.push(val);
        }

        var result = 0;
        var i = 0;
        while (!stack.isEmpty()) {
            var val = stack.pop();
            result = result + (int) Math.pow(10, i) * rotate(val);
            i++;
        }

        return result != n;
    }

    private int rotate(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 6) {
            return 9;
        } else if (n == 8) {
            return 8;
        } else {
            return 6;
        }

    }
}
