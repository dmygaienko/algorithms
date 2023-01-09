package com.mygaienko.common.algorithms.leetcode.sparse_package_multiplication;

class Solution {

    /**
     * A is an m × n matrix and B is an n × p matrix,
     */
    public int[][] multiply(int[][] a, int[][] b) {
        int M = a.length;
        int N = a[0].length;
        int P = b[0].length;

        int[][] product = new int[M][P];

        for (int i = 0; i < M; i++) {
            for (int n = 0; n < N; n++) {
                if (a[i][n] != 0) {
                    for (int j = 0; j < P; j++) {
                        product[i][j] += a[i][n] * b[n][j];
                    }
                }

            }
        }

        return product;
    }

}