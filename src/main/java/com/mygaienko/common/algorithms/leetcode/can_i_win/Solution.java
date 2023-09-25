 package com.mygaienko.common.algorithms.leetcode.can_i_win;

 import org.apache.commons.lang3.tuple.Pair;

 import java.util.HashMap;
 import java.util.Map;

 class Solution {

    int maxChoosableInteger;
    int desiredTotal;

    // problem very similar to dynamic type as we need to make step and by calculating
    // current we need to have result from previos one.
    // one each step we need to choose any of left integers, so we need to somehow store already picked values.
    // it could be set or bitset
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        this.maxChoosableInteger = maxChoosableInteger;
        this.desiredTotal = desiredTotal;
        if (desiredTotal <= maxChoosableInteger) return true;
        return canIWin(new HashMap<>(), 0, true, 0);
    }

    // a) on the first move can move if there is at least one move that reach target
    // b) on the second move first can win if on the last step there is always sum with max that not reach target,
    // but with two minimum (first move) it is reachable

     // The player who can make the target=biggest+smallest+1 will win the game.
    private boolean canIWin(Map<Pair<Integer, Boolean>, Boolean> memo, int sum, boolean first, int visited) {
        int minFree = getMinFree(visited);
        int maxFree = getMaxFree(visited);
        if (minFree > maxFree) return !first;

        var key = Pair.of(visited, first);
        var cached = memo.get(key);
        if (cached != null) return cached;

        if (sum + minFree + maxFree + 1 == desiredTotal) {
            memo.put(key, first);
            return first;
        }

        int clone = setVisited(visited, minFree);
        var result = canIWin(memo, sum + minFree, !first, clone);
        memo.put(key, result);
        return result;
    }

    private int setVisited(int visited, int free) {
        return visited | (1 << free);
    }

    private int getMinFree(long visited) {
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int mask = 1 << i;
            if ((visited & mask) == 0) return i;
        }
        return Integer.MAX_VALUE;
    }

    private int getMaxFree(int visited) {
        for (int i = maxChoosableInteger; i > 0; i--) {
            int mask = 1 << i;
            if ((visited & mask) == 0) return i;
        }
        return Integer.MIN_VALUE;
    }

}
