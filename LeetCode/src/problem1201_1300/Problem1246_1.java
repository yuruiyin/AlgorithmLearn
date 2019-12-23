package problem1201_1300;

public class Problem1246_1 {

    private int[] arr;
    private int[][] memo;

    private int backTrack(int left, int right) {
        if (left == right) {
            return 1;
        }

        if (left == right - 1) {
            // 两个数字
            return arr[left] == arr[right] ? 1 : 2;
        }

        if (memo[left][right] != 0) {
            return memo[left][right];
        }

        if (arr[left] == arr[right]) {
            memo[left][right] = backTrack(left + 1, right - 1);
            return memo[left][right];
        }

        int min = Integer.MAX_VALUE;
        for (int k = left; k < right; k++) {
            min = Math.min(min, backTrack(left, k) + backTrack(k + 1, right));
        }

        memo[left][right] = min;
        return min;
    }

    public int minimumMoves(int[] arr) {
        this.arr = arr;
        int len = arr.length;
        memo = new int[len][len];
        return backTrack(0, len - 1);
    }

}
