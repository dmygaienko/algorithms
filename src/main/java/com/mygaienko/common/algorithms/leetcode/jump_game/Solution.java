package com.mygaienko.common.algorithms.leetcode.jump_game;

class Solution {

    public boolean canJump(int[] nums) {
        int N = nums.length;

        if (N == 1) return true;

        int currentJump = 0;
        int i = 0;

        while (i < N) {
            int jump = nums[i];

            if (currentJump < jump) {
                currentJump = jump;
            }

            if (currentJump == 0 && jump == 0) {
                if (i == N - 1) {
                    return true;
                } else {
                    return false;
                }
            }

            currentJump--;
            i++;
        }

        return i >= N;
    }

}
