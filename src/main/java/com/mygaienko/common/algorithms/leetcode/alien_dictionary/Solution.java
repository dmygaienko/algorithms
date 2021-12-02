package com.mygaienko.common.algorithms.leetcode.alien_dictionary;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 269. Alien Dictionary
 * https://leetcode.com/problems/alien-dictionary/
 */
class Solution {

    public static final String NOT_VALID_DICTIONARY = "";

    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return NOT_VALID_DICTIONARY;
        if (words.length == 1) return getUniqueChars(words[0]);

        Map<Character, Integer> prereqs = new LinkedHashMap<>();
        Map<Character, Set<Character>> adj = new HashMap<>();
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];

            int length = Math.min(curr.length(), next.length());
            fillPrereqs(prereqs, curr, next);
            for (int j = 0; j < length; j++) {
                char currC = curr.charAt(j);
                char nextC = next.charAt(j);

                prereqs.putIfAbsent(currC, 0);
                prereqs.putIfAbsent(nextC, 0);

                if (currC != nextC) {
                    adj.putIfAbsent(currC, new LinkedHashSet<>());
                    if (adj.get(currC).add(nextC)) {
                        prereqs.compute(nextC, (k, v) -> v + 1);
                    }

                    fill(prereqs, curr, j+1);
                    fill(prereqs, next, j+1);
                    break;
                } else {
                    if (j == length - 1 && curr.length() > next.length()) {
                        return NOT_VALID_DICTIONARY;
                    }
                }
            }
        }

        Queue<Character> queue = new ArrayDeque<>();
        for (Map.Entry<Character, Integer> entry : prereqs.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Character next = queue.poll();
            sb.append(next);

            Set<Character> dependents = adj.get(next);
            if (dependents == null) {
                continue;
            }

            for (Character dependent : dependents) {
                Integer computed = prereqs.compute(dependent, (k, v) -> v == null ? 0 : v - 1);
                if (computed == 0) {
                    queue.offer(dependent);
                }
            }
        }

        String dictionary = sb.toString();
        return dictionary.length() != prereqs.entrySet().size() ? NOT_VALID_DICTIONARY : dictionary;
    }

    private void fillPrereqs(Map<Character, Integer> prereqs, String curr, String next) {
        if (curr.length() > next.length()) {
            fill(prereqs, curr, next.length());
        } else if (curr.length() < next.length()) {
            fill(prereqs, next, curr.length());
        }
    }

    private void fill(Map<Character, Integer> prereqs, String str, int ind) {
        for (int i = ind; i < str.length(); i++) {
            prereqs.putIfAbsent(str.charAt(i), 0);
        }
    }

    private String getUniqueChars(String word) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> chars = new HashMap<>();
        for (char c : word.toCharArray()) {
            Integer occur = chars.compute(c, (k, v) -> v == null ? 1 : v + 1);
            if (occur == 1) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
