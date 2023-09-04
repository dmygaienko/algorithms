package com.mygaienko.common.algorithms.leetcode.strings_differ_by_one_character;

import java.util.*;

class Solution {

    public boolean differByOne(String[] dict) {
        return differByOne(dict, 0, false) || differByOne(dict, 1, true);
    }

    public boolean differByOne(String[] dict, int start, boolean strict) {
        if (dict == null || dict.length == 0) return false;

        var queue = initQueue(dict, start);

        while (!queue.isEmpty()) {
            Result result = queue.poll();
            int nextI = result.i + 1;

            Map<Long, Set<Integer>> hashToRow = new HashMap<>();

            Set<Long> notFounds = new HashSet<>();
            for (Integer row : result.hits) {
                char ch = dict[row].charAt(nextI);
                long hash = result.hash * 13 + ch * 17;

                Set<Integer> hashes = hashToRow.computeIfAbsent(hash, v -> new HashSet<>());
                hashes.add(row);

                if (hashes.size() == 1) {
                    notFounds.add(hash);
                } else {
                    notFounds.remove(hash);
                }
            }

            Map<Long, List<Integer>> suffixHashToRow = new HashMap<>();

            for (var entry : hashToRow.entrySet()) {
                if (entry.getValue().size() == 1) {
                    if (!strict) {
                        if (nextI == dict[0].length() - 1) return true;

                        int row = entry.getValue().iterator().next();
                        long suffixHash = calculateHash(dict, row, nextI + 1);
                        suffixHashToRow.computeIfAbsent(suffixHash, v -> new ArrayList<>()).add(row);
                    }
                } else if (strict && nextI == dict[0].length() - 1) {
                    return true;
                } else {
                    queue.offer(new Result(nextI, entry.getKey(), entry.getValue()));

                    if (!notFounds.isEmpty()) {
                        for (Integer row : entry.getValue()) {
                            long suffixHash = calculateHash(dict, row, nextI + 1);
                            suffixHashToRow.computeIfAbsent(suffixHash, v -> new ArrayList<>()).add(row);
                        }
                    }
                }
            }

            if (!strict) {
                for (Map.Entry<Long, List<Integer>> entry : suffixHashToRow.entrySet()) {
                    if (entry.getKey() != 0 && entry.getValue().size() > 1) return true;
                }
            }

        }

        return false;
    }

    private Queue<Result> initQueue(String[] dict, int start) {
        Map<Long, Set<Integer>> hashToRowInit = new HashMap<>();

        Queue<Result> queue = new LinkedList<>();

        for (int r = 0; r < dict.length; r++) {
            char ch = dict[r].charAt(start);

            long hash = (long) 13 + ch * 17;
            hashToRowInit.computeIfAbsent(hash, v -> new HashSet<>()).add(r);
        }

        for (var entry : hashToRowInit.entrySet()) {
            var hits = entry.getValue();
            if (hits.size() > 1) {
                queue.offer(new Result(0, entry.getKey(), hits));
            }
        }
        return queue;
    }

    private long calculateHash(String[] dict, int row, int i) {
        int hash = 0;
        if (i >= dict[row].length()) return hash;

        for (int s = i; s < dict[row].length(); s++) {
            char ch = dict[row].charAt(s);
            hash = hash * 13 + ch * 17;
        }

        return hash;
    }

    class Result {
        int i;
        long hash;
        Set<Integer> hits;

        public Result(int i, long hash, Set<Integer> hits) {
            this.i = i;
            this.hash = hash;
            this.hits = hits;
        }
    }


}
