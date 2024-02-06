package com.mygaienko.common.algorithms.leetcode.design_search_autocomplete_system;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class AutocompleteSystemV2 {

    Trie root = new Trie();

    Trie curr = root;

    StringBuilder sb = new StringBuilder();

    public AutocompleteSystemV2(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            root.add(0, sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            if (curr != null) {
                curr.count++;
                curr.sentence = sb.toString();
            } else {
                root.add(0, sb.toString(), 1);
            }
            curr = root;
            sb = new StringBuilder();
            return List.of();
        }
        sb.append(c);
        if (curr == null) {
            return List.of();
        }
        var heap = new PriorityQueue<>(Comparator
                .<Pair<String, Integer>>comparingInt(Pair::getValue)
                .thenComparing(Pair::getKey, Comparator.reverseOrder()));
        curr = curr.get(c, heap);

        var result = new ArrayList<String>();
        while (!heap.isEmpty()) {
            result.add(heap.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }

    class Trie {

        String sentence = null;

        Map<Character, Trie> chars = new TreeMap<>();

        int count = 0;

        public void add(int index, String sentence, int count) {
            if (index >= sentence.length()) {
                this.sentence = sentence;
                this.count += count;
                return;
            }
            var next = chars.computeIfAbsent(sentence.charAt(index), v -> new Trie());
            next.add(index + 1, sentence, count);
        }

        public Trie get(char c, PriorityQueue<Pair<String, Integer>> heap) {
            Trie trie = chars.get(c);
            traverse(trie, heap);
            return trie;
        }

        private void traverse(Trie trie, PriorityQueue<Pair<String, Integer>> heap) {
            if (trie == null) return;

            if (trie.count > 0) {
                if (heap.size() < 3) {
                    heap.add(Pair.of(trie.sentence, trie.count));
                } else if (heap.peek().getValue() < trie.count) {
                    heap.poll();
                    heap.add(Pair.of(trie.sentence, trie.count));
                }
            }

            for (var next : trie.chars.entrySet()) {
                traverse(next.getValue(), heap);
            }
        }
    }
}
