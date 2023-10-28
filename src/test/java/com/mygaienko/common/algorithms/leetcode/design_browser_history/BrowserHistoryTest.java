package com.mygaienko.common.algorithms.leetcode.design_browser_history;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class BrowserHistoryTest {

    /**
     * ["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
     *
     * [["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
     */
    @Test
    public void test() {
        var browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");

        assertThat(browserHistory.back(1)).isEqualTo("facebook.com");
        assertThat(browserHistory.back(1)).isEqualTo("google.com");
        assertThat(browserHistory.forward(1)).isEqualTo("facebook.com");

        browserHistory.visit("linkedin.com");
        assertThat(browserHistory.forward(2)).isEqualTo("linkedin.com");
        assertThat(browserHistory.back(2)).isEqualTo("google.com");
        assertThat(browserHistory.back(7)).isEqualTo("leetcode.com");
    }

    /**
     * ["BrowserHistory","visit","back","back","forward","forward","visit","visit","back"]
     *
     * [["zav.com"],["kni.com"],[7],[7],[5],[1],["pwrrbnw.com"],["mosohif.com"],[9]]
     *
     * [null,null,"zav.com","zav.com","kni.com","kni.com",null,null,"zav.com"]
     */
    @Test
    public void test1() {

    }
}