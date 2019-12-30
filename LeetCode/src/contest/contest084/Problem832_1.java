package contest.contest084;

public class Problem832_1 {

    public int[][] flipAndInvertImage(int[][] arr) {
        int rowCount = arr.length;
        int colCount = arr[0].length;
        for (int i = 0; i < rowCount; i++) {
            int left = 0;
            int right = colCount - 1;
            while (left < right) {
                int tmp = arr[i][left];
                arr[i][left] = arr[i][right];
                arr[i][right] = tmp;
                arr[i][left] ^= 1;
                arr[i][right] ^= 1;
                left++;
                right--;
            }
            if (left == right) {
                arr[i][left] ^= 1;
            }
        }

        return arr;
    }

}
