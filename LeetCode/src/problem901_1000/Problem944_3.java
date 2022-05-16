package problem901_1000;

public class Problem944_3 {

    public int minDeletionSize(String[] strs) {
        int ans = 0;
        int rowCount = strs.length;
        int colCount = strs[0].length();
        for (int j = 0; j < colCount; j++) {
            ans += getAns(strs, rowCount, j);
        }
        return ans;
    }

    private int getAns(String[] strs, int rowCount, int col) {
        int pre = strs[0].charAt(col);
        for (int i = 1; i < rowCount; i++) {
            char cur = strs[i].charAt(col);
            if (cur < pre) {
                return 1;
            }
            pre = cur;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Problem944_3().minDeletionSize(new String[]{"rrjk","furt","guzm"}));

    }

}
