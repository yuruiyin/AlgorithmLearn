package contest.contest175;

import java.util.HashMap;
import java.util.Map;

public class Problem04 {

    private int[][] intSeats;  // 值为1代表可做，0代表不可做
    private int rowCount;
    private int colCount;
    private Map<Long, Integer> memoMap;

    private int[] getNextPos(int row, int col) {
        if (col == colCount - 1) {
            return new int[]{row + 1, 0};
        }

        return new int[]{row, col + 1};
    }

    private long arrToLong(int row, int col) {
        long ans = 0;
        for (int j = col; j < colCount; j++) {
            ans += intSeats[row][j];
            ans <<= 1L;
        }

        for (int i = row + 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                ans += intSeats[i][j];
                ans <<= 1L;
            }
        }

        return ans;
    }

    private int backTrack(int row, int col) {
        if (row == rowCount) {
            return 0;
        }

        long key = arrToLong(row, col);
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int[] nextPos = getNextPos(row, col);

        if (intSeats[row][col] == 0) {
            int res = backTrack(nextPos[0], nextPos[1]);
            memoMap.put(key, res);
            return res;
        }

        // 两种选择，坐或不坐

        // 不坐
        int notSeatRes = backTrack(nextPos[0], nextPos[1]);

        // 坐
        // 右下
        int oldSeat1 = 1;
        if (row + 1 < rowCount && col + 1 < colCount) {
            oldSeat1 = intSeats[row + 1][col + 1];
            intSeats[row + 1][col + 1] = 0;
        }

        // 左下
        int oldSeat2 = 1;
        if (row + 1 < rowCount && col - 1 >= 0) {
            oldSeat2 = intSeats[row + 1][col - 1];
            intSeats[row + 1][col - 1] = 0;
        }

        // 右
        int oldSeat3 = 1;
        if (col + 1 < colCount) {
            oldSeat3 = intSeats[row][col + 1];
            intSeats[row][col + 1] = 0;
        }

        int seatRes = backTrack(nextPos[0], nextPos[1]) + 1;

        // 右下
        if (row + 1 < rowCount && col + 1 < colCount) {
            intSeats[row + 1][col + 1] = oldSeat1;
        }

        // 左下
        if (row + 1 < rowCount && col - 1 >= 0) {
            intSeats[row + 1][col - 1] = oldSeat2;
        }

        // 右
        if (col + 1 < colCount) {
            intSeats[row][col + 1] = oldSeat3;
        }

        int max = Math.max(notSeatRes, seatRes);
        memoMap.put(key, max);
        return max;
    }

    public int maxStudents(char[][] seats) {
        rowCount = seats.length;
        colCount= seats[0].length;

        intSeats = new int[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                intSeats[i][j] = seats[i][j] == '.' ? 1 : 0;
            }
        }

        memoMap = new HashMap<>();
        return backTrack(0, 0);
    }

}
