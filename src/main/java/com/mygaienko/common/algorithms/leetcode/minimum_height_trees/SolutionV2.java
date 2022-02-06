//package com.mygaienko.common.algorithms.leetcode.minimum_height_trees;
//
//import java.util.ArrayDeque;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Queue;
//
//class SolutionV2 {
//
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        Map<Integer, Integer> ins = new HashMap<>();
//        Map<Integer, List<Integer>> outs = new HashMap<>();
//
//        Map<Integer, Integer> inDegree = new HashMap<>();
//        Map<Integer, Integer> outDegree = new HashMap<>();
//
//        Map<Integer, Integer> inDegreesFull = new HashMap<>();
//        Map<Integer, Integer> outDegreesFull = new HashMap<>();
//
//        for (int[] edge : edges) {
//            int from = edge[0];
//            int to = edge[1];
//            ins.put(to, from);
//            outs.computeIfAbsent(from, (v) -> new ArrayList<>()).add(to);
//            outDegree.compute(from, (k,v) -> v == null ? 1 : v + 1);
//            outDegree.putIfAbsent(to, 0);
//            inDegree.compute(to, (k,v) -> v == null ? 1 : v + 1);
//            inDegree.putIfAbsent(from, 0);
//        }
//
//        Queue<Integer> outQueue = new ArrayDeque<>();
//        for (Entry<Integer, Integer> entry : outDegree.entrySet()) {
//            if (entry.getValue() == 0) {
//                outQueue.offer(entry.getKey());
//            }
//        }
//
//        while (!outQueue.isEmpty()) {
//            Integer next = outQueue.poll();
//
//            Integer from = ins.get(next);
//            if (from != null) {
//                Integer out = outDegree.compute(from, (k, v) -> v--);
//                if (out == 0) {
//                    outQueue.offer(from);
//                }
//            }
//
//            int outDegreeFull = 0;
//            List<Integer> nextOuts = outs.get(next);
//            if (nextOuts != null) {
//                for (Integer out : nextOuts) {
//                    outDegreeFull += outDegreesFull.getOrDefault(out, 0);
//                }
//            }
//            outDegreesFull.put(next, outDegreeFull);
//        }
//
//        Queue<Integer> inQueue = new ArrayDeque<>();
//        for (Entry<Integer, Integer> entry : inDegree.entrySet()) {
//            if (entry.getValue() == 0) {
//                inQueue.offer(entry.getKey());
//            }
//        }
//
//        while (!inQueue.isEmpty()) {
//            Integer next = inQueue.poll();
//
//            List<Integer> nextOuts = outs.get(next);
//            if (nextOuts != null) {
//                for (Integer nextOut : nextOuts) {
//                    Integer in = inDegree.compute(nextOut, (k, v) -> v--);
//                    if (in < 1) {
//                        inQueue.offer(in);
//                    }
//                }
//            }
//
//            Integer from = ins.get(next);
//            int fullInDegree = from != null ? inDegreesFull.getOrDefault(from, 0) : 0;
//            inDegreesFull.put(next, fullInDegree);
//        }
//
//        return Collections.emptyList();
//    }
//}