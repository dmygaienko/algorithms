package com.mygaienko.common.algorithms.leetcode.maximum_vacation_days;

import java.util.Arrays;

class Solution {

    // sort cities per week by count of vacation days (static array of lists)
    // build adjacency matrix from flights
    // iterate over weeks and calculate cities with max day and which has flights

    // build adjacency matrix from flights
    // keep calculation in dp [city][week] = value

    public int maxVacationDays(int[][] adj, int[][] days) {
        var dp = new int[days.length][days[0].length]; // cities, weeks
        //init for first week
        var cities = adj[0];
        for (int i = 0; i < days.length; i++) { // cities
            Arrays.fill(dp[i], -1);
        }

        for (int to = 0; to < cities.length; to++) {
            if (adj[0][to] == 1 || to == 0) {
                var vacation = days[to][0];
                dp[to][0] = Math.max(dp[to][0], vacation);
            }
        }

        var max = 0;
        //calculate all the cities for 1 to n weeks
        for (int j = 0; j < days[0].length; j++) { // weeks
            for (int i = 0; i < days.length; i++) { // cities

                if (dp[i][j] >= 0 && j + 1 < days[0].length) { // city is available
                    var nextCities = adj[i];
                    for (int k = 0; k < nextCities.length; k++) {
                        if (adj[i][k] == 1 || i == k) {
                            var nextVacation = dp[i][j] + days[k][j + 1];
                            dp[k][j + 1] = Math.max(dp[k][j + 1], nextVacation);
                        }
                    }
                }

                max = Math.max(max, dp[i][j]);
            }
        }

        return max;
    }

}
