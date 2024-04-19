package com.mygaienko.common.algorithms.leetcode.design_compressed_string_iterator;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

class StringIterator {

    List<Pair<Character, Integer>> pairs = new ArrayList<>();

    int pairIndex = 0;
    int charIndex = 0;

    public StringIterator(String compressedString) {
        var nextCh = ' ';
        var nextCount = 0;
        for (var ch : compressedString.toCharArray()) {
            if (Character.isLetter(ch)) {
                if (nextCount > 0 && nextCh != ' ') {
                    pairs.add(Pair.of(nextCh, nextCount));
                    nextCount = 0;
                }
                nextCh = ch;
            } else {
                nextCount = nextCount * 10 + (ch - '0');
            }
        }
        if (nextCount > 0 && nextCh != ' ') {
            pairs.add(Pair.of(nextCh, nextCount));
        }
    }

    public char next() {
        if (pairIndex >= pairs.size()) return ' ';

        var pair = pairs.get(pairIndex);
        var result = pair.getKey();
        var count = pair.getValue();
        if (charIndex + 1 < count) {
            charIndex++;
        } else {
            pairIndex++;
            charIndex = 0;
        }
        return result;
    }

    public boolean hasNext() {
        return pairs.size() > pairIndex;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
