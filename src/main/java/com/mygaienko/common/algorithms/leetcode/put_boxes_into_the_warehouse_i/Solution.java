package com.mygaienko.common.algorithms.leetcode.put_boxes_into_the_warehouse_i;

import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        Arrays.sort(boxes);

        var stack = new ArrayDeque<Integer>();

        for (int i = 0; i < warehouse.length; i++) {
            if (!stack.isEmpty() && warehouse[stack.peek()] > warehouse[i]) {
                stack.push(i);
            } else if (stack.isEmpty()) {
                stack.push(i);
            }
        }

        var b = 0;
        var right = warehouse.length - 1;
        Integer popped = null;
        while (b < boxes.length && (!stack.isEmpty() || right >= 0)) {

            if (popped == null && !stack.isEmpty()) {
                popped = stack.pop();
            }

            int nextBox = boxes[b];
            if (stack.isEmpty() && nextBox > warehouse[popped]) break;
            while (!stack.isEmpty() && (stack.peek() > right || warehouse[popped] < nextBox)) {
                right = Math.min(right, popped - 1);
                popped = stack.pop();
            }

            if (warehouse[popped] >= nextBox && ((stack.isEmpty() ? 0 : stack.peek()) <= right)) {
                b++;
                right--;
            }

        }
        return b;
    }
}