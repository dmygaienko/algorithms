package com.mygaienko.common.algorithms.leetcode.reorder_data_in_log_files;

import java.util.Arrays;

class Solution {

    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a, b) -> {
            var aSplit = a.split(" ", 2);
            var bSplit = b.split(" ", 2);

            var aIsLetter = Character.isLetter(aSplit[1].charAt(0));
            var bIsLetter = Character.isLetter(bSplit[1].charAt(0));

            if (aIsLetter && bIsLetter) {
                var comp = aSplit[1].compareTo(bSplit[1]);
                if (comp != 0) return comp;
                return aSplit[0].compareTo(bSplit[0]);
            }

            if (aIsLetter && !bIsLetter) return -1;
            if (!aIsLetter && bIsLetter) return 1;

            return 0;
        });
        return logs;
    }

}
