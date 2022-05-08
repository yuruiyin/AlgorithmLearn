package contest.contest292;

import java.util.HashMap;
import java.util.Map;

public class D {

    private char[][] grid;
    private int rowCount;
    private int colCount;
    private int pathNodeCount;
    private Map<Integer, Boolean> memoMap;

    private boolean rec(int r, int c, int leftCount, int rightCount) {
        if (rightCount > leftCount || rightCount + (pathNodeCount - r - c - 1) < leftCount) {
            return false;
        }

        if (r == rowCount - 1 && c == colCount - 1) {
            return leftCount == rightCount;
        }

        int key = r * 100_00 + c * 100 + (leftCount - rightCount);
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        boolean rightRes = false;
        if (r < rowCount && c + 1 < colCount) {
            rightRes = rec(r, c + 1, leftCount + ((grid[r][c + 1] - '(') ^ 1), rightCount + grid[r][c + 1] - '(');
        }

        if (rightRes) {
            memoMap.put(key, true);
            return true;
        }

        boolean ans = false;
        if (r + 1 < rowCount && c < colCount) {
            ans = rec(r + 1, c, leftCount + ((grid[r + 1][c] - '(') ^ 1), rightCount + grid[r + 1][c] - '(');
        }

        memoMap.put(key, ans);
        return ans;
    }

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        this.rowCount = grid.length;
        this.colCount = grid[0].length;
        memoMap = new HashMap<>();
        pathNodeCount = rowCount + colCount - 1;
        if (grid[0][0] == ')' || (pathNodeCount) % 2 == 1) {
            return false;
        }
        return rec(0, 0, 1, 0);
    }

    public static void main(String[] args) {
        System.out.println(new D().hasValidPath(new char[][]{
                {'(', ')'}, {'(', ')'}
        }));
        System.out.println((int) '(');
        System.out.println((int) ')');
    }

}
