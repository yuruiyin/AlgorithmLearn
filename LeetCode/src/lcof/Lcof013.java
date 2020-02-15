package lcof;

import java.util.LinkedList;

public class Lcof013 {

    private int[] dx = new int[]{-1, 1, 0, 0};
    private int[] dy = new int[]{0, 0, -1, 1};

    private int getNumBitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    private boolean isValid(int row, int col, int k) {
        return getNumBitSum(row) + getNumBitSum(col) <= k;
    }

    public int movingCount(int m, int n, int k) {
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int ans = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int row = node[0];
                int col = node[1];
                ans++;

                for (int j = 0; j < 4; j++) {
                    int nextRow = row + dx[j];
                    int nextCol = col + dy[j];

                    if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n ||
                            visited[nextRow][nextCol] || !isValid(nextRow, nextCol, k)) {
                        continue;
                    }

                    visited[nextRow][nextCol] = true;
                    queue.add(new int[]{nextRow, nextCol});
                }
            }
        }

        return ans;
    }

}
