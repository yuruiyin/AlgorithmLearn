package problem801_900;

public class Problem861 {

    public int matrixScore(int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;

        // 第一列单独处理
        for (int i = 0; i < rowCount; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < colCount; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }

        // 后面每列，让每一列有更多的1即可
        for (int j = 1; j < colCount; j++) {
            int oneCount = 0;
            for (int i = 0; i < rowCount; i++) {
                if (grid[i][j] == 1) {
                    oneCount++;
                }
            }

            int zeroCount = rowCount - oneCount;
            if (oneCount >= zeroCount) {
                continue;
            }

            for (int i = 0; i < rowCount; i++) {
                grid[i][j] ^= 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < rowCount; i++) {
            int num = 0;
            for (int j = 0; j < colCount; j++) {
                num <<= 1;
                num += grid[i][j];
            }
            sum += num;
        }

        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem861().matrixScore(new int[][]{
                {0,1},
                {1,1}
        }));
    }

}
