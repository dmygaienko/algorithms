package com.mygaienko.common.algorithms.leetcode.final_prices_with_a_special_discount_in_a_shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * increased monotonic stack
 */
public class Solution {

    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];

        Stack<int[]> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];

            while (!stack.isEmpty() && stack.peek()[1] >= price) {
                int[] arr = stack.pop();
                int ind = arr[0];
                int last = arr[1];
                map.put(ind, last - price);
            }
            stack.push(new int[]{i, price});
        }

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            result[i] = map.getOrDefault(i, price);
        }

        return result;
    }

}
