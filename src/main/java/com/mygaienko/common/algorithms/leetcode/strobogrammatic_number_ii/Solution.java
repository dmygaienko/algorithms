package com.mygaienko.common.algorithms.leetcode.strobogrammatic_number_ii;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

    private static final Integer ZERO = 0;
    private static final List<Integer> sourceAbs = List.of(ZERO, 1, 8);
    private static final List<Integer> source = List.of(ZERO, 1, 6, 8, 9);
    private static final Map<Integer, Integer> rotated = Map.of(
            0, 0,
            1, 1,
            6, 9,
            8, 8,
            9, 6);

    public List<String> findStrobogrammatic(int n) {
        return findStrob(0, n, new LinkedList<>());
    }

    private List<String> findStrob(int i, int n, LinkedList<Integer> number) {
        List<String> result = new ArrayList<>();
        if (n % 2 == 0 ?
                number.size() < n / 2 :
                number.size() <= n / 2) {

            List<Integer> sourceLocal = n % 2 == 0 ? source : (number.size() * 2 + 1 == n ? sourceAbs : source);
            for (Integer s : sourceLocal) {
                if (s.equals(ZERO) && i == 0 && n > 1) continue;
                number.addLast(s);
                List<String> sResult = findStrob(i + 1, n, number);
                if (!sResult.isEmpty()) {
                    result.addAll(sResult);
                }
                number.removeLast();
            }
        } else {
            return doubleCopy(n, number);
        }
        return result;
    }

    private List<String> doubleCopy(int n, LinkedList<Integer> number) {
        StringBuilder sb = new StringBuilder();
        number.forEach(sb::append);
        Iterator<Integer> iterator = number.descendingIterator();
        if (number.size() > n / 2) iterator.next();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            sb.append(rotated.get(next));
        }
        return List.of(sb.toString());
    }

}
