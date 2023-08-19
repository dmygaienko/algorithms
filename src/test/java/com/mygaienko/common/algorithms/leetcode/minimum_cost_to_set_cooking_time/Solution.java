package com.mygaienko.common.algorithms.leetcode.minimum_cost_to_set_cooking_time;

class Solution {

    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        int digit = startAt;
        int minCost = Integer.MAX_VALUE;

        //set target as normal minutes and seconds
        int minutes = targetSeconds / 60;
        int seconds = targetSeconds % 60;

        // set minutes
        int minutesDozens = minutes / 10;
        int minutesDigits = minutes % 10;
        int secondsDozens = seconds / 10;
        int secondsDigit = seconds % 10;

        if (minutesDozens < 10) {
            minCost = Math.min(minCost, cost(moveCost, pushCost, digit, minutesDozens, minutesDigits, secondsDozens, secondsDigit));
        }

        if (minutes > 0 && seconds <= 39) {
            minutes = (targetSeconds - 60) / 60;
            minutesDozens = minutes / 10;
            minutesDigits = minutes % 10;
            seconds += 60;
            secondsDozens = seconds / 10;
            secondsDigit = seconds % 10;
            minCost = Math.min(minCost, cost(moveCost, pushCost, digit, minutesDozens, minutesDigits, secondsDozens, secondsDigit));
        }
        return minCost;

    }

    public int cost(int moveCost, int pushCost, int digit,
                    int minutesDozens, int minutesDigits, int secondsDozens, int secondsDigit) {
        int cost = 0;

        //normilize
        if (minutesDozens == 0) {
            minutesDozens = -1;
            if (minutesDigits == 0) {
                minutesDigits = -1;
                if (secondsDozens == 0) {
                    secondsDozens = -1;
                }
            }
        }

        if (minutesDozens != -1) {
            if (digit != minutesDozens) {
                digit = minutesDozens;
                cost += moveCost;
            }
            cost += pushCost;
        }

        if (minutesDigits != -1) {
            if (digit != minutesDigits) {
                digit = minutesDigits;
                cost += moveCost;
            }
            cost += pushCost;
        }


        if (secondsDozens != -1) {
            if (digit != secondsDozens) {
                digit = secondsDozens;
                cost += moveCost;
            }
            cost += pushCost;
        }


        if (secondsDigit != -1) {
            if (digit != secondsDigit) {
                digit = secondsDigit;
                cost += moveCost;
            }
            cost += pushCost;
        }

        return cost;
    }

}
