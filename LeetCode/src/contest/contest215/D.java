package contest.contest215;

import java.util.HashMap;
import java.util.Map;

/**
 * A
 *
 * @author: yry
 * @date: 2020/11/15
 */
public class D {

    private int m;
    private int n;

    private Map<Long, Integer> memoMap;

    private int[] getNextRows(int col, int preRow, int curRow, int type) {
        int newPreRow, newCurRow;
        if (col == n - 1) {
            newPreRow = curRow * 10 + type;
            newCurRow = 0;
        } else {
            newPreRow = preRow;
            newCurRow = curRow * 10 + type;
        }
        return new int[]{newPreRow, newCurRow};
    }

    private int[] getNextPos(int row, int col) {
        if (col < n - 1) {
            return new int[]{row, col + 1};
        }
        return new int[]{row + 1, 0};
    }

    private int getValue(int row, int col, int preRow, int curRow, int pow, int type) {
        int pow1 = pow / 10;
        int preRowColValue = preRow / pow1 % 10;
        int neighborCount = 0;
        if (col > 0 && curRow % 10 != 1) {
            neighborCount++;
        }

        if (row > 0 && preRowColValue != 1) {
            neighborCount++;
        }

        int value = type == 2 ? 120 - neighborCount * 30 : 40 + neighborCount * 20;
        if (row - 1 >= 0) {
            if (preRowColValue == 2) {
                value -= 30;
            } else if (preRowColValue == 3) {
                value += 20;
            }
        }

        if (col - 1 >= 0) {
            if (curRow % 10 == 2) {
                value -= 30;
            } else if (curRow % 10 == 3)  {
                value += 20;
            }
        }

        return value;
    }

    private int dfs(int row, int col, int inCount, int exCount, int preRow, int curRow) {
        if (inCount == 0 && exCount == 0 || row >= m) {
            return 0;
        }

        long pow = (long) Math.pow(10, n - col);
        long tmp = curRow * pow + preRow % pow;
        long key = row + col * 10 + inCount * 100 + exCount * 1000 + tmp * 1000L * 100000L;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        // 三种选择
        // 不放
        int ansMax = 0;
        int[] nextPos = getNextPos(row, col);
        int[] newRows = getNextRows(col, preRow, curRow, 1);
        ansMax = Math.max(ansMax, dfs(nextPos[0], nextPos[1], inCount, exCount, newRows[0], newRows[1]));

        // 放内向
        if (inCount > 0) {
            newRows = getNextRows(col, preRow, curRow, 2);
            int value = getValue(row, col, preRow, curRow, (int) pow, 2);
            ansMax = Math.max(ansMax, dfs(nextPos[0], nextPos[1], inCount - 1, exCount, newRows[0], newRows[1]) + value);
        }

        // 放外向
        if (exCount > 0) {
            newRows = getNextRows(col, preRow, curRow, 3);
            int value = getValue(row, col, preRow, curRow, (int) pow, 3);
            ansMax = Math.max(ansMax, dfs(nextPos[0], nextPos[1], inCount, exCount - 1, newRows[0], newRows[1]) + value);
        }

        memoMap.put(key, ansMax);
        return ansMax;
    }

    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        // 全排列暴力枚举
        this.m = m;
        this.n = n;
        memoMap = new HashMap<>();
        return dfs(0, 0, introvertsCount, extrovertsCount, 0, 0);
    }
    
    public static void main(String[] args) {
        System.out.println(new D().getMaxGridHappiness(5, 4, 6, 3));
    }

}
