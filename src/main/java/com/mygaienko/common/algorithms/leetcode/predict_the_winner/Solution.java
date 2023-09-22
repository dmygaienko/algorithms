package com.mygaienko.common.algorithms.leetcode.predict_the_winner;

/**
 * you have to write the recursion thinking of can u make Player1 win be it any possible way.
 * So in the course of doing so u might come across the idea that if it's player1 turn to pick
 * then he can go with either end element and will declared winner if he wins in any of it's choice (so OR).
 * If it's Player2 turn then Player1 can only win if player1 value is greater than that of player2
 * in any of the choices of Player2(so we need both true i.e &&).
 *
 * another intuition:
 *
 * int scoreByLeft = nums[left] - maxDiff(nums, left + 1, right, n);
 * int scoreByRight = nums[right] - maxDiff(nums, left, right - 1, n);
 */
public class Solution {

    public boolean predictTheWinner(int[] ints) {
        if (ints.length <= 1) return true;
        return isFirstAllWaysWinner(ints, true, 0, 0, 0, ints.length - 1);
    }

    private boolean isFirstAllWaysWinner(int[] ints, boolean first, int sumOne, int sumTwo, int s, int e) {
        if (s == e) {
            if (first) {
                return sumOne + ints[s] >= sumTwo;
            } else {
                return sumOne >= sumTwo + ints[s];
            }
        }

        if (first) {
            return isFirstAllWaysWinner(ints, !first, sumOne + ints[s], sumTwo, s + 1, e)
                    || isFirstAllWaysWinner(ints, !first, sumOne + ints[e], sumTwo, s, e - 1);
        } else {
            return isFirstAllWaysWinner(ints, !first, sumOne, sumTwo  + ints[s], s + 1, e)
                    && isFirstAllWaysWinner(ints, !first, sumOne, sumTwo + ints[e], s, e - 1);
        }
    }

}
