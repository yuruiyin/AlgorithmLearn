package problem1101_1200;

import java.util.*;

public class Problem1102_1 {

    class Node {
        int row;
        int col;
        int prevMin;
        Node(int row, int col, int prevMin) {
            this.row = row;
            this.col = col;
            this.prevMin = prevMin;
        }
    }

    class Index {
        int row;
        int col;
        Index(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }

            if (!(obj instanceof Index)) {
                return false;
            }

            Index index = (Index) obj;

            return this.row == index.row && this.col == index.col;
        }

        @Override
        public int hashCode() {
            return row * 31 + col;
        }
    }

    // BFS
    public int maximumMinimumPath(int[][] arr) {
        int rowCount = arr.length;
        int colCount = arr[0].length;
        LinkedList<Node> queue = new LinkedList<>();
        queue.addLast(new Node(0, 0, arr[0][0]));
        int[][] prevMinArr = new int[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                prevMinArr[i][j] = -1;
            }
        }

        prevMinArr[0][0] = arr[0][0];

        while (!queue.isEmpty()) {
            List<Node> nodeList = new ArrayList<>();
            while (!queue.isEmpty()) {
                nodeList.add(queue.removeFirst());
            }

            if (nodeList.size() == 1 && nodeList.get(0).row == rowCount - 1 && nodeList.get(0).col == colCount - 1) {
                return nodeList.get(0).prevMin;
            }

            Set<Index> wantAddIndexSet = new HashSet<>();
            for (Node node : nodeList) {
                int row = node.row;
                int col = node.col;
                int prevMin = node.prevMin;
                if (col < colCount - 1) {
                    // 可以往右
                    wantAddIndexSet.add(new Index(row, col+1));
                    if (prevMinArr[row][col+1] == -1) {
                        prevMinArr[row][col+1] = Math.min(prevMin, arr[row][col+1]);
                    } else {
                        int min = Math.min(prevMin, arr[row][col+1]);
                        prevMinArr[row][col+1] = Math.max(prevMinArr[row][col+1], min);
                    }
                }

                if (row < rowCount - 1) {
                    // 可以往下
                    wantAddIndexSet.add(new Index(row+1, col));
                    if (prevMinArr[row+1][col] == -1) {
                        prevMinArr[row+1][col] = Math.min(prevMin, arr[row+1][col]);
                    } else {
                        int min = Math.min(prevMin, arr[row+1][col]);
                        prevMinArr[row+1][col] = Math.max(prevMinArr[row+1][col], min);
                    }
                }
            }

            for (Index index: wantAddIndexSet) {
                int row = index.row;
                int col = index.col;
                queue.addLast(new Node(row, col, prevMinArr[row][col]));
            }

        }

        return -1;
    }
    
    public static void main(String[] args) {

    }
    
}
