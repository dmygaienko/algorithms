package com.mygaienko.common.algorithms.leetcode.find_permutation;

class Solution {

    // generate array of int according to s length with unique integers increasing from 1 to n - 1
    // iterate over Strings s and check whether comparison is true or not, if not, swap both values
    public int[] findPermutation(String s) {
        int N = s.length() + 1;
        var permutation = new int[N];
        for (int i = 0; i < N; i++) {
            permutation[i] = i + 1;
        }

        for (int i = 0; i < s.length(); i++) {
            int j = i;

            while (s.charAt(j) == 'D') {
                if (j + 1 < s.length() && s.charAt(j + 1) == 'D') {
                    j++;
                } else {
                    swap(permutation, i, j + 1);
                    break;
                }
            }

            i = j;
        }

        return permutation;
    }

    private void swap(int[] arr, int from, int to) {
        while (from < to) {
            var temp = arr[from];
            arr[from] = arr[to];
            arr[to] = temp;
            from++;
            to--;
        }
    }
}