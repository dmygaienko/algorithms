package com.mygaienko.common.algorithms.leetcode.word_abbreviation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {

    public List<String> wordsAbbreviation(List<String> words) {
        var result = new String[words.size()];
        var groups = new HashMap<String, List<IndexWord>>();
        for (int i = 0; i < words.size(); i++) {
            var word = words.get(i);
            var abbreviation = abbreviate(word, 1);
            groups.computeIfAbsent(abbreviation, v -> new ArrayList<>()).add(new IndexWord(word, i));
        }

        for (var entry : groups.entrySet()) {
            if (entry.getValue().size() == 1) {
                var indexWord = entry.getValue().get(0);
                result[indexWord.index] = entry.getKey();
            } else {
                var root = new Trie();
                for (var indexWord : entry.getValue()) {
                    var curr = root;
                    for (var ch : indexWord.word.substring(1).toCharArray()) {
                        if (curr.nodes[ch - 'a'] == null) {
                            curr.nodes[ch - 'a'] = new Trie();
                        }
                        curr = curr.nodes[ch - 'a'];
                        curr.count++;
                    }
                }

                for (var indexWord : entry.getValue()) {
                    int i = 0;
                    var curr = root;
                    for (var ch : indexWord.word.substring(1).toCharArray()) {
                        if (curr.count == 1) break;
                        curr = curr.nodes[ch - 'a'];
                        i++;
                    }
                    var abbreviation = abbreviate(indexWord.word, i + 1);
                    result[indexWord.index] = indexWord.word.length() == abbreviation.length() ? indexWord.word : abbreviation;
                }
            }
        }
        return Arrays.asList(result);
    }

    private String abbreviate(String word, int i) {
        var abbreviationLength = word.length() - i - 1;
        if (word.length() < 4 || abbreviationLength == 0) {
            return word;
        }
        return word.substring(0, i) + abbreviationLength + word.substring(word.length() - 1);
    }

    class IndexWord {
        String word;
        int index;

        public IndexWord(String word, int index) {
            this.word = word;
            this.index = index;
        }
    }

    class Trie {
        Trie[] nodes = new Trie[26];
        int count = 0;
    }


}