package problem1201_1300;

public class Problem1246_1 {

    private int[] arr;
    private int[][] memo;

    private int backTrack(int i, int j) {
        if (i == j) {
            return 1;
        }

        if (i == j - 1) {
            // 两个数字
            return arr[i] == arr[j] ? 1 : 2;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        int min = Integer.MAX_VALUE;
        if (arr[i] == arr[j]) {
            min = backTrack(i + 1, j - 1);
        }

        for (int k = i; k < j; k++) {
            min = Math.min(min, backTrack(i, k) + backTrack(k + 1, j));
        }

        memo[i][j] = min;
        return min;
    }

    public int minimumMoves(int[] arr) {
        this.arr = arr;
        int len = arr.length;
        memo = new int[len][len];
        return backTrack(0, len - 1);
    }

}
