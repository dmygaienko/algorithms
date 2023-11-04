 package com.mygaienko.common.algorithms.leetcode.pattern_132;

import java.util.Comparator;
import java.util.TreeSet;

 class SolutionV2 {

     // iterate overn nums
     // assign element to min Max and curMin and curMax and check whether next is in between
     // 1 2 4 10 4 2 11 12 3
     public boolean find132pattern(int[] nums) {

         var list = new TreeSet<>(Comparator.<int[]>comparingInt(arr -> arr[0])
 //                .thenComparing(arr -> arr[1])
         );
         var min = Integer.MAX_VALUE;
         var max = Integer.MIN_VALUE;

         var currMin = Integer.MAX_VALUE;
         var currMax = Integer.MIN_VALUE;
         for (int i = 0; i < nums.length; i++) {
             var next = nums[i];
             min = Math.min(min, next);
             max = Math.max(max, next);

             if (next < currMin) {
                 if (currMax != Integer.MIN_VALUE) {
                     list.add(new int[]{currMin, currMax});
                     currMax = Integer.MIN_VALUE;
                 }
                 currMin = next;

             } else if (next > currMax) {
                 currMax = next;
             } else if (next < currMax && next > currMin) {
                 return true;
             }

             if (min < next && next < max) {
                 for (var range : list.headSet(new int[]{next, next})) {
                     if (range[0] < next && range[1] > next) return true;
                 }
             }

         }

         return false;
     }


 }