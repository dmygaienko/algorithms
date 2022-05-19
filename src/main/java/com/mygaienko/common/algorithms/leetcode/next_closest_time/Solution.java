package com.mygaienko.common.algorithms.leetcode.next_closest_time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    public static final int HOURS = 24;
    public static final int MINS = 60;
    public static final int MINS_IN_DAY = HOURS * MINS;

    public String nextClosestTime(String time) {
        char[] timeArray = time.toCharArray();

        List<char[]> times = generateTimes(timeArray);

        char[] closest = null;
        long closestMinDiff = Long.MAX_VALUE;
        for (char[] chars : times) {
            int minDiff = calcDiff(timeArray, chars);
            if (minDiff < closestMinDiff) {
                closestMinDiff = minDiff;
                closest = chars;
            }
        }

        return closest == null ? "" : String.valueOf(closest);
    }

    private int calcDiff(char[] timeArray, char[] closestArray) {
        int timeMin = toMin(timeArray);
        int closestMin = toMin(closestArray);
        return timeMin < closestMin
                ? closestMin - timeMin
                : MINS_IN_DAY - (timeMin - closestMin);
    }

    private int toMin(char[] timeArray) {
        return toInt(timeArray[0]) * 10 * MINS +
                toInt(timeArray[1]) * MINS +
                toInt(timeArray[3]) * 10 +
                toInt(timeArray[4]);
    }

    private int toInt(char ch) {
        return ch - '0';
    }

    private List<char[]> generateTimes(char[] timeArray) {
        return generateTimes(timeArray, Arrays.copyOf(timeArray, timeArray.length),  0);
    }

    private List<char[]> generateTimes(char[] initialTimeArray, char[] timeArray, int i) {
        List<char[]> result = new ArrayList<>();

        if (i == 2) { // no multiplying for ':' char
            result.addAll(generateTimes(initialTimeArray, timeArray, i + 1));
        } else {

            for (int j = 0; j < initialTimeArray.length; j++) {
                if (j == 2) continue; // skip ':' char

                char nextCh = initialTimeArray[j];

                char[] copied = Arrays.copyOf(timeArray, timeArray.length);
                copied[i] = nextCh;

                if (i == 1) {   // hours validation
                    int hours = toInt(copied[0]) * 10 + toInt(copied[1]);
                    if (hours > 23) continue; // empty
                }

                if (i == 4) {  // minutes validation
                    int mins = toInt(copied[3]) * 10 + toInt(copied[4]);
                    if (mins > 59) continue; // empty
                }

                if (i < timeArray.length - 1) {
                    result.addAll(generateTimes(initialTimeArray, copied, i + 1));
                } else {
                    result.add(copied);
                }
            }

        }

        return result;
    }

}
