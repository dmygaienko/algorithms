package com.mygaienko.common.util;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

    @SneakyThrows
    public static String readString(Class<?> aClass, String file) {
        byte[] bytes = Files.readAllBytes(Paths.get(aClass.getResource(file).toURI()));
        return new String(bytes);
    }

}
