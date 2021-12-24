//package com.mygaienko.common.algorithms.leetcode.optimal_account_balancing;
//
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.atomic.AtomicInteger;
//
//class SolutionV2 {
//
//    public int minTransfers(int[][] transactions) {
//        int[] debt = buildDebtArray(transactions); // Debt amount to balance for each person.
//        int minTransfersAfter = getMinTransfersAfter(0, debt);
//        return minTransfersAfter;
//    }
//
//    private int getMinTransfersAfter(int curId, int[] debt) {
//        while (curId < debt.length && debt[curId] == 0)
//            curId++; // go further
//        // Base case.
//        if (curId == debt.length)
//            return 0; // end of array
//        // Recursive case.
//        int minTransactions = Integer.MAX_VALUE;
//        for (int i = curId + 1; i < debt.length; i++) {
//            int product = debt[curId] * debt[i];
//            if (product < 0) {
//                debt[i] += debt[curId]; // process transaction
//                int tempMinTransactions = getMinTransfersAfter(curId + 1, debt) + 1;
//                minTransactions = Math.min(minTransactions, tempMinTransactions);
//                debt[i] -= debt[curId]; //revert
//            }
//        }
//
//        return minTransactions;
//    }
//
//    private int[] buildDebtArray(int[][] transactions) {
//        Map<Integer, Integer> debtMap = new HashMap<>(); // Map person ID to debt amount.
//
//        for (int[] transaction : transactions) {
//            int giver = transaction[0];
//            int taker = transaction[1];
//            int amount = transaction[2];
//            debtMap.put(giver, debtMap.getOrDefault(giver, 0) + amount);
//            debtMap.put(taker, debtMap.getOrDefault(taker, 0) - amount);
//        }
//
//        int[] debt = new int[debtMap.size()];
//        int i = 0;
//        for (int amount : debtMap.values()) {
//            debt[i++] = amount;
//        }
//
//        return debt;
//    }
//
//}
