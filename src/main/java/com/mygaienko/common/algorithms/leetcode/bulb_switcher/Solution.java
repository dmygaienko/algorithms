package com.mygaienko.common.algorithms.leetcode.bulb_switcher;

class Solution {

    // 1 1 1 1 1
    // 0 1 1 1 1
    // 1 0 1 1 1
    // 0 1 0 1 1
    // 1 0 1 0 1
    // 1 0 1 0 0
    public int bulbSwitch(int n) {
        int result = n;
        for (int i = 2; i <= n - 1; i++) {
            result -= n / i;
        }
        return result - 1;
    }

}