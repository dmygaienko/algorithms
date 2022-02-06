package com.mygaienko.common.algorithms.leetcode.reconstruct_itinerary;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {

    private static final String START = "JFK";

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> adjMatrix = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);

            adjMatrix.computeIfAbsent(from, v -> new PriorityQueue<>()).add(to);
        }

        List<String> route = new LinkedList<>();
        ArrayDeque<String> stack = new ArrayDeque<>();
        stack.push(START);

        while (!stack.isEmpty()) {

            while (adjMatrix.containsKey(stack.peek())
                    && !adjMatrix.get(stack.peek()).isEmpty()) {
                PriorityQueue<String> adj = adjMatrix.get(stack.peek());
                stack.push(adj.poll()); // The reason we got stuck is that we hit the exit
            }

            route.add(0, stack.pop());
        }

        return route;
    }
}
