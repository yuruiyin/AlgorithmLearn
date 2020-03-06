package problem001_100;

public class Problem052_2 {

    // N皇后问题的解法数
    private int ansSum = 0;
    private int n;

    /**
     * 回溯法求解n皇后问题，一行一行遍历
     * @param row 当前行内
     * @param colUsed 列是否使用标识
     * @param sumUsed 撇是否使用标识
     * @param diffUsed 捺是否使用标识
     */
    private void backTrack(int row, int colUsed, int sumUsed, int diffUsed) {
        if (row == n) {
            ansSum++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int oneMoveCol = 1 << col;
            int oneMoveSum = 1 << (row + col);
            int oneMoveDiff = 1 << (row - col + n);

            if ((colUsed & oneMoveCol) != 0 || (sumUsed & oneMoveSum) != 0 || (diffUsed & oneMoveDiff) != 0) {
                continue;
            }

            backTrack(row + 1, colUsed ^ oneMoveCol, sumUsed ^ oneMoveSum, diffUsed ^ oneMoveDiff);
        }

    }

    public int totalNQueens(int n) {
        this.n = n;
        backTrack( 0, 0, 0, 0);
        return ansSum;
    }

    public static void main(String[] args) {
        int n = 15;
        long start = System.currentTimeMillis();
        System.out.println(new Problem052_2().totalNQueens(n));
        long end = System.currentTimeMillis();
        System.out.println("n = " + n + ", 耗时: " + (end - start) + "ms");
    }

}
