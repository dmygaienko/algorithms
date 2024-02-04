package com.mygaienko.common.algorithms.leetcode.put_boxes_into_the_warehouse_i;

import java.util.Arrays;

public class SolutionV2 {

    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        var minHeight = new int[warehouse.length];
        minHeight[0] = warehouse[0];
        for (int i = 1; i < minHeight.length; i++) {
            minHeight[i] = Math.min(minHeight[i - 1], warehouse[i]);
        }

        Arrays.sort(boxes);

        int count = 0;
        for (int i = warehouse.length - 1; i >= 0; i--) {
            if (count < boxes.length && minHeight[i] >= boxes[count]) {
                count++;
            }
        }

        return count;
    }
}
