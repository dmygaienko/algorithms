package com.mygaienko.common.algorithms.leetcode.string_transforms_into_another_string;

import org.apache.commons.lang3.tuple.Pair;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {

    public boolean canConvert(String str1, String str2) {
        var convertMap = new HashMap<Character, Character>();
        var dependencies = new HashMap<Character, Integer>();
        for (int i = 0; i < str1.length(); i++) {
            var charA = str1.charAt(i);
            var charB = str2.charAt(i);

            var prevCharB = convertMap.get(charA);
            if (prevCharB != null && prevCharB != charB) {
                return false;
            }

            if (prevCharB == null) {
                convertMap.put(charA, charB);
                dependencies.compute(charA, (k, v) -> v == null ? 1 : v + 1);
            }
        }

        var queue = new PriorityQueue<>(
                Comparator.<Pair<Character, Character>>comparingInt(pair -> convertMap.containsKey(pair.getValue()) ? 1 : 0));
        for (var entry : convertMap.entrySet()) {
            queue.add(Pair.of(entry.getKey(), entry.getValue()));
        }

        while (!queue.isEmpty()) {
            var next = queue.poll();
            var from = next.getKey();
            var to = next.getValue();

            if (dependencies.getOrDefault(to, 0) > 0) return false;

            dependencies.compute(from, (k, v) -> v == null ? 0 : v - 1);
        }

        return true;
    }

}