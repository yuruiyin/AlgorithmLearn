package problem801_900;

public class Problem867 {

    public int[][] transpose(int[][] arr) {
        int rowCount = arr.length;
        int colCount = arr[0].length;
        int[][] ansArr = new int[colCount][rowCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                ansArr[j][i] = arr[i][j];
            }
        }

        return ansArr;
    }

}
