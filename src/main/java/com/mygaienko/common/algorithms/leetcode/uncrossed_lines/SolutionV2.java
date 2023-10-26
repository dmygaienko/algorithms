package com.mygaienko.common.algorithms.leetcode.uncrossed_lines;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

class SolutionV2 {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        var nums1Map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums1.length; i++) {
            var num = nums1[i];
            nums1Map.computeIfAbsent(num, v -> new ArrayList()).add(i);
        }

        var queue = new PriorityQueue<int[]>(Comparator.comparingInt(arr -> Math.abs(arr[0] - arr[1])));

        for (int i2 = 0; i2 < nums2.length; i2++) {
            var num2 = nums2[i2];
            var index1List = nums1Map.getOrDefault(num2, List.of());
            for (var i1 : index1List) {
                queue.offer(new int[]{i1, i2});
            }
        }

        var count = 0;
        while (!queue.isEmpty()) {
            var next = queue.poll();
            var i1 = next[0];
            var i2 = next[1];

            var mid = (i1 + i2) / 2;
            if (nums1[i1] >= 0 && nums2[i2] >= 0 &&
                    ((mid < nums1.length && nums1[mid] >= 0)
                            || (mid < nums2.length && nums2[mid] >= 0))) {
                count++;
                int from = Math.min(i1, i2);
                int to = Math.max(i1, i2);
                while (from <= to) {
                    if (from < nums1.length) {
                        nums1[from] *= -1;
                    }

                    if (from < nums2.length) {
                        nums2[from] *= -1;
                    }
                    from++;
                }
            }
        }


        return count;

    }

}
