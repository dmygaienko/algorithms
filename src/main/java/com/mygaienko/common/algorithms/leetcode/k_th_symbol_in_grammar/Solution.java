package com.mygaienko.common.algorithms.leetcode.k_th_symbol_in_grammar;

class Solution {

    public int kthGrammar(int n, int k) {
        return kthGrammar(n, k, 1, 1, 0);
    }

    private int kthGrammar(int n, int k, int curN, int curK, int curEl) {
        if (curN == n) return curEl;

        int from = curK == 1 ? 1 : (curK - 1) * (int) Math.pow(2, n - curN) + 1;
        int to = from + (int) Math.pow(2, n - curN - 1);

        if (k >= from && k < to) { // down left
            return kthGrammar(n, k, curN + 1, curK * 2 - 1, curEl == 0 ? 0 : 1);
        } else { // down right
            return kthGrammar(n, k, curN + 1, curK * 2, curEl == 0 ? 1 : 0);
        }
    }

//    public int depthFirstSearch(int n, int k, int rootVal) {
//        if (n == 1) {
//            return rootVal;
//        }
//
//        int totalNodes = (int) Math.pow(2, n - 1);
//
//        // Target node will be present in the right half sub-tree of the current root node.
//        if (k > (totalNodes / 2)) {
//            int nextRootVal = (rootVal == 0) ? 1 : 0;
//            return depthFirstSearch(n - 1, k - (totalNodes / 2), nextRootVal);
//        }
//        // Otherwise, the target node is in the left sub-tree of the current root node.
//        else {
//            int nextRootVal = (rootVal == 0) ? 0 : 1;
//            return depthFirstSearch(n - 1, k, nextRootVal);
//        }
//    }
//
//    public int kthGrammar(int n, int k) {
//        return depthFirstSearch(n, k, 0);
//    }

}
