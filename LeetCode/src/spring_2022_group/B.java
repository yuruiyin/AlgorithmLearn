package spring_2022_group;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class B {

    private int endRow;
    private int endCol;
    private char[][] grid;
    private int rowCount;
    private int colCount;
    private final int[] dx = new int[]{-1, 1, 0, 0};
    private final int[] dy = new int[]{0, 0, -1, 1};

    private int[] getNextPos(char direction, int row, int col) {
        // "^","v","<",">"
        if (direction == '<') {
            return new int[]{row, col - 1};
        } else if (direction == '>') {
            return new int[]{row, col + 1};
        } else if (direction == '^') {
            return new int[]{row - 1, col};
        } else {
            return new int[]{row + 1, col};
        }
    }

    static class Node {
        int row;
        int col;
        int changeCount;

        Node(int row, int col, int changeCount) {
            this.row = row;
            this.col = col;
            this.changeCount = changeCount;
        }
    }

    private int bfs(int row, int col) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col, 0));
        Map<Integer, Integer> minChangeMap = new HashMap<>();
        minChangeMap.put(row * 100 + col, 0);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.pollFirst();
                int curRow = node.row;
                int curCol = node.col;
                int[] nextPos = getNextPos(grid[curRow][curCol], curRow, curCol);
                for (int j = 0; j < 4; j++) {
                    int nextRow = curRow + dx[j];
                    int nextCol = curCol + dy[j];
                    if (nextRow < 0 || nextCol < 0 || nextRow >= rowCount || nextCol >= colCount) {
                        continue;
                    }

                    int offset = 1;
                    if (nextRow == nextPos[0] && nextCol == nextPos[1]) {
                        offset = 0;
                    }
                    int nextChangeCount = node.changeCount + offset;

                    int key = nextRow * 100 + nextCol;
                    if (minChangeMap.containsKey(key)) {
                        if (nextChangeCount >= minChangeMap.get(key)) {
                            continue;
                        }
                    }
                    minChangeMap.put(key, nextChangeCount);
                    queue.add(new Node(nextRow, nextCol, nextChangeCount));
                }
            }
        }

        return minChangeMap.get(endRow * 100 + endCol);
    }

    public int conveyorBelt(String[] matrix, int[] start, int[] end) {
        this.endRow = end[0];
        this.endCol = end[1];
        this.rowCount = matrix.length;
        this.colCount = matrix[0].length();
        grid = new char[rowCount][colCount];
        for (int i = 0; i < matrix.length; i++) {
            grid[i] = matrix[i].toCharArray();
        }
        return bfs(start[0], start[1]);
    }

    public static void main(String[] args) {
        System.out.println(new B().conveyorBelt(new String[]{">>v", "v^<", "<><"}, new int[]{0, 1}, new int[]{2, 0}));
        System.out.println("hello world");
    }

}
