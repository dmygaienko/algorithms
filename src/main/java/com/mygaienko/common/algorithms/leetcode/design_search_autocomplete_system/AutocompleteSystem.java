package com.mygaienko.common.algorithms.leetcode.design_search_autocomplete_system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class AutocompleteSystem {

    Trie root = new Trie();

    Trie curr = root;

    StringBuilder sb = new StringBuilder();

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            root.add(0, sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            root.add(0, sb.toString(), 1);
            curr = root;
            sb = new StringBuilder();
            return List.of();
        }

        sb.append(c);

        if (curr == null) {
            return List.of();
        }

        return curr.get(c);
    }

    class Trie {

        Map<Character, Trie> chars = new HashMap<>();
        Map<String, Integer> sentences = new HashMap<>();

        public void add(int index, String sentence, int count) {
            var curr = root;
            for (int i = index; i < sentence.length(); i++) {
                curr = curr.chars.computeIfAbsent(sentence.charAt(i), v -> new Trie());
                curr.sentences.compute(sentence, (k, v) -> v == null ? count : v + count);
            }
        }

        public List<String> get(char c) {
            curr = curr.chars.get(c);
            Set<String> sentences = new HashSet<>();
            if (curr != null) {
                sentences = curr.sentences.keySet();
            }
            Comparator<String> comparator = Comparator
                    .<String>comparingInt(s -> curr.sentences.get(s))
                    .thenComparing(Comparator.reverseOrder());
            var heap = new PriorityQueue<>(comparator);
            for (var sentence : sentences) {
                heap.add(sentence);
                if (heap.size() > 3) {
                    heap.poll();
                }
            }

            var result = new ArrayList<String>();
            while (!heap.isEmpty()) {
                result.add(heap.poll());
            }
            Collections.reverse(result);
            return result;
        }

    }
}
