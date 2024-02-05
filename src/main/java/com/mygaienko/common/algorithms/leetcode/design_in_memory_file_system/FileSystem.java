package com.mygaienko.common.algorithms.leetcode.design_in_memory_file_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;

class FileSystem {

    Node root = new Node();

    public FileSystem() {

    }

    public List<String> ls(String path) {
        String[] paths = split(path);
        if (paths.length == 0) {
            return new ArrayList<>(root.dirs.keySet());
        }
        var curr = getDirOrCreate(paths, false);
        if (curr.isFile()) {
            return List.of(paths[paths.length - 1]);
        } else {
            return new ArrayList<>(curr.dirs.keySet());
        }
    }

    public void mkdir(String path) {
        getDirOrCreate(split(path), false);
    }

    public void addContentToFile(String filePath, String content) {
        String[] paths = split(filePath);
        var fileName = paths[paths.length - 1];
        var curr = getDirOrCreate(paths, true);
        Node file = curr.computeIfAbsent(fileName, v -> new Node());
        file.isFile = true;
        file.content += content;
    }

    public String readContentFromFile(String filePath) {
        String[] paths = split(filePath);
        var curr = getDirOrCreate(paths, false);
        return curr.content;
    }

    private Node getDirOrCreate(String[] splitted, boolean skiptLast) {
        var curr = root;
        var to = skiptLast ? splitted.length - 1 : splitted.length;
        for (int i = 1; i < to; i++) {
            var subPath = splitted[i];
            curr = curr.computeIfAbsent(subPath, v -> new Node());
        }
        return curr;
    }

    private String[] split(String path) {
        return path.split("/");
    }

    class Node {

        String content = "";

        boolean isFile;

        Map<String, Node> dirs = new TreeMap<>();

        public Node get(String s) {
            return dirs.get(s);
        }

        public Node computeIfAbsent(String s, Function<String, Node> f) {
            return dirs.computeIfAbsent(s, f);
        }

        public void add(String subPath, Node unit) {
            dirs.put(subPath, unit);
        }

        public boolean isFile() {
            return isFile;
        }

    }
}
