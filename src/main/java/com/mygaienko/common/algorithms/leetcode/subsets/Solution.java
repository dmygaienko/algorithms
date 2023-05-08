package com.mygaienko.common.algorithms.leetcode.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(Arrays.stream(nums).boxed().collect(toList()));

        for (int i = 1; i <= nums.length; i++) { // for each length - 1
            generateLists(nums, subsets, new ArrayList<>(), 0, i);
        }

        return subsets;
    }

    private void generateLists(int[] nums, List<List<Integer>> subsets, List<Integer> skipList, int j, int size) {
        for (int n = j; n < nums.length && skipList.size() < size; n++) { // for each available number
            List<Integer> nextSkipList = new ArrayList<>(skipList);
            nextSkipList.add(n);

            if (nextSkipList.size() == size) {
                List<Integer> subSet = generateSubset(nums, nextSkipList);
                subsets.add(subSet);
            } else if ( n + 1 < nums.length){
                generateLists(nums, subsets, nextSkipList, n + 1, size);
            }
        }
    }

    private List<Integer> generateSubset(int[] nums, List<Integer> skipList) {
        List<Integer> subSet = new ArrayList<>();

        for (int n = 0, s = 0; n < nums.length; n++) {
            if (s < skipList.size() && n == skipList.get(s)) {
                s++;
            } else {
                subSet.add(nums[n]);
            }
        }

        return subSet;
    }

}
