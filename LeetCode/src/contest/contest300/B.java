package contest.contest300;

import common.ListNode;

import java.util.Arrays;
import java.util.List;

public class B {

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        ListNode cur = head;
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(grid[i], -1);
        }
//        int curRow = 0;
//        int curCol = 0;
        int initRow = 0;
        int initCol = 0;
        while (cur != null) {
            for (int j = initCol; j < n - initCol; j++) {
                if (cur == null) {
                    return grid;
                }
                grid[initRow][j] = cur.val;
                cur = cur.next;
            }
            for (int i = initRow + 1; i < m - initRow; i++) {
                if (cur == null) {
                    return grid;
                }
                grid[i][n - initCol - 1] = cur.val;
                cur = cur.next;
            }
            for (int j = n - initCol - 1 - 1; j >= initCol; j--) {
                if (cur == null) {
                    return grid;
                }
                grid[m - initRow - 1][j] = cur.val;
                cur = cur.next;
            }
            for (int i = m - initRow - 1 - 1; i >= initRow + 1; i--) {
                if (cur == null) {
                    return grid;
                }
                grid[i][initCol] = cur.val;
                cur = cur.next;
            }
            initRow++;
            initCol++;
        }
        return grid;
    }

}
