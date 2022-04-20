package com.mygaienko.common.algorithms.leetcode.cracking_the_safe;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.joining;

class Solution {

    public String crackSafe(int n, int k) {
        if (n == 0) return "";
        if (n == 1) {
            return IntStream.range(0, k).mapToObj(String::valueOf).collect(joining());
        }

        Map<String, Queue<String>> passwords = generatePasswordsMap(n - 1, k);

        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push(String.join("", Collections.nCopies(n - 1, "0")));

        LinkedList<String> path = new LinkedList<>();

        while (!stack.isEmpty()) {

            while (passwords.containsKey(stack.peek())
                    && !passwords.get(stack.peek()).isEmpty()) {

                Queue<String> adjPaths = passwords.get(stack.peek());
                String polled = adjPaths.poll();
                stack.push(polled);
            }

            path.addFirst(stack.pop());
        }

        StringBuilder sb = new StringBuilder();
        sb.append(path.removeFirst());
        path.forEach(subPath -> sb.append(subPath.charAt(subPath.length()-1)));
        return sb.toString();
    }

    public Map<String, Queue<String>> generatePasswordsMap(int n, int k) {
        List<List<Integer>> list = generatePasswords(new ArrayList<>(), 0, n, k);
        Map<String, Queue<String>> result = new HashMap<>();
        for (List<Integer> integers : list) {
            String key = integers.stream().map(String::valueOf).collect(joining());
            Queue<String> value = result.computeIfAbsent(key, v -> new ArrayDeque<>());

            String prevKey = key.substring(1);
            for (int i = 0; i < k; i++) {
                value.offer(prevKey + i);
            }
        }
        return result;
    }

    private List<List<Integer>> generatePasswords(List<List<Integer>> current, int i, int n, int k) {
        if (i == n) return current;

        List<List<Integer>> result = new ArrayList<>();

        if (current.isEmpty()) {
            for (int j = 0; j < k; j++) {
                List<Integer> newList = new ArrayList<>();
                newList.add(j);
                result.add(newList);
            }
        } else {
            for (List<Integer> integers : current) {
                for (int j = 0; j < k; j++) {
                    List<Integer> newList = new ArrayList<>(integers);
                    newList.add(j);
                    result.add(newList);
                }
            }
        }

        return generatePasswords(result, i + 1, n, k);
    }

}
