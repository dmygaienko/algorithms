package com.mygaienko.common.algorithms.leetcode.reconstruct_itinerary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * eulerian circuit
 *
 * https://leetcode.com/problems/reconstruct-itinerary/discuss/78768/Short-Ruby-Python-Java-C%2B%2B
 * https://www.youtube.com/watch?v=8MpoO2zA2l4&t=4s&ab_channel=WilliamFiset
 */

class SolutionV2 {

    private static final String START = "JFK";

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> targets = new HashMap<>();
        for (List<String> ticket : tickets)
            targets.computeIfAbsent(ticket.get(0),
                    k -> new PriorityQueue<>()).add(ticket.get(1));

        LinkedList<String> route = new LinkedList();

        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.empty()) {
            while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty()) {
                PriorityQueue<String> adj = targets.get(stack.peek());
                stack.push(adj.poll());
            }

            route.addFirst(stack.pop());
        }
        return route;
    }
}
