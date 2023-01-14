package contest.contest324;

import java.util.*;

public class C {

    public boolean isPossible(int n, List<List<Integer>> edges) {
        int[] degreeArr = new int[n + 1];
        Set<Long> edgeSet = new HashSet<>();
        for (List<Integer> edge: edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            degreeArr[u]++;
            degreeArr[v]++;
            edgeSet.add(u * 100001L + v);
            edgeSet.add(v * 100001L + u);
        }

        List<Integer> oddDegreeList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (degreeArr[i] % 2 == 1) {
                oddDegreeList.add(i);
            }
        }

        int size = oddDegreeList.size();
        if (size == 0) {
            return true;
        }

        if (size == 2) {
            int node1 = oddDegreeList.get(0);
            int node2 = oddDegreeList.get(1);
            if (!edgeSet.contains(node1 * 100001L + node2)) {
                return true;
            }

            for (int i = 1; i <= n; i++) {
                if (i != node1 && i != node2 && !edgeSet.contains(i * 100001L + node2) && !edgeSet.contains(i * 100001L + node1)) {
                    return true;
                }
            }

            return false;
        }

        if (size == 4) {
            // 第一个和第i个
            for (int i = 1; i <= 3; i++) {
                if (edgeSet.contains(oddDegreeList.get(0) * 100001L + oddDegreeList.get(i))) {
                    continue;
                }
                // 剩下两个
                List<Integer> leftList = new ArrayList<>();
                for (int j = 1; j <= 3; j++) {
                    if (j == i) {
                        continue;
                    }
                    leftList.add(j);
                }
                int node1 = oddDegreeList.get(leftList.get(0));
                int node2 = oddDegreeList.get(leftList.get(1));
                if (!edgeSet.contains(node1 * 100001L + node2)) {
                    return true;
                }
            }
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
