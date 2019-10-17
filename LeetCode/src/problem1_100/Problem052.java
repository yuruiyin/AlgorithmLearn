package problem1_100;

public class Problem052 {

    // N皇后问题的解法数
    private int ansSum = 0;

    // 标记当前列是否已经被占用
    private boolean[] columnFlag;
    // 标记右下角对角线被占用，（x, y)的差值相等，代表处于右对角线上
    private boolean[] colRowDiffFlag; // 列大于行的时候
    private boolean[] rowColDiffFlag; // 行大于列的时候
    // 标记左下角对角线被占用，（x, y)的和相等，代表处于左对角线上
    private boolean[] sumFlag;

    /**
     * 回溯法求解n皇后问题，一行一行遍历
     * @param n 每行或每列的格子数
     * @param row 当前遍历到的行
     */
    private void solveNQueuesByBackTrack(int n, int row) {
        if (row == n) {
            ansSum++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int rowColSum = row + col;
            if (columnFlag[col] || sumFlag[rowColSum]) {
                continue;
            }

            int colRowDiff = col - row;
            if (col >= row && colRowDiffFlag[colRowDiff]) {
                continue;
            }

            int rowColDiff = row - col;
            if (row > col && rowColDiffFlag[rowColDiff]) {
                continue;
            }

            columnFlag[col] = true;
            if (col >= row) {
                colRowDiffFlag[colRowDiff] = true;
            } else {
                rowColDiffFlag[rowColDiff] = true;
            }
            sumFlag[rowColSum] = true;
            solveNQueuesByBackTrack(n, row + 1);
            columnFlag[col] = false;
            if (col >= row) {
                colRowDiffFlag[colRowDiff] = false;
            } else {
                rowColDiffFlag[rowColDiff] = false;
            }
            sumFlag[rowColSum] = false;
        }

    }

    public int totalNQueens(int n) {
        columnFlag = new boolean[n];
        colRowDiffFlag = new boolean[n];
        rowColDiffFlag = new boolean[n];
        sumFlag = new boolean[2 * n - 1];
        solveNQueuesByBackTrack(n, 0);
        return ansSum;
    }
    
    public static void main(String[] args) {
        int n = 15;
        long start = System.currentTimeMillis();
        System.out.println(new Problem052().totalNQueens(n));
        long end = System.currentTimeMillis();
        System.out.println("n = " + n + ", 耗时: " + (end - start) + "ms");
    }
    
}
