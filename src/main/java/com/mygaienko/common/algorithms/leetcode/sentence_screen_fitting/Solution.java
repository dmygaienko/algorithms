package com.mygaienko.common.algorithms.leetcode.sentence_screen_fitting;

import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int wordsTyping(String[] sentence, int rows, int cols) {
        int times = 0;
        int i = 0;

        int curRow = 0;
        int curColumn = 0;

        int[][] memo = new int[cols][2];
        int startRow = curRow;
        int startColumn = curColumn;

        int memoSize = 0;
        while (curRow < rows) {
            if (i == 0 && curColumn < cols && (memo[curColumn][0] != 0 || memo[curColumn][1] != 0)) {
                int row = memo[curColumn][0];
                int column = memo[curColumn][1];

                curRow += row;
                curColumn = column;
                if (curRow < rows) {
                    times++;
                }
            } else if (i == sentence.length) {
                int diffRow = curRow - startRow;
                memo[startColumn] = new int[] {diffRow, curColumn};
                startRow = curRow;
                startColumn = curColumn;
                times++;
                i = 0;

                memoSize++;
                if (curColumn + sentence[i].length() >= cols && rows % (curRow + 1) == 0) return (rows / (curRow + 1)) * memoSize;
            } else if (curColumn == 0 && sentence[i].length() <= cols) {
                curColumn += sentence[i].length();
                i++;
            } else if (curColumn + sentence[i].length() < cols) {
                curColumn += sentence[i].length() + 1;
                i++;
            } else {
                curColumn = 0;
                curRow++;
            }
        }
        return times;
    }
}
