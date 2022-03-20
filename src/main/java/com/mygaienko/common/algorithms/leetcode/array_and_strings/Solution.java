package com.mygaienko.common.algorithms.leetcode.array_and_strings;

import java.util.Map;

import static java.lang.String.valueOf;

/**
 *      123
 *      456
 * --------
 *   543210
 * --------
 *      738
 *     615
 *    492
 * --------
 *    56088
 */
class Solution {

    public static final char DEFAULT = '\u0000';
    private final Map<Character, Map<Character, String>> multiplyMap = initMultipleMap();
    private final Map<Character, Map<Character, String>> sumMap = initSumMap();

    public String multiply(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        char[] num1Ch = num1.toCharArray();
        char[] num2Ch = num2.toCharArray();

        char[] ranks = new char[num1.length() + num2.length()];

        for (int i = 0; i < num2Ch.length; i++) {
            for (int j = 0; j < num1Ch.length; j++) {

                char multiplier1 = num1Ch[num1Ch.length - j - 1];
                char multiplier2 = num2Ch[num2Ch.length - i - 1];

                String product = multiplyMap.get(multiplier1).get(multiplier2);
                int rank = i + j;

                applyRank(product, ranks, rank);
            }
        }

        return stripZero(toString(ranks));
    }

    private String stripZero(String value) {
        boolean strip = true;
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (c == '0' && strip && i < chars.length - 1) {
                continue;
            } else {
                strip = false;
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    private void applyRank(String product, char[] ranks, int rank) {
        if (product.length() > 1) {
            String currentSum = sum(ranks[rank], product.charAt(1));
            if (currentSum.length() > 1) {
                ranks[rank] = currentSum.charAt(1);
                applyRank(valueOf(currentSum.charAt(0)), ranks, rank + 1);
            } else {
                ranks[rank] = currentSum.charAt(0);
            }
            applyRank(valueOf(product.charAt(0)), ranks, rank + 1);

        } else {
            String currentSum = sum(ranks[rank], product.charAt(0));

            if (currentSum.length() > 1) {
                ranks[rank] = currentSum.charAt(1);
                applyRank(valueOf(currentSum.charAt(0)), ranks, rank + 1);
            } else {
                ranks[rank] = currentSum.charAt(0);
            }
        }
    }

    private String sum(char ch1, char ch2) {
        return sumMap.get(ch1 == DEFAULT ? '0' : ch1).get(ch2);
    }

    private String toString(char[] ranks) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = ranks.length - 1; i >= 0 ; i--) {
            char value = ranks[i];
            if (value != DEFAULT) {
                stringBuilder.append(value);
            }
        }
        return stringBuilder.toString();
    }

    private Map<Character, Map<Character, String>> initMultipleMap() {
        return Map.of('1',
                Map.of(
                        '1' , "1",
                        '2' , "2",
                        '3' , "3",
                        '4' , "4",
                        '5' , "5",
                        '6' , "6",
                        '7' , "7",
                        '8' , "8",
                        '9' , "9",
                        '0' , "0"
                        ),
                '2',
                Map.of(
                        '1' , "2",
                        '2' , "4",
                        '3' , "6",
                        '4' , "8",
                        '5' , "10",
                        '6' , "12",
                        '7' , "14",
                        '8' , "16",
                        '9' , "18",
                        '0' , "0"
                ),
                '3',
                Map.of(
                        '1' , "3",
                        '2' , "6",
                        '3' , "9",
                        '4' , "12",
                        '5' , "15",
                        '6' , "18",
                        '7' , "21",
                        '8' , "24",
                        '9' , "27",
                        '0' , "0"
                ),
                '4',
                Map.of(
                        '1' , "4",
                        '2' , "8",
                        '3' , "12",
                        '4' , "16",
                        '5' , "20",
                        '6' , "24",
                        '7' , "28",
                        '8' , "32",
                        '9' , "36",
                        '0' , "0"
                ),
                '5',
                Map.of(
                        '1' , "5",
                        '2' , "10",
                        '3' , "15",
                        '4' , "20",
                        '5' , "25",
                        '6' , "30",
                        '7' , "35",
                        '8' , "40",
                        '9' , "45",
                        '0' , "0"
                ),
                '6',
                Map.of(
                        '1' , "6",
                        '2' , "12",
                        '3' , "18",
                        '4' , "24",
                        '5' , "30",
                        '6' , "36",
                        '7' , "42",
                        '8' , "48",
                        '9' , "54",
                        '0' , "0"
                ),
                '7',
                Map.of(
                        '1' , "7",
                        '2' , "14",
                        '3' , "21",
                        '4' , "28",
                        '5' , "35",
                        '6' , "42",
                        '7' , "49",
                        '8' , "56",
                        '9' , "63",
                        '0' , "0"
                ),
                '8',
                Map.of(
                        '1' , "8",
                        '2' , "16",
                        '3' , "24",
                        '4' , "32",
                        '5' , "40",
                        '6' , "48",
                        '7' , "56",
                        '8' , "64",
                        '9' , "72",
                        '0' , "0"
                ),
                '9',
                Map.of(
                        '1' , "9",
                        '2' , "18",
                        '3' , "27",
                        '4' , "36",
                        '5' , "45",
                        '6' , "54",
                        '7' , "63",
                        '8' , "72",
                        '9' , "81",
                        '0' , "0"
                ),
                '0',
                Map.of(
                        '1' , "0",
                        '2' , "0",
                        '3' , "0",
                        '4' , "0",
                        '5' , "0",
                        '6' , "0",
                        '7' , "0",
                        '8' , "0",
                        '9' , "0",
                        '0' , "0"
                )
        );
    }

