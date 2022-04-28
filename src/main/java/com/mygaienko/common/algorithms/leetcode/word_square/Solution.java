package com.mygaienko.common.algorithms.leetcode.word_square;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) return result;
        int size = words[0].length();
        if (size == 1) {
            Arrays.stream(words).forEach(s -> result.add(List.of(s)));
            return result;
        }

        Trie root = initTrie(words);

        return wordSquares(words, root, new ArrayDeque<>(), 0, size);
    }

    private List<List<String>> wordSquares(String[] words, Trie root, ArrayDeque<String> currentSquare, int i, int size) {
        List<List<String>> squares = new ArrayList<>();
        if (i == 0) {
            for (String nextString : words) {
                List<List<String>> lists = wordSquares(words, root, new ArrayDeque<>(List.of(nextString)), i + 1, size);
                if (!lists.isEmpty()) {
                    squares.addAll(lists);
                }
            }
        } else if (i < size){
            String pref = getPrefix(currentSquare, i);
            List<String> samePrefixStrings = root.get(pref);
            for (String samePrefix : samePrefixStrings) {
                currentSquare.addLast(samePrefix);
                List<List<String>> lists = wordSquares(words, root, currentSquare, i + 1, size);
                if (!lists.isEmpty()) {
                    squares.addAll(lists);
                }
                currentSquare.removeLast();
            }
        } else {
            squares.add(new ArrayList<>(currentSquare));
        }
        return squares;
    }

    private String getPrefix(ArrayDeque<String> currentSquare, int i) {
        StringBuilder sb = new StringBuilder();
        for (String s : currentSquare) {
            char lastChar = s.charAt(i);
            sb.append(lastChar);
        }
        return sb.toString();
    }

    private Trie initTrie(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            root.add(word);
        }
        return root;
    }

}

class Trie {

    List<String> words = new ArrayList<>();

    Map<Character, Trie> chars = new HashMap<>();

    public void add(String word) {
        add(word, 0);
    }

    private void add(String word, int i) {
        if (i < word.length()) {
            char nextChar = word.charAt(i);
            Trie trie = chars.computeIfAbsent(nextChar, v -> new Trie());
            trie.add(word, i + 1);
            words.add(word);
        }
    }

    public List<String> get(String pref) {
        int i = 0;
        Trie trie = this;
        while (i < pref.length()) {
            char ch = pref.charAt(i);
            if (trie.chars.containsKey(ch)) {
                trie = trie.chars.get(ch);
                i++;
            } else {
                return List.of();
            }
        }
        return trie.words;
    }

}