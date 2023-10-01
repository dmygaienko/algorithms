package com.mygaienko.common.algorithms.leetcode.reorganize_string;

import java.util.LinkedList;

class Solution {

    // iterate over characters with two points
    // find same chars
    // try to find new position before current index
    // try to find new position after current index
    // if not find new position return ""
    public String reorganizeString(String s) {
        Character prev = null;
        Character curr = null;
        LinkedList<Character> reorganized = new LinkedList<>();
        LinkedList<Character> bench = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (prev == null) {
                prev = s.charAt(i);
                reorganized.add(prev);
                continue;
            } else {
                curr = s.charAt(i);
            }

            if (prev == curr) {
                findPlace(reorganized, i, curr, bench);
            } else {
                reorganized.add(curr);
            }

            if (!bench.isEmpty() && bench.peek() != curr) {
                var fromBench = bench.pop();
                reorganized.add(fromBench);
                curr = fromBench;
            }

            prev = curr;
        }
        var sb = new StringBuilder();
        reorganized.forEach(sb::append);
        return bench.isEmpty() ? sb.toString() : "";
    }

    private void findPlace(LinkedList<Character> reorganized, int index, char ch,
                           LinkedList<Character> bench) {
        if (reorganized.get(0) != ch) {
            reorganized.addFirst(ch);
        } else {
            bench.push(ch);
        }
    }

}