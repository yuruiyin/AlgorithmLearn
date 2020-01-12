package contest.contest171;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem03 {

    public int makeConnected(int n, int[][] connections) {
        int edgeCount = connections.length;
        if (edgeCount < n - 1) {
            return -1;
        }

        List<Integer>[] treeArr = new ArrayList[n];

        for (int[] con : connections) {
            int node1 = con[0];
            int node2 = con[1];
            List<Integer> tree1 = treeArr[node1];
            List<Integer> tree2 = treeArr[node2];

            if (tree1 != null && tree2 != null) {
                if (tree1 == tree2) {
                    continue;
                }

                tree1.addAll(tree2);
                for (Integer node : tree2) {
                    treeArr[node] = tree1;
                }
            } else if (tree1 != null) {
                tree1.add(node2);
                treeArr[node2] = tree1;
            } else if (tree2 != null) {
                tree2.add(node1);
                treeArr[node1] = tree2;
            } else {
                List<Integer> tree = new ArrayList<>();
                tree.add(node1);
                tree.add(node2);
                treeArr[node1] = tree;
                treeArr[node2] = tree;
            }
        }

        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (treeArr[i] == null) {
                treeArr[i] = new ArrayList<>();
                treeArr[i].add(i);
            }
        }

        for (int i = 0; i < n; i++) {
            set.add(treeArr[i]);
        }

        return set.size() - 1;
    }

}
