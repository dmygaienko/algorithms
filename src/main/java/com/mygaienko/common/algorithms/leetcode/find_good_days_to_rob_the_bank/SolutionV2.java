package com.mygaienko.common.algorithms.leetcode.find_good_days_to_rob_the_bank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class SolutionV2 {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        var decrRanges = getDecrRanges(security, time);
        var incrRanges = getIncrRanges(security, time);

        var goodDays = new ArrayList();

        while (true) {
            if (decrRanges.isEmpty() || incrRanges.isEmpty()) {
                break;
            } else if (decrRanges.peek()[1] < incrRanges.peek()[0]) {
                decrRanges.poll();
            } else if (incrRanges.peek()[1] < decrRanges.peek()[0]) {
                incrRanges.poll();
            } else if (decrRanges.peek()[1] >= incrRanges.peek()[0]) {
                for (int i = Math.max(incrRanges.peek()[0], decrRanges.peek()[0]); i <= Math.min(incrRanges.peek()[1], decrRanges.peek()[1]); i++) {
                    goodDays.add(i);
                }

                if (decrRanges.peek()[1] <= incrRanges.peek()[1]) {
                    decrRanges.poll();
                } else {
                    incrRanges.poll();
                }
            }
        }

        return goodDays;
    }

    private static LinkedList<int[]> getIncrRanges(int[] security, int time) {
        int start = -1;
        var incrRanges = new LinkedList<int[]>();
        for (int i = 0; i < security.length; i++) {
            if (start == -1) {
                start = i;
            } else if (security[i - 1] > security[i]) {
                if (i - 1 + 1 - start >= time) {
                    incrRanges.offer(new int[]{start, i - 1 - time});
                }
                start = i;
            }
            if (i == security.length - 1 && i - 1 + 1 - start >= time) {
                incrRanges.offer(new int[]{start, i - time});
            }
        }
        return incrRanges;
    }

    private static LinkedList<int[]> getDecrRanges(int[] security, int time) {
        int start = -1;
        var decrRanges = new LinkedList<int[]>();
        for (int i = 0; i < security.length; i++) {
            if (start == -1) {
                start = i;
            } else if (security[i - 1] < security[i]) {
                if (i - 1 + 1 - start >= time) {
                    decrRanges.offer(new int[]{start + time, i - 1});
                }
                start = i;
            }
            if (i == security.length - 1 && i - 1 + 1 - start >= time) {
                decrRanges.offer(new int[]{start + time, i});
            }
        }
        return decrRanges;
    }
}