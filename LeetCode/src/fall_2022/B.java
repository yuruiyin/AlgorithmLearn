package fall_2022;

import java.util.HashSet;
import java.util.Set;

public class B {

    public int transportationHub(int[][] path) {
        int n = 1001;
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        Set<Integer> set = new HashSet<>();
        for (int[] edge: path) {
            int u = edge[0];
            int v = edge[1];
            inDegree[v]++;
            outDegree[u]++;
            set.add(u);
            set.add(v);
        }

        for (int i = 0; i <= 1000; i++) {
            if (inDegree[i] == set.size() - 1 && outDegree[i] == 0) {
                return i;
            }
        }
        return -1;
    }

}
