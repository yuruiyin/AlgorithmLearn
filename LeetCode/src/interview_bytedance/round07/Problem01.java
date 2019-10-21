package interview_bytedance.round07;

public class Problem01 {

    private int[] memoCount = new int[10000];

    private int backTracking(int row, int col, int rowMax, int colMax) {
        if (row == rowMax || col == colMax) {
            return 1;
        }

        if (memoCount[row * 100 + col] != 0) {
            return memoCount[row * 100 + col];
        }

        // 向下
        int bottomCount = backTracking(row + 1, col, rowMax, colMax);

        // 向右
        int rightCount = backTracking(row, col + 1, rowMax, colMax);

        int count = bottomCount + rightCount;
        memoCount[row * 100 + col] = count;
        return count;
    }

    public int uniquePaths(int m, int n) {
        return backTracking(0, 0, n - 1, m - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(new Problem01().uniquePaths(3, 2));
        System.out.println(new Problem01().uniquePaths(7, 3));
        System.out.println(new Problem01().uniquePaths(51, 9));
    }
    
}
