package com.mygaienko.common.algorithms.leetcode.longest_absolute_file_path;

import java.util.HashMap;
import java.util.Map;

/**
 * 388. Longest Absolute File Path
 * https://leetcode.com/problems/longest-absolute-file-path/
 */
class Solution {

    private static final String NEW_LINE = "\n";
    private static final String TAB = "\t";
    private static final String EXT = ".";
    private static final char WHITE_SPACE = ' ';

    public int lengthLongestPath(String input) {
        return parseFileSystem(input)
                .getMaxLength();
    }

    private Root parseFileSystem(String input) {
        Root root = new Root();
        parseFileSystem(input, 0, root);
        return root;
    }

    private void parseFileSystem(String input, int i, Foldable foldable) {
        if (input.length() <= i) {
            return;
        }

        if (input.regionMatches(i, NEW_LINE, 0, NEW_LINE.length())) {
            parseFileSystem(input, i +NEW_LINE.length(), foldable.getRoot());
        } else if (input.regionMatches(i, TAB, 0, TAB.length())) {
            parseFileSystem(input, i+TAB.length(), foldable.getLastFoldable());
        } else {
            char c = input.charAt(i);
            if (Character.isLetterOrDigit(c) || c == WHITE_SPACE) {
                String name;
                int newLineIndex = input.indexOf(NEW_LINE, i);
                if (newLineIndex > 0) {
                    name = input.substring(i, newLineIndex);
                } else {
                    name = input.substring(i);
                }

                int newLength = foldable.getLength() + name.length();
                newLength = foldable instanceof Root ? newLength : newLength + 1;
                if (name.contains(EXT)) {
                    File file = new File(name, newLength);
                    foldable.addStorable(name, file);
                } else {
                    Folder folder = new Folder(foldable.getRoot(), name, newLength);
                    foldable.addStorable(name, folder);
                }

                parseFileSystem(input, i + name.length(), foldable);
            }
        }
    }

    static class Root extends Folder {

        int maxLength = 0;

        Root() {
            super(null, "root", 0);
        }

        public Root getRoot() {
            return this;
        }

        public int getMaxLength() {
            return maxLength;
        }

        public void setMaxLength(int maxLength) {
            this.maxLength = maxLength;
        }

    }

    static class Folder implements Storable, Foldable {
        final Root root;
        final Map<String, Storable> children = new HashMap<>();
        final String name;
        final int length;

        Foldable lastFoldable;

        Folder(Root root, String name, int length) {
            this.root = root;
            this.name = name;
            this.length = length;
        }

        public Foldable getLastFoldable() {
            return lastFoldable;
        }

        public Storable addStorable(String key, Storable storable) {
            if (storable instanceof Foldable) {
                lastFoldable = (Foldable) storable;
            } else if (storable instanceof File && storable.getLength() > getRoot().getMaxLength()) {
                getRoot().setMaxLength(storable.getLength());
            }
            return children.put(key, storable);
        }

        public Root getRoot() {
            return root;
        }

        @Override
        public int getLength() {
            return length;
        }
    }

    static class File implements Storable {
        final String name;
        final int length;

        File(String name, int length) {
            this.name = name;
            this.length = length;
        }

        public int getLength() {
            return length;
        }
    }

    interface Storable {
        int getLength();
    }

    interface Foldable {
        Foldable getLastFoldable();
        Storable addStorable(String key, Storable storable);
        Root getRoot();
        int getLength();
    }

}
