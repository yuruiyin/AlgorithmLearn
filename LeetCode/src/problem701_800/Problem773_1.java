package problem701_800;

import java.util.LinkedList;

public class Problem773_1 {

    static class Data {
        int boardFlag;
        int pos0;
        Data(int boardFlag, int pos0) {
            this.boardFlag = boardFlag;
            this.pos0 = pos0;
        }
    }

    private final int[][] map = new int[][]{
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
    };

    private int convert(int[][] board) {
        int flag = 0;
        for (int i = 1; i >= 0; i--) {
            for (int j = 2; j >= 0; j--) {
                int idx = 5 - (i * 3 + j);
                flag += (board[i][j] << (idx * 3));
            }
        }
        return flag;
    }

    private int swap(int boardFlag, int pos0, int pos1) {
        pos0 *= 3;
        pos1 *= 3;
        int value0 = boardFlag & (7 << pos0);
        int value1 = boardFlag & (7 << pos1);
        return boardFlag - value0 - value1 + (value0 >>> pos0 << pos1) + (value1 >>> pos1 << pos0);
    }

    private int calcTargetBoardFlag() {
        int ansFlag = 0;
        int[] arr = new int[]{0, 5, 4, 3, 2, 1};
        for (int i = 0; i < 6; i++) {
            ansFlag += (arr[i] << (i * 3));
        }
        return ansFlag;
    }

    private int bfs(int[][] board) {
        LinkedList<Data> queue = new LinkedList<>();
        int boardFlag = convert(board);
        int pos0 = findPosition(boardFlag);
        queue.add(new Data(boardFlag, pos0));
        boolean[] visited = new boolean[1 << 18];
        int ans = 0;
        int targetBoardFlag = calcTargetBoardFlag();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Data data = queue.poll();
                int curPos0 = data.pos0;
                int tmpFlag = data.boardFlag;
                if (tmpFlag == targetBoardFlag) {
                    return ans;
                }

                if (visited[tmpFlag]) {
                    continue;
                }

                visited[tmpFlag] = true;
                int[] neighPosArr = map[curPos0];
                for (int neiPos : neighPosArr) {
                    int newBoardFlag = swap(tmpFlag, curPos0, neiPos);
                    queue.add(new Data(newBoardFlag, neiPos));
                }
            }
            ans++;
        }

        return -1;
    }

    private int findPosition(int boardFlag) {
        for (int i = 0; i < 6; i++) {
            if ((boardFlag & 7) == 0) {
                return i;
            }
            boardFlag >>>= 3;
        }
        return 0;
    }

    // target: [[1,2,3],[4,5,0]]
    public int slidingPuzzle(int[][] board) {
        return bfs(board);
    }

    public static void main(String[] args) {
        System.out.println(new Problem773_1().slidingPuzzle(new int[][]{
                {1, 2, 3}, {4, 0, 5}
        }));
    }

}
