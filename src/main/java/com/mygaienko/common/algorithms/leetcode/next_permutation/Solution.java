package com.mygaienko.common.algorithms.leetcode.next_permutation;

public class Solution {

    public void nextPermutation(int[] nums){
        int i = nums.length -1; // start from the end

        while(i > 0 && nums[i-1] >= nums[i]){
            i--;
        }

        if(i==0){
            reverse(nums,0,nums.length -1 );
        }else{
            // found the first one not in order
            int j = i;

            // found just bigger one
            while (j < nums.length && nums[j] > nums[i - 1]) {
                j++;
            }

            // But, recall that while scanning the numbers from the right, we simply kept decrementing the index
            // until we found the pair a[i]a[i]a[i] and a[i−1]a[i-1]a[i−1] where, a[i]>a[i−1]a[i] > a[i-1]a[i]>a[i−1].
            // Thus, all numbers to the right of a[i−1]a[i-1]a[i−1] were already sorted in descending order.
            // Furthermore, swapping a[i−1]a[i-1]a[i−1] and a[j]a[j]a[j] didn't change that order.
            // swap(nums[i-1],nums[j-1]);
            int tmp = nums[i - 1];
            nums[i - 1] = nums[j - 1];
            nums[j - 1] = tmp;
            reverse(nums, i, nums.length - 1);
        }
    }

    // reverse the sequence
    static void reverse(int[] arr,int start, int end){
        int tmp;
        for(int i = 0; i <= (end - start)/2; i++ ){
            tmp = arr[start + i];
            arr[start + i] = arr[end - i];
            arr[end - i ] = tmp;
        }
    }

}
