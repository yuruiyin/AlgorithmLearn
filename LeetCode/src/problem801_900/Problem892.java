package problem801_900;

public class Problem892 {

    public int surfaceArea(int[][] grid) {
        int n = grid.length;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            // 6 * grid[0][0] - 2 * (grid[0][0] - 1)
            return 4 * grid[0][0] + 2;
        }

        // 先不考虑每个网格柱子之间的的重叠
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum += grid[i][j] == 0 ? 0 : (4 * grid[i][j] + 2);
            }
        }

        // 看左边和上边是否有重合, 有重合则减2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != 0) {
                    // 看上边的网格
                    sum -= 2 * Math.min(grid[i][j], grid[i-1][j]);
                }

                if (j != 0) {
                    sum -= 2 * Math.min(grid[i][j], grid[i][j-1]);
                }
            }
        }

        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem892().surfaceArea(new int[][]{
                {2}
        }));

        System.out.println(new Problem892().surfaceArea(new int[][]{
                {1,2},
                {3,4}
        }));

        System.out.println(new Problem892().surfaceArea(new int[][]{
                {1,0},
                {0,2}
        }));

        System.out.println(new Problem892().surfaceArea(new int[][]{
                {1,1,1},
                {1,0,1},
                {1,1,1}
        }));

        System.out.println(new Problem892().surfaceArea(new int[][]{
                {2,2,2},
                {2,1,2},
                {2,2,2}
        }));
    }
    
}
