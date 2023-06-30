package com.mygaienko.common.algorithms.leetcode.sum_of_two_integers;

class Solution {

    public int getSum(int a, int b) {
        int sum = a;
        int carry = b;

        while (carry != 0) {
            sum = a ^ b;
            carry = ( a & b ) << 1;

            a = sum;
            b = carry;
        }

        return sum;
    }

//    public int getSum(int a, int b) {
//        int x = Math.abs(a), y = Math.abs(b);
//        // ensure that abs(a) >= abs(b)
//        if (x < y) return getSum(b, a);
//
//        // abs(a) >= abs(b) -->
//        // a determines the sign
//        int sign = a > 0 ? 1 : -1;
//
//        if (a * b >= 0) {
//            // sum of two positive integers x + y
//            // where x > y
//            while (y != 0) {
//                int answer = x ^ y;
//                int carry = (x & y) << 1;
//                x = answer;
//                y = carry;
//            }
//        } else {
//            // difference of two positive integers x - y
//            // where x > y
//            while (y != 0) {
//                int answer = x ^ y;
//                int borrow = ((~x) & y) << 1;
//                x = answer;
//                y = borrow;
//            }
//        }
//        return x * sign;
//    }

}
