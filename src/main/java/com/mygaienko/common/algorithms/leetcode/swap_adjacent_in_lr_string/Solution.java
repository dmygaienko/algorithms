package com.mygaienko.common.algorithms.leetcode.swap_adjacent_in_lr_string;

import java.util.BitSet;

class Solution {

    String FROM1 = "XL";
    String TO1 = "LX";

    String FROM2 = "RX";
    String TO2 = "XR";

    public boolean canTransform(String a1, String b) {
        StringBuilder a = new StringBuilder(a1);
        int N = a.length();

        int L = 0;
        int R = N - 1;

        int l = L;
        int r = R;

        boolean changed = true;
        BitSet bitSet = new BitSet(N);
        while ((l <= R || r >= L) || changed) {

            if (l <= R) {
                if (a.charAt(l) != b.charAt(l) && l + 1 < N || (l + 1 < N && a.charAt(l+1) != 'R' && b.charAt(l+1) == 'R')
                        && !bitSet.get(l) && !bitSet.get(l + 1)) {

                    if (a.charAt(l) == FROM2.charAt(0) && a.charAt(l + 1) == FROM2.charAt(1)) {
                        replace(a, l, TO2);
                        changed = true;
                    }
                }

                if (a.charAt(l) == b.charAt(l) && (l == 0 || bitSet.get(l - 1))) {
                    bitSet.set(l);
                    L = l;
                }
                l++;
            }

            if (r >= L) {
                if (a.charAt(r) != b.charAt(r) && r - 1 >= 0 || (r - 1 >= 0 && a.charAt(r-1) != 'L' && b.charAt(r-1) == 'L')
                        && !bitSet.get(r) && !bitSet.get(r - 1)) {

                    if (a.charAt(r-1) == FROM1.charAt(0) && a.charAt(r) == FROM1.charAt(1)) {
                        replace(a, r - 1, TO1);
                        changed = true;
                    }
                }

                if (a.charAt(r) == b.charAt(r) && (r + 1 == N || bitSet.get(r + 1))) {
                    bitSet.set(r);
                    R = r;
                }
                r--;
            }

            if (r <= L && l >= R) {
                if (a.toString().equals(b)) {
                    return true;
                } else if (changed) {
                    l = L;
                    r = R;
                    changed = false;
                }
            }
        }

        return a.toString().equals(b);
    }

    public void replace(StringBuilder a, int i, String to) {
        a.replace(i, i + 2 , to);
    }

}
