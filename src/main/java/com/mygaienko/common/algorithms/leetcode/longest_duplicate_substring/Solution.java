package com.mygaienko.common.algorithms.leetcode.longest_duplicate_substring;


import java.util.*;

/**
 * https://leetcode.com/problems/longest-duplicate-substring/
 */
public class Solution {

    private static final int NOT_FOUND = -1;
    private static final int B = 29;
    private static final int Q = 10_000_019;

    public String longestDupSubstring(String s) {

        int left = 1;
        int right = s.length() - 1;
        int subSize = 0;
        int subPos = NOT_FOUND;

        // binary search of sub string
        while (left <= right) {
            int midSize = left + (right - left)/2;

            int nextPos = isDubExist(s, midSize);
            if (nextPos == NOT_FOUND) {
                right = midSize - 1;
            } else {
                subSize = midSize;
                subPos = nextPos;
                left = midSize + 1;
            }
        }

        return subPos == NOT_FOUND ? "" : s.substring(subPos, subPos + subSize);
    }

    public int isDubExist(String s, int size) {
        int pos = NOT_FOUND;

        int start = 0;

        Map<Integer, List<Integer>> hashToPositions = new HashMap<>();

        int hashCode = hashCode(s, start, start + size);
        hashToPositions.put(hashCode, listWithValue(start));

        int firstLetterCoeff = 1;
        for (int i = size - 1; i > 0; --i) {
            firstLetterCoeff = (firstLetterCoeff*B) % Q;
        }

        for (int i = start + 1; i + size <= s.length(); i++) {
            hashCode = rollHashCode(s, hashCode, i, i + size - 1, firstLetterCoeff);

            List<Integer> prevPositions = hashToPositions.putIfAbsent(hashCode, listWithValue(i));

            boolean found = false;
            if (prevPositions != null) {
                found = foundDuplicates(s, size, i, prevPositions);
                prevPositions.add(i);
            }

            if (found) {
                return i;
            }

        }

        return pos;
    }

    private boolean foundDuplicates(String s, int size, int i, List<Integer> positions) {
        for (Integer position : positions) {
            if (compareSubstrings(s, size, i, position)) {
                return true;
            }
        }
        return false;
    }

    private Boolean compareSubstrings(String s, int size, int i, Integer position) {
        for (int i1 = i, i2 = position; i1 < i + size && i2 < position + size; i1++, i2++) {
            if (s.charAt(i1) != s.charAt(i2)) {
                return false;
            }
        }
        return true;
    }

    private List<Integer> listWithValue(int hashCode) {
        List<Integer> integers = new ArrayList<>();
        integers.add(hashCode);
        return integers;
    }

    private int hashCode(String s, int start, int end) {
        int h = 0;
        for (int i = start; i < end; i++) {
            int charCode = getChar(s, i);
            h = (h * B + charCode) % Q;
        }
        return h;
    }

    private int rollHashCode(String s, int prevHash, int start, int end, int multiplier) {
        int hashCode = prevHash;

        // Ensure non-negative hash by adding the modulus
        hashCode += Q;

        // Remove hash of previous first character
        hashCode -= (multiplier * getChar(s, start - 1)) % Q;
        hashCode *= B;

        // Add hash of new last character
        hashCode += getChar(s, end);
        hashCode %= Q;

        return hashCode;
    }

    private int getChar(String s, int i) {
        return s.charAt(i) - 'a';
    }

}
