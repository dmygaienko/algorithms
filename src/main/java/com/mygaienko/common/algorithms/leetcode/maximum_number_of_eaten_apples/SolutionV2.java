package com.mygaienko.common.algorithms.leetcode.maximum_number_of_eaten_apples;

import java.util.Arrays;

public class SolutionV2 {

    public int eatenApples(int[] apples, int[] days) {
        var maxAppleRoten = Integer.MIN_VALUE;
        var sorted = new int[apples.length][3];
        for (int i = 0; i < apples.length; i++) {
            var appleCount = apples[i];
            var appleRoten = i + days[i];
            sorted[i] = new int[]{i, appleRoten, appleCount};
            maxAppleRoten = Math.max(maxAppleRoten, appleRoten);
        }
        var dp = new int[maxAppleRoten + 1];
        Arrays.sort(sorted, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < sorted.length; i++) {
            var day = sorted[i][0];
            var appleRoten = sorted[i][1];
            var appleCount = sorted[i][2];

            for (int j = day; j < appleRoten; j++) {
                if (appleCount == 0) break;

                if (dp[j] == 0) {
                    dp[j] = 1;
                    appleCount--;
                }
            }
        }

        var total = 0;
        for (var apple : dp) {
            if (apple != 0) {
                total++;
            }
        }

        return total;
    }
}
