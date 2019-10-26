package problem1101_1200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem1146 {

    private List<Map<Integer, Integer>> snaps;
    private Map<Integer, Integer> latestSnap;

    public Problem1146(int length) {
        snaps = new ArrayList<>(length);
        latestSnap = new HashMap<>();
    }

    public void set(int index, int val) {
        latestSnap.put(index, val);
    }

    public int snap() {
        Map<Integer, Integer> wantAddSnap = new HashMap<>();
        for (Integer index: latestSnap.keySet()) {
            wantAddSnap.put(index, latestSnap.get(index));
        }
        snaps.add(wantAddSnap);

        return snaps.size() - 1;
    }

    public int get(int index, int snap_id) {
        Map<Integer, Integer> snap = snaps.get(snap_id);
        if (snap.containsKey(index)) {
            return snap.get(index);
        }

        return 0;
    }

    public static void main(String[] args) {

    }

}
