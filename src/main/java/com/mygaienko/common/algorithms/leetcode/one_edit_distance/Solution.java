package com.mygaienko.common.algorithms.leetcode.one_edit_distance;

class Solution {

    // iterating with two iterators
    // if length of s > than t we need to find char to delete
    // if length of s = t we need to find char to replace
    // if length of s < that t we need to find char to add

    // after reaching both ends of string return whether action is applied
    // if after edition chars are not the same return false
    public boolean isOneEditDistance(String s, String t) {
        var S = s.length();
        var T = t.length();

        if (Math.abs(T - S) > 1) return false;

        var sIndex = 0;
        var tIndex = 0;

        boolean edited = false;
        while (sIndex < S && tIndex < T) {
            var sChar = s.charAt(sIndex);
            var tChar = t.charAt(tIndex);

            if (sChar != tChar) {
                if (edited) {
                    return false;
                } else if (S > T) {
                    tIndex--; // delete S char, go to the next
                } else { // S < T
                    sIndex--; // delete T char, go to the next
                } // OR replace once

                edited = true;
            }

            sIndex++;
            tIndex++;
        }

        if (!edited) {
            if (sIndex == S && tIndex + 1 == T) return true;
            if (tIndex == T && sIndex + 1 == S) return true;
        }

        return edited;
    }
}