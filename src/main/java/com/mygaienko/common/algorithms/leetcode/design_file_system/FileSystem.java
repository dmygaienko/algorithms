package com.mygaienko.common.algorithms.leetcode.design_file_system;

import java.util.HashMap;
import java.util.Map;

class FileSystem extends Folder {

    public FileSystem() {
    }

}

class Folder {

    static final int NOT_FOUND = -1;
    int value;
    final Map<String, Folder> folders = new HashMap<>();

    Folder(int value) {
        this.value = value;
    }

    Folder() {
        value = NOT_FOUND;
    }

    public boolean createPath(String path, int value) {
        int startingSlashIndex = path.indexOf("/");
        if (startingSlashIndex != 0) return false;
        int nextSlashIndex = path.indexOf("/", 1);
        if (nextSlashIndex == NOT_FOUND) {
            if (path.length() == 1) return false;
            String subPath = path.substring(1);
            boolean exist = folders.get(subPath) != null;
            if (exist) return false;
            folders.put(subPath, new Folder(value));
            return true;
        } else {
            String subPath = path.substring(1, nextSlashIndex);
            Folder folder = folders.get(subPath);
            if (folder == null) return false;
            return folder.createPath(path.substring(nextSlashIndex), value);
        }
    }

    public int get(String path) {
        int startingSlashIndex = path.indexOf("/");
        if (startingSlashIndex != 0) return NOT_FOUND;
        int nextSlashIndex = path.indexOf("/", 1);
        if (nextSlashIndex == NOT_FOUND) {
            if (path.length() == 1) return NOT_FOUND;
            Folder folder = folders.get(path.substring(1));
            return folder != null ? folder.value : NOT_FOUND;
        } else {
            Folder folder = folders.get(path.substring(1, nextSlashIndex));
            return folder != null ? folder.get(path.substring(nextSlashIndex)) : NOT_FOUND;
        }
    }
    
}