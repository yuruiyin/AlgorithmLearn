package contest.contest111;

public class Problem02 {

    public int minDeletionSize(String[] strs) {
        int rowCount = strs.length;
        int colCount = strs[0].length();
        char[][] arr = new char[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            arr[i] = strs[i].toCharArray();
        }

        int ans = 0;
        for (int j = 0; j < colCount; j++) {
            boolean isNeedRemoved = false;
            for (int i = 1; i < rowCount; i++) {
                if (arr[i][j] < arr[i-1][j]) {
                    isNeedRemoved = true;
                    break;
                }
            }
            if (isNeedRemoved) {
                ans++;
            }
        }

        return ans;
    }

}
