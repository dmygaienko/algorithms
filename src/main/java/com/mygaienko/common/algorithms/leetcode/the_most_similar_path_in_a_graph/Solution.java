package com.mygaienko.common.algorithms.leetcode.the_most_similar_path_in_a_graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        // Create an array dp where dp[i][j] is the min edit distance
        // for the path starting at node i
        // and compared to index j of the targetPath.
        var dp = new Integer[targetPath.length][n];
        var path = new int[targetPath.length][n];

        //init dp
        for (int i = 0; i < n; i++) {
            dp[0][i] = names[i].equals(targetPath[0]) ? 0 : 1;
        }

        //calculate dp
        for (int i = 1; i < targetPath.length; i++) {
            Arrays.fill(dp[i], targetPath.length + 1);

            for (int[] road : roads) {
                for (int j = 0; j < 2; j++) {
                    int u = road[j];
                    int v = road[j ^ 1];
                    int mismatch = names[v].equals(targetPath[i]) ? 0 : 1;
                    int cur = dp[i - 1][u] + mismatch;

                    if (cur < dp[i][v]) {
                        dp[i][v] = cur;
                        path[i][v] = u;
                    }
                }
            }
        }

        List<Integer> lastDp = Arrays.asList(dp[targetPath.length - 1]);
        int v = lastDp.indexOf(Collections.min(lastDp));

        var ans = new ArrayList<Integer>();
        ans.add(v);

        for (int i = targetPath.length - 1; i > 0; i--) {
            v = path[i][v];
            ans.add(v);
        }

        Collections.reverse(ans);
        return ans;
    }

}