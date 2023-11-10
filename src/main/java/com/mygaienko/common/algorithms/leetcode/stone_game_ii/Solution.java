package com.mygaienko.common.algorithms.leetcode.stone_game_ii;

class Solution {

    // iterate over piles

    // let N be the piles length
    // let M be the max piles everyone can get

    // let [N][M] be the dp array
    // to get into the i step we need to move from previos step (optimized)
    // for the previous person
    public int stoneGameII(int[] piles) {
        var N = piles.length;
        var M = N / 2;

        var dp = new int[N][M];
        dp[0][0] = piles[0];
        dp[1][0] = piles[1];
        dp[1][1] = dp[0][0] + piles[1];

        var maxM = 2;
        for (int i = 2; i < N; i++) {
            for (int j = 0; j < maxM; j++) {

            }
        }

        return dp[N - 1][M - 1];
    }

}
