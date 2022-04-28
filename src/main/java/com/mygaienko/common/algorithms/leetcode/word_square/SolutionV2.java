package com.mygaienko.common.algorithms.leetcode.word_square;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionV2 {

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) return result;
        int size = words[0].length();
        if (size == 1) {
            Arrays.stream(words).forEach(s -> result.add(List.of(s)));
            return result;
        }
        return wordSquares(words, new ArrayList<>(), 0, size);
    }

    private List<List<String>> wordSquares(String[] words, List<Integer> current, int i, int size) {
        List<List<String>> squares = new ArrayList<>();
        if (i == 0) {
            for (int l = 0; l < words.length; l++) {
                List<List<String>> lists = wordSquares(words, List.of(l), i + 1, size);
                if (!lists.isEmpty()) {
                    squares.addAll(lists);
                }
            }
        } else if (i > 0 && i < size) {
            String firstWord = words[current.iterator().next()];
            char iChar = firstWord.charAt(i);
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                if (iChar != word.charAt(0)) continue;
                List<Integer> ids = new ArrayList<>(current);
                ids.add(j);
                if (!isSquare(words, ids)) continue;
                List<List<String>> lists = wordSquares(words, ids, i + 1, size);
                if (!lists.isEmpty()) {
                    squares.addAll(lists);
                }
            }
        } else if (i == size) {
            List<String> square = getSquare(words, current);
            if (!square.isEmpty()) {
                squares.add(square);
            }
        }
        return squares;
    }

    public List<String> getSquare(String[] words, List<Integer> ids) {
        List<String> strings = new ArrayList<>();
        if (isSquare(words,ids)) {
            for (Integer id : ids) {
                strings.add(words[id]);
            }
            return strings;
        }
        return strings;
    }

    private boolean isSquare(String[] words, List<Integer> ids) {
        for (int i = 0; i < ids.size() - 1; i++) { // last char is common
            String nextHorizontalWord = words[ids.get(i)];
            char lastHorizontalChar = nextHorizontalWord.charAt(ids.size()-1);

            String lastHorizontalWord = words[ids.get(ids.size()-1)];
            char nextHorizontalChar = lastHorizontalWord.charAt(i);
            if (lastHorizontalChar != nextHorizontalChar) return false;
        }
        return true;
    }

}
