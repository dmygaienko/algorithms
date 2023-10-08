package com.mygaienko.common.algorithms.leetcode.fair_distribution_of_cookies;

import java.util.BitSet;

class SolutionV3 {

    int target = 0;

    public int distributeCookies(int[] cookies, int k) {
        var sum = 0;
        for (int i = 0; i < cookies.length; i++) {
            sum += cookies[i];
        }
        target = sum / k;

        int[] res = distributeCookies(cookies, 0, 0, sum, new BitSet(cookies.length));
        return Math.max(res[0], res[1]);
    }

    private int[] distributeCookies(int[] cookies, int current, int currentSum, int sum, BitSet bitSet) {
        int[] res = null;
        if (current == target && currentSum + current != sum) {
            currentSum += current;
            current = 0;
        } else if (current >= target && currentSum + current == sum) {
            return new int[]{current, target};
        }

        for (int i = 0; i < cookies.length; i++) {
            if (!bitSet.get(i)) {
                var next = cookies[i];
                bitSet.set(i);

                int nextCurrent = current + next;
                var result = distributeCookies(cookies, nextCurrent, currentSum, sum, bitSet);
                if (res == null || (result != null && result[1] == target && res[0] > result[0])) {
                    res = result;
                }

                bitSet.set(i, false);
            }
        }

        return res;
    }
}
