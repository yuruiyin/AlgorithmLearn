package contest.contest177;

import java.util.HashSet;
import java.util.Set;

public class Problem02 {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int edgeCount = 0;
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                edgeCount++;
            }

            if (rightChild[i] != -1) {
                edgeCount++;
            }
        }

        if (edgeCount != n - 1) {
            return false;
        }

        // 判断是否只有一个节点入度为0
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                visited[leftChild[i]] = true;
            }

            if (rightChild[i] != -1) {
                visited[rightChild[i]] = true;
            }
        }

        int reachCount = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                reachCount++;
            }
        }

        if (reachCount != n - 1) {
            return false;
        }

        // 判断是否存在反向平行边，如0->1,和1->0
        Set<Integer> edgeVisited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                int edge1 = i * n + leftChild[i];
                int edge2 = leftChild[i] * n + i;
                if (edgeVisited.contains(edge1) || edgeVisited.contains(edge2)) {
                    return false;
                }

                edgeVisited.add(edge1);
                edgeVisited.add(edge2);
            }

            if (rightChild[i] != -1) {
                int edge1 = i * n + rightChild[i];
                int edge2 = rightChild[i] * n + i;
                if (edgeVisited.contains(edge1) || edgeVisited.contains(edge2)) {
                    return false;
                }

                edgeVisited.add(edge1);
                edgeVisited.add(edge2);
            }
        }

        return true;
    }

}
