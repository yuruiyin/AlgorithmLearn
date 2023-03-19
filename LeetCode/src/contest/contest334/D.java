package contest.contest334;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class D {

    class Node {
        int x;
        int y;
        long cost;

        Node(int x, int y, long cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    private long calcCost(long curCost, long nextGridValue, boolean isStart) {
        curCost++;
        if (nextGridValue <= curCost) {
            return curCost;
        }

        if (isStart) {
            return -1;
        }

        if ((nextGridValue - curCost) % 2 == 0) {
            return nextGridValue;
        }

        return nextGridValue + 1;
    }

    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        PriorityQueue<Node> heap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Long.compare(o1.cost, o2.cost);
            }
        });

        heap.add(new Node(0, 0, 0));

        boolean[][] visited = new boolean[m][n];
        long[][] minValue = new long[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(minValue[i], Long.MAX_VALUE);
        }

        while (!heap.isEmpty()) {
            Node node = heap.poll();
            if (visited[node.x][node.y]) {
                continue;
            }
            visited[node.x][node.y] = true;
            for (int j = 0; j < 4; j++) {
                int nextX = node.x + dx[j];
                int nextY = node.y + dy[j];
                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                    continue;
                }
                boolean isStart = node.x == 0 && node.y == 0;
                long nextCost = calcCost(node.cost, grid[nextX][nextY], isStart);
                if (nextCost == -1) {
                    continue;
                }
                if (nextCost >= minValue[nextX][nextY]) {
                    continue;
                }
                minValue[nextX][nextY] = nextCost;
                heap.add(new Node(nextX, nextY, nextCost));
            }
        }

        return minValue[m - 1][n - 1] == Long.MAX_VALUE ? -1 : (int) minValue[m - 1][n - 1];
    }

}
