package contest.contest303;

public class B {

    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean isOk = true;
                for (int ii = 0; ii < n; ii++) {
                    if (grid[i][ii] != grid[ii][j]) {
                        isOk = false;
                        break;
                    }
                }
                if (isOk) {
                    ans++;
                }
            }
        }
        return ans;
    }

}
