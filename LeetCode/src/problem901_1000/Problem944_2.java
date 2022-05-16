package problem901_1000;

public class Problem944_2 {

    public int minDeletionSize(String[] strs) {
        int ans = 0;
        int rowCount = strs.length;
        int colCount = strs[0].length();
        char[][] grid = new char[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
            grid[i] = strs[i].toCharArray();
        }
        for (int j = 0; j < colCount; j++) {
            for (int i = 1; i < rowCount; i++) {
                if (grid[i][j] < grid[i-1][j]) {
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Problem944_2().minDeletionSize(new String[]{"rrjk","furt","guzm"}));
    }

}
