package problem001_100;

import java.util.ArrayList;
import java.util.List;

public class Problem051 {

    private List<List<String>> ansList = new ArrayList<>();

    // 每行的皇后的列位置数组
    private int[] columns;
    // 标记当前列是否已经被占用
    private boolean[] columnFlag;
    // 标记右下角对角线被占用，（x, y)的差值相等，代表处于右对角线上
    private boolean[] colRowDiffFlag; // 列大于行的时候
    private boolean[] rowColDiffFlag; // 行大于列的时候
    // 标记左下角对角线被占用，（x, y)的和相等，代表处于左对角线上
    private boolean[] sumFlag;

    private List<String> getOneAns() {
        int n = columns.length;
        List<String> list = new ArrayList<>();
        for (int col: columns) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (i == col) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }

        return list;
    }

    /**
     * 回溯法求解n皇后问题，一行一行遍历
     * @param n 每行或每列的格子数
     * @param row 当前遍历到的行
     */
    private void solveNQueuesByBackTrack(int n, int row) {
        if (row == n) {
            ansList.add(getOneAns());
            return;
        }

        for (int col = 0; col < n; col++) {
            if (columnFlag[col] || sumFlag[row + col]) {
                continue;
            }

            if (col >= row && colRowDiffFlag[col - row]) {
                continue;
            }

            if (row > col && rowColDiffFlag[row - col]) {
                continue;
            }

            columns[row] = col;
            columnFlag[col] = true;
            if (col >= row) {
                colRowDiffFlag[col - row] = true;
            } else {
                rowColDiffFlag[row - col] = true;
            }
            sumFlag[row + col] = true;
            solveNQueuesByBackTrack(n, row + 1);
            columnFlag[col] = false;
            if (col >= row) {
                colRowDiffFlag[col - row] = false;
            } else {
                rowColDiffFlag[row - col] = false;
            }
            sumFlag[row + col] = false;
        }

    }

    public List<List<String>> solveNQueens(int n) {
        columns = new int[n];
        columnFlag = new boolean[n];
        colRowDiffFlag = new boolean[n];
        rowColDiffFlag = new boolean[n];
        sumFlag = new boolean[2 * n - 1];
        solveNQueuesByBackTrack(n, 0);
        return ansList;
    }

    public static void main(String[] args) {
        int n = 14;
        long start = System.currentTimeMillis();
        List<List<String>> ansList = new Problem051().solveNQueens(n);
        long end = System.currentTimeMillis();

        System.out.println("n = " + n + ", 耗时: " + (end - start) + "ms");
        
        System.out.println("有" + ansList.size() + "种解法");

//        for (List<String> list : ansList) {
//            for (String str: list) {
//                System.out.println(str + ",");
//            }
//            System.out.println();
//        }
    }

}
