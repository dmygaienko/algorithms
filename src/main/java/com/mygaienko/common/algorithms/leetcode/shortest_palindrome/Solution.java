package com.mygaienko.common.algorithms.leetcode.shortest_palindrome;

public class Solution {

    public String shortestPalindrome(String s) {
        if (isPalindrome(s)) {
           return s;
        }

        String newString = s + "." + reverse(s);
        int[] ints = computeLpsArray(newString);
        int maxPrefixSize = ints[ints.length - 1];
        return reversedSuffix(s, s.length() - maxPrefixSize) + s;
    }

    static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }
        return true;
    }

    private String reversedSuffix(String str, int maximumPrefixLength) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= str.length() - maximumPrefixLength ; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    static String reverse(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0 ; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    /**
     * compute longest prefix suffix array for the pattern
     */
    static int[] computeLpsArray (String pattern) {
        int length = pattern.length();
        int[] lps = new int[length];


        int longestLength = 0; // length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // first element is always 0

        //loop calculates lps[i] from 1 to M-1
        while (i < length) {

            if (pattern.charAt(i) == pattern.charAt(longestLength)) {
                longestLength++;
                lps[i] = longestLength;
                i++;
            } else {
                if (longestLength == 0) {
                    lps[i] = 0;
                    i++;
                }  else {
                    longestLength = lps[longestLength-1];
                    //Consider the example. AAACAAAA and i = 7. The idea is similar
                    // to search step. if A != C, then let's check that last character of LPS is same as I
                }
            }
        }

        return lps;
    }

    static int kmpSearch(String txt, String pattern) {
        int N = txt.length();
        int M = pattern.length();

        int lps[] = computeLpsArray(pattern);

        int j = 0; // index for pattern
        int i = 0; // index for text

        while (i < N) {
            if (pattern.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }

            if (j == M) {
                //found pattern at index i - j
                return i - j;
//                j=lps[j-1];
            } else if (i < N  && pattern.charAt(j) != txt.charAt(i)) {
                // do not match lps[0..lps[j-1]] chars
                // they will match anyway

                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }

        return -1;
    }
}