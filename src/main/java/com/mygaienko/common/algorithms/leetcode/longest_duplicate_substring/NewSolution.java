package com.mygaienko.common.algorithms.leetcode.longest_duplicate_substring;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Liuda's solution
 */
public class NewSolution {
    private static final Integer ALREADY_ADDED = -1;


    public String longestDupSubstring(String s) {
        return getResult(s);
    }


    public String getResult(String originString) {
        char[] chars = originString.toCharArray();
        List<Position> positions = IntStream.range(0, chars.length)
                .mapToObj(i -> new Position(i, chars[i], 0, originString))
                .collect(Collectors.toList());

        return calculate(positions);
    }

    private String calculate(List<Position> positions) {
        while (true) {
            List<Position> result = getPositionWithDuplicates(positions);
            if (!result.isEmpty()) {
                positions = result;

            } else {
                return getResult(positions);
            }
        }
    }

    private String getResult(List<Position> result) {
        if (result.isEmpty()) {
            return "";
        }
        return result.get(0).toString();

    }


    private List<Position> getPositionWithDuplicates(List<Position> positions) {
        Map<Position, Integer> distinct = new HashMap<>();
        List<Position> result = new ArrayList<>();
        for (Position position : positions) {
            Position extended = position.extend();
            if (extended != null) {

                Integer duplicateStartPosition = distinct.get(extended);
                if (duplicateStartPosition != null) {
                    result.add(extended);
                    if (duplicateStartPosition >= 0) {
                        result.add(extended.ofStartPosition(duplicateStartPosition));
                        distinct.put(extended, ALREADY_ADDED);
                    }
                } else {
                    distinct.put(extended, extended.startPosition);
                }
            }
        }
        return result;
    }


    private class Position {
        private int startPosition;
        private int hashCode;
        private int length;
        private String originString;

        Position(int startPosition, int hashCode, int length, String originString) {
            this.hashCode = hashCode;
            this.startPosition = startPosition;
            this.length = length;
            this.originString = originString;
        }


        Position extend() {
            if (startPosition + length >= originString.length()) {
                return null;
            }
            char c = originString.charAt(startPosition + length);
            int newHashCode = hashCode * 31 + c;
            return new Position(startPosition, newHashCode, length + 1, originString);
        }

        Position ofStartPosition(int startPosition) {
            return new Position(startPosition, hashCode, length, originString);
        }


        @Override
        public boolean equals(Object o) {
            return this.hashCode == ((Position)o).hashCode;
        }

        @Override
        public int hashCode() {
            return hashCode;
        }

        public String toString() {
            if (length == 0) {
                return "";
            }
            return originString.substring(startPosition, startPosition + length);
        }
    }


}
