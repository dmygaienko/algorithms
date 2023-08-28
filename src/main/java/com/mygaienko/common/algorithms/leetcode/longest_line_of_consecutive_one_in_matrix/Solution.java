package com.mygaienko.common.algorithms.leetcode.longest_line_of_consecutive_one_in_matrix;

class Solution {

    int H = 0;
    int V = 1;
    int D = 2;
    int A = 3;

    public int longestLine(int[][] mat) {
        int longest = 0;

        int N = mat.length;
        int M = mat[0].length;

        int[][] prevDp = new int[M][4];
        int[][] currDp = new int[M][4];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int val = mat[i][j];
                if (val != 1) continue;

                int hVal = 0;
                if (j - 1 >= 0 && currDp[j-1][H] != 0)  {
                    hVal = currDp[j-1][H];
                }
                currDp[j][H] = hVal + val;


                int vVal = 0;
                if (i - 1 >= 0 && prevDp[j][V] != 0) {
                    vVal = prevDp[j][V];
                }
                currDp[j][V] = vVal + val;

                int dVal = 0;
                if (i - 1 >= 0 && j - 1 > 0 && prevDp[j - 1][D] != 0) {
                    dVal = prevDp[j-1][D];
                }
                currDp[j][D] = dVal + val;

                int adVal = 0;
                if (i - 1 >= 0 && j + 1 < M && prevDp[j+1][A] != 0) {
                    adVal = prevDp[j+1][A];
                }
                currDp[j][A] = adVal + val;


                longest = Math.max(longest, currDp[j][H]);
                longest = Math.max(longest, currDp[j][V]);
                longest = Math.max(longest, currDp[j][D]);
                longest = Math.max(longest, currDp[j][A]);
            }
            prevDp = currDp;
            currDp = new int[M][4];
        }

        return longest;
    }

}
