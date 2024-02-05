package com.mygaienko.common.algorithms.leetcode.design_in_memory_file_system;


import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class FileSystemTest {

    @Test
    public void test() {
        var fileSystem = new FileSystem();
        assertThat(fileSystem.ls("/")).isEmpty();
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        assertThat(fileSystem.ls("/a/b/c")).containsExactly("d");
    }

    @Test
    public void test2() {
        var fileSystem = new FileSystem();
        fileSystem.mkdir("/a/b/c");
        fileSystem.addContentToFile("/a/b/c/d", "hello");
        var actual = fileSystem.readContentFromFile("/a/b/c/d");
        assertThat(actual).isEqualTo("hello");
    }

    /**
     * ["FileSystem",   "mkdir",        "ls",   "ls",           "mkdir",   "ls",    "ls",   "addContentToFile",     "readContentFromFile",  "ls",       "readContentFromFile"]
     * <p>
     * [[],             ["/zijzllb"],   ["/"],  ["/zijzllb"],   ["/r"],     ["/"],  ["/r"], ["/zijzllb/hfktg","d"], ["/zijzllb/hfktg"],     ["/"],      ["/zijzllb/hfktg"]]
     * <p>
     * [null,           null,           ["zijzllb"],    [],     null,    ["r","zijzllb"],[],    null,               "d",                    ["r","zijzllb"],    "d"]
     */
    @Test
    public void test10() {
        var fileSystem = new FileSystem();
        fileSystem.mkdir("/zijzllb");
        assertThat(fileSystem.ls("/")).containsExactly("zijzllb");
        assertThat(fileSystem.ls("/zijzllb")).isEmpty();

        fileSystem.mkdir("/r");
        assertThat(fileSystem.ls("/")).containsExactly("r", "zijzllb");
        assertThat(fileSystem.ls("/r")).isEmpty();

        fileSystem.addContentToFile("/zijzllb/hfktg", "d");
        assertThat(fileSystem.readContentFromFile("/zijzllb/hfktg")).isEqualTo("d");

        assertThat(fileSystem.ls("/")).containsExactly("r", "zijzllb");
        assertThat(fileSystem.readContentFromFile("/zijzllb/hfktg")).contains("d");
    }

    /**
     * ["FileSystem",   "mkdir",        "ls",           "ls",   "mkdir",    "ls",   "ls",   "addContentToFile",         "ls",       "ls",       "ls"]
     * <p>
     * [[],             ["/goowmfn"],   ["/goowmfn"],   ["/"],  ["/z"],     ["/"],  ["/"],  ["/goowmfn/c","shetopcy"],  ["/z"], ["/goowmfn/c"],["/goowmfn"]]
     */
    @Test
    public void test11() {
        var fileSystem = new FileSystem();
        fileSystem.mkdir("/goowmfn");
        assertThat(fileSystem.ls("/goowmfn")).isEmpty();
        assertThat(fileSystem.ls("/")).containsExactly("goowmfn");

        fileSystem.mkdir("/z");
        assertThat(fileSystem.ls("/")).containsExactly("goowmfn", "z");
        assertThat(fileSystem.ls("/")).containsExactly("goowmfn", "z");

        fileSystem.addContentToFile("/goowmfn/c", "shetopcy");
        assertThat(fileSystem.ls("/z")).isEmpty();
        assertThat(fileSystem.ls("/goowmfn/c")).containsExactly("c");
        assertThat(fileSystem.ls("/goowmfn")).containsExactly("c");
    }

}