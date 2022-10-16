package com.mygaienko.common.algorithms.leetcode.design_file_system;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FileSystemTest {

    @Test
    public void test() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.createPath("/a",1);
        assertThat(fileSystem.get("/a")).isEqualTo(1);
    }

    @Test
    public void test2() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.createPath("/leet",1);
        fileSystem.createPath("/leet/code",2);
        assertThat(fileSystem.get("/leet/code")).isEqualTo(2);
        assertThat(fileSystem.createPath("/c/d",1)).isFalse();
        assertThat(fileSystem.get("/c")).isEqualTo(-1);
    }

    @Test
    public void test3() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.createPath("/leet",1);
        fileSystem.createPath("/leet/code",2);
        assertThat(fileSystem.get("/leet/code")).isEqualTo(2);
        assertThat(fileSystem.createPath("/c/d",1)).isFalse();
        assertThat(fileSystem.get("/c")).isEqualTo(-1);
    }


}