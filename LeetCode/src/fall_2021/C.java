package fall_2021;

/**
 * A
 *
 * @author: yry
 * @date: 2021/9/11
 */
public class C {

    private int rowCount;
    private int colCount;

    private boolean isChanged(char[][] grid, int row, int col) {
        // 上
        boolean isChange = false;
        for (int i = row - 1; i >= 0; i--) {
            if (grid[i][col] != 'O') {
                if (grid[i][col] == 'X') {
                    for (int ii = i + 1; ii <= row - 1; ii++) {
                        isChange = true;
                        grid[ii][col] = 'X';
                    }
                }
                break;
            }
        }

        // 下
        for (int i = row + 1; i < rowCount; i++) {
            if (grid[i][col] != 'O') {
                if (grid[i][col] == 'X') {
                    for (int ii = i - 1; ii >= row + 1; ii--) {
                        isChange = true;
                        grid[ii][col] = 'X';
                    }
                }
                break;
            }
        }

        // 左
        for (int j = col - 1; j >= 0; j--) {
            if (grid[row][j] != 'O') {
                if (grid[row][j] == 'X') {
                    for (int jj = j + 1; jj <= col - 1; jj++) {
                        isChange = true;
                        grid[row][jj] = 'X';
                    }
                }
                break;
            }
        }

        // 右
        for (int j = col + 1; j < colCount; j++) {
            if (grid[row][j] != 'O') {
                if (grid[row][j] == 'X') {
                    for (int jj = j - 1; jj >= col + 1; jj--) {
                        isChange = true;
                        grid[row][jj] = 'X';
                    }
                }
                break;
            }
        }

        // 对角线
        for (int offsetX = -1; offsetX <= 1 ;offsetX += 2) {
            for (int offsetY = -1; offsetY <= 1; offsetY += 2) {
                for (int n = 1; ; n++) {
                    int curRow = row + n * offsetX;
                    int curCol = col + n * offsetY;
                    if (curRow < 0 || curRow >= rowCount || curCol < 0 || curCol >= colCount) {
                        break;
                    }

                    if (grid[curRow][curCol] != 'O') {
                        if (grid[curRow][curCol] == 'X') {
                            for (int nn = n - 1; nn >= 1; nn--) {
                                isChange = true;
                                int curRow1 = row + nn * offsetX;
                                int curCol1 = col + nn * offsetY;
                                grid[curRow1][curCol1] = 'X';
                            }
                        }
                        break;
                    }
                }
            }
        }

        return isChange;
    }

    private int getWhiteCount(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 'O') {
                    ans++;
                }
            }
        }
        return ans;
    }

    private int rec(char[][] grid) {
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == 'X') {
                    boolean isChanged = isChanged(grid, i , j);
                    if (!isChanged) {
                        continue;
                    }

                    return rec(grid);
                }
            }
        }

        return getWhiteCount(grid);
    }

    private char[][] copy(char[][] grid) {
        char[][] copyGrid = new char[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                copyGrid[i][j] = grid[i][j];
            }
        }
        return copyGrid;
    }

    public int flipChess(String[] chessboard) {
        rowCount = chessboard.length;
        colCount = chessboard[0].length();
        char[][] grid = new char[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            grid[i] = chessboard[i].toCharArray();
        }

        int initWhiteCount = getWhiteCount(grid);

        int ansMax = 0;
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                if (grid[i][j] == '.') {
                    char[][] copyGrid = copy(grid);
                    copyGrid[i][j] = 'X';
                    int whiteCount = rec(copyGrid);
                    ansMax = Math.max(ansMax, initWhiteCount - whiteCount);
                }
            }
        }
        return ansMax;
    }
    
    public static void main(String[] args) {
        System.out.println(new C().flipChess(new String[]{
                "....X.","....X.","XOOO..","......","......"
        }));
    }

}
