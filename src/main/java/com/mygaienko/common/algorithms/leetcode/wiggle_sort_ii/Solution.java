package com.mygaienko.common.algorithms.leetcode.wiggle_sort_ii;

class Solution {

    public void wiggleSort(int[] nums) {
        boolean wiggle = true; // on wiggle prev < next
        for (int i = 0; i + 1 < nums.length; i++) {
            int prev = nums[i];
            int next = nums[i + 1];
            if (wiggle && prev >= next) {
                findAndReplace(nums, i, true);
            } else if (!wiggle && prev <= next) {
                findAndReplace(nums, i, false);
            }

            wiggle = !wiggle;
        }
    }

    private void findAndReplace(int[] nums, int prevIndex, boolean greater) {
        int indexToReplace = prevIndex + 1;
        int prevValue = nums[prevIndex];
        int nextValue = nums[indexToReplace];

        if (indexToReplace == nums.length - 1) {
            if (prevValue != nextValue) {
                replace(nums, prevIndex, indexToReplace);
            } else { //prevValue == nextValue
                softReplace(nums, prevIndex, indexToReplace, greater);

                if (nums[prevIndex] == nums[indexToReplace]) {
                    softReplace(nums, prevIndex - 1, indexToReplace - 1, !greater);
                }
            }
        }

        for (int i = indexToReplace + 1; i < nums.length; i++) {
            int currValue = nums[i];

            if (greater && prevValue < currValue) {
                replace(nums, indexToReplace, i);
                return;
            } else if (greater && currValue < nextValue) {
                replace(nums, prevIndex, i);
                return;
            } else if (!greater && prevValue > currValue) {
                replace(nums, indexToReplace, i);
                return;
            } else if (!greater && currValue > nextValue) {
                replace(nums, prevIndex, i);
                return;
            }
        }

        if (prevValue == nums[prevIndex] && nextValue == nums[indexToReplace]) {
            softReplace(nums, prevIndex, indexToReplace, greater);
            if (prevValue == nums[prevIndex] && nextValue == nums[indexToReplace]) {
                if (prevIndex - 1 >= 0) {
                    softReplace(nums, prevIndex - 1, indexToReplace - 1, !greater);
                    if (prevValue == nums[prevIndex] && nextValue == nums[indexToReplace]) {
                        replace(nums, prevIndex, indexToReplace);
                    }
                } else {
                    replace(nums, prevIndex, indexToReplace);
                }
            }
        }
    }

    private void softReplace(int[] nums, int prevIndex, int indexToReplace, boolean greater) {
        int prevValue = nums[prevIndex];
        int replaceValue = nums[indexToReplace];

        for (int i = 0; i < nums.length; i++) {
            boolean first = i == 0;
            boolean last = i == nums.length - 1;

            int current = nums[i];
            if (current == replaceValue) continue;


            int currentPrev = first ? Integer.MIN_VALUE : nums[i - 1];
            int currentNext = last ? Integer.MAX_VALUE : nums[i + 1];

            if (greater && current > prevValue || (!greater && current < prevValue)) {
                if (first && (current > currentNext) == (replaceValue > currentNext) && replaceValue != currentNext) {
                    replace(nums, indexToReplace, i);
                    return;
                } else if (!first && !last &&
                        (current > currentNext) == (replaceValue > currentNext) && replaceValue != currentNext &&
                        (current < currentPrev) == (replaceValue < currentPrev) && replaceValue != currentPrev) {
                    replace(nums, indexToReplace, i);
                    return;
                } else if (last && (current < currentPrev) == (replaceValue < currentPrev) && replaceValue != currentPrev) {
                    replace(nums, indexToReplace, i);
                    return;
                }
            }

        }
    }

    private void replace(int[] nums, int currentIndex, int i) {
        int temp = nums[currentIndex];
        nums[currentIndex] = nums[i];
        nums[i] = temp;
    }

}
