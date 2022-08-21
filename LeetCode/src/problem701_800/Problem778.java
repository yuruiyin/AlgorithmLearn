package problem701_800;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Problem778 {

    class Node {
        int maxValue;
        int row;
        int col;
        Node(int maxValue, int row, int col) {
            this.maxValue = maxValue;
            this.row = row;
            this.col = col;
        }
    }

    public int swimInWater(int[][] grid) {
        // bfs + 优先队列
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int[][] valueArr = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            Arrays.fill(valueArr[i], Integer.MAX_VALUE);
        }
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        PriorityQueue<Node> heap = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.maxValue - o2.maxValue;
            }
        });
        valueArr[0][0] = grid[0][0];

        heap.add(new Node(grid[0][0], 0, 0));
        while (!heap.isEmpty()) {
            int size = heap.size();
            for (int i = 0; i < size; i++) {
                Node top = heap.poll();
                int curValue = top.maxValue;
                int curRow = top.row;
                int curCol = top.col;
                for (int j = 0; j < 4; j++) {
                    int nextRow = curRow + dx[j];
                    int nextCol = curCol + dy[j];
                    if (nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount) {
                        continue;
                    }

                    int nextValue = Math.max(curValue, grid[nextRow][nextCol]);
                    if (nextValue >= valueArr[nextRow][nextCol]) {
                        continue;
                    }

                    valueArr[nextRow][nextCol] = nextValue;
                    heap.add(new Node(nextValue, nextRow, nextCol));
                }
            }
        }

        return valueArr[rowCount - 1][colCount - 1];
    }

}
