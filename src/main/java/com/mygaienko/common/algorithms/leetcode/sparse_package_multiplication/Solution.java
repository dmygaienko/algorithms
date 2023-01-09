package com.mygaienko.common.algorithms.leetcode.sparse_package_multiplication;

class Solution {

    public int[][] multiply(int[][] a, int[][] b) {
        int M = a.length;
        int P = b[0].length;

        int[][] product = new int[M][P];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < P; j++) {
                product[i][j] = multiply(a, b, i, j);
            }
        }

        return product;
    }

    private int multiply(int[][] a, int[][] b, int i, int j) {
        int A = a[0].length;

        int result = 0;
        for (int n = 0; n < A; n++) {
            result += a[i][n] * b[n][j];
        }
        return result;
    }

}