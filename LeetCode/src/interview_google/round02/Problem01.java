package interview_google.round02;

public class Problem01 {

    public int[][] flipAndInvertImage(int[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        for (int i = 0; i < m; i++) {
            // 水平翻转
            for (int j = 0; j < n / 2; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[i][n-j-1];
                arr[i][n-j-1] = tmp;
            }

            // 反转 1->0 0->1
            for (int j = 0; j < n; j++) {
                arr[i][j] ^= 1;
            }
        }

        return arr;
    }
    
    public static void main(String[] args) {

    }
    
}
