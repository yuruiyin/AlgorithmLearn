package doubleContest.round16;

import java.util.List;

public class Problem1301 {

    private static final int MOD = 1000000007;

    private char[][] arr;
    private int rowCount;
    private int colCount;
    private Result[][] memo;

    class Result {
        long max;
        long count;
        Result(long max, long count) {
            this.max = max;
            this.count = count;
        }
    }

    private Result backTrack(int row, int col) {
        if (row < 0 || row >= rowCount || col < 0 || col >= colCount || arr[row][col] == 'X') {
            return new Result(-1, 0);
        }

        if (row == 0 && col == 0) {
            return new Result(0, 1);
        }

        if (memo[row][col] != null) {
            return memo[row][col];
        }

        Result left = backTrack(row, col - 1);
        Result top = backTrack(row - 1, col);
        Result leftTop = backTrack(row -1, col -1);

        long max = Math.max(Math.max(left.max, top.max), leftTop.max);
        long count = 0;

        if (left.max == max) {
            count = (count + left.count) % MOD;
        }

        if (top.max == max) {
            count = (count + top.count) % MOD;
        }

        if (leftTop.max == max) {
            count = (count + leftTop.count) % MOD;
        }

        if (arr[row][col] != 'S' && max != -1) {
            memo[row][col] = new Result ((max + arr[row][col] - '0') % MOD, count);
            return memo[row][col];
        }

        memo[row][col] = new Result(max, count);
        return memo[row][col];
    }

    public int[] pathsWithMaxScore(List<String> board) {
        rowCount = board.size();
        colCount = board.get(0).length();
        arr = new char[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            arr[i] = board.get(i).toCharArray();
        }

        memo = new Result[rowCount][colCount];

        Result ans = backTrack(rowCount - 1, colCount - 1);
        if (ans.max == -1) {
            return new int[]{0, 0};
        }
        return new int[]{(int) (ans.max % MOD), (int) (ans.count % MOD)};
    }
    
}
