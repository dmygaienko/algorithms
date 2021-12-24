package com.mygaienko.common.algorithms.leetcode.asteroid_collision;

import java.util.Stack;

class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            int next = asteroids[i];

            if (stack.size() == 0) {
                stack.push(next);
            } else if (next > -1) {
                stack.push(next);
            } else {
                int absNext = Math.abs(next);

                while (stack.size() > 0 && stack.peek() > -1 && stack.peek() < absNext) {
                    stack.pop();
                }

                if (stack.size() == 0 || stack.peek() < 0) {
                    stack.push(next);
                } else if (stack.peek() == absNext) {
                    stack.pop();
                }
            }
        }

        int [] result = new int[stack.size()];
        for (int i = stack.size() -1 ; i > -1; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

}
