package problem301_400;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

public class P317_1 {

    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0,0, -1, 1};

    int ansMinDistance = Integer.MAX_VALUE;

    class Node {
        int r;
        int c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return r == node.r && c == node.c;
        }

        @Override
        public int hashCode() {
            return Objects.hash(r, c);
        }
    }

    private int getDistanceSumByBfs(int[][] grid, int m, int n, int r, int c, int oneCount, Set<Node> visited) {
        LinkedList<Node> queue = new LinkedList<>();
        int level = 0;
        Node firstNode = new Node(r, c);
        queue.add(firstNode);
        visited.add(firstNode);
        int distanceSum = 0;
        int reachOneCount = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node curNode = queue.pollFirst();
                int curR = curNode.r;
                int curC = curNode.c;
                for (int j = 0; j < 4; j++) {
                    int nextR = curR + dx[j];
                    int nextC = curC + dy[j];
                    if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || grid[nextR][nextC] == 2) {
                        continue;
                    }

                    Node nextNode = new Node(nextR, nextC);
                    if (visited.contains(nextNode)) {
                        continue;
                    }

                    int nextValue = grid[nextR][nextC];
                    visited.add(nextNode);
                    if (nextValue == 0) {
                        queue.add(nextNode);
                    } else {
                        distanceSum += level;
                        reachOneCount++;
                    }
                }
            }
        }

        if (oneCount == reachOneCount) {
            return distanceSum;
        }

        return -1;
    }

    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int oneCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    oneCount++;
                }
            }
        }

        Set<Node> unableReachSet = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (unableReachSet.contains(new Node(i, j))) {
                        continue;
                    }
                    Set<Node> visited = new HashSet<>();
                    int distanceSum = getDistanceSumByBfs(grid, m, n, i, j, oneCount, visited);
                    if (distanceSum == -1) {
                        // 不能达到
                        unableReachSet.addAll(visited);
                    } else {
                        ansMinDistance = Math.min(ansMinDistance, distanceSum);
                    }
                }
            }
        }

        return ansMinDistance == Integer.MAX_VALUE ? -1 : ansMinDistance;
    }

    public static void main(String[] args) {
        System.out.println(new P317_1().shortestDistance(new int[][]{{1,0,2,0,1}, {0,0,0,0,0}, {0,0,1,0,0}}));
    }

}
