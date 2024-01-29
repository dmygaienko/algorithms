package com.mygaienko.common.algorithms.leetcode.shortest_distance_to_target_color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionV2 {

    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        var n = colors.length;
        var currentRight = new int[]{0, 0, 0};
        var currentLeft = new int[]{n - 1, n - 1, n - 1};

        var distance = new int[3][n];
        Arrays.stream(distance).forEach(arr -> Arrays.fill(arr, -1));

        //going forward
        for (int i = 0; i < colors.length; i++) {
            var color = colors[i] - 1;
            for (int j = currentRight[color]; j < i + 1; j++) {
                distance[color][j] = i - j;
            }
            currentRight[color] = i + 1;
        }

        //going backward
        for (int i = colors.length - 1; i >= 0; i--) {
            var color = colors[i] - 1;
            for (int j = currentLeft[color]; j > i - 1; j--) {
                var diff = j - i;
                if (distance[color][j] == -1 || distance[color][j] > diff) {
                    distance[color][j] = diff;
                }
            }
            currentLeft[color] = i - 1;
        }

        var result = new ArrayList<Integer>();
        for (var query : queries) {
            var index = query[0];
            var color = query[1] - 1;
            result.add(distance[color][index]);
        }

        return result;
    }

}
