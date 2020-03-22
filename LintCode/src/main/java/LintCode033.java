import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LintCode033
 *
 * @author: yry
 * @date: 2020/3/19
 */
public class LintCode033 {

    private boolean[] colFlag;
    private boolean[] sumFlag;
    private boolean[] diffFlag;
    private List<List<String>> ansList;
    private int n;
    private char[][] grid;

    private List<String> getAns(int[] colArr) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            grid[i][colArr[i]] = 'Q';
            list.add(new String(grid[i]));
            grid[i][colArr[i]] = '.';
        }
        return list;
    }

    private void dfs(int row, int[] colArr) {
        if (row == n) {
            ansList.add(getAns(colArr));
            return;
        }

        for (int col = 0; col < n; col++) {
            int sum = row + col;
            int diff = row - col + n;
            if (colFlag[col] || sumFlag[sum] || diffFlag[diff]) {
                continue;
            }

            colFlag[col] = true;
            sumFlag[sum] = true;
            diffFlag[diff] = true;
            colArr[row] = col;
            dfs(row + 1, colArr);
            colFlag[col] = false;
            sumFlag[sum] = false;
            diffFlag[diff] = false;
        }
    }

    private void initGrid() {
        grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], '.');
        }
    }

    public List<List<String>> solveNQueens(int n) {
        // write your code here
        colFlag = new boolean[n];
        sumFlag = new boolean[2 * n];
        diffFlag = new boolean[2 * n];
        ansList = new ArrayList<>();
        this.n = n;
        initGrid();
        dfs(0, new int[n]);
        return ansList;
    }

}
