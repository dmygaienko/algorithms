package com.mygaienko.common.algorithms.leetcode.count_words_obtained_after_adding_a_letter;

import java.util.*;

class SolutionV2 {

    // Solution 1 (N*M)
    // put targetWords to map with length as key and list of sets(of target chars) as value - N
    // for each startWord get list by length + 1 key and verify whether set contains all startWord chars. N*M
    //
    // Solution 2 (N^3)
    // for each startWord (N) iterate over targetWords ()N) and compare chars (N).
    public int wordCount(String[] startWords, String[] targetWords) {
        var lengthToWords = new HashMap<Integer, List<Set<Character>>>();
        for (var t : targetWords) {
            HashSet<Character> charSet = new HashSet<>();
            for (char c : t.toCharArray()) {
                charSet.add(c);
            }

            lengthToWords.computeIfAbsent(t.length(), v -> new ArrayList<>()).add(charSet);
        }

        int count = 0;
        for (var s : startWords) {
            var targets = lengthToWords.get(s.length() + 1);
            if (targets == null) continue;
            var iterator = targets.iterator();
            while (iterator.hasNext()) {
                var targetCharSet = iterator.next();

                boolean found = true;
                for (char c : s.toCharArray()) {
                    if (!targetCharSet.contains(c)) {
                        found = false;
                        break;
                    }
                }

                if (found) {
                    iterator.remove();
                    count++;
                }

            }
        }
        return count;
    }

}
