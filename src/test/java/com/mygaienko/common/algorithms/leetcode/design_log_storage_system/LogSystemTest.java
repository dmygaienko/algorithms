package com.mygaienko.common.algorithms.leetcode.design_log_storage_system;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LogSystemTest {

    LogSystem logSystem = new LogSystem();

    @Test
    public void test() {
        logSystem = new LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:01:22:59:59");
        logSystem.put(3, "2016:01:01:00:00:00");

        assertThat(logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year")).contains(3, 2, 1);
        assertThat(logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour")).contains(2, 1);
    }

    @Test
    public void test11() {
        logSystem = new LogSystem();
        logSystem.put(1, "2017:01:01:23:59:59");
        logSystem.put(2, "2017:01:02:23:59:59");

        assertThat(logSystem.retrieve("2017:01:01:23:59:58", "2017:01:02:23:59:58", "Second")).containsOnly(1);
    }
}