package com.mygaienko.common.algorithms.leetcode.ternary_expression_parser;

public class Solution {

    public String parseTernary(String expression) {
        var wantedQ = 0;
        var wantedS = 0;

        var currQ = 0;
        var currS = 0;
        for (int i = 0; i < expression.length(); i++) {
            var nextCh = expression.charAt(i);
            if ((i + 1 == expression.length() || expression.charAt(i + 1) != '?') && (wantedQ == currQ && wantedS == currS)) {
                return String.valueOf(nextCh);
            }

            if (nextCh == 'T' && expression.charAt(i + 1) == '?' && (wantedQ == currQ && wantedS == currS)) {
                wantedQ++;
            } else if (nextCh == 'F' && expression.charAt(i + 1) == '?' && (wantedQ == currQ && wantedS == currS)) {
                wantedQ++;
                wantedS++;
            } else if (nextCh == '?') {
                currQ++;
            } else if (nextCh == ':') {
                currS++;
            }

        }
        return "";
    }
}
