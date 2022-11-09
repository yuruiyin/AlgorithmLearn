package contest.contest310;

import utils.TreeMultiSet;

import java.util.Arrays;
import java.util.Comparator;

public class C {

    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int len = intervals.length;
        TreeMultiSet<Integer> treeMultiSet = new TreeMultiSet<>();
        treeMultiSet.add(intervals[0][1]);
        int ans = 1;
        for (int i = 1; i < len; i++) {
            int minEnd = treeMultiSet.first();
            int s = intervals[i][0];
            int e = intervals[i][1];
            if (s <= minEnd) {
                treeMultiSet.add(e);
            } else {
                treeMultiSet.pollFirst();
                treeMultiSet.add(e);
            }
        }
        return treeMultiSet.size();
    }

}