    private Map<Character, Map<Character, String>> initSumMap() {
        return Map.of('1',
                Map.of(
                        '1' , "2",
                        '2' , "3",
                        '3' , "4",
                        '4' , "5",
                        '5' , "6",
                        '6' , "7",
                        '7' , "8",
                        '8' , "9",
                        '9' , "10",
                        '0' , "1"
                ),
                '2',
                Map.of(
                        '1' , "3",
                        '2' , "4",
                        '3' , "5",
                        '4' , "6",
                        '5' , "7",
                        '6' , "8",
                        '7' , "9",
                        '8' , "10",
                        '9' , "11",
                        '0' , "2"
                ),
                '3',
                Map.of(
                        '1' , "4",
                        '2' , "5",
                        '3' , "6",
                        '4' , "7",
                        '5' , "8",
                        '6' , "9",
                        '7' , "10",
                        '8' , "11",
                        '9' , "12",
                        '0' , "3"
                ),
                '4',
                Map.of(
                        '1' , "5",
                        '2' , "6",
                        '3' , "7",
                        '4' , "8",
                        '5' , "9",
                        '6' , "10",
                        '7' , "11",
                        '8' , "12",
                        '9' , "13",
                        '0' , "4"
                ),
                '5',
                Map.of(
                        '1' , "6",
                        '2' , "7",
                        '3' , "8",
                        '4' , "9",
                        '5' , "10",
                        '6' , "11",
                        '7' , "12",
                        '8' , "13",
                        '9' , "14",
                        '0' , "5"
                ),
                '6',
                Map.of(
                        '1' , "7",
                        '2' , "8",
                        '3' , "9",
                        '4' , "10",
                        '5' , "11",
                        '6' , "12",
                        '7' , "13",
                        '8' , "14",
                        '9' , "15",
                        '0' , "6"
                ),
                '7',
                Map.of(
                        '1' , "8",
                        '2' , "9",
                        '3' , "10",
                        '4' , "11",
                        '5' , "12",
                        '6' , "13",
                        '7' , "14",
                        '8' , "15",
                        '9' , "16",
                        '0' , "7"
                ),
                '8',
                Map.of(
                        '1' , "9",
                        '2' , "10",
                        '3' , "11",
                        '4' , "12",
                        '5' , "13",
                        '6' , "14",
                        '7' , "15",
                        '8' , "16",
                        '9' , "17",
                        '0' , "08"
                ),
                '9',
                Map.of(
                        '1' , "10",
                        '2' , "11",
                        '3' , "12",
                        '4' , "13",
                        '5' , "14",
                        '6' , "15",
                        '7' , "16",
                        '8' , "17",
                        '9' , "18",
                        '0' , "9"
                ),
                '0',
                Map.of(
                        '1' , "1",
                        '2' , "2",
                        '3' , "3",
                        '4' , "4",
                        '5' , "5",
                        '6' , "6",
                        '7' , "7",
                        '8' , "8",
                        '9' , "9",
                        '0' , "0"
                )
        );
    }
}
