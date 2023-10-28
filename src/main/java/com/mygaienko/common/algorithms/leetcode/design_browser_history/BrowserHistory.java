package com.mygaienko.common.algorithms.leetcode.design_browser_history;

import java.util.ArrayDeque;

/**
 * Two stacks: history and future
 */
class BrowserHistory {

    ArrayDeque<String> historyStack = new ArrayDeque<>();
    ArrayDeque<String> futureStack = new ArrayDeque<>();

    public BrowserHistory(String homepage) {
        visit(homepage);
    }

    public void visit(String url) {
        futureStack.clear();
        historyStack.push(url);
    }

    public String back(int steps) {
        for (int i = 0; i < steps && historyStack.size() > 1; i++) {
            var popped = historyStack.pop();
            futureStack.push(popped);
        }
        return historyStack.peek();
    }

    public String forward(int steps) {
        var result = "";
        for (int i = 0; i < steps && !futureStack.isEmpty(); i++) {
            String popped = futureStack.pop();
            historyStack.push(popped);
            result = popped;
        }

        return result.equals("") ? historyStack.peek() : result;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
