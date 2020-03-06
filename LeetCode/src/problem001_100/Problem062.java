package problem001_100;

public class Problem062 {

    private int[][] memo;
    private int m;
    private int n;

    private int backTrack(int row, int col) {
        if (row == m - 1 || col == n - 1) {
            return 1;
        }

        if (memo[row][col] != 0) {
            return memo[row][col];
        }

        // 向下和向右
        memo[row][col] = backTrack(row + 1, col) + backTrack(row, col + 1);
        return memo[row][col];
    }

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        memo = new int[m][n];
        return backTrack(0, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Problem062().uniquePaths(3, 2));
        System.out.println(new Problem062().uniquePaths(7, 3));
        System.out.println(new Problem062().uniquePaths(51, 9));
    }

}
