package com.mygaienko.common.algorithms.leetcode.three_sum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

class Solution {

    public List<List<Integer>> threeSum(int[] nums) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (Entry<Integer, Integer> entry : map.entrySet()) {

            Integer key = entry.getKey();
            int sum = key;
            if (entry.getValue() > 1) {
                sum += key;
                if ((sum == key && entry.getValue() > 2)
                        || map.tailMap(key, false).containsKey(-sum)) {
                    result.add(List.of(key, key, -sum));
                }
            }

            Set<Entry<Integer, Integer>> tailSet = map.tailMap(key, false).entrySet();
            for (Entry<Integer, Integer> tailEntry : tailSet) {
                Integer tailKey = tailEntry.getKey();
                if (tailEntry.getValue() > 1) {
                    int tailSum = tailKey + tailKey;
                    if (key + tailSum == 0) {
                        result.add(List.of(key, tailKey, tailKey));
                    }
                }

                int currentSum = key + tailKey;
                if (map.tailMap(tailKey, false).containsKey(-currentSum)) {
                    result.add(List.of(key, tailKey, -currentSum));
                }
            }

        }

        return result;
    }

}
