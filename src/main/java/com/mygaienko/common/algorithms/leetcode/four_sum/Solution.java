package com.mygaienko.common.algorithms.leetcode.four_sum;

import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, Integer> numsCount = new HashMap<>();
        Map<Integer, Integer> duplicates = new HashMap<>();
        if (nums.length < 4) return List.of();
        Arrays.sort(nums);
        long average_value = target / 4;
        if  (nums[0] > average_value || average_value > nums[nums.length - 1]) {
            return  List.of();
        }

        var twoSumIndexes = new HashMap<Long, List<List<Integer>>>();

        for (int i = 0; i < nums.length; i++) {
            var first = nums[i];
            numsCount.compute(first, (k, v) -> v == null ? 1 : v + 1);
            for (int j = i + 1; j < nums.length; j++) {
                var second = nums[j];
                long sum = first + second;
                List<Integer> twoSum = List.of(i, j);
                var twoSumHash = Objects.hash(i % 8, first, second);
                if (duplicates.getOrDefault(twoSumHash, 0) < 2) {
                    duplicates.compute(twoSumHash, (k, v) -> v == null ? 1 : v + 1);
                    twoSumIndexes
                            .computeIfAbsent(sum, v -> new ArrayList<>())
                            .add(twoSum);
                }
            }
        }

        var hashes = new HashSet<Integer>();
        var result = new ArrayList<List<Integer>>();

        var iterator = twoSumIndexes.entrySet().iterator();
        while (iterator.hasNext()) {
            var entry = iterator.next();
            var prefixList = entry.getValue();
            var suffixList = twoSumIndexes.get(target - entry.getKey());

            if (prefixList == null || suffixList == null) continue;

            for (var pref : prefixList) {
                for (var suff : suffixList) {

                    int num1 = nums[pref.get(0)];
                    int num2 = nums[pref.get(1)];
                    int num3 = nums[suff.get(0)];
                    int num4 = nums[suff.get(1)];

                    int cached1 = numsCount.get(num1);
                    int cached2 = numsCount.get(num2);
                    int cached3 = numsCount.get(num3);
                    int cached4 = numsCount.get(num4);

                    if (numsCount.compute(num1, (k, v) -> v - 1) >= 0 &&
                            numsCount.compute(num2, (k, v) -> v - 1) >= 0 &&
                            numsCount.compute(num3, (k, v) -> v - 1) >= 0 &&
                            numsCount.compute(num4, (k, v) -> v - 1) >= 0
                    ) {
                        List<Integer> list = List.of(num1, num2, num3, num4);
                        var hash = list.hashCode();
                        if (!hashes.contains(hash) && pref.get(1) <= suff.get(0)) {
                            result.add(list);
                            hashes.add(hash);
                        }
                    }

                    numsCount.put(num1, cached1);
                    numsCount.put(num2, cached2);
                    numsCount.put(num3, cached3);
                    numsCount.put(num4, cached4);
                }
            }
        }
        return result;
    }
}
