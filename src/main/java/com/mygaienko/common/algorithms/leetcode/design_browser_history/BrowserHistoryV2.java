package com.mygaienko.common.algorithms.leetcode.design_browser_history;

import java.util.LinkedList;

class BrowserHistoryV2 {

    LinkedList<String> history;
    int index = 0;

    public BrowserHistoryV2(String homepage) {
        history = new LinkedList<>();
        visit(homepage);
    }

    public void visit(String url) {
        removeForward();
        history.add(url);
        index = history.size() - 1;
    }

    public String back(int steps) {
        index = Math.max(0, index - steps);

        String result = null;
        if (history.isEmpty()) result = "";
        else if (history.size() <= steps) result = history.get(0);
        else result = history.get(index);

        return result;
    }

    public String forward(int steps) {
        index = Math.min(history.size() - 1, index + steps);
        var result = history.get(index);
        return result;
    }

    private void removeForward() {
        if (index + 1 >= history.size()) return;
        var it = history.listIterator(index + 1);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
