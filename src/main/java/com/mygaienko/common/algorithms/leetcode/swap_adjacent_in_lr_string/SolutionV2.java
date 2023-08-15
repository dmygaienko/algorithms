package com.mygaienko.common.algorithms.leetcode.swap_adjacent_in_lr_string;

import java.util.BitSet;

class SolutionV2 {

    String FROM1 = "XL";
    String TO1 = "LX";

    String FROM2 = "RX";
    String TO2 = "XR";

    public boolean canTransform(String a1, String b) {
        StringBuilder a = new StringBuilder(a1);
        int N = a.length();

        int L = 0;
        int R = N - 1;

        boolean changed = true;
        BitSet bitSet = new BitSet(N);
        for (int it = L; it <= R; it++) {

            int i = it;
            while (a.charAt(i) != b.charAt(i) && i + 1 < N || (i + 1 < N && a.charAt(i + 1) != 'R' && b.charAt(i + 1) == 'R')
                    && !bitSet.get(i) && !bitSet.get(i + 1)) {

                if (a.charAt(i) == FROM2.charAt(0) && a.charAt(i + 1) == FROM2.charAt(1)) {
                    replace(a, i, TO2);
                    changed = true;
                }

                if (a.charAt(i) == b.charAt(i) && (i == 0 || bitSet.get(i - 1))) {
                    bitSet.set(i);
                    L = i;
                }
                i++;
            }

            i = it;
            while (a.charAt(i) != b.charAt(i) && i - 1 >= 0 || (i - 1 >= 0 && a.charAt(i - 1) != 'L' && b.charAt(i - 1) == 'L')
                    && !bitSet.get(i) && !bitSet.get(i - 1)) {

                if (a.charAt(i - 1) == FROM1.charAt(0) && a.charAt(i) == FROM1.charAt(1)) {
                    replace(a, i - 1, TO1);
                    changed = true;
                }

                if (a.charAt(i) == b.charAt(i) && (i + 1 == N || bitSet.get(i + 1))) {
                    bitSet.set(i);
                    R = i;
                }
                i--;
            }

            if (it == R) {
                if (a.toString().equals(b)) {
                    return true;
                } else if (changed) {
                    it = L;
                    changed = false;
                }
            }

        }

        return a.toString().equals(b);
    }

    public void replace(StringBuilder a, int i, String to) {
        a.replace(i, i + 2, to);
    }

}
