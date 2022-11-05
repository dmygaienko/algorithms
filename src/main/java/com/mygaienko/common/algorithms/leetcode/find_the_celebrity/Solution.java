package com.mygaienko.common.algorithms.leetcode.find_the_celebrity;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution extends Relation {

    public int findCelebrity(int n) {
        Set<Integer> common = new HashSet<>();

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            Integer next = stack.pop();
            if (common.contains(next)) continue;

            int knows = 0;
            for (int i = 0; i < n; i++) {
                if (i == next) continue;

                if (knows(next, i)) {
                    common.add(next);
                    if (!common.contains(i)) {
                        stack.push(i);
                    }
                    knows++;
                    break;
                }
            }

            if (knows == 0) {
                int known = 0;
                for (int i = 0; i < n; i++) {
                    if (i == next) continue;

                    if (knows(i, next)) {
                        known++;
                    } else {
                        break;
                    }
                }
                if (known == n - 1) return next;
            }

        }
        return -1;
    }

}
