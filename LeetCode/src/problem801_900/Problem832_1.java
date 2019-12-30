package problem801_900;

public class Problem832_1 {

    public int[][] flipAndInvertImage(int[][] arr) {
        int colCount = arr[0].length;
        for (int[] rowArr: arr) {
            int l = 0;
            int r = colCount - 1;
            while (l < r) {
                if (rowArr[l] == rowArr[r]) {
                    rowArr[l] ^= 1;
                    rowArr[r] = rowArr[l];
                }
                l++;
                r--;
            }
            if (l == r) {
                rowArr[l] ^= 1;
            }
        }

        return arr;
    }

}
