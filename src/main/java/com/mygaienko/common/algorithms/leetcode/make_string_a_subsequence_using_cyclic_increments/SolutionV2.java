package com.mygaienko.common.algorithms.leetcode.make_string_a_subsequence_using_cyclic_increments;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class SolutionV2 {

    public boolean canMakeSubsequence(String str1, String str2) {
        var charOccurences = new List[26];
        for (int i = 0; i < charOccurences.length; i++) {
            charOccurences[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < str1.length(); i++) {
            var next = str1.charAt(i);
            charOccurences[next - 'a'].add(i);
        }

        var queue = new ArrayDeque<int[]>();
        var firstChar = str2.charAt(0);
        var nextChar = cycl(firstChar);
        for (var index : charOccurences[firstChar - 'a']) {
            queue.offer(new int[]{(int) index, 0});
        }

        for (var index : charOccurences[nextChar - 'a']) {
            queue.offer(new int[]{(int) index, 0});
        }

        while (!queue.isEmpty()) {
            var next = queue.poll();
            var str1Index = next[0];
            var str2Index = next[1];

            if (str2Index + 1 == str2.length()) return true;

            var nextCh = str2.charAt(str2Index + 1);
            var nextChIndex = getOccurencesIndex(charOccurences, nextCh, str1Index);
            for (int i = nextChIndex; i < charOccurences[nextCh - 'a'].size(); i++) {
                var index = charOccurences[nextCh - 'a'].get(i);
                queue.offer(new int[]{(int) index, str2Index + 1});
            }

            var cyclChar = cycl(nextCh);
            var cyclCharIndex = getOccurencesIndex(charOccurences, cyclChar, str1Index);
            for (int i = cyclCharIndex; i < charOccurences[cyclChar - 'a'].size(); i++) {
                var index = charOccurences[cyclChar - 'a'].get(i);
                queue.offer(new int[]{(int) index, str2Index + 1});
            }
        }

        return false;
    }

    private char cycl(char ch) {
        var index = ch - 'a';
        if (index == 0) return 'z';
        return (char) (index - 1 + 'a');
    }

    int getOccurencesIndex(List[] charOccurences, char ch, int str1Index) {
        var result = Integer.MAX_VALUE;
        var nextIndex = str1Index + 1;

        var index = ch - 'a';
        var list = charOccurences[index];
        if (list.isEmpty()) return result;

        var left = 0;
        var right = list.size() - 1;

        while (left <= right) {
            var mid = left + (right - left) / 2;
            var val = (int) list.get(mid);

            if (val == nextIndex) {
                return mid;
            } else if (val < nextIndex) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = mid;
            }
        }

        return result;
    }

}