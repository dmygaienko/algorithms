package com.mygaienko.common.algorithms.leetcode.fraction_to_recurring_decimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        String result;
        if (numerator <= 0 && denominator < 0) {
            result = posFractionToDecimal(Math.abs((long) numerator), Math.abs((long) denominator));
        } else if (numerator >= 0 && denominator >= 0) {
            result = posFractionToDecimal(numerator, denominator);
        } else {
            result = "-" + posFractionToDecimal(Math.abs((long) numerator), Math.abs((long) denominator));;
        }
        return result;
    }

    public String posFractionToDecimal(long numerator, long denominator) {
        if (numerator == 0) return "0";

        List<String> sb = new ArrayList<>();

        HashMap<Long, Integer> remainsToDigit = new HashMap<>();

        boolean pointInitialised = false;
        int i = 0;
        long remain = numerator;

        while (remain != 0) {
            while (remain < denominator) {
                if (i == 0) {
                    remainsToDigit.put(remain, i + 1);
                }

                remain *= 10;

                if (!pointInitialised && i == 0) {
                    sb.add("0.");
                    pointInitialised = true;
                    i++;
                } else if (!pointInitialised) {
                    sb.set(i-1, sb.get(i-1) + ".");
                    pointInitialised = true;
                } else {
                    sb.add("0");
                    i++;
                }
            }

            long fullPart = remain/denominator;
            remain = (remain % denominator);

            if (remainsToDigit.containsKey(remain)) {
                int groupStart = remainsToDigit.get(remain);
                sb.add(String.valueOf(fullPart));

                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < sb.size(); j++) {
                    if (j == groupStart) stringBuilder.append("(");
                    String next = sb.get(j);
                    stringBuilder.append(next);
                }
                stringBuilder.append(")");
                return stringBuilder.toString();
            } else {
                sb.add(String.valueOf(fullPart));
                remainsToDigit.put(remain, i + 1);
            }

            if (pointInitialised) {
                remain *= 10;
            }
            ++i;
        }


        return String.join("", sb);
    }

}
