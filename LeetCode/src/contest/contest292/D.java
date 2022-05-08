package contest.contest292;

import java.util.HashMap;
import java.util.Map;

public class D {

    private char[][] grid;
    private int rowCount;
    private int colCount;
    private Map<Integer, Boolean> memoMap;

    private int[] getCount(int r, int c) {
        if (r < 0 || c < 0 || r >= rowCount || c >= colCount) {
            return new int[]{0, 0};
        }
        return new int[]{grid[r][c] == '(' ? 1 : 0, grid[r][c] == '(' ? 0 : 1};
    }

    private boolean rec(int r, int c, int leftCount, int rightCount) {
        if (r >= rowCount || c >= colCount || rightCount > leftCount) {
            return false;
        }

        if (r == rowCount - 1 && c == colCount - 1) {
            return leftCount == rightCount;
        }

        int key = r * 100_00_00 + c * 100_00 + leftCount * 100 + rightCount;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int[] nextRightCount = getCount(r, c + 1);
        boolean rightRes = rec(r, c + 1, leftCount + nextRightCount[0], rightCount + nextRightCount[1]);
        int[] nextBottomCount = getCount(r + 1, c);
        boolean bottomRes = rec(r + 1, c, leftCount + nextBottomCount[0], rightCount + nextBottomCount[1]);
        boolean ans = bottomRes || rightRes;
        memoMap.put(key, ans);
        return ans;
    }

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid;
        this.rowCount = grid.length;
        this.colCount = grid[0].length;
        memoMap = new HashMap<>();
        if (grid[0][0] == ')') {
            return false;
        }
        return rec(0, 0, 1, 0);
    }

    public static void main(String[] args) {
        System.out.println(new D().hasValidPath(new char[][]{
                {'(',')'},{'(',')'}
        }));
    }

}
