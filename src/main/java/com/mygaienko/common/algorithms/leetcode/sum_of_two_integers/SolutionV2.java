package com.mygaienko.common.algorithms.leetcode.sum_of_two_integers;

class SolutionV2 {
    public int getSum(int a, int b) {
        if (a < b) {
            int c = b;
            b = a;
            a = c;
        }

        int[] aBits = getBitsArray(a);
        int[] bBits = getBitsArray(b);
        int[] sumBits = sumArrays(aBits, bBits);
        return convertToInt(sumBits);
    }

    private int[] getBitsArray(int val) {
        int[] bits = new int[32];
        for (int i = 0; i < bits.length; i++) {
            int mask = 1 << i;
            bits[31 - i] = (val & mask) != 0 ? 1 : 0;
        }
        return bits;
    }

    private int[] sumArrays(int[] aBits, int[] bBits) {
        int[] sumArray = new int[32];

        int trans = 0;
        for (int i = aBits.length - 1; i >= 0 ; i--) {
            int aVal = aBits[i];
            int bVal = bBits[i];
            int sum = trans + aVal + bVal;
            int result = sum % 2;
            sumArray[i] = result;
            trans = sum / 2;
        }
        return sumArray;
    }

    private int convertToInt(int[] sumBits) {
        boolean negative = false;

        if (sumBits[0] == 1) {
            negative = true;
            sumBits = invertBits(sumBits);
        }

        int result = 0;
        for (int i = sumBits.length -1; i >= 0; i--) {
            if (sumBits[i] == 1) {
                result = result + (int) Math.pow(2, sumBits.length - 1 - i);
            }
        }

        return negative ? (result + 1) * -1  : result;
    }

    private int[] invertBits(int[] sumBits) {
        for (int i = 0; i < sumBits.length; i++) {
            sumBits[i] = sumBits[i] == 1 ? 0 : 1;
        }
        return sumBits;
    }
}
