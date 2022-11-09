package problem601_700;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class Problem646_2 {

    public int findLongestChain(int[][] pairs) {
        int len = pairs.length;
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int ansMax = 1;
        int last = pairs[0][1];
        for (int i = 1; i < len; i++) {
            if (pairs[i][0] > last) {
                last = pairs[i][1];
                ansMax++;
            }
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
        return ansMax;
    }

}
