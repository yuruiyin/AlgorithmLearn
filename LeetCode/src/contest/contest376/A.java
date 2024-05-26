package contest.contest376;

public class A {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] ans = new int[2];
        boolean[] visited = new boolean[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[grid[i][j]]) {
                    ans[0] = grid[i][j];
                }
                visited[grid[i][j]] = true;
            }
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                ans[1] = i;
                break;
            }
        }

        return ans;
    }

}
