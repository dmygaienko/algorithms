package com.mygaienko.common.algorithms.leetcode.divide_chocolate;

class Solution {

    public int maximizeSweetness(int[] sweetness, int k) {
        var sum = 0;
        var left = Integer.MAX_VALUE;
        for (var s : sweetness) {
            left = Math.min(left, s);
            sum += s;
        }
        var right = sum / (k + 1);

        var maxSweetness = 0;
        while (left <= right) {
            var mid = left + (right - left) / 2;

            if (isDividable(sweetness, k + 1, mid)) {
                maxSweetness = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return maxSweetness;
    }

    private boolean isDividable(int[] sweetness, int chunks, int minSweetness) {
        var count = 0;
        var currSweetness = 0;
        for (var s : sweetness) {
            currSweetness += s;

            if (currSweetness >= minSweetness) {
                count++;
                currSweetness = 0;
            }
        }

        return count >= chunks;
    }

}
