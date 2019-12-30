package problem901_1000;

public class Problem944 {

    public int minDeletionSize(String[] arr) {
        int ans = 0;
        int rowCount = arr.length;
        int colCount = arr[0].length();
        for (int j = 0; j < colCount; j++) {
            for (int i = 1; i < rowCount; i++) {
                if (arr[i].charAt(j) < arr[i-1].charAt(j)) {
                    ans++;
                    break;
                }
            }
        }

        return ans;
    }

}
