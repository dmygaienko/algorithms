package com.mygaienko.common.algorithms.bitwise_ors_of_subarrays;

import java.util.HashSet;

class Solution {

    public int subarrayBitwiseORs(int[] arr) {
        var subArrays = new HashSet<Integer>();

        var prevDp = new HashSet<>();
        var currDp = new HashSet<>();

        prevDp.add(arr[0]);
        subArrays.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            var curr = arr[i];
            subArrays.add(curr);
            currDp.add(curr);

            for (var subArrVal : prevDp) {
                var nextSubArrVal = ((Integer) subArrVal) | curr;
                currDp.add(nextSubArrVal);
                subArrays.add(nextSubArrVal);
            }

            prevDp = currDp;
            currDp = new HashSet<>();
        }

        return subArrays.size();
    }

}