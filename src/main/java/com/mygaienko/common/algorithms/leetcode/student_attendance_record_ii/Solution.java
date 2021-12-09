package com.mygaienko.common.algorithms.leetcode.student_attendance_record_ii;

class Solution {

    int modulo = (int) Math.pow(10, 9) + 7;

    public int checkRecord(int n) {
        long result = 1;

        for (int i = 1; i <= n; i++) {
            result = result * 3;
//            if (i % 2 == 0) {
//                result -= 1;
//            }
//
//            if (i % 3 == 0) {
//                result -= 1;
//            }

            if (i > 1) { // any 2 A
                int j = i-2;
                while (j > -1) {
                    result -= Math.pow(2, j);
                    j--;
                }
            }

            if (i > 2) { // 3 conseq LLL
                int j = i-3;
                while (j > -1) {
                    result -= Math.pow(3, j);
                    j--;
                }
            }

            result %= modulo;
        }

        return (int) result;
    }

}
