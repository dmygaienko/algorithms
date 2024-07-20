package com.mygaienko.common.algorithms.leetcode.custom_sort_string;

import java.util.ArrayList;
import java.util.Arrays;

class Solution {

    public String customSortString(String order, String s) {
        var orders = new int[26];
        Arrays.fill(orders, Integer.MAX_VALUE);
        for (int i = 0; i < order.length(); i++) {
            var next = order.charAt(i);
            var nextIndex = next - 'a';
            orders[nextIndex] = Math.min(orders[nextIndex], i);
        }

        var custom = new ArrayList<Character>();
        for (var ch : s.toCharArray()) {
            custom.add(ch);
        }

        custom.sort((left, right) -> orders[left - 'a'] - orders[right - 'a']);

        var sb = new StringBuilder();
        for (var sorted : custom) {
            sb.append(sorted);
        }
        return sb.toString();
    }

}
