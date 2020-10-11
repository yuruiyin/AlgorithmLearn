package contest.contest200;

/**
 * A
 *
 * @author: yry
 * @date: 2020/8/2
 */
public class C {

    private boolean isAllZeroFun(int[][] grid, int row, int fromCol, int len) {
        boolean isAllZero = true;
        for (int j = fromCol; j < len; j++) {
            if (grid[row][j] != 0) {
                isAllZero = false;
                break;
            }
        }
        return isAllZero;
    }

    private void swapRow(int[] row1, int[] row2) {
        int len = row1.length;
        for (int i = 0; i < len; i++) {
            int tmp = row1[i];
            row1[i] = row2[i];
            row2[i] = tmp;
        }
    }

    public int minSwaps(int[][] grid) {
        int len = grid.length;

        int count = 0;
        for (int i = 0; i < len - 1; i++) {
            boolean isAllZero = isAllZeroFun(grid, i, i + 1, len);
            if (isAllZero) {
                continue;
            }

            // 找到下面最近的一行对应位置都是0的
            int rowIdx = -1;
            for (int ii = i + 1; ii < len; ii++) {
                boolean tmpIsAllZero = isAllZeroFun(grid, ii, i + 1, len);
                if (tmpIsAllZero) {
                    rowIdx = ii;
                    break;
                }
            }

            if (rowIdx == -1) {
                return -1;
            }

            count += (rowIdx - i);

            for (int row = rowIdx; row > i; row--) {
                swapRow(grid[row], grid[row - 1]);
            }
        }

        return count;
    }
    
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {0,0,1},{1,1,0},{1,0,0}
        };

        System.out.print(new C().minSwaps(grid));
    }

}
