package com.mygaienko.common.algorithms.leetcode.number_of_wonderful_substrings;

class Solution {

    public long wonderfulSubstrings(String word) {
        var evenOdds = new int[word.length()];

        for (int i = 0; i < word.length(); i++) {
            var ch = word.charAt(i);
            var charIndex = ch - 'a';
            var prevValue = i == 0 ? 0 : evenOdds[i - 1];

            var charBit = 1 << charIndex;
            evenOdds[i] = prevValue ^ charBit;
        }

        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (hasNoSingleCharOrAtMostOne(evenOdds[i])) {
                count++;
            }
            for (int j = i + 1; j < word.length(); j++) {
                var result = evenOdds[i] ^ evenOdds[j];
                if (hasNoSingleCharOrAtMostOne(result)) {
                    count++;
                }
            }
        }

        return count;
    }

    private boolean hasNoSingleCharOrAtMostOne(int n) {
        return n == 0 || (n > 0 && (n & (n - 1)) == 0);
    }

/*
    public long wonderfulSubstrings(String word) {
        int n = word.length();
        long count = 0;

        long[] freq = new long[(1 << 10) + 1]; // Since we have to take only 2^10 possibilies, we can avoid an HashMap

        freq[0] = 1;
        int res = 0; // initialize the frequency of 0000000000 as 1 because when no element is encountered, then th bitmask is 0

        for (int i = 0; i < n; i++) {
            int mask = (1 << (word.charAt(i) - 'a'));
            res ^= mask; // toggling bit of the current character to make it from odd to even OR even to odd
            int chkMask = 1;

            count += freq[res];
            for (int j = 1; j <= 10; j++) {  // Loop for checking all possiblities of different places of the Different Bit
                count += freq[chkMask ^ res];
                chkMask <<= 1;
            }

            freq[res]++; // increasing the frequency of the current bitmask
        }

        return count;
    }
*/

}
