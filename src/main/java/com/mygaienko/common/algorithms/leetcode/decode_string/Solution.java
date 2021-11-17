package com.mygaienko.common.algorithms.leetcode.decode_string;

public class Solution {

    /**
     * 3[a2[c]]
     * accaccacc
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
       return decode(s);
    }

    private String decode(String s) {
        return decode(s, 0).value;
    }

    private Result decode(String s, int i) {
        if (i >= s.length()) {
            return new Result("", i);
        }

        char aChar = s.charAt(i);

        if (Character.isDigit(aChar)) {

            int j = getDigitLastInd(s, i);

            int numeric = Integer.valueOf(s.substring(i, j));
            StringBuilder sb = new StringBuilder();
            Result decoded = decode(s, j);
            for (int m = 0; m < numeric; m++) {
                sb.append(decoded.value);
            }
            Result nextDecode = decode(s, decoded.i);
            return new Result(sb.toString() + nextDecode.value, nextDecode.i);
        } else if (aChar == '[') {
            return decode(s, i+1);
        } else if (aChar == ']')
            return new Result("", i + 1);
        else {
            Result result = decode(s, i + 1);
            return new Result(aChar + result.value, result.i);
        }
    }

    private static class Result {
        String value;
        int i;

        public Result(String value, int i) {
            this.value = value;
            this.i = i;
        }
    }


    private int getDigitLastInd(String s, int i) {
        int j = i+1;
        for (; j < s.length(); j++) {
            char nextChar = s.charAt(j);
            if (!Character.isDigit(nextChar)) {
                break;
            }
        }
        return j;
    }

}
