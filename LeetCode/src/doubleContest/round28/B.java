package doubleContest.round28;

/**
 * B
 *
 * @author: yry
 * @date: 2020/6/13
 */
public class B {

    class SubrectangleQueries {

        private int[][] grid;
        private int m;
        private int n;

        public SubrectangleQueries(int[][] rectangle) {
            grid = rectangle;
            this.m = grid.length;
            this.n = grid[0].length;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    grid[i][j] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return grid[row][col];
        }
    }

}
