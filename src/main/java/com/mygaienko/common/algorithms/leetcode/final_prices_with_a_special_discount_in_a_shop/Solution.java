package com.mygaienko.common.algorithms.leetcode.final_prices_with_a_special_discount_in_a_shop;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];

        Stack<Integer> stack = new Stack();
        Map<Integer, Integer> map = new HashMap<>();

        for (int price : prices) {
            if (!stack.isEmpty() && stack.peek() > price) {
                int last = stack.peek();
                map.put(last, last - price);
            }
            stack.push(price);
        }

        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            result[i] = map.getOrDefault(price, price);
        }

        return result;
    }

}
