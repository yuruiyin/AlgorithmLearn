package problem901_1000;


// 思路：思考保留列的最大值，就是删除列的最小值
public class Problem960 {

    private char[][] grid;
    private int rowCount;
    private int colCount;
    private Integer[][] memo;

    private int dp(int curCol, int preCol) {
        if (curCol == colCount) {
            return 0;
        }

        if (memo[curCol][preCol] != null) {
            return memo[curCol][preCol];
        }

        // 每一列都有两种情况，保留或不保留，但是保留也要看能不能保留，跟preCol有关系
        boolean canSave = true;
        if (preCol != 0) {
            for (int i = 0; i < rowCount; i++) {
                if (grid[i][curCol] < grid[i][preCol]) {
                    canSave = false;
                    break;
                }
            }
        }

        int saveRes = 0;
        if (canSave) {
            saveRes = 1 + dp(curCol + 1, curCol);
        }

        int nonSaveRes = dp(curCol + 1, preCol);
        memo[curCol][preCol] = Math.max(saveRes, nonSaveRes);
        return memo[curCol][preCol];
    }

    public int minDeletionSize(String[] arr) {
        rowCount = arr.length;
        colCount = arr[0].length() + 1;
        grid = new char[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 1; j < colCount; j++) {
                grid[i][j] = arr[i].charAt(j - 1);
            }
        }

        memo = new Integer[colCount][colCount];
        return colCount - dp(1, 0) - 1;
    }

    public static void main(String[] args) {

    }

}
