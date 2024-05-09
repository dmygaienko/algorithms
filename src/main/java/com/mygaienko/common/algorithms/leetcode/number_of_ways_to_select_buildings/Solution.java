package com.mygaienko.common.algorithms.leetcode.number_of_ways_to_select_buildings;

class Solution {
    public long numberOfWays(String s) {
        var suffixSum = new int[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            var building = s.charAt(i) - '0';

            if (i == s.length() - 1 && building == 0) {
                suffixSum[i] = 1;
            } else if (building == 0) {
                suffixSum[i] = suffixSum[i + 1] + 1;
            } else if (i < s.length() - 1 && building == 1) {
                suffixSum[i] = suffixSum[i + 1];
            }
        }

        var count = 0L;
        var zeroCount = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            var building = s.charAt(i) - '0';
            var oneCount = i - zeroCount;

            var currentCount = 0;
            if (i == 0 && building == 0) {
                zeroCount = 1;
            } else if (building == 0) {
                var suffixOnes = s.length() - i - 1 - suffixSum[i + 1];
                currentCount = oneCount * suffixOnes;
                zeroCount++;
            } else {
                currentCount = zeroCount * suffixSum[i + 1];
            }

            count += currentCount;
        }

        return count;
    }


    /*public long numberOfWays(String s, int k) {
        // int k = 3;
        long[][] ways = new long[k][2];
        for (int i = 0; i < s.length(); ++i) {
            int idx = s.charAt(i) - '0';
            ++ways[0][idx];
            for (int j = 1; j < k; ++j) {
                ways[j][idx] += ways[j - 1][1 - idx];
            }
        }
        return ways[k - 1][0] + ways[k - 1][1];
    }

    public long numberOfWays(String s) {
        long one = 0, zero = 0, oneZero = 0, zeroOne = 0, ways = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ++zero;
                oneZero += one; // Count in '10'.
                ways += zeroOne; // Count in '010'.
            }else {
                ++one;
                zeroOne += zero; // Count in '01'.
                ways += oneZero; // Count in '101'.
            }
        }
        return ways;
    }*/
}