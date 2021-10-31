package com.mygaienko.common.util;

import com.mygaienko.common.algorithms.leetcode.longest_duplicate_substring.SolutionTest;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    @SneakyThrows
    public static String readString(Class<? extends SolutionTest> aClass, String file) {
        byte[] bytes = Files.readAllBytes(Paths.get(aClass.getResource(file).toURI()));
        return new String(bytes);
    }

}
