package doubleContest.round78;

import kotlin.Pair;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class D {

    /**
     * TLE
     */
    public int largestVariance(String s) {
        char[] arr = s.toCharArray();
        int len = arr.length;
        int ansMax = 0;
        for (int i = 0; i < len; i++) {
            int[][] map = new int[26][2];
            TreeSet<int[]> treeSet = new TreeSet<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
                }
            });
            int[] data = new int[]{arr[i], 1};
            map[arr[i] - 'a'] = data;
            treeSet.add(data);
            for (int j = i + 1; j < len; j++) {
                if (map[arr[j] - 'a'] != null) {
                    treeSet.remove(map[arr[j] - 'a']);
                    map[arr[j] - 'a'][1]++;
                    treeSet.add(map[arr[j] - 'a']);
                } else {
//                    System.out.println("map[arr[j] - 'a'] == null");
                    int[] tmp = new int[]{arr[j], 1};
                    map[arr[j] - 'a'] = tmp;
                    treeSet.add(tmp);
                }
                ansMax = Math.max(ansMax, treeSet.last()[1] - treeSet.first()[1]);
            }
        }
        return ansMax;
    }

    public static void main(String[] args) {
//        System.out.println(new D().largestVariance("aababbb"));
        System.out.println(new D().largestVariance("lripaa"));
    }

}
