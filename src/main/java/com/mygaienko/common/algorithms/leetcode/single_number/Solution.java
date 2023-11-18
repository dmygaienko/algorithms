package com.mygaienko.common.algorithms.leetcode.single_number;

class Solution {
    public int singleNumber(int[] nums) {
        var single = 0;

        //for each bit iterate over array and calculate sum
        for (int i = 0; i < 32; i++) {
            int sum = 0;

            //iterate over array
            for (var num : nums) {
                var numIBit = (num >> i) & 1; //extract bit
                sum += numIBit;
            }

            //find mod of two to find which value is left alone
            int bitValue = sum % 2;

            //compose bit with previos found
            single = single | (bitValue << i);
        }

        return single;
    }
}
