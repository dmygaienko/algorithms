package com.mygaienko.common.algorithms.leetcode.snapshot_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class SnapshotArray {

    int SNAP_OPT = 5;
    int snap_id = 0;
    Map<Integer, int[]> snapshots = new HashMap<>();
    Map<Integer, Map<Integer, Integer>> compactSnapshots = new HashMap<>();

    public SnapshotArray(int length) {
        snapshots.put(snap_id, new int[length]);
    }

    public void set(int index, int val) {
       if (isOriginal(snap_id)) {
           snapshots.get(snap_id)[index] = val;
       } else {
           compactSnapshots.get(snap_id).put(index, val);
       }
    }

    public int snap() {
        ++snap_id;
        if (isOriginal(snap_id)) {
            buildSnapshot();
        } else {
            compactSnapshots.put(snap_id, new HashMap<>());
        }
        return snap_id - 1;
    }

    public boolean isOriginal(int snapId) {
        return snapId % SNAP_OPT == 0;
    }

    public int get(int index, int snap_id) {
        if (isOriginal(snap_id)) {
            return snapshots.get(snap_id)[index];
        } else {
            int localSnapId = snap_id;
            while (!isOriginal(localSnapId)) {
                Integer value = compactSnapshots.get(localSnapId).get(index);
                if (value != null) return value;
                localSnapId--;
            }
            return snapshots.get(localSnapId)[index];
        }
    }

    private void buildSnapshot() {
        int prevSnapId = snap_id - SNAP_OPT;
        int[] prevOriginalArray = snapshots.get(prevSnapId);
        int[] newArray = Arrays.copyOf(prevOriginalArray, prevOriginalArray.length);
        snapshots.put(snap_id, newArray);

        int localSnapId = prevSnapId + 1;
        while (localSnapId != snap_id) {
            Map<Integer, Integer> compactSnapshot = compactSnapshots.get(localSnapId);
            for (Entry<Integer, Integer> entry : compactSnapshot.entrySet()) {
                newArray[entry.getKey()] = entry.getValue();
            }
            localSnapId++;
        }
    }

}
