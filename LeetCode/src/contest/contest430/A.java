package contest.contest430;

public class A {

    public int minimumOperations(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 1; i < m; i++) {
                int newValue = Math.max(0, grid[i-1][j] - grid[i][j] + 1);
                grid[i][j] += newValue;
                ans += newValue;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

}
