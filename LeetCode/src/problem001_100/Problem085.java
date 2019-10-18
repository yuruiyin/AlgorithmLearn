package problem001_100;

public class Problem085 {

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return 0;
        }

        int m = matrix[0].length;

        if (m == 0) {
            return 0;
        }

        // 计算每个点的最大宽度（即当前点所在的行，以当前点为结束点最大的连续的1的个数）
        int[][] maxWidthArr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }

                if (j == 0) {
                    maxWidthArr[i][j] = 1;
                } else {
                    maxWidthArr[i][j] = maxWidthArr[i][j-1] + 1;
                }
            }
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int minWidth = maxWidthArr[i][j];
                for (int k = i; k >= 0; k--) {
                    if (maxWidthArr[k][j] == 0) {
                        break;
                    }

                    if (maxWidthArr[k][j] < minWidth) {
                        minWidth = maxWidthArr[k][j];
                    }

                    int area = (i - k + 1) * minWidth;

                    if (area > maxArea) {
                        maxArea = area;
                    }
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(new Problem085().maximalRectangle(new char[][]{
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        }));
    }

}
