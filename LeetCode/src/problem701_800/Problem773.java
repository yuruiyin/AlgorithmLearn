package problem701_800;

import java.util.LinkedList;

public class Problem773 {

    static class Data {
        int[][] board;
        int r0;
        int c0;
        Data(int[][] board, int r0, int c0) {
            this.board = board;
            this.r0 = r0;
            this.c0 = c0;
        }
    }

    private final int[] dx = new int[]{-1, 1, 0, 0};
    private final int[] dy = new int[]{0, 0, -1, 1};

    private int convert(int[][] board) {
        int flag = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                flag *= 10;
                flag += board[i][j];
            }
        }
        return flag;
    }

    private void swap(int[][] board, int r0, int c0, int r1, int c1) {
        int t = board[r0][c0];
        board[r0][c0] = board[r1][c1];
        board[r1][c1] = t;
    }

    private int[][] copyBoard(int[][] board) {
        int[][] resBoard = new int[2][3];
        for (int i = 0; i < 2; i++) {
            System.arraycopy(board[i], 0, resBoard[i], 0, 3);
        }
        return resBoard;
    }

    private int bfs(int[][] board, int r0, int c0) {
        LinkedList<Data> queue = new LinkedList<>();
        queue.add(new Data(board, r0, c0));
        boolean[] visited = new boolean[543211];
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Data data = queue.poll();
                int[][] curBoard = data.board;
                int curR0 = data.r0;
                int curC0 = data.c0;
                int tmpFlag = convert(curBoard);
                if (tmpFlag == 123450) {
                    return ans;
                }

                if (visited[tmpFlag]) {
                    continue;
                }

                visited[tmpFlag] = true;
                for (int j = 0; j < 4; j++) {
                    int[][] tmpBoard = copyBoard(curBoard);
                    int neiR = curR0 + dx[j];
                    int neiC = curC0 + dy[j];
                    if (neiR < 0 || neiR >= 2 || neiC < 0 || neiC >= 3) {
                        continue;
                    }
                    swap(tmpBoard, curR0, curC0, neiR, neiC);
                    queue.add(new Data(tmpBoard, neiR, neiC));
                }
            }
            ans++;
        }

        return -1;
    }

    private int[] findZeroPosition(int[][] board) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // target: [[1,2,3],[4,5,0]]
    public int slidingPuzzle(int[][] board) {
        int[] position0 = findZeroPosition(board);
        return bfs(board, position0[0], position0[1]);
    }

    public static void main(String[] args) {
        System.out.println(new Problem773().slidingPuzzle(new int[][]{
                {1, 2, 3}, {4, 0, 5}
        }));
    }

}
